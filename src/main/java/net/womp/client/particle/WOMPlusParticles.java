package net.womp.client.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.womp.WOMPlus;
import yesman.epicfight.particle.HitParticleType;

public class WOMPlusParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, WOMPlus.MODID);


    public static final DeferredHolder<ParticleType<?>, HitParticleType> RandomSlashHitParticle = PARTICLES.register( "random_slash_hit_particle",()  -> new HitParticleType(true, HitParticleType.RANDOM_WITHIN_BOUNDING_BOX, HitParticleType.ZERO));

}
