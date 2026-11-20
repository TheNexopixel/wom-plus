package net.womp.gameasset.animation;

import net.minecraftforge.fml.ModList;
import net.shelmarow.combat_evolution.CombatEvolution;
import net.womp.gameasset.animation.executions.WOMPExecutions;
import yesman.epicfight.api.animation.AnimationManager;


public class ANIMBuilder {
    public static void buildAnimations(AnimationManager.AnimationBuilder builder) {

        WOMPAnimations.build(builder);

        if(ModList.get().isLoaded(CombatEvolution.MOD_ID)) {
            WOMPExecutions.build(builder);
        }

    }


}

