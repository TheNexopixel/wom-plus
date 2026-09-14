package net.womp.skill.compat;


import net.minecraft.world.InteractionHand;
import net.neoforged.bus.api.IEventBus;
import net.womp.gameassets.animation.WOMPAnimations;
import net.womp.skill.WOMPSkills;
import net.womp.world.capabilities.item.WOMPWeaponCategories;
import reascer.wom.gameasset.WOMSkills;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.event.types.registry.SkillBuilderModificationEvent;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.Objects;

public class WOMSkillCompat implements ICompatModule {

    public static void onCounterAttackSkillCreate(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(WOMSkills.COUNTER_ATTACK.getId())) {
            if (event.getSkillBuilder() instanceof GuardSkill.Builder builder) {
                builder.addGuardMotion(
                        WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> WOMPAnimations.GREATAXE_ONEHAND_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> Animations.GREATSWORD_GUARD_BREAK
                ).addAdvancedGuardMotion(WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> WOMPAnimations.GREATAXE_ONEHAND_AIRSLASH);


                builder.addGuardMotion(
                        WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.SPEAR_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED
                ).addAdvancedGuardMotion(WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> WOMPAnimations.BLACKSTAR_COUNTERATTACK);


                builder.addGuardMotion(
                        WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> Animations.LONGSWORD_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED
                ).addAdvancedGuardMotion(WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> WOMPAnimations.HOLLOW_GUARD_STANCE_COUNTER);


                builder.addGuardMotion(
                        WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_NEUTRALIZED
                ).addAdvancedGuardMotion(WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_COUNTER);


                builder.addGuardMotion(CapabilityItem.WeaponCategories.SHIELD, (item, player) ->
                        Animations.BIPED_HIT_SHIELD
                ).addGuardBreakMotion(CapabilityItem.WeaponCategories.SHIELD, (item, player) ->
                        Animations.BIPED_COMMON_NEUTRALIZED
                ).addAdvancedGuardMotion(CapabilityItem.WeaponCategories.SHIELD, (itemCap, playerpatch) -> {
                            if (Objects.equals(playerpatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getInnateSkill(playerpatch, playerpatch.getAdvancedHoldingItemStack(InteractionHand.MAIN_HAND)), WOMPSkills.RAAAHHH.get())) {
                                return WOMPAnimations.HOLLOW_GUARD_STANCE_COUNTER;
                            }
                            return Animations.BIPED_HIT_SHIELD;
                        }
                );
            }
        }
    }

    public static void onVengefulParrySkillCreate(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(WOMSkills.VENGEFUL_PARRY.getId())) {
            if (event.getSkillBuilder() instanceof GuardSkill.Builder builder) {
                builder.addGuardMotion(
                        WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> WOMPAnimations.GREATAXE_ONEHAND_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> Animations.GREATSWORD_GUARD_BREAK);


                builder.addGuardMotion(
                        WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.SPEAR_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED);


                builder.addGuardMotion(
                        WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.SPEAR_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED);


                builder.addGuardMotion(
                        WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> Animations.LONGSWORD_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED);


                builder.addGuardMotion(
                        WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_NEUTRALIZED);
            }
        }
    }

    public static void onPerfectBulwarkSkillCreate(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(WOMSkills.PERFECT_BULWARK.getId())) {
            if (event.getSkillBuilder() instanceof GuardSkill.Builder builder) {

                builder.addGuardMotion(
                        WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> WOMPAnimations.GREATAXE_ONEHAND_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> Animations.GREATSWORD_GUARD_BREAK
                ).addAdvancedGuardMotion(WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> WOMPAnimations.GREATAXE_ONEHAND_AIRSLASH);


                builder.addGuardMotion(
                        WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.SPEAR_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED
                ).addAdvancedGuardMotion(WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> WOMPAnimations.BLACKSTAR_COUNTERATTACK);


                builder.addGuardMotion(
                        WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> Animations.LONGSWORD_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED
                ).addAdvancedGuardMotion(WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> WOMPAnimations.HOLLOW_GUARD_STANCE_COUNTER);


                builder.addGuardMotion(
                        WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_NEUTRALIZED
                ).addAdvancedGuardMotion(WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_COUNTER);


                builder.addGuardMotion(CapabilityItem.WeaponCategories.SHIELD, (item, player) ->
                        Animations.BIPED_HIT_SHIELD
                ).addGuardBreakMotion(CapabilityItem.WeaponCategories.SHIELD, (item, player) ->
                        Animations.BIPED_COMMON_NEUTRALIZED
                ).addAdvancedGuardMotion(CapabilityItem.WeaponCategories.SHIELD, (itemCap, playerpatch) -> {
                    if (Objects.equals(playerpatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getInnateSkill(playerpatch, playerpatch.getAdvancedHoldingItemStack(InteractionHand.MAIN_HAND)), WOMPSkills.RAAAHHH.get())) {
                        return WOMPAnimations.HOLLOW_GUARD_STANCE_COUNTER;
                    }
                    return Animations.BIPED_HIT_SHIELD;
                });
            }
        }
    }

    @Override
    public void onModEventBus(IEventBus iEventBus) {
    }

    @Override
    public void onGameEventBus(IEventBus iEventBus) {
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(WOMSkillCompat::onCounterAttackSkillCreate, 5);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(WOMSkillCompat::onVengefulParrySkillCreate, 6);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(WOMSkillCompat::onPerfectBulwarkSkillCreate, 5);
    }

    @Override
    public void onModEventBusClient(IEventBus iEventBus) {
    }

    @Override
    public void onGameEventBusClient(IEventBus iEventBus) {
    }
}
