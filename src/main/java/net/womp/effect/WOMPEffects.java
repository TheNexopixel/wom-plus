package net.womp.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.womp.WomPLUS;
import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;

public class WOMPEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, WomPLUS.MODID);

    public static final RegistryObject<MobEffect> IMPREGNABILITY =
            EFFECTS.register("impregnability",()-> new FortifiedEffect(MobEffectCategory.BENEFICIAL,0xFFC0C0C0)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, "af227945-3f3f-46d9-b600-cc0b9139ffb9", 0.15d, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, "df227945-3b3f-46d9-b600-cc0b9139ffb9", 0.15d, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ARMOR, "df227985-3f8f-46d9-b600-cc0b9139ffb9", 8.0d, AttributeModifier.Operation.ADDITION)
                    .addAttributeModifier(EpicFightAttributes.IMPACT.get(), "df227935-3f3f-46d9-b600-cc0b9139ffb9", 2.5, AttributeModifier.Operation.ADDITION)
                    .addAttributeModifier(EpicFightAttributes.STAMINA_REGEN.get(), "df227985-3f0f-46d9-b600-cc0b9139ffb9", 0.5, AttributeModifier.Operation.ADDITION)
            );
}
