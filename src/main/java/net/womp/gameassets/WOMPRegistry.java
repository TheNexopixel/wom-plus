package net.womp.gameassets;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.womp.client.particle.WOMPlusParticles;
import net.womp.effect.WOMPEffects;
import net.womp.skill.WOMPSkills;
import net.womp.world.capabilities.item.WOMPConditionals;
import net.womp.world.capabilities.item.WOMPItemCapabilitesPreset;
import net.womp.world.capabilities.item.WOMPMovesets;
import net.womp.world.item.WOMPCreativeTab;

import java.util.List;

public class WOMPRegistry {
    public static List<DeferredRegister<?>> REGISTERS =
            List.of(
                    WOMPCreativeTab.CREATIVE_MODE_TABS,
                    WOMPEffects.EFFECTS,
                    WOMPlusParticles.PARTICLES,
                    WOMPSounds.SOUNDS,
                    WOMPItemCapabilitesPreset.REGISTRY,
                    WOMPMovesets.REGISTRY,
                    WOMPSkills.REGISTRY,
                    WOMPConditionals.REGISTRY
            );
}
