package net.womp.skill.weapon_innate;

import com.google.common.collect.Maps;
import net.minecraft.nbt.CompoundTag;
import net.womp.gameassets.animation.WOMPAnimations;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.AnimationPlayer;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.DynamicAnimation;
import yesman.epicfight.api.animation.types.EntityState;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks.Player;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;

import java.util.Map;
import java.util.Objects;

public class EvilPunishment extends WeaponInnateSkill {

    protected float stamina_consumption;

    private final Map<AnimationManager.AnimationAccessor<? extends StaticAnimation>, AnimationManager.AnimationAccessor<? extends AttackAnimation>> comboAnimation = Maps.newHashMap();

    public EvilPunishment(WeaponInnateSkill.Builder<?> builder) {
        super(builder);
    }

    @Override
    public void loadDatapackParameters(CompoundTag parameters) {
        this.stamina_consumption = parameters.getFloat("stamina_consumption");

        super.loadDatapackParameters(parameters);
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener listener) {
        super.onInitiate(container, listener);
        listener.registerEvent(Player.CONSUME_SKILL, (event) -> {
            if (event.getSkill() == container.getSkill() && container.getExecutor().getOriginal().isSprinting()) {
                if (!container.getExecutor().getOriginal().isCreative()) {
                    event.setResourceType(Resource.STAMINA);
                    event.setAmount(this.stamina_consumption);
                } else {
                    event.setResourceType(Resource.NONE);
                }
                container.activate();
            }
        }, this);
    }

    @Override
    public void executeOnServer(SkillContainer container, CompoundTag args) {
        ServerPlayerPatch player = container.getServerExecutor();

        if (!player.getOriginal().isSprinting()) {
            if (player.getAnimator().getPlayerFor(null) instanceof AnimationPlayer animPlayer
                    && !animPlayer.isEmpty()) {
                AssetAccessor<? extends DynamicAnimation> animation = animPlayer.getAnimation().get().getAccessor();

                if (this.comboAnimation.containsKey(animation.get().getAccessor())) {
                    player.playAnimationSynchronized(this.comboAnimation.get((AssetAccessor<? extends  DynamicAnimation>)animation), 0.0F);
                    super.executeOnServer(container, args);
                }
            }
        } else {
            player.playAnimationSynchronized(WOMPAnimations.EVIL_TACHI_NEW_BATTOJUTSO, 0.0F);
        }
        super.executeOnServer(container, args);
    }
    @Override
    public boolean checkExecuteCondition(SkillContainer container) {
        EntityState playerState = container.getExecutor().getEntityState();
        return container.getExecutor().getOriginal().isSprinting() || this.comboAnimation.containsKey(Objects.requireNonNull(container.getExecutor().getAnimator().getPlayerFor(null)).getAnimation().get().getAccessor()) && playerState.canUseSkill() && playerState.inaction();
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
