package net.womp.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.womp.WomPLUS;
import net.womp.client.particle.RandomSharpCutParticle;
import net.womp.client.particle.WomPlusParticles;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid= WomPLUS.MODID, value= Dist.CLIENT, bus= Mod.EventBusSubscriber.Bus.MOD)
public class ClientModBusEvent {


    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onParticleRegistry(final RegisterParticleProvidersEvent event) {

        event.registerSpecial(WomPlusParticles.randomSlashHitParticleTYPE.get(), new RandomSharpCutParticle.Provider() );



    }


}
