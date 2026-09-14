package net.womp.gameassets;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.womp.WOMPlus;

import java.util.function.Supplier;

public class WOMPSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, WOMPlus.MODID);

    public static final Supplier<SoundEvent> skeleton_banging = registerSound();

    private static Supplier<SoundEvent> registerSound() {
        ResourceLocation res = ResourceLocation.fromNamespaceAndPath(WOMPlus.MODID, "sfx.skeleton_banging");
        return SOUNDS.register("sfx.skeleton_banging", () -> SoundEvent.createVariableRangeEvent(res));
    }
}
