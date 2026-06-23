package net.womp.gameasset.animation.executions;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.shelmarow.combat_evolution.api.event.RegisterCustomExecutionEvent;
import reascer.wom.main.WeaponsOfMinecraft;
import reascer.wom.world.item.WOMItems;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.main.EpicFightMod;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.item.GloveItem;

public class  CombatEvolutionCompat implements ICompatModule {

    public static void registerExecution(RegisterCustomExecutionEvent event){

            event.registerExecutionByItem(WeaponsOfMinecraft.identifier("evil_tachi"), CapabilityItem.Styles.TWO_HAND,
                    WOMPExecutionTypes.EVIL_TACHI);

            event.registerExecutionByItem(WeaponsOfMinecraft.identifier("iron_greataxe"), CapabilityItem.Styles.TWO_HAND,
                    WOMPExecutionTypes.GREATAXE_DUAL);
            event.registerExecutionByItem(WeaponsOfMinecraft.identifier("golden_greataxe"), CapabilityItem.Styles.TWO_HAND,
                    WOMPExecutionTypes.GREATAXE_DUAL);
            event.registerExecutionByItem(WeaponsOfMinecraft.identifier("diamond_greataxe"), CapabilityItem.Styles.TWO_HAND,
                    WOMPExecutionTypes.GREATAXE_DUAL);
            event.registerExecutionByItem(WeaponsOfMinecraft.identifier("netherite_greataxe"), CapabilityItem.Styles.TWO_HAND,
                    WOMPExecutionTypes.GREATAXE_DUAL);



    }


    @Override
    public void onModEventBus(IEventBus iEventBus) {
        iEventBus.addListener(CombatEvolutionCompat::registerExecution);
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


}
