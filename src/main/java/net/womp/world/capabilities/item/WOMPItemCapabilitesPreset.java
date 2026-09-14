package net.womp.world.capabilities.item;

import net.womp.WOMPlus;
import net.womp.client.particle.WOMPlusParticles;
import net.womp.gameassets.animation.WOMPCollider;
import reascer.wom.gameasset.colliders.WOMWeaponColliders;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.registry.deferred.ItemPresetRegister;
import yesman.epicfight.registry.deferred.holders.DeferredWeapon;
import yesman.epicfight.registry.entries.EpicFightParticles;
import yesman.epicfight.registry.entries.EpicFightProviderConditionals;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public class WOMPItemCapabilitesPreset {

    public static final ItemPresetRegister REGISTRY = ItemPresetRegister.create(WOMPlus.MODID);

    public static final DeferredWeapon EVIL_TACHI_REIFT = REGISTRY.registerWeapon("evil_tachi_reift", () ->
            WeaponCapability.builder()
                    .category(WOMPWeaponCategories.EVIL_TACHI)
                    .collider(WOMPCollider.EVIL_TACHI)
                    .swingSound(EpicFightSounds.WHOOSH)
                    .hitSound(EpicFightSounds.BLADE_HIT)
                    .canBePlacedOffhand(false)
                    .addConditionals(EpicFightProviderConditionals.DEFAULT_2H_WIELD_STYLE)
                    .addMoveset(CapabilityItem.Styles.TWO_HAND, WOMPMovesets.EVIL_TACHI_REIFT));


    public static final DeferredWeapon EVIL_TACHI = REGISTRY.registerWeapon("evil_tachi", () ->
            WeaponCapability.builder()
                    .category(WOMPWeaponCategories.EVIL_TACHI)
                    .collider(WOMPCollider.EVIL_TACHI)
                    .hitParticle(WOMPlusParticles.RandomSlashHitParticle)
                    .swingSound(EpicFightSounds.WHOOSH)
                    .hitSound(EpicFightSounds.BLADE_HIT)
                    .canBePlacedOffhand(false)
                    .addConditionals(EpicFightProviderConditionals.DEFAULT_2H_WIELD_STYLE)
                    .addMoveset(CapabilityItem.Styles.TWO_HAND, WOMPMovesets.EVIL_TACHI));

    public static final DeferredWeapon BLACKSTAR = REGISTRY.registerWeapon("blackstar", () ->
            WeaponCapability.builder()
                    .category(WOMPWeaponCategories.BLACKSTAR)
                    .collider(WOMPCollider.BLACKSTAR)
                    .swingSound(EpicFightSounds.WHOOSH_BIG)
                    .hitParticle(EpicFightParticles.HIT_BLUNT)
                    .hitSound(EpicFightSounds.BLUNT_HIT_HARD)
                    .canBePlacedOffhand(false)
                    .addConditionals(EpicFightProviderConditionals.DEFAULT_2H_WIELD_STYLE)
                    .addMoveset(CapabilityItem.Styles.TWO_HAND, WOMPMovesets.BLACKSTAR));

    public static final DeferredWeapon NOVA = REGISTRY.registerWeapon("nova", () ->
            WeaponCapability.builder()
                    .category(WOMPWeaponCategories.NOVA)
                    .collider(WOMWeaponColliders.NOVA)
                    .swingSound(EpicFightSounds.WHOOSH)
                    .hitParticle(EpicFightParticles.HIT_BLADE)
                    .hitSound(EpicFightSounds.BLADE_HIT)
                    .canBePlacedOffhand(true)
                    .addConditionals(EpicFightProviderConditionals.DEFAULT_1H_WIELD_STYLE, WOMPConditionals.DUAL_NOVA)
                    .addMoveset(CapabilityItem.Styles.ONE_HAND, WOMPMovesets.NOVA_1H)
                    .addMoveset(CapabilityItem.Styles.TWO_HAND, WOMPMovesets.NOVA_2H)
    );

    public static final DeferredWeapon GREATAXE = REGISTRY.registerWeapon("greataxe", () ->
            WeaponCapability.builder()
                    .category(WOMPWeaponCategories.WOM_GREATAXE)
                    .collider(ColliderPreset.GREATSWORD)
                    .swingSound(EpicFightSounds.WHOOSH_BIG)
                    .hitParticle(EpicFightParticles.HIT_BLADE)
                    .hitSound(EpicFightSounds.BLADE_HIT)
                    .canBePlacedOffhand(true)
                    .addConditionals(WOMPConditionals.DUAL_GREATAXES, EpicFightProviderConditionals.DEFAULT_1H_WIELD_STYLE)
                    .addMoveset(CapabilityItem.Styles.TWO_HAND, WOMPMovesets.GREATAXE_2H)
                    .addMoveset(CapabilityItem.Styles.ONE_HAND, WOMPMovesets.GREATAXE_1H));

    public static final DeferredWeapon HOLLOW_LONGSWORD = REGISTRY.registerWeapon("hollow_longsword", () ->
            WeaponCapability.builder()
                    .category(WOMPWeaponCategories.HOLLOW_LONGSWORD)
                    .collider(WOMPCollider.HOLLOW_LONGSWORD)
                    .swingSound(EpicFightSounds.WHOOSH)
                    .hitParticle(EpicFightParticles.HIT_BLADE)
                    .hitSound(EpicFightSounds.BLADE_HIT)
                    .canBePlacedOffhand(false)
                    .addConditionals(EpicFightProviderConditionals.SHIELD_OFFHAND, EpicFightProviderConditionals.DEFAULT_2H_WIELD_STYLE)
                    .addMoveset(CapabilityItem.Styles.ONE_HAND, WOMPMovesets.HOLLOW_LONGSWORD_GUARD)
                    .addMoveset(CapabilityItem.Styles.TWO_HAND, WOMPMovesets.HOLLOW_LONGSWORD_2H));
}
