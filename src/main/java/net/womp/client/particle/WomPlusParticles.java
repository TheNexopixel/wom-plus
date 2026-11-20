package net.womp.client.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.womp.WomPLUS;
import yesman.epicfight.particle.HitParticleType;


public class WomPlusParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, WomPLUS.MODID);


    public static final RegistryObject<HitParticleType> randomSlashHitParticleTYPE = PARTICLES.register( "random_slash_hit_particle",()  -> new HitParticleType(true, HitParticleType.RANDOM_WITHIN_BOUNDING_BOX, HitParticleType.ZERO));

}
