package net.womp.world.capabilities.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.womp.WomPLUS;
import net.womp.gameasset.animation.WOMPAnimations;
import net.womp.gameasset.animation.WOMPCollider;
import net.womp.skill.WOMPSkills;
import reascer.wom.gameasset.WOMSkills;
import reascer.wom.particle.WOMParticles;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.particle.HitParticleType;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = WomPLUS.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WOMPCapabilites {

    public static HitParticleType randomSlashHitParticleTYPE(){
        int randomInt = (int)(Math.random() * (double)4.0F);
        HitParticleType RandomHitParticle;
        switch (randomInt) {
            case 0 -> RandomHitParticle = WOMParticles.SHARPCUT_SLASH.get();
            case 1 -> RandomHitParticle = WOMParticles.SHARPCUT_LEFT_SLASH.get();
            case 2 -> RandomHitParticle = WOMParticles.SHARPCUT_RIGHT_SLASH.get();
            case 3 -> RandomHitParticle = WOMParticles.SHARPCUT_ANGLED_UP_RIGHT_SLASH.get();
            default -> RandomHitParticle = WOMParticles.SHARPCUT_ANGLED_DOWN_LEFT_SLASH.get();
        }
        return RandomHitParticle;
    }
    public static final Function<Item, CapabilityItem.Builder> EVIL_TACHI = (item) ->
            WeaponCapability.builder()
                    .category(WOMPWeaponCategories.EVIL_TACHI)
                    .styleProvider((pp) -> CapabilityItem.Styles.TWO_HAND)
                    .collider(WOMPCollider.EVIL_TACHI)
                    .hitParticle(randomSlashHitParticleTYPE())
                    .swingSound(EpicFightSounds.WHOOSH.get())
                    .hitSound(EpicFightSounds.BLADE_HIT.get())
                    .canBePlacedOffhand(false)
                    .passiveSkill(WOMSkills.EVIL_TACHI_PASSIVE)
                    .innateSkill(CapabilityItem.Styles.TWO_HAND, ip -> WOMPSkills.EVIL_BEAAAAMMMM)
                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND,
                            WOMPAnimations.EVIL_ODACHI_AUTO1,
                            WOMPAnimations.EVIL_ODACHI_AUTO2,
                            WOMPAnimations.EVIL_ODACHI_AUTO3,
                            WOMPAnimations.EVIL_ODACHI_AUTO4,
                            WOMPAnimations.EVIL_ODACHI_AUTO5,
                            WOMPAnimations.EVIL_ODACHI_DASH,
                            WOMPAnimations.EVIL_ODACHI_AIRSLASH)


                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, WOMPAnimations.EVIL_ODACHI_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, WOMPAnimations.EVIL_ODACHI_WALK)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, WOMPAnimations.EVIL_ODACHI_RUN)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, WOMPAnimations.EVIL_ODACHI_GUARD);

    public static final Function<Item, CapabilityItem.Builder> GREATAXE = (item) ->
            WeaponCapability.builder()
                    .category(WOMPWeaponCategories.WOM_GREATAXE)
                    .styleProvider((pp) -> CapabilityItem.Styles.ONE_HAND)
                    .weaponCombinationPredicator((entityPatch) -> EpicFightCapabilities.getItemStackCapability(entityPatch.getOriginal().getOffhandItem()).getWeaponCategory() == WOMPWeaponCategories.WOM_GREATAXE)
                    .collider(ColliderPreset.GREATSWORD)
                    .styleProvider((pp) ->
                            pp.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == WOMPWeaponCategories.WOM_GREATAXE ? CapabilityItem.Styles.TWO_HAND : CapabilityItem.Styles.ONE_HAND)
                    .swingSound(EpicFightSounds.WHOOSH_BIG.get())
                    .hitParticle(EpicFightParticles.HIT_BLADE.get())
                    .hitSound(EpicFightSounds.BLADE_HIT.get())
                    .canBePlacedOffhand(true)
                    .innateSkill(CapabilityItem.Styles.TWO_HAND, ip -> WOMPSkills.ANNIHILATE)
                    .innateSkill(CapabilityItem.Styles.ONE_HAND, ip -> EpicFightSkills.STEEL_WHIRLWIND)

                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND,
                            WOMPAnimations.GREATAXE_DUAL_AUTO1,
                            WOMPAnimations.GREATAXE_DUAL_AUTO2,
                            WOMPAnimations.GREATAXE_DUAL_AUTO3,
                            WOMPAnimations.GREATAXE_DUAL_AUTO4,
                            WOMPAnimations.GREATAXE_DUAL_DASH,
                            WOMPAnimations.GREATAXE_AIRSLASH)

                    .newStyleCombo(CapabilityItem.Styles.ONE_HAND,
                            WOMPAnimations.GREATAXE_ONEHAND_AUTO1,
                            WOMPAnimations.GREATAXE_ONEHAND_AUTO2,
                            WOMPAnimations.GREATAXE_ONEHAND_AUTO3,
                            Animations.GREATSWORD_DASH,
                            Animations.GREATSWORD_AIR_SLASH)


                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.IDLE, WOMPAnimations.GREATAXE_ONEHAND_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.WALK, WOMPAnimations.GREATAXE_ONEHAND_WALK)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.RUN, WOMPAnimations.GREATAXE_ONEHAND_RUN)

                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, WOMPAnimations.GREATAXE_DUAL_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, WOMPAnimations.GREATAXE_DUAL_WALK)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, WOMPAnimations.GREATAXE_DUAL_RUN);

    public static final Function<Item, CapabilityItem.Builder> HOLLOW_LONGSWORD = (item) ->
            WeaponCapability.builder()
                    .category(CapabilityItem.WeaponCategories.LONGSWORD)
                    .styleProvider((pp) -> CapabilityItem.Styles.ONE_HAND)
                    .collider(WOMPCollider.HOLLOW_LONGSWORD)
                    .styleProvider((pp) ->
                            pp.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.SHIELD ? CapabilityItem.Styles.TWO_HAND : CapabilityItem.Styles.ONE_HAND)
                    .swingSound(EpicFightSounds.WHOOSH.get())
                    .hitParticle(EpicFightParticles.HIT_BLADE.get())
                    .hitSound(EpicFightSounds.BLADE_HIT.get())
                    .canBePlacedOffhand(false)
                    .innateSkill(CapabilityItem.Styles.TWO_HAND, ip -> WOMPSkills.RAAAHHH)
                    .weaponCombinationPredicator((entityPatch) -> EpicFightCapabilities.getItemStackCapability(entityPatch.getOriginal().getOffhandItem()).getWeaponCategory() == CapabilityItem.WeaponCategories.SHIELD)
                    .innateSkill(CapabilityItem.Styles.ONE_HAND, ip -> EpicFightSkills.SHARP_STAB)
                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND,
                            WOMPAnimations.HOLLOW_OCHS_AUTO1,
                            WOMPAnimations.HOLLOW_OCHS_AUTO2,
                            WOMPAnimations.HOLLOW_OCHS_AUTO3,
                            WOMPAnimations.HOLLOW_OCHS_AUTO4,
                            Animations.LONGSWORD_DASH,
                            Animations.LONGSWORD_AIR_SLASH)

                    .newStyleCombo(CapabilityItem.Styles.ONE_HAND,

                            WOMPAnimations.HOLLOW_ONEHANDED_AUTO1,
                            WOMPAnimations.HOLLOW_ONEHANDED_AUTO2,
                            WOMPAnimations.HOLLOW_ONEHANDED_AUTO3,
                            Animations.LONGSWORD_DASH,
                            Animations.LONGSWORD_AIR_SLASH)


                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, WOMPAnimations.HOLLOW_OCHS_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, WOMPAnimations.HOLLOW_OCHS_WALK)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, WOMPAnimations.HOLLOW_OCHS_RUN)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK_SHIELD, Animations.BIPED_BLOCK)

                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.IDLE, WOMPAnimations.HOLLOW_ONEHANDED_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.WALK, WOMPAnimations.HOLLOW_ONEHANDED_WALK)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.RUN, Animations.BIPED_RUN_LONGSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.BLOCK, Animations.LONGSWORD_GUARD)
            ;

    @SubscribeEvent
    public static void WeaponMovesetRegister(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID, "greataxe"), GREATAXE);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID, "hollow_longsword"), HOLLOW_LONGSWORD);
            event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID, "evil_tachi"), EVIL_TACHI);
    }

}
