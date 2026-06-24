package net.womp.gameasset.animation;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.resources.ResourceLocation;
import net.womp.WomPLUS;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;

public class WOMPCollider {
    private static final BiMap<ResourceLocation, Collider> PRESETS = HashBiMap.create();

    public static Collider registerCollider(ResourceLocation rl, Collider collider) {
        if (PRESETS.containsKey(rl)) {
            throw new IllegalStateException("Collider named " + rl + " already registered.");
        }
        PRESETS.put(rl, collider);

        return collider;
    }

    public static final Collider EVIL_TACHI = registerCollider(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID,"evil_tachi"),new MultiOBBCollider(3, 0.3D, 0.3D, 1.6D, 0D, 0.0D, -1.6D));
    public static final Collider EVIL_TACHI_BACK = registerCollider(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID,"evil_tachi_back"),new MultiOBBCollider(3, 0.35D, 0.35D, 0.6D, 0D, 0.0D, 0.7D));
    public static final Collider EVIL_TACHI_SPECIAL = registerCollider(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID,"evil_tachi_special"),new MultiOBBCollider(2, 0.55D, 0.65D, 0.6D, 0D, 0.3D, 0.45D));
    public static final Collider EVIL_TACHI_RAY = registerCollider(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID,"evil_tachi_ray"),new MultiOBBCollider(1, 0.4D, 0.4D, 10.5D, 0D, 1.0D, -11.4D));
    public static final Collider EVIL_TACHI_BATTOJUTSO = registerCollider(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID,"backhand_innate"),new MultiOBBCollider(1, 1.8D, 1.0D, 2.1D, 0D, 1.5D, -0.4D));
    public static final Collider EVIL_TACHI_BUSTER_RELEASE = registerCollider(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID,"whirlwind2"),new MultiOBBCollider(1, 4.0D, 1.2D, 4.0D, 0D, 1.5D, 0.0D));
    public static final Collider SHIELD = registerCollider(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID,"shield"),new MultiOBBCollider(2, 0.35D, 0.55D, 0.75D, 0.0D, 0.15D, -0.35D));
    public static final Collider HOLLOW_LONGSWORD = registerCollider(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID,"bat"),new MultiOBBCollider(4, 0.4D, 0.4D, 1.13D, 0D, 0.0D, -1.23D));
    public static final Collider EVIL_TACHI_COUNTER = registerCollider(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID,"evil_tachi_counter"),new MultiOBBCollider(1, 2.0D, 0.8D, 1.5D, -0.5D, 1.0D, -1.3D));
    public static final Collider GREATAXE_BIG = registerCollider(ResourceLocation.fromNamespaceAndPath(WomPLUS.MODID,"bonesaw4"),new MultiOBBCollider(1, 1.8D, 1.0D, 2.1D, 0D, 0.5D, -1.4D));

}
