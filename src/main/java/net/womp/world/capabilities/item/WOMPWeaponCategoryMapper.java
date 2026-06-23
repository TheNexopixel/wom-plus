package net.womp.world.capabilities.item;

import net.minecraft.world.item.Item;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WOMPWeaponCategoryMapper {
    private static final Map<WOMPWeaponCategories, WeaponCategory> categoryMap = new HashMap<>();

    static {
        categoryMap.put(WOMPWeaponCategories.EVIL_TACHI, CapabilityItem.WeaponCategories.TACHI);
        categoryMap.put(WOMPWeaponCategories.WOM_GREATAXE, CapabilityItem.WeaponCategories.GREATSWORD);
    }
    public static CapabilityItem.Builder apply(Item item, WOMPWeaponCategories category) {
        WeaponCategory mappedCategory = categoryMap.getOrDefault(category, category);
        try {
            Method applyMethod = mappedCategory.getClass().getMethod("apply", Item.class);
            return (CapabilityItem.Builder) applyMethod.invoke(mappedCategory, item);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
