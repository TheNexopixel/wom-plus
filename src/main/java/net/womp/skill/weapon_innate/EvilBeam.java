package net.womp.skill.weapon_innate;

import net.minecraft.nbt.CompoundTag;
import net.womp.gameassets.animation.WOMPAnimations;
import reascer.wom.world.item.WOMItems;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;

public class EvilBeam extends SimpleWeaponInnateSkill {

    private static final float STAMINA_COST = 6.0F;

    public EvilBeam(Builder builder) {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener listener) {
        super.onInitiate(container, listener);
        listener.registerEvent(EpicFightEventHooks.Player.CONSUME_SKILL, (event) -> {
            if (event.getSkill() == container.getSkill() && container.getExecutor().getOriginal().isSprinting()) {
                event.setResourceType(Resource.NONE);
                container.activate();
            }
        }, this);
    }

    @Override
    public void executeOnServer(SkillContainer container, CompoundTag args) {
        PlayerPatch<?> player = container.getServerExecutor();

        if (player.getOriginal().isSprinting() && player.getOriginal().getMainHandItem().getItem() == WOMItems.EVIL_TACHI.get()) {

            if (!player.getOriginal().isCreative()){
                player.consumeForSkill(this, Resource.STAMINA, STAMINA_COST);
            }

            player.playAnimationSynchronized(WOMPAnimations.EVIL_ODACHI_BATTOJUTSU, 0.0F);
        }
        super.executeOnServer(container, args);
    }
}