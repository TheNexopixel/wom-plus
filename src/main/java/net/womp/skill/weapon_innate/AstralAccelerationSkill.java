package net.womp.skill.weapon_innate;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.womp.gameassets.animation.WOMPAnimations;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

public class AstralAccelerationSkill extends WeaponInnateSkill {

    public AstralAccelerationSkill(WeaponInnateSkill.Builder<?> builder) {
        super(builder);}

        @Override
        public void executeOnServer (SkillContainer container, CompoundTag args){
            super.executeOnServer(container, args);
            container.getExecutor().playAnimationSynchronized(WOMPAnimations.NOVA_ASTRAL_ACCELERATION, 0.0f);
        }


    }

