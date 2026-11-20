package net.womp.mixin;

import net.womp.gameasset.animation.WOMPAnimations;
import net.womp.gameasset.animation.WOMPCollider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import reascer.wom.gameasset.colliders.WOMWeaponColliders;
import reascer.wom.skill.guard.DreadFullBusterSkill;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;


@Mixin(value = DreadFullBusterSkill.class, remap = false)
public class BusterMixin {

    @Inject(method = "getWindupAnimation", at = @At("HEAD"), cancellable = true)
    private void DFBWindup(CapabilityItem capabilityItem, PlayerPatch<?> playerPatch, CallbackInfoReturnable<AnimationManager.AnimationAccessor<?>> cir) {
        if (capabilityItem.getWeaponCollider() == WOMPCollider.EVIL_TACHI) {
            cir.setReturnValue(WOMPAnimations.EVIL_TACHI_NEW_DFB_WINDUP);
        }
        if (capabilityItem.getWeaponCollider() == WOMPCollider.BLACKSTAR) {
            cir.setReturnValue(WOMPAnimations.BLACKSTAR_DFB_WINDUP);
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Inject(method = "getReleaseAnimataion", at = @At("HEAD"), cancellable = true)
    private void DFBRelease(CapabilityItem capabilityItem, PlayerPatch<?> playerPatch, CallbackInfoReturnable<AnimationManager.AnimationAccessor<? extends StaticAnimation>> cir){
        if(capabilityItem.getWeaponCollider() == WOMPCollider.EVIL_TACHI){
            cir.setReturnValue(WOMPAnimations.EVIL_TACHI_NEW_DFB_RELEASE);
        }
        if (capabilityItem.getWeaponCollider() == WOMPCollider.BLACKSTAR) {
            cir.setReturnValue(WOMPAnimations.BLACKSTAR_DFB_RELEASE);
        }
    }

}
