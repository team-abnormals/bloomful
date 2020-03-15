package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.common.world.gen.feature.BigWisteriaTreeFeature;
import com.pugz.bloomful.common.world.gen.feature.WisteriaTreeFeature;
import com.pugz.bloomful.core.util.BiomeFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BloomfulFeatures {
    public static Feature<TreeFeatureConfig> WISTERIA_TREE = new WisteriaTreeFeature(TreeFeatureConfig::func_227338_a_);
    public static Feature<TreeFeatureConfig> BIG_WISTERIA_TREE = new BigWisteriaTreeFeature(TreeFeatureConfig::func_227338_a_);

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        //FlowerVillagePools.init();
        event.getRegistry().registerAll(
                WISTERIA_TREE.setRegistryName("wisteria_tree"),
                BIG_WISTERIA_TREE.setRegistryName("big_wisteria_tree")
        );
    }

    public static void generateFeatures() {
        WisteriaTreeFeature.addFeature();
        BloomfulFeatures.addFeature();
    }
    
    public static void addFeature() {
        ForgeRegistries.BIOMES.getValues().forEach(BloomfulFeatures::generate);
    }

    public static void generate(Biome biome) {
        if (biome == Biomes.FLOWER_FOREST) {
            BiomeFeatures.addDelphiniums(biome, 4);
        }
    }
}