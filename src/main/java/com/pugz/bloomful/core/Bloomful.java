package com.pugz.bloomful.core;

import com.pugz.bloomful.core.registry.BiomeRegistry;
import com.pugz.bloomful.core.registry.BlockRegistry;
import com.pugz.bloomful.core.registry.FeatureRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bloomful")
public class Bloomful
{
    public Bloomful() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        BlockRegistry.registerBlockData();
        BiomeRegistry.registerBiomeDictionaries();
        FeatureRegistry.generateFeatures();
    }
}
