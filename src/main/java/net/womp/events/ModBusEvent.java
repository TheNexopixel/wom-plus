package net.womp.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.womp.WOMPlus;
import net.womp.gameassets.animation.WOMPAnimationBuilder;
import yesman.epicfight.api.animation.AnimationManager;

@EventBusSubscriber(modid = WOMPlus.MODID)
public class ModBusEvent {

    @SubscribeEvent
    public static void registerAnimation(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(WOMPlus.MODID, WOMPAnimationBuilder::buildAnimations);
    }
}
