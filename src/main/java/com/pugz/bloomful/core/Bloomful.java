package com.pugz.bloomful.core;

import com.pugz.bloomful.core.proxy.ClientProxy;
import com.pugz.bloomful.core.proxy.ServerProxy;
import com.pugz.bloomful.core.registry.BiomeRegistry;
import com.pugz.bloomful.core.registry.BlockRegistry;
import com.pugz.bloomful.core.registry.EntityRegistry;
import com.pugz.bloomful.core.registry.FeatureRegistry;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bloomful")
public class Bloomful {
    public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public Bloomful() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        proxy.init();
        BlockRegistry.registerBlockData();
        BiomeRegistry.registerBiomeDictionaries();
        FeatureRegistry.generateFeatures();
        EntityRegistry.registerSpawns();
        BiomeRegistry.registerBiomeSpawns();
    }
}