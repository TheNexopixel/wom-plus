package net.womp.world.capabilities.item;

import net.minecraft.world.InteractionHand;
import net.womp.WOMPlus;
import yesman.epicfight.api.ex_cap.provider.ProviderConditional;
import yesman.epicfight.registry.deferred.ProviderConditionalRegister;
import yesman.epicfight.registry.deferred.holders.DeferredConditional;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

@SuppressWarnings("UnstableAPIUsage")
public class WOMPConditionals {
    public static ProviderConditionalRegister REGISTRY = ProviderConditionalRegister.create(WOMPlus.MODID);

    public static final DeferredConditional DUAL_GREATAXES = REGISTRY.registerConditional(
            "dual_greataxes",
            () -> ProviderConditional.createWeaponCategory(CapabilityItem.Styles.TWO_HAND, WOMPWeaponCategories.WOM_GREATAXE, InteractionHand.OFF_HAND, true)
    );
    public static final DeferredConditional DUAL_NOVA = REGISTRY.registerConditional(
            "nova_dual",
            () -> ProviderConditional.createWeaponCategory(CapabilityItem.Styles.TWO_HAND, WOMPWeaponCategories.NOVA, InteractionHand.OFF_HAND, true)
    );
}
