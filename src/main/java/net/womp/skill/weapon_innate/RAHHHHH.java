package net.womp.skill.weapon_innate;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.effect.MobEffectInstance;
import net.womp.gameasset.animation.WOMPAnimations;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

import java.util.UUID;

public class RAHHHHH extends WeaponInnateSkill {

    public RAHHHHH(SkillBuilder<? extends WeaponInnateSkill> builder) {
        super(builder);
    }

    @Override
    public void executeOnServer(SkillContainer container, FriendlyByteBuf args) {
        super.executeOnServer(container, args);
        container.getExecutor().playAnimationSynchronized(WOMPAnimations.RAAAHHHHH,0.1f);
    }


}
