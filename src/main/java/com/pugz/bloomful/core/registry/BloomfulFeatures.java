package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.common.world.gen.feature.BigWisteriaTreeFeature;
import com.pugz.bloomful.common.world.gen.feature.WisteriaTreeFeature;
import com.pugz.bloomful.core.BloomfulConfig;
import com.pugz.bloomful.core.util.BiomeFeatures;
import com.pugz.bloomful.core.util.WisteriaColor;

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
    public static final Feature<TreeFeatureConfig> WISTERIA_TREE = new WisteriaTreeFeature(TreeFeatureConfig::func_227338_a_);
    public static final Feature<TreeFeatureConfig> BIG_WISTERIA_TREE = new BigWisteriaTreeFeature(TreeFeatureConfig::func_227338_a_);

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        //FlowerVillagePools.init();
        event.getRegistry().registerAll(
                WISTERIA_TREE.setRegistryName("wisteria_tree"),
                BIG_WISTERIA_TREE.setRegistryName("big_wisteria_tree")
        );
    }
    
    public static void generateFeatures() {
        ForgeRegistries.BIOMES.getValues().forEach(BloomfulFeatures::generateWisteriaTrees);
    }

    public static void generateWisteriaTrees(Biome biome) {
    	if (biome.getCategory() == Biome.Category.FOREST) {
            if (biome == Biomes.FLOWER_FOREST)  {
            	BiomeFeatures.addDelphiniums(biome, 12);
                BiomeFeatures.addWisteriaTreesBeehive(biome, 2, 0.01F, false);
            }
        }
    	if (BloomfulConfig.ValuesHolder.generateWisterias()) {
	        if (biome.getCategory() == Biome.Category.JUNGLE) {
	            BiomeFeatures.addWisteriaTree(biome, WisteriaColor.PINK, 0, 0.1F, true);
	        }
	        else if (biome.getCategory() == Biome.Category.SWAMP) {
	            BiomeFeatures.addWisteriaTree(biome, WisteriaColor.BLUE, 0, 0.001F, true);
	        }
	        else if (biome.getCategory() == Biome.Category.PLAINS) {
	            BiomeFeatures.addWisteriaTreeBeehive(biome, WisteriaColor.PURPLE, 0, 0.001F, true);
	        }
	        else if (biome.getCategory() == Biome.Category.ICY) {
	            BiomeFeatures.addWisteriaTree(biome, WisteriaColor.BLUE, 0, 0.001F, true);
	        }
    	}
    }
}