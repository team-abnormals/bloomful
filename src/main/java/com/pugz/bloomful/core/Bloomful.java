package com.pugz.bloomful.core;

import com.pugz.bloomful.client.render.ButterflyRenderer;
import com.pugz.bloomful.client.render.WisteriaBoatRenderer;
import com.pugz.bloomful.common.entity.ButterflyEntity;
import com.pugz.bloomful.common.entity.WisteriaBoatEntity;
import com.pugz.bloomful.core.registry.BloomfulBiomes;
import com.pugz.bloomful.core.registry.BloomfulBlocks;
import com.pugz.bloomful.core.registry.BloomfulFeatures;
import com.pugz.bloomful.core.registry.BloomfulItems;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bloomful")
public class Bloomful {

    public Bloomful() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        BloomfulBlocks.BLOCKS.register(modEventBus);
        BloomfulItems.ITEMS.register(modEventBus);
        BloomfulBiomes.BIOMES.register(modEventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
        
        modEventBus.addListener(this::setupCommon);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
        	modEventBus.addListener(this::setupClient);
        });
    }
    
    
    public void setupClient(final FMLClientSetupEvent event) {
    	RenderingRegistry.registerEntityRenderingHandler(WisteriaBoatEntity.class, WisteriaBoatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ButterflyEntity.class, ButterflyRenderer::new);
    }

    public void setupCommon(final FMLCommonSetupEvent event) {
        BloomfulBlocks.registerBlockData();
        BloomfulBiomes.registerBiomesToDictionary();
        BloomfulFeatures.generateFeatures();
        //EntityRegistry.registerSpawns();
    }
}