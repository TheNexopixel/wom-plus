package net.womp.mixin;

import net.womp.gameassets.animation.WOMPAnimations;
import net.womp.gameassets.animation.WOMPCollider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import reascer.wom.gameasset.animations.weapons.AnimsNova;
import reascer.wom.gameasset.colliders.WOMWeaponColliders;
import reascer.wom.skill.guard.DreadFullBusterSkill;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;


@Mixin(value = DreadFullBusterSkill.class, remap = false)
public class BusterMixin {

    @Inject(method = "getWindupAnimation", at = @At("HEAD"), cancellable = true)
    private void evilTachiWindup(CapabilityItem capabilityItem, PlayerPatch<?> playerPatch, CallbackInfoReturnable<AnimationManager.AnimationAccessor<?>> cir) {
        if (capabilityItem.getWeaponCollider() == WOMPCollider.EVIL_TACHI) {
            cir.setReturnValue(WOMPAnimations.EVIL_TACHI_NEW_DFB_WINDUP);
        }
        if (capabilityItem.getWeaponCollider() == WOMPCollider.BLACKSTAR) {
            cir.setReturnValue(WOMPAnimations.BLACKSTAR_DFB_WINDUP);
        }
        if (capabilityItem.getWeaponCollider() == WOMWeaponColliders.NOVA) {
            cir.setReturnValue (capabilityItem.getStyle(playerPatch) == CapabilityItem.Styles.TWO_HAND ? AnimsNova.NOVA_BUSTER_WINDUP : WOMPAnimations.NOVA_ONEHAND_DFB_WINDUP);
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Inject(method = "getReleaseAnimataion", at = @At("HEAD"), cancellable = true)
    private void evilTachiRelease(CapabilityItem capabilityItem, PlayerPatch<?> playerPatch, CallbackInfoReturnable<AnimationManager.AnimationAccessor<? extends StaticAnimation>> cir){
        if(capabilityItem.getWeaponCollider() == WOMPCollider.EVIL_TACHI){
            cir.setReturnValue(WOMPAnimations.EVIL_TACHI_NEW_DFB_RELEASE);
        }
        if (capabilityItem.getWeaponCollider() == WOMPCollider.BLACKSTAR) {
            cir.setReturnValue(WOMPAnimations.BLACKSTAR_DFB_RELEASE);
        }
        if (capabilityItem.getWeaponCollider() == WOMWeaponColliders.NOVA) {
            cir.setReturnValue (capabilityItem.getStyle(playerPatch) == CapabilityItem.Styles.TWO_HAND ? AnimsNova.NOVA_BUSTER_RELEASE : WOMPAnimations.NOVA_ONEHAND_DFB_RELEASE);
        }
    }

}
