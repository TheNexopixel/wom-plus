package net.womp.world.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.womp.WomPLUS;
import reascer.wom.world.item.WOMItems;

public class WOMPCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WomPLUS.MODID);

    public static final RegistryObject<CreativeModeTab> WOMPLUS = CREATIVE_MODE_TABS.register("womplus", () -> CreativeModeTab.builder().icon(() ->
                    new
                            ItemStack(WOMItems.EVIL_TACHI.get()))
            .title(Component.translatable("creativetab.womplus"))

            .displayItems((itemDisplayParameters, output) -> {
                    output.accept(WOMItems.EVIL_TACHI.get());
                    output.accept(WOMItems.NETHERITE_GREATAXE.get());
                    output.accept(WOMItems.DIAMOND_GREATAXE.get());
                    output.accept(WOMItems.GOLDEN_GREATAXE.get());
                    output.accept(WOMItems.IRON_GREATAXE.get());
                    output.accept(WOMItems.HOLLOW_LONGSWORD.get());
            })
            .build());
}
