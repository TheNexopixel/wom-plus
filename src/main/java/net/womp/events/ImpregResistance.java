package net.womp.events;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;
import net.womp.WOMPlus;
import net.womp.effect.WOMPEffects;
import net.womp.skill.WOMPSkills;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.event.types.entity.ApplyStunEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.damagesource.StunType;

@EventBusSubscriber(modid = WOMPlus.MODID)
public class ImpregResistance {

    @SubscribeEvent
    public static void applyResistance(LivingIncomingDamageEvent event) {
        var effectInstance = event.getEntity().getEffect(WOMPEffects.IMPREGNABILITY.getDelegate());

        if (effectInstance != null && !event.isCanceled()) {
            float originalAmount = event.getAmount();

            float reductionFactor = 1.0f - ((effectInstance.getAmplifier() + 1) * 0.10f);

            reductionFactor = Math.max(0.0f, reductionFactor);

            event.setAmount(originalAmount * reductionFactor);
        }
    }

    public static void onStun(ApplyStunEvent event) {
        LivingEntity entity = event.getEntityPatch().getOriginal();
        StunType stunType = event.getStunType();
        if (entity.hasEffect(WOMPEffects.IMPREGNABILITY.getDelegate()) && stunType != StunType.NEUTRALIZE) {
            event.setStunTime(0);
            event.setSTunAnimation(null);
        }
    }

    public static void applyEpicFightHooks() {
        EpicFightEventHooks.Entity.APPLY_STUN.registerEvent(ImpregResistance::onStun);
    }

    @SubscribeEvent
    public static void onKnockback(LivingKnockBackEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(WOMPEffects.IMPREGNABILITY.getDelegate())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (event.getSlot().equals(EquipmentSlot.MAINHAND) && event.getEntity().hasEffect(WOMPEffects.IMPREGNABILITY.getDelegate())) {
            LivingEntity target = event.getEntity();
            if (target instanceof ServerPlayer player) {
                ServerPlayerPatch playerPatch = EpicFightCapabilities.getServerPlayerPatch(player);
                if (playerPatch != null) {
                    if (!playerPatch.getAdvancedHoldingItemCapability(InteractionHand.MAIN_HAND).isEmpty()
                            && !(playerPatch.getAdvancedHoldingItemCapability(InteractionHand.MAIN_HAND).getInnateSkill(playerPatch, playerPatch.getValidItemInHand(InteractionHand.MAIN_HAND)) == WOMPSkills.RAAAHHH.get())

                    ) {
                        target.removeEffect(WOMPEffects.IMPREGNABILITY.getDelegate());
                    }
                }
            }
        }
    }
}
