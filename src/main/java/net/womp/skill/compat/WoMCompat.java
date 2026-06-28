package net.womp.skill.compat;


import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegisterEvent;
import net.womp.gameasset.animation.WOMPAnimations;
import net.womp.world.capabilities.item.WOMPWeaponCategories;
import reascer.wom.gameasset.WOMSkills;

import reascer.wom.world.item.WOMItems;
import yesman.epicfight.api.client.forgeevent.WeaponCategoryIconRegisterEvent;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@SuppressWarnings("unchecked")
public class WoMCompat implements ICompatModule {
    public static void registerGuard(Event event) {
    }

    @Override
    public void onModEventBus(IEventBus iEventBus) {
    }
    @Override
    public void onForgeEventBus(IEventBus iEventBus) {
    }
    @Override
    public void onModEventBusClient(IEventBus iEventBus) {
    }
    @Override
    public void onForgeEventBusClient(IEventBus iEventBus) {
    }

    public static void regIcon(WeaponCategoryIconRegisterEvent event) {
        event.registerCategory(WOMPWeaponCategories.EVIL_TACHI, new ItemStack(WOMItems.EVIL_TACHI.get()));
        event.registerCategory(WOMPWeaponCategories.HOLLOW_LONGSWORD, new ItemStack(WOMItems.HOLLOW_LONGSWORD.get()));
        event.registerCategory(WOMPWeaponCategories.WOM_GREATAXE, new ItemStack(WOMItems.IRON_GREATAXE.get()));
    }

    public static boolean regGuarded = false;

    public static void buildSkillEvent(RegisterEvent event) {
        if (EpicFightSkills.GUARD == null) {
            return;
        }
        if (regGuarded) {
            return;
        }
        try {
            regGuard();
        } catch (Exception e) {
            e.printStackTrace();
        }
        regGuarded = true;
    }

    public static void regGuard() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> guardMotions = new HashMap<>();
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> guardBreakMotions = new HashMap<>();
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> advancedGuardMotions = new HashMap<>();


        guardMotions.put(WOMPWeaponCategories.EVIL_TACHI, (item, player) ->
                WOMPAnimations.EVIL_ODACHI_GUARD_HIT);
        guardBreakMotions.put(WOMPWeaponCategories.EVIL_TACHI, (item, player) ->
                WOMPAnimations.EVIL_ODACHI_NEUTRALIZED);
        advancedGuardMotions.put(WOMPWeaponCategories.EVIL_TACHI, (itemCap, playerpatch) ->
                WOMPAnimations.EVIL_ODACHI_COUNTER);


        guardMotions.put(WOMPWeaponCategories.WOM_GREATAXE, (item, player) ->
                WOMPAnimations.GREATAXE_ONEHAND_GUARD_HIT);
        guardBreakMotions.put(WOMPWeaponCategories.WOM_GREATAXE, (item, player) ->
                Animations.GREATSWORD_GUARD_BREAK);
        advancedGuardMotions.put(WOMPWeaponCategories.WOM_GREATAXE, (itemCap, playerpatch) ->
                WOMPAnimations.GREATAXE_ONEHAND_GUARD_COUNTER);

        guardMotions.put(WOMPWeaponCategories.HOLLOW_LONGSWORD, (item, player) ->
                Animations.LONGSWORD_GUARD_HIT);
        guardBreakMotions.put(WOMPWeaponCategories.HOLLOW_LONGSWORD, (item, player) ->
                Animations.BIPED_COMMON_NEUTRALIZED);
        advancedGuardMotions.put(WOMPWeaponCategories.HOLLOW_LONGSWORD, (itemCap, playerpatch) ->
                WOMPAnimations.HOLLOW_GUARD_STANCE_COUNTER);

        guardMotions.put(CapabilityItem.WeaponCategories.SHIELD, (item, player) ->
                Animations.BIPED_HIT_SHIELD);
        guardBreakMotions.put(CapabilityItem.WeaponCategories.SHIELD, (item, player) ->
                Animations.BIPED_COMMON_NEUTRALIZED);
        advancedGuardMotions.put(CapabilityItem.WeaponCategories.SHIELD, (itemCap, playerpatch) ->
                WOMPAnimations.HOLLOW_GUARD_STANCE_COUNTER);


        Field temp;
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> target;
        temp = GuardSkill.class.getDeclaredField("guardMotions");
        temp.setAccessible(true);
        target = (Map) temp.get(WOMSkills.COUNTER_ATTACK);
        for (WeaponCategory weaponCapability : guardMotions.keySet()) {
            target.put(weaponCapability, guardMotions.get(weaponCapability));
        }
        target = (Map) temp.get(WOMSkills.VENGEFUL_PARRY);
        for (WeaponCategory weaponCapability : guardMotions.keySet()) {
            target.put(weaponCapability, guardMotions.get(weaponCapability));
        }

        temp = GuardSkill.class.getDeclaredField("guardBreakMotions");
        temp.setAccessible(true);
        target = (Map) temp.get(WOMSkills.COUNTER_ATTACK);
        for (WeaponCategory weaponCapability : guardBreakMotions.keySet()) {
            target.put(weaponCapability, guardBreakMotions.get(weaponCapability));
        }
        target = (Map) temp.get(WOMSkills.VENGEFUL_PARRY);
        for (WeaponCategory weaponCapability : guardBreakMotions.keySet()) {
            target.put(weaponCapability, guardBreakMotions.get(weaponCapability));
        }

        temp = GuardSkill.class.getDeclaredField("advancedGuardMotions");
        temp.setAccessible(true);
        target = (Map) temp.get(WOMSkills.COUNTER_ATTACK);
        for (WeaponCategory weaponCapability : advancedGuardMotions.keySet()) {
            target.put(weaponCapability, advancedGuardMotions.get(weaponCapability));
        }

    }
}