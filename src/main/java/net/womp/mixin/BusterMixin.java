package net.womp.mixin;

import net.womp.gameasset.animation.WOMPAnimations;
import net.womp.gameasset.animation.WOMPCollider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
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
            cir.setReturnValue(WOMPAnimations.EVIL_ODACHI_OVERHEADSLASH_CHARGE);
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Inject(method = "getReleaseAnimataion", at = @At("HEAD"), cancellable = true)
    private void evilTachiRelease(CapabilityItem capabilityItem, PlayerPatch<?> playerPatch, CallbackInfoReturnable<AnimationManager.AnimationAccessor<? extends StaticAnimation>> cir){
        if(capabilityItem.getWeaponCollider() == WOMPCollider.EVIL_TACHI){
            cir.setReturnValue(WOMPAnimations.EVIL_ODACHI_OVERHEADSLASH_RELEASE);
        }
    }

}
