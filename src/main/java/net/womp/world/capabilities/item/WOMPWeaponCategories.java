package net.womp.world.capabilities.item;

import net.minecraft.world.item.Item;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

public enum WOMPWeaponCategories implements WeaponCategory {
    WOM_GREATAXE,
    EVIL_TACHI;

    final int id;

    WOMPWeaponCategories() {
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
    }



    @Override
    public int universalOrdinal() {
        return this.id;
    }
    public CapabilityItem.Builder apply(Item item) {
        return WOMPWeaponCategoryMapper.apply(item,this);
    }

}




