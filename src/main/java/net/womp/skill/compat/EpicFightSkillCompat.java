package net.womp.skill.compat;

import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.womp.gameassets.animation.WOMPAnimations;
import net.womp.world.capabilities.item.WOMPWeaponCategories;
import reascer.wom.world.item.WOMItems;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
import yesman.epicfight.api.client.event.types.registry.RegisterWeaponCategoryIconEvent;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.event.types.registry.SkillBuilderModificationEvent;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.registry.entries.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.passive.SwordmasterSkill;

import java.util.List;

public class EpicFightSkillCompat implements ICompatModule {

    @OnlyIn(Dist.CLIENT)
    public static void registerIcon(RegisterWeaponCategoryIconEvent event) {
        event.registerCategory(WOMPWeaponCategories.EVIL_TACHI, new ItemStack(WOMItems.EVIL_TACHI.get()));
        event.registerCategory(WOMPWeaponCategories.HOLLOW_LONGSWORD, new ItemStack(WOMItems.HOLLOW_LONGSWORD.get()));
        event.registerCategory(WOMPWeaponCategories.WOM_GREATAXE, new ItemStack(WOMItems.IRON_GREATAXE.get()));
        event.registerCategory(WOMPWeaponCategories.BLACKSTAR, new ItemStack(WOMItems.BLACKSTAR.get()));
    }

    public static void onSwordMasterSkillCreate(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EpicFightSkills.SWORD_MASTER.getId())) {
            if (event.getSkillBuilder() instanceof SwordmasterSkill.Builder builder) {
                builder
                        .addAvailableWeaponCategory(WOMPWeaponCategories.EVIL_TACHI)
                        .addAvailableWeaponCategory(WOMPWeaponCategories.HOLLOW_LONGSWORD)
                ;
            }
        }
    }

    public static void onGuardSkillcreate(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EpicFightSkills.GUARD.getId())) {
            if (event.getSkillBuilder() instanceof GuardSkill.Builder builder) {

                builder.addGuardMotion(
                        WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.SPEAR_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED);

                builder.addGuardMotion(
                        WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> WOMPAnimations.GREATAXE_ONEHAND_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> Animations.GREATSWORD_GUARD_BREAK);

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


    public static void onImpactGuardSkillcreate(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EpicFightSkills.IMPACT_GUARD.getId())) {
            if (event.getSkillBuilder() instanceof GuardSkill.Builder builder) {

                builder.addGuardMotion(
                        WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.SPEAR_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED);

                builder.addGuardMotion(
                        WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> WOMPAnimations.GREATAXE_ONEHAND_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> Animations.GREATSWORD_GUARD_BREAK);

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

    public static void onParrySkillCreate(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EpicFightSkills.PARRYING.getId())) {
            if (event.getSkillBuilder() instanceof GuardSkill.Builder builder) {

                builder.addGuardMotion(
                        WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.SPEAR_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.BLACKSTAR,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED);

                builder.addGuardMotion(
                        WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> WOMPAnimations.GREATAXE_ONEHAND_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.WOM_GREATAXE,
                        (i, p) -> Animations.GREATSWORD_GUARD_BREAK);

                builder.addGuardMotion(
                        WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> Animations.LONGSWORD_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED
                ).addAdvancedGuardMotion(WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> List.of(Animations.LONGSWORD_GUARD_ACTIVE_HIT1, Animations.LONGSWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT3,Animations.SWORD_GUARD_ACTIVE_HIT1));

                builder.addGuardMotion(
                        WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_NEUTRALIZED
                ).addAdvancedGuardMotion(WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> List.of(WOMPAnimations.EVIL_ODACHI_PARRY1, WOMPAnimations.EVIL_ODACHI_PARRY2));
            }
        }
    }

    @Override
    public void onModEventBus(IEventBus iEventBus) {
    }

    @Override
    public void onGameEventBus(IEventBus iEventBus) {
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(EpicFightSkillCompat::onGuardSkillcreate, 2);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(EpicFightSkillCompat::onImpactGuardSkillcreate, 4);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(EpicFightSkillCompat::onParrySkillCreate, 4);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(EpicFightSkillCompat::onSwordMasterSkillCreate, 2);
    }

    @Override
    public void onModEventBusClient(IEventBus iEventBus) {
    }

    @Override
    public void onGameEventBusClient(IEventBus iEventBus) {
        EpicFightClientEventHooks.Registry.WEAPON_CATEGORY_ICON.registerEvent(EpicFightSkillCompat::registerIcon);
    }
}
