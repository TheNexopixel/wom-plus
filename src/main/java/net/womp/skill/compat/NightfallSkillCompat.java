package net.womp.skill.compat;

import com.hm.efn.gameasset.EFNSkills;
import com.hm.efn.gameasset.animations.EFNSkillAnimations;
import net.neoforged.bus.api.IEventBus;
import net.womp.gameassets.animation.WOMPAnimations;
import net.womp.world.capabilities.item.WOMPWeaponCategories;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.event.types.registry.SkillBuilderModificationEvent;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.guard.GuardSkill;

import java.util.List;

public class NightfallSkillCompat implements ICompatModule {

    public static void onEnhancedParrySkillCreate(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EFNSkills.EFN_PARRY_HOLDER.getId())) {
            if (event.getSkillBuilder() instanceof GuardSkill.Builder builder) {
                builder.addGuardMotion(
                        WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> Animations.LONGSWORD_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED
                ).addAdvancedGuardMotion(WOMPWeaponCategories.HOLLOW_LONGSWORD,
                        (i, p) -> List.of(EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1, EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2, EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT3));

                builder.addGuardMotion(
                        WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_GUARD_HIT
                ).addGuardBreakMotion(WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> WOMPAnimations.EVIL_ODACHI_NEUTRALIZED
                ).addAdvancedGuardMotion(WOMPWeaponCategories.EVIL_TACHI,
                        (i, p) -> List.of(EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1, EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2, EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT3));
            }
        }
    }

    @Override
    public void onModEventBus(IEventBus iEventBus) {
    }

    @Override
    public void onGameEventBus(IEventBus iEventBus) {
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(NightfallSkillCompat::onEnhancedParrySkillCreate, 4);
    }

    @Override
    public void onModEventBusClient(IEventBus eventBus) {
    }

    @Override
    public void onGameEventBusClient(IEventBus iEventBus) {

    }
}
