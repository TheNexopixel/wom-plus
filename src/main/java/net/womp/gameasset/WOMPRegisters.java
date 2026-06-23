package net.womp.gameasset;

import net.minecraftforge.registries.DeferredRegister;
import net.womp.effect.WOMPEffects;
import net.womp.world.item.WOMPCreativeTab;

import java.util.List;

public class WOMPRegisters {

    public static List<DeferredRegister<?>> REGISTERS =
            List.of(
                    WOMPCreativeTab.CREATIVE_MODE_TABS,
                    WOMPEffects.EFFECTS,
                    WOMPSounds.SOUNDS

            );
}
