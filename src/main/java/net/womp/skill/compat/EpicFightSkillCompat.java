package net.womp.skill.compat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.womp.WomPLUS;
import net.womp.gameasset.animation.WOMPAnimations;
import net.womp.world.capabilities.item.WOMPWeaponCategories;
import reascer.wom.world.item.WOMItems;
import yesman.epicfight.api.client.forgeevent.WeaponCategoryIconRegisterEvent;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.guard.ParryingSkill;
import yesman.epicfight.skill.passive.SwordmasterSkill;

import java.util.List;


@Mod.EventBusSubscriber(modid = WomPLUS.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EpicFightSkillCompat {
    public static void forceGuard(SkillBuildEvent bus) {
    }

    @SubscribeEvent
    public static void onGuardSkillCreate(SkillBuildEvent.ModRegistryWorker.SkillCreateEvent<GuardSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "guard"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();
            builder.addGuardMotion(WOMPWeaponCategories.EVIL_TACHI, (item, player) -> WOMPAnimations.EVIL_ODACHI_GUARD_HIT)
            .addGuardBreakMotion(WOMPWeaponCategories.EVIL_TACHI, (item, player) -> WOMPAnimations.EVIL_ODACHI_NEUTRALIZED);

            builder.addGuardMotion(WOMPWeaponCategories.WOM_GREATAXE, (item, player) -> WOMPAnimations.GREATAXE_ONEHAND_GUARD_HIT)
                    .addGuardBreakMotion(WOMPWeaponCategories.WOM_GREATAXE, (item, player) -> Animations.GREATSWORD_GUARD_BREAK);

        }
    }
    @SubscribeEvent
    public static void onSwordSkillCreate(SkillBuildEvent.ModRegistryWorker.SkillCreateEvent<SwordmasterSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight","swordmaster"))) {
            SwordmasterSkill.Builder builder = event.getSkillBuilder();
            builder.addAvailableWeaponCategory(WOMPWeaponCategories.EVIL_TACHI);
        }
    }

    @SubscribeEvent
    public static void onParrySkillCreate(SkillBuildEvent.ModRegistryWorker.SkillCreateEvent<ParryingSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "parrying"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();
            builder.addGuardMotion(WOMPWeaponCategories.WOM_GREATAXE, (item, player) -> WOMPAnimations.GREATAXE_ONEHAND_GUARD_HIT)
                    .addGuardBreakMotion(WOMPWeaponCategories.WOM_GREATAXE, (item, player) -> Animations.GREATSWORD_GUARD_BREAK);

            builder.addGuardMotion(WOMPWeaponCategories.EVIL_TACHI, (item, player) -> WOMPAnimations.EVIL_ODACHI_GUARD_HIT)
                    .addGuardBreakMotion(WOMPWeaponCategories.EVIL_TACHI, (item, player) -> WOMPAnimations.EVIL_ODACHI_NEUTRALIZED)
                    .addAdvancedGuardMotion(WOMPWeaponCategories.EVIL_TACHI, (item, player) -> List.of(WOMPAnimations.EVIL_ODACHI_PARRY1, WOMPAnimations.EVIL_ODACHI_PARRY2));
        }
    }
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onIconCreate(WeaponCategoryIconRegisterEvent icon){
        icon.registerCategory(WOMPWeaponCategories.EVIL_TACHI, new ItemStack(WOMItems.EVIL_TACHI.get()));
        icon.registerCategory(WOMPWeaponCategories.WOM_GREATAXE, new ItemStack(WOMItems.IRON_GREATAXE.get()));

    }

}
