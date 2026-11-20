package net.womp.skill.weapon_innate;

import com.google.common.collect.Maps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.womp.gameasset.animation.WOMPAnimations;
import net.womp.skill.WOMPSkills;
import reascer.wom.world.item.WOMItems;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.DynamicAnimation;
import yesman.epicfight.api.animation.types.EntityState;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;

import java.util.Map;
import java.util.Objects;

public class EvilPunishment extends WeaponInnateSkill {

    private static final float STAMINA_COST = 6.0F;

    private final Map<AnimationManager.AnimationAccessor<? extends StaticAnimation>, AnimationManager.AnimationAccessor<? extends AttackAnimation>> comboAnimation = Maps.newHashMap();

    public EvilPunishment(SkillBuilder<? extends WeaponInnateSkill> builder) {
        super(builder);
    }

    private boolean injectedStack = false;

    @Override
    public boolean canExecute(SkillContainer container) {
        PlayerPatch<?> player = container.getExecutor();

        if (player.getOriginal().isSprinting()
                && Objects.equals(player.getAdvancedHoldingItemCapability(InteractionHand.MAIN_HAND)
                .getInnateSkill(player, player.getValidItemInHand(InteractionHand.MAIN_HAND)), WOMPSkills.EVIL_PUNISHMENT))
        {

            if (// container.getStack() <= 0
             !player.getOriginal().isCreative()
                    && player.getStamina() >= STAMINA_COST) {
                container.setStack(container.getStack() +1);
                injectedStack = true;
            }

            return player.getStamina() >= STAMINA_COST;
        }

        return super.canExecute(container);
    }
    @Override
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);
    }
    @Override
    public void onRemoved(SkillContainer container) {
    }



    @Override
    public void executeOnServer(SkillContainer container, FriendlyByteBuf args) {
        AssetAccessor<? extends DynamicAnimation> animation = Objects.requireNonNull(container.getExecutor().getAnimator().getPlayerFor(null)).getAnimation();
        if (this.comboAnimation.containsKey(animation)) {
            container.getExecutor().playAnimationSynchronized(this.comboAnimation.get(animation), 0.0F);
            super.executeOnServer(container, args);
        }

        PlayerPatch<?> player = container.getServerExecutor();

        if (player.getOriginal().isSprinting()
                && Objects.equals(player.getAdvancedHoldingItemCapability(InteractionHand.MAIN_HAND)
                .getInnateSkill(player, player.getValidItemInHand(InteractionHand.MAIN_HAND)), WOMPSkills.EVIL_PUNISHMENT))
        {

            if (!player.getOriginal().isCreative()){

                player.setStamina(player.getStamina() - STAMINA_COST);
            }

            player.playAnimationSynchronized(
                    WOMPAnimations.EVIL_TACHI_NEW_BATTOJUTSO,
                    0.0F
            );

            if (!injectedStack) {
                container.setStack(
                        Math.min(
                                container.getStack() + 1,
                                container.getSkill().getMaxStack()
                        )
                );
            }

            injectedStack = false;
            return;
        }

        super.executeOnServer(container, args);



    }
    @Override
    public boolean checkExecuteCondition(SkillContainer container) {
        EntityState playerState = container.getExecutor().getEntityState();

        return this.comboAnimation.containsKey(Objects.requireNonNull(container.getExecutor().getAnimator().getPlayerFor(null)).getAnimation()) && playerState.canUseSkill() && playerState.inaction();
    }
    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        this.comboAnimation.clear();

        this.comboAnimation.put(
                WOMPAnimations.EVIL_TACHI_NEW_AUTO1,
                WOMPAnimations.EVIL_TACHI_NEW_AUTO1_SKILL
        );
        this.comboAnimation.put(
                WOMPAnimations.EVIL_TACHI_NEW_AUTO2,
                WOMPAnimations.EVIL_TACHI_NEW_AUTO2_SKILL
        );
        this.comboAnimation.put(
                WOMPAnimations.EVIL_TACHI_NEW_AUTO3,
                WOMPAnimations.EVIL_TACHI_NEW_AUTO3_SKILL
        );
        this.comboAnimation.put(
                WOMPAnimations.EVIL_TACHI_NEW_AUTO4,
                WOMPAnimations.EVIL_TACHI_NEW_AUTO4_SKILL
        );

        this.comboAnimation.put(
                WOMPAnimations.EVIL_TACHI_NEW_AIRSLASH,
                WOMPAnimations.EVIL_TACHI_NEW_AIRSLASH_SKILL
        );
        this.comboAnimation.put(
                WOMPAnimations.EVIL_TACHI_NEW_AIRSLASH_SKILL,
                WOMPAnimations.EVIL_TACHI_NEW_AIRSLASH_SKILL2
        );
        this.comboAnimation.put(
                WOMPAnimations.EVIL_TACHI_NEW_DASH,
                WOMPAnimations.EVIL_TACHI_NEW_DASH_SKILL
        );
        this.comboAnimation.put(
                WOMPAnimations.EVIL_TACHI_NEW_BATTOJUTSO,
                WOMPAnimations.EVIL_TACHI_NEW_BATTOJUTSO_SKILL
        );

        return this;
    }
}
