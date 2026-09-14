package net.womp.skill;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.womp.WOMPlus;
import net.womp.gameassets.animation.WOMPAnimations;
import net.womp.skill.weapon_innate.AstralAccelerationSkill;
import net.womp.skill.weapon_innate.EvilBeam;
import net.womp.skill.weapon_innate.EvilPunishment;
import net.womp.skill.weapon_innate.RAHHHHH;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.registry.EpicFightRegistries;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;

import java.util.Set;

public class WOMPSkills {

    public static final DeferredRegister<Skill> REGISTRY = DeferredRegister.create(EpicFightRegistries.Keys.SKILL, WOMPlus.MODID);

    public static final DeferredHolder<Skill, WeaponInnateSkill> EVIL_BEAAAAMMMM = REGISTRY.register("evil_beam", key -> EvilBeam.createSimpleWeaponInnateBuilder(EvilBeam::new)
            .setAnimations(WOMPAnimations.EVIL_ODACHI_BEAAAMMMM)
            .setCategory(SkillCategories.WEAPON_INNATE)
            .newProperty()
            .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.5F))
            .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.GUARD_PUNCTURE))
            .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG,Set.of(EpicFightDamageTypeTags.FINISHER))
            .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(25.0F))
            .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(15.5F))
            .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
            .addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE))
            .build(key));

    public static final DeferredHolder<Skill, EvilPunishment> EVIL_PUNISHMENT = REGISTRY.register("evil_punishment", key -> EvilPunishment.createWeaponInnateBuilder(EvilPunishment::new)
            .setCategory(SkillCategories.WEAPON_INNATE)
            .build(key));

    public static final DeferredHolder<Skill, WeaponInnateSkill> COMET = REGISTRY.register("comet", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder(SimpleWeaponInnateSkill::new)
            .setAnimations(WOMPAnimations.COMET)
            .setCategory(SkillCategories.WEAPON_INNATE)
            .newProperty()
            .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(20.0F))
            .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT
            .create())).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE))
            .build(key));

    public static final DeferredHolder<Skill, WeaponInnateSkill> ANNIHILATE = REGISTRY.register("annihilate", key -> SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder(SimpleWeaponInnateSkill::new)
            .setAnimations(WOMPAnimations.ANNIHILATE)
            .setCategory(SkillCategories.WEAPON_INNATE)
            .newProperty()
            .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10.0F))
            .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT
            .create())).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE))
            .build(key));

    public static final DeferredHolder<Skill, RAHHHHH> RAAAHHH = REGISTRY.register("rahhh", key -> RAHHHHH.createWeaponInnateBuilder(RAHHHHH::new)
            .setCategory(SkillCategories.WEAPON_INNATE)
            .build(key));

    public static final DeferredHolder<Skill, AstralAccelerationSkill> ASTRAL_ACCELERATION = REGISTRY.register("astral_acceleration", key -> AstralAccelerationSkill.createWeaponInnateBuilder(AstralAccelerationSkill::new)
            .setCategory(SkillCategories.WEAPON_INNATE)
            .build(key));
}
