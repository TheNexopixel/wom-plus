package net.womp.skill;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.womp.WomPLUS;
import net.womp.gameasset.animation.WOMPAnimations;
import net.womp.skill.weapon_innate.Evil_beam;
import net.womp.skill.weapon_innate.RAHHHHH;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;

import java.util.Set;

@Mod.EventBusSubscriber(modid = WomPLUS.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WOMPSkills {
    public static Skill EVIL_BEAAAAMMMM;
    public static Skill COMET;
    public static Skill ANNIHILATE;
    public static Skill RAAAHHH;

    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent build){
        SkillBuildEvent.ModRegistryWorker modRegistry = build.createRegistryWorker(WomPLUS.MODID);


        WeaponInnateSkill evilbeam = modRegistry.build("evil_beam", Evil_beam::new, Evil_beam.createSimpleWeaponInnateBuilder()
                .setAnimations(WOMPAnimations.EVIL_ODACHI_BEAAAMMMM)
                .setCategory(SkillCategories.WEAPON_INNATE));
        evilbeam.newProperty()
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.7F))
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.GUARD_PUNCTURE))
                .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG,Set.of(EpicFightDamageTypeTags.FINISHER))
                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(25.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(15.5F))
                .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT
                        .create())).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE));

        EVIL_BEAAAAMMMM = evilbeam;

        WeaponInnateSkill annihilate = modRegistry.build("annihilate", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder()
                .setAnimations(WOMPAnimations.ANNIHILATE)
                .setCategory(SkillCategories.WEAPON_INNATE));
        annihilate.newProperty()
                .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.2F))
                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(20.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(7.5F))
                .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT
                        .create())).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE));
        ANNIHILATE = annihilate;

        WeaponInnateSkill comet = modRegistry.build("comet", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder()
                .setAnimations(WOMPAnimations.COMET)
                .setCategory(SkillCategories.WEAPON_INNATE));
        comet.newProperty()
                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(20.0F))
                .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT
                        .create())).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE));
        COMET = comet;

        RAAAHHH = modRegistry.build("rahhh", RAHHHHH::new,
                RAHHHHH.createWeaponInnateBuilder()
                        .setCategory(SkillCategories.WEAPON_INNATE)
        );
    }
}
