package net.womp.events;


import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.womp.WomPLUS;
import net.womp.gameasset.animation.ANIMBuilder;
import yesman.epicfight.api.animation.AnimationManager;

@Mod.EventBusSubscriber(modid = WomPLUS.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvent {

    @SubscribeEvent
    public static void registerAnimation(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(WomPLUS.MODID, ANIMBuilder::buildAnimations);
    }


}
