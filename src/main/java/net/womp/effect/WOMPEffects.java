package net.womp.effect;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.womp.WOMPlus;
import yesman.epicfight.registry.entries.EpicFightAttributes;

public class WOMPEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, WOMPlus.MODID);

    public static final DeferredHolder<MobEffect, MobEffect> IMPREGNABILITY = EFFECTS.register("impregnability",() -> new FortifiedEffect(MobEffectCategory.BENEFICIAL,0xFFC0C0C0)
            .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(WOMPlus.MODID, "effect.attack_speed"), 0.15d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(WOMPlus.MODID, "effect.attack_strength"), 0.15d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(WOMPlus.MODID, "effect.armor"), 8.0d, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(EpicFightAttributes.IMPACT, ResourceLocation.fromNamespaceAndPath(WOMPlus.MODID, "effect.attack_impact"), 2.5, AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(EpicFightAttributes.STAMINA_REGEN, ResourceLocation.fromNamespaceAndPath(WOMPlus.MODID, "effect.stamina_regen"), 0.5, AttributeModifier.Operation.ADD_VALUE)
    );
}
