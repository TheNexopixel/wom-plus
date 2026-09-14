package net.womp.gameassets.animation;

import yesman.epicfight.api.animation.AnimationManager;

public class WOMPAnimationBuilder {

    public static void buildAnimations(AnimationManager.AnimationBuilder builder) {
        WOMPAnimations.build(builder);
        /*
        if(ModList.get().isLoaded(CombatEvolution.MOD_ID)) {
            WOMPExecutions.build(builder);
        }
        */
    }
}
