package net.womp.world.capabilities.item;

import net.womp.WOMPlus;
import net.womp.gameassets.animation.WOMPAnimations;
import net.womp.skill.WOMPSkills;
import reascer.wom.gameasset.WOMAnimations;
import reascer.wom.gameasset.WOMSkills;
import reascer.wom.gameasset.animations.weapons.AnimsBlackstar;
import reascer.wom.gameasset.animations.weapons.AnimsNova;
import reascer.wom.gameasset.animations.weapons.AnimsRuine;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.data.Moveset;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.registry.deferred.MovesetRegister;
import yesman.epicfight.registry.deferred.holders.DeferredMoveset;
import yesman.epicfight.registry.entries.EpicFightSkills;

public final class WOMPMovesets
{
    private WOMPMovesets() {}
    public static final MovesetRegister REGISTRY = MovesetRegister.create(WOMPlus.MODID);

    public static final DeferredMoveset EVIL_TACHI_REIFT = REGISTRY.registerMoveset("evil_tachi_reift", () -> Moveset.builder()
            .addComboAttacks(
                    WOMPAnimations.EVIL_TACHI_NEW_AUTO1,
                    WOMPAnimations.EVIL_TACHI_NEW_AUTO2,
                    WOMPAnimations.EVIL_TACHI_NEW_AUTO3,
                    WOMPAnimations.EVIL_TACHI_NEW_AUTO4,
                    WOMPAnimations.EVIL_TACHI_NEW_DASH,
                    WOMPAnimations.EVIL_TACHI_NEW_AIRSLASH
            )
            .addLivingMotionModifier(LivingMotions.IDLE, WOMPAnimations.EVIL_TACHI_NEW_IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, WOMPAnimations.EVIL_ODACHI_WALK)
            .addLivingMotionModifier(LivingMotions.SNEAK, WOMPAnimations.EVIL_ODACHI_SNEAK)
            .addLivingMotionModifier(LivingMotions.KNEEL, WOMPAnimations.EVIL_ODACHI_KNEEL)
            .addLivingMotionModifier(LivingMotions.RUN, WOMPAnimations.EVIL_ODACHI_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, WOMPAnimations.EVIL_ODACHI_GUARD)
            .addInnateSkill((itemStack, playerPatch) -> WOMPSkills.EVIL_PUNISHMENT.get())
    );

    public static final DeferredMoveset EVIL_TACHI = REGISTRY.registerMoveset("evil_tachi", () -> Moveset.builder()
            .addComboAttacks(
                    WOMPAnimations.EVIL_ODACHI_AUTO1,
                    WOMPAnimations.EVIL_ODACHI_AUTO2,
                    WOMPAnimations.EVIL_ODACHI_AUTO3,
                    WOMPAnimations.EVIL_ODACHI_AUTO4,
                    WOMPAnimations.EVIL_ODACHI_AUTO5,
                    WOMPAnimations.EVIL_ODACHI_DASH,
                    WOMPAnimations.EVIL_TACHI_NEW_AIRSLASH
            )
            .addLivingMotionModifier(LivingMotions.IDLE, WOMPAnimations.EVIL_ODACHI_IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, WOMPAnimations.EVIL_ODACHI_WALK)
            .addLivingMotionModifier(LivingMotions.SNEAK, WOMPAnimations.EVIL_ODACHI_SNEAK)
            .addLivingMotionModifier(LivingMotions.KNEEL, WOMPAnimations.EVIL_ODACHI_KNEEL)
            .addLivingMotionModifier(LivingMotions.RUN, WOMPAnimations.EVIL_ODACHI_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, WOMPAnimations.EVIL_ODACHI_GUARD)
            .setPassiveSkill(WOMSkills.EVIL_TACHI_PASSIVE)
            .addInnateSkill((itemStack, playerPatch) -> WOMPSkills.EVIL_BEAAAAMMMM.get())
    );

    public static final DeferredMoveset BLACKSTAR = REGISTRY.registerMoveset("blackstar", () -> Moveset.builder()
            .addComboAttacks(
                    AnimsBlackstar.BLACKSTAR_ATTACK_1,
                    AnimsBlackstar.BLACKSTAR_ATTACK_2,
                    AnimsBlackstar.BLACKSTAR_ATTACK_3,
                    AnimsBlackstar.BLACKSTAR_ATTACK_4,
                    AnimsBlackstar.BLACKSTAR_CHOCKNWAVE,
                    AnimsBlackstar.BLACKSTAR_GRAVITY
            )
            .addLivingMotionModifier(LivingMotions.IDLE, AnimsBlackstar.BLACKSTAR_IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, AnimsBlackstar.BLACKSTAR_WALK)
            .addLivingMotionModifier(LivingMotions.RUN, AnimsBlackstar.BLACKSTAR_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, Animations.SPEAR_GUARD)
            .setPassiveSkill(WOMSkills.UNBREAKABLE_PASSIVE)
            .addInnateSkill((itemStack, playerPatch) -> WOMSkills.UNBREAKBLE.get())
    );
    public static final DeferredMoveset NOVA_2H = REGISTRY.registerMoveset("nova_2h", () -> Moveset.builder()
            .addComboAttacks(
                    AnimsNova.NOVA_ATTACK_1,
                    AnimsNova.NOVA_ATTACK_2,
                    AnimsNova.NOVA_ATTACK_3,
                    AnimsNova.NOVA_ATTACK_4,
                    AnimsNova.NOVA_ATTACK_DASH,
                    AnimsNova.NOVA_ATTACK_AIRSLASH
            )
            .addLivingMotionModifier(LivingMotions.IDLE, AnimsNova.NOVA_IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, AnimsNova.NOVA_WALK)
            .addLivingMotionModifier(LivingMotions.RUN, AnimsNova.NOVA_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, AnimsNova.NOVA_GUARD_HOLD)
            .addInnateSkill((itemStack, playerPatch) -> WOMSkills.FLASH_MUTILATION.get())
    );

    public static final DeferredMoveset NOVA_1H = REGISTRY.registerMoveset("nova_1h", () -> Moveset.builder()
            .addComboAttacks(
                    WOMPAnimations.NOVA_ONEHAND_AUTO1,
                    WOMPAnimations.NOVA_ONEHAND_AUTO2,
                    WOMPAnimations.NOVA_ONEHAND_AUTO3,
                    WOMPAnimations.NOVA_ONEHAND_AUTO4,
                    WOMPAnimations.NOVA_ONEHAND_DASH,
                    WOMPAnimations.NOVA_ONEHAND_AIRSLASH
            )
            .addLivingMotionModifier(LivingMotions.IDLE, WOMPAnimations.NOVA_ONEHAND_IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, AnimsBlackstar.BLACKSTAR_WALK)
            .addLivingMotionModifier(LivingMotions.RUN, WOMAnimations.STAFF_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, AnimsRuine.RUINE_GUARD)
            .addInnateSkill((itemStack, playerPatch) -> WOMPSkills.ASTRAL_ACCELERATION.get())
    );

    public static final DeferredMoveset GREATAXE_1H = REGISTRY.registerMoveset("greataxe_1h", () -> Moveset.builder()
            .addComboAttacks(
                    WOMPAnimations.GREATAXE_ONEHAND_AUTO1,
                    WOMPAnimations.GREATAXE_ONEHAND_AUTO2,
                    WOMPAnimations.GREATAXE_ONEHAND_AUTO3,
                    WOMPAnimations.GREATAXE_ONEHAND_AUTO4,
                    WOMPAnimations.GREATAXE_ONEHAND_DASH,
                    WOMPAnimations.GREATAXE_ONEHAND_AIRSLASH_NEW
            )
            .addLivingMotionModifier(LivingMotions.IDLE, WOMPAnimations.GREATAXE_ONEHAND_IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, WOMPAnimations.GREATAXE_ONEHAND_WALK)
            .addLivingMotionModifier(LivingMotions.RUN, WOMPAnimations.GREATAXE_ONEHAND_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, WOMPAnimations.GREATAXE_ONEHAND_GUARD)
            .addInnateSkill((itemStack, playerPatch) -> WOMPSkills.COMET.get())
    );

    public static final DeferredMoveset GREATAXE_2H = REGISTRY.registerMoveset("greataxe_2h", () -> Moveset.builder()
            .addComboAttacks(
                    WOMPAnimations.GREATAXE_DUAL_REIFT_AUTO1,
                    WOMPAnimations.GREATAXE_DUAL_REIFT_AUTO2,
                    WOMPAnimations.GREATAXE_DUAL_REIFT_AUTO3,
                    WOMPAnimations.GREATAXE_DUAL_REIFT_AUTO4,
                    WOMPAnimations.GREATAXE_DUAL_REIFT_DASH,
                    WOMPAnimations.GREATAXE_AIRSLASH
            )
            .addLivingMotionModifier(LivingMotions.IDLE, WOMPAnimations.GREATAXE_DUAL_REIFT_IDLE)
            .addLivingMotionModifier(LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD)
            .addLivingMotionModifier(LivingMotions.WALK, WOMPAnimations.GREATAXE_DUAL_WALK)
            .addLivingMotionModifier(LivingMotions.RUN, WOMPAnimations.GREATAXE_DUAL_RUN)
            .addInnateSkill((itemStack, playerPatch) -> WOMPSkills.ANNIHILATE.get())
    );

    public static final DeferredMoveset HOLLOW_LONGSWORD_2H = REGISTRY.registerMoveset("hollow_longsword_2h", () -> Moveset.builder()
            .addComboAttacks(
                    WOMPAnimations.HOLLOW_ONEHANDED_AUTO1,
                    WOMPAnimations.HOLLOW_ONEHANDED_AUTO2,
                    WOMPAnimations.HOLLOW_ONEHANDED_AUTO3,
                    Animations.LONGSWORD_DASH,
                    Animations.LONGSWORD_AIR_SLASH
            )
            .addLivingMotionModifier(LivingMotions.IDLE, WOMPAnimations.HOLLOW_ONEHANDED_IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, WOMPAnimations.HOLLOW_ONEHANDED_WALK)
            .addLivingMotionModifier(LivingMotions.RUN, Animations.BIPED_RUN_LONGSWORD)
            .addLivingMotionModifier(LivingMotions.BLOCK, Animations.LONGSWORD_GUARD)
            .addInnateSkill((itemStack, playerPatch) -> EpicFightSkills.SHARP_STAB.get())
    );

    public static final DeferredMoveset HOLLOW_LONGSWORD_GUARD = REGISTRY.registerMoveset("hollow_longsword_guard", () -> Moveset.builder()
            .addComboAttacks(
                    WOMPAnimations.HOLLOW_GUARD_STANCE_AUTO1,
                    WOMPAnimations.HOLLOW_GUARD_STANCE_AUTO2,
                    WOMPAnimations.HOLLOW_GUARD_STANCE_AUTO3,
                    WOMPAnimations.HOLLOW_GUARD_STANCE_AUTO4,
                    WOMPAnimations.HOLLOW_GUARD_STANCE_AUTO5,
                    WOMPAnimations.HOLLOW_GUARD_STANCE_DASH,
                    WOMPAnimations.HOLLOW_GUARD_STANCE_AIRSLASH
            )
            .addLivingMotionModifier(LivingMotions.IDLE, WOMPAnimations.HOLLOW_GUARD_STANCE_IDLE)
            .addLivingMotionModifier(LivingMotions.WALK, WOMPAnimations.HOLLOW_OCHS_WALK)
            .addLivingMotionModifier(LivingMotions.RUN, WOMPAnimations.HOLLOW_OCHS_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, Animations.LONGSWORD_GUARD)
            .addInnateSkill((itemStack, playerPatch) -> WOMPSkills.RAAAHHH.get())
    );
}