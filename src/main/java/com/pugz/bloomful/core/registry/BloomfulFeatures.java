package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.common.world.gen.feature.BigWisteriaTreeFeature;
import com.pugz.bloomful.common.world.gen.feature.WisteriaFlowersFeature;
import com.pugz.bloomful.common.world.gen.feature.WisteriaTreeFeature;
import com.pugz.bloomful.core.util.BiomeFeatures;
import com.pugz.bloomful.core.util.WisteriaColor;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BloomfulFeatures {
    public static Feature<NoFeatureConfig> WISTERIA_TREE_BLUE = new WisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.BLUE);
    public static Feature<NoFeatureConfig> WISTERIA_TREE_PINK = new WisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.PINK);
    public static Feature<NoFeatureConfig> WISTERIA_TREE_PURPLE = new WisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.PURPLE);
    public static Feature<NoFeatureConfig> WISTERIA_TREE_WHITE = new WisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.WHITE);
    public static Feature<NoFeatureConfig> BIG_WISTERIA_TREE_BLUE = new BigWisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.BLUE);
    public static Feature<NoFeatureConfig> BIG_WISTERIA_TREE_PINK = new BigWisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.PINK);
	public static Feature<NoFeatureConfig> BIG_WISTERIA_TREE_PURPLE = new BigWisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.PURPLE);
    public static Feature<NoFeatureConfig> BIG_WISTERIA_TREE_WHITE = new BigWisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.WHITE);
    public static Feature<NoFeatureConfig> WISTERIA_FLOWERS = new WisteriaFlowersFeature(NoFeatureConfig::deserialize);

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        //FlowerVillagePools.init();
        event.getRegistry().registerAll(
                WISTERIA_TREE_BLUE.setRegistryName("blue_wisteria_tree"),
                WISTERIA_TREE_PINK.setRegistryName("pink_wisteria_tree"),
                WISTERIA_TREE_PURPLE.setRegistryName("purple_wisteria_tree"),
                WISTERIA_TREE_WHITE.setRegistryName("white_wisteria_tree"),
                BIG_WISTERIA_TREE_BLUE.setRegistryName("big_blue_wisteria_tree"),
                BIG_WISTERIA_TREE_PINK.setRegistryName("big_pink_wisteria_tree"),
                BIG_WISTERIA_TREE_PURPLE.setRegistryName("big_purple_wisteria_tree"),
                BIG_WISTERIA_TREE_WHITE.setRegistryName("big_white_wisteria_tree"),
                WISTERIA_FLOWERS.setRegistryName("wisteria_flowers")
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