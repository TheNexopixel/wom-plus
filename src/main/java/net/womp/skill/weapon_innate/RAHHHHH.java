package net.womp.skill.weapon_innate;

import net.minecraft.nbt.CompoundTag;
import net.womp.gameassets.animation.WOMPAnimations;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

public class RAHHHHH extends WeaponInnateSkill {

    public RAHHHHH(WeaponInnateSkill.Builder<?> builder) {
        super(builder);
    }

    @Override
    public void executeOnServer(SkillContainer container, CompoundTag args) {
        super.executeOnServer(container, args);
        container.getExecutor().playAnimationSynchronized(WOMPAnimations.RAAAHHHHH,0.1f);
    }
}
