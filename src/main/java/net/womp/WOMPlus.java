package net.womp;

import com.hm.efn.EFN;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.womp.events.ImpregResistance;
import net.womp.gameassets.WOMPRegistry;
import net.womp.skill.compat.EpicFightSkillCompat;
import net.womp.skill.compat.NightfallSkillCompat;
import net.womp.skill.compat.WOMSkillCompat;
import net.womp.world.capabilities.item.WOMPWeaponCategories;
import org.slf4j.Logger;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.nio.file.Path;
import java.util.Optional;

@Mod(WOMPlus.MODID)
public class WOMPlus {
    public static final String MODID = "womplus";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WOMPlus(IEventBus modEventBus) {
        WOMPRegistry.REGISTERS.forEach(deferredRegister -> deferredRegister.register(modEventBus));

        modEventBus.addListener(this::addPackFindersEvent);

        WeaponCategory.ENUM_MANAGER.registerEnumCls(MODID, WOMPWeaponCategories.class);

        ICompatModule.loadCompatModule(modEventBus, EpicFightSkillCompat.class);
        ICompatModule.loadCompatModule(modEventBus, WOMSkillCompat.class);

        if(ModList.get().isLoaded(EFN.MODID)){
            ICompatModule.loadCompatModule(modEventBus, NightfallSkillCompat.class);
        }

        ImpregResistance.applyEpicFightHooks();
    }

    public void addPackFindersEvent(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            Path resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/wom_override");

            PackLocationInfo packLocation = new PackLocationInfo("wom_override", Component.translatable("pack.wom_override.title"), PackSource.BUILT_IN, Optional.empty());
            addDataPack(event, resourcePath, packLocation);
        }

        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path resourcePath = ModList.get().getModFileById(MODID).getFile().findResource("packs/womplus_trailpack");

            PackLocationInfo packLocation = new PackLocationInfo("womplus_trailpack", Component.translatable("pack.womplus_trailpack.title"), PackSource.BUILT_IN, Optional.empty());
            addResourcePack(event, resourcePath, packLocation);
        }
    }

    private void addResourcePack(AddPackFindersEvent event, Path path, PackLocationInfo packLocationInfo) {
        Pack.ResourcesSupplier packResources = new PathPackResources.PathResourcesSupplier(path);
        Pack newPack = Pack.readMetaAndCreate(packLocationInfo, packResources, PackType.CLIENT_RESOURCES, new PackSelectionConfig(false, Pack.Position.TOP, false));

        if (newPack != null) {
            event.addRepositorySource(source -> source.accept(newPack));
        }
    }

    private void addDataPack(AddPackFindersEvent event, Path path, PackLocationInfo packLocationInfo) {
        Pack.ResourcesSupplier packResources = new PathPackResources.PathResourcesSupplier(path);
        Pack newPack = Pack.readMetaAndCreate(packLocationInfo, packResources, PackType.SERVER_DATA, new PackSelectionConfig(false, Pack.Position.TOP, false));

        if (newPack != null) {
            event.addRepositorySource(source -> source.accept(newPack));
        }
    }
}
