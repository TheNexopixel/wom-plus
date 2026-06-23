package net.womp;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.PathPackResources;
import net.shelmarow.combat_evolution.CombatEvolution;
import net.womp.gameasset.WOMPRegisters;
import net.womp.gameasset.animation.executions.CombatEvolutionCompat;
import net.womp.skill.compat.EpicFightSkillCompat;
import net.womp.skill.compat.NightfallCompat;
import net.womp.skill.compat.WoMCompat;
import net.womp.world.capabilities.item.WOMPWeaponCategories;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.nio.file.Path;


@Mod(WomPLUS.MODID)
public class WomPLUS {

    public static final String MODID = "womplus";




    public WomPLUS(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();

        WOMPRegisters.REGISTERS.forEach(deferredRegister -> deferredRegister.register(bus));
        bus.addListener(this::addPackFindersEvent);
        bus.addListener(EpicFightSkillCompat::forceGuard);
        bus.addListener(WoMCompat::buildSkillEvent);
        ICompatModule.loadCompatModule(context, WoMCompat.class);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(WoMCompat::regIcon));

        MinecraftForge.EVENT_BUS.register(this);

        WeaponCategory.ENUM_MANAGER.registerEnumCls(WomPLUS.MODID, WOMPWeaponCategories.class);



        if(ModList.get().isLoaded(CombatEvolution.MOD_ID)){
            ICompatModule.loadCompatModule(context, CombatEvolutionCompat.class);
        }
        if(ModList.get().isLoaded("efn")){
            ICompatModule.loadCompatModule(context, NightfallCompat.class);
        }




    }





    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


        }
    }

    public void addPackFindersEvent(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            Path resourcePath = ModList.get().getModFileById(WomPLUS.MODID).getFile().findResource("packs/wom_override");
            PathPackResources pack = new PathPackResources(ModList.get().getModFileById(WomPLUS.MODID).getFile().getFileName() + ":" + resourcePath, false, resourcePath);
            Pack.ResourcesSupplier resourcesSupplier = (string) -> pack;
            Pack.Info info = Pack.readPackInfo("wom_override", resourcesSupplier);

            if (info != null) {
                event.addRepositorySource((source) ->
                        source.accept(Pack.create("wom_override", Component.translatable("pack.wom_override.title"), false, resourcesSupplier, info, PackType.SERVER_DATA, Pack.Position.TOP, false, PackSource.SERVER)));
            }
        }
    }




}
