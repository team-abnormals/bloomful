package com.pugz.bloomful.core;

import com.pugz.bloomful.client.render.ButterflyRenderer;
import com.pugz.bloomful.client.render.WisteriaBoatRenderer;
import com.pugz.bloomful.common.entity.ButterflyEntity;
import com.pugz.bloomful.common.entity.WisteriaBoatEntity;
import com.pugz.bloomful.core.registry.BiomeRegistry;
import com.pugz.bloomful.core.registry.BlockRegistry;
import com.pugz.bloomful.core.registry.FeatureRegistry;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bloomful")
public class Bloomful {

    public Bloomful() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> this::initSetupClient);   
    }
    
    public void initSetupClient() {
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);	
    }
    
    public void setupClient(final FMLClientSetupEvent event) {
    	RenderingRegistry.registerEntityRenderingHandler(WisteriaBoatEntity.class, WisteriaBoatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ButterflyEntity.class, ButterflyRenderer::new);
    }

    public void setupCommon(final FMLCommonSetupEvent event) {
        BlockRegistry.registerBlockData();
        BiomeRegistry.registerBiomesToDictionary();
        FeatureRegistry.generateFeatures();
        //EntityRegistry.registerSpawns();
    }
}