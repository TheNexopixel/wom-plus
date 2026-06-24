package net.womp.skill.weapon_innate;

import net.minecraft.network.FriendlyByteBuf;
import net.womp.gameasset.animation.WOMPAnimations;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;

public class Evil_beam extends SimpleWeaponInnateSkill {

    private static final float STAMINA_COST = 6.0F;

    public Evil_beam(SkillBuilder<? extends SimpleWeaponInnateSkill> builder) {
        super((Builder) builder);
    }

    @Override
    public boolean canExecute(SkillContainer container) {
        PlayerPatch<?> player = container.getExecutor();


        if (!player.getOriginal().isSprinting()) {
            return false;
        }


        if (player.getStamina() < STAMINA_COST) {
            return false;
        }

        return super.canExecute(container);
    }

    @Override
    public void executeOnServer(SkillContainer container, FriendlyByteBuf args) {
        PlayerPatch<?> player = container.getServerExecutor();

        if (player.getOriginal().isSprinting()) {

            if (player.getStamina() < STAMINA_COST) {
                return;
            }


            player.setStamina(player.getStamina() - STAMINA_COST);


            player.playAnimationSynchronized(
                    WOMPAnimations.EVIL_ODACHI_BATTOJUTSO,
                    0.0F
            );

            return;
        }
        super.executeOnServer(container, args);
    }
}