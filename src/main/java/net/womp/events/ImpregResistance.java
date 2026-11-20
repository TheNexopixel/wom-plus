package net.womp.events;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.womp.WomPLUS;
import net.womp.effect.WOMPEffects;
import net.womp.skill.WOMPSkills;
import yesman.epicfight.api.forgeevent.EntityStunEvent;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.damagesource.StunType;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = WomPLUS.MODID,bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ImpregResistance {

    @SubscribeEvent
    public static void resistance(LivingDamageEvent event) {
        var effectInstance = event.getEntity().getEffect(WOMPEffects.IMPREGNABILITY.get());

        if (effectInstance != null && !event.isCanceled()) {
            float originalAmount = event.getAmount();

            float reductionFactor = 1.0f - ((effectInstance.getAmplifier() + 1) * 0.10f);

            reductionFactor = Math.max(0.0f, reductionFactor);

            event.setAmount(originalAmount * reductionFactor);
        }
    }

    @SubscribeEvent
    public static void onStun(EntityStunEvent event) {
        LivingEntity entity = event.getStunnedEntityPatch().getOriginal();
        StunType stunType = event.getStunType();
        if (entity.hasEffect(WOMPEffects.IMPREGNABILITY.get()) && stunType != StunType.NEUTRALIZE) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onKB(LivingKnockBackEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(WOMPEffects.IMPREGNABILITY.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onEquipMentChange(LivingEquipmentChangeEvent event) {
        if (event.getSlot().equals(EquipmentSlot.MAINHAND) && event.getEntity().hasEffect(WOMPEffects.IMPREGNABILITY.get())) {
            LivingEntity target = event.getEntity();
            if (target instanceof ServerPlayer player) {
                ServerPlayerPatch playerPatch = EpicFightCapabilities.getServerPlayerPatch(player);
                if (playerPatch != null) {
                    if (!playerPatch.getAdvancedHoldingItemCapability(InteractionHand.MAIN_HAND).isEmpty()
                            && !Objects.equals(playerPatch.getAdvancedHoldingItemCapability(InteractionHand.MAIN_HAND)
                            .getInnateSkill(playerPatch, playerPatch.getValidItemInHand(InteractionHand.MAIN_HAND)), WOMPSkills.RAAAHHH)

                    ) {
                        target.removeEffect(WOMPEffects.IMPREGNABILITY.get());
                    }
                }
            }
        }
    }
}
