package net.womp.api.animation;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.damagesource.StunType;

import java.util.List;


public class AnimUtils {
    public static AnimationEvent.SimpleEvent<AnimationEvent.Event<?, ?, ?, ?, ?, ?, ?, ?, ?, ?>> LaunchEnemyAirSlash(float height) {

        return AnimationEvent.SimpleEvent.create(
                (livingEntityPatch, assetAccessor, animationParameters) -> {

                    if (!livingEntityPatch.isLastAttackSuccess()) {
                        return;
                    }

                    List<LivingEntity> targets =
                            livingEntityPatch.getCurrentlyActuallyHitEntities();

                    if (targets == null || targets.isEmpty()) {
                        return;
                    }

                    for (LivingEntity entity : targets) {

                        if (entity == null || !entity.isAlive()) {
                            continue;
                        }

                        LivingEntityPatch<?> targetPatch =
                                EpicFightCapabilities.getEntityPatch(
                                        entity,
                                        LivingEntityPatch.class
                                );

                        if (targetPatch != null && !targetPatch.isStunned()) {

                            float stunTime = height * (
                                    1.0F - (float) entity.getAttributeValue(
                                            Attributes.KNOCKBACK_RESISTANCE
                                    )
                            );

                            targetPatch.applyStun(
                                    StunType.HOLD,
                                    stunTime
                            );
                        }

                        entity.addEffect(
                                new MobEffectInstance(
                                        MobEffects.LEVITATION,
                                        4,
                                        5,
                                        true,
                                        false,
                                        false
                                )
                        );
                    }
                },
                AnimationEvent.Side.SERVER
        );
    }

}
