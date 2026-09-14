package net.womp.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.womp.WOMPlus;
import net.womp.client.particle.RandomSharpCutParticle;
import net.womp.client.particle.WOMPlusParticles;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = WOMPlus.MODID, value = Dist.CLIENT)
public class ClientModBusEvent {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onParticleRegistry(final RegisterParticleProvidersEvent event) {
        event.registerSpecial(WOMPlusParticles.RandomSlashHitParticle.get(), new RandomSharpCutParticle.Provider() );
    }
}
