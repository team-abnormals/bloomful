package com.pugz.bloomful.core;

import com.pugz.bloomful.core.registry.BloomfulBlocks;
import com.pugz.bloomful.core.registry.BloomfulFeatures;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bloomful")
public class Bloomful {
	
	public static final String MODID = "bloomful";
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    public Bloomful() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        

        REGISTRY_HELPER.getDeferredBlockRegister().register(modEventBus);
        REGISTRY_HELPER.getDeferredItemRegister().register(modEventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
        
        modEventBus.addListener(this::modConfig);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BloomfulConfig.SERVER_SPEC);
        
        modEventBus.addListener(this::setupCommon);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
        	modEventBus.addListener(this::setupClient);
        });
    }
    
    public void modConfig(final ModConfig.ModConfigEvent event)
	{
		ModConfig config = event.getConfig();
		if (config.getSpec() == BloomfulConfig.SERVER_SPEC)
			BloomfulConfig.refresh();
	}
    
    
    public void setupClient(final FMLClientSetupEvent event) {
    	BloomfulConfig.refresh();
    	BloomfulBlocks.setupRenderLayer();
    }

    public void setupCommon(final FMLCommonSetupEvent event) {
    	BloomfulConfig.refresh();
        BloomfulBlocks.registerBlockData();
        //BloomfulBiomes.registerBiomesToDictionary();
        BloomfulFeatures.generateFeatures();
        //EntityRegistry.registerSpawns();
    }
}