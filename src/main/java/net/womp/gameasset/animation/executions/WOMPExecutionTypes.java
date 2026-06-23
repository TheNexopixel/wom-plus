package net.womp.gameasset.animation.executions;

import net.minecraft.world.phys.Vec3;
import net.shelmarow.combat_evolution.execution.ExecutionTypeManager;

public class WOMPExecutionTypes {

    public static final ExecutionTypeManager.Type GREATAXE_DUAL = new ExecutionTypeManager.Type(
            WOMPExecutions.GREATAXE_DUAL_EXECUTE,
            WOMPExecutions.GREATAXE_DUAL_EXECUTED,
            new Vec3(1.65, 0.0F, 0.0F), 0.0F, 112
    );
    public static final ExecutionTypeManager.Type EVIL_TACHI = new ExecutionTypeManager.Type(
            WOMPExecutions.EVIL_TACHI_EXECUTE,
            WOMPExecutions.EVIL_TACHI_EXECUTED,
            new Vec3(1.35, 0.0F, 0.0F), 0.0F, 128
    );
}
