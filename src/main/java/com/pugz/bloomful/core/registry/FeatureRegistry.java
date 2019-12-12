package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.common.world.gen.feature.BigWisteriaTreeFeature;
import com.pugz.bloomful.common.world.gen.feature.DelphiniumFeature;
import com.pugz.bloomful.common.world.gen.feature.WisteriaFlowersFeature;
import com.pugz.bloomful.common.world.gen.feature.WisteriaTreeFeature;
import com.pugz.bloomful.common.world.gen.feature.structure.FlowerVillagePools;
import com.pugz.bloomful.core.util.WisteriaColor;
import net.minecraft.world.gen.feature.DoublePlantConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class FeatureRegistry {
    public static Feature WISTERIA_TREE_BLUE = new WisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.BLUE).setSapling((IPlantable) BlockRegistry.BLUE_WISTERIA_SAPLING).setRegistryName("blue_wisteria_tree");
    public static Feature WISTERIA_TREE_PINK = new WisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.PINK).setSapling((IPlantable) BlockRegistry.PINK_WISTERIA_SAPLING).setRegistryName("pink_wisteria_tree");
    public static Feature WISTERIA_TREE_PURPLE = new WisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.PURPLE).setSapling((IPlantable) BlockRegistry.PURPLE_WISTERIA_SAPLING).setRegistryName("purple_wisteria_tree");
    public static Feature WISTERIA_TREE_WHITE = new WisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.WHITE).setSapling((IPlantable) BlockRegistry.WHITE_WISTERIA_SAPLING).setRegistryName("white_wisteria_tree");
    public static Feature BIG_WISTERIA_TREE_BLUE = new BigWisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.BLUE).setSapling((IPlantable) BlockRegistry.BLUE_WISTERIA_SAPLING).setRegistryName("big_blue_wisteria_tree");
    public static Feature BIG_WISTERIA_TREE_PINK = new BigWisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.PINK).setSapling((IPlantable) BlockRegistry.PINK_WISTERIA_SAPLING).setRegistryName("big_pink_wisteria_tree");
    public static Feature BIG_WISTERIA_TREE_PURPLE = new BigWisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.PURPLE).setSapling((IPlantable) BlockRegistry.PURPLE_WISTERIA_SAPLING).setRegistryName("big_purple_wisteria_tree");
    public static Feature BIG_WISTERIA_TREE_WHITE = new BigWisteriaTreeFeature(NoFeatureConfig::deserialize, false, WisteriaColor.WHITE).setSapling((IPlantable) BlockRegistry.WHITE_WISTERIA_SAPLING).setRegistryName("big_white_wisteria_tree");
    public static Feature DELPHINIUMS_BLUE = new DelphiniumFeature(DoublePlantConfig::deserialize).setRegistryName("blue_delphinium");
    public static Feature DELPHINIUMS_PINK = new DelphiniumFeature(DoublePlantConfig::deserialize).setRegistryName("pink_delphinium");
    public static Feature DELPHINIUMS_PURPLE = new DelphiniumFeature(DoublePlantConfig::deserialize).setRegistryName("purple_delphinium");
    public static Feature DELPHINIUMS_WHITE = new DelphiniumFeature(DoublePlantConfig::deserialize).setRegistryName("white_delphinium");
    public static Feature WISTERIA_FLOWERS = new WisteriaFlowersFeature(NoFeatureConfig::deserialize).setRegistryName("wisteria_flowers");

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        //FlowerVillagePools.init();
        event.getRegistry().registerAll(
                WISTERIA_TREE_BLUE,
                WISTERIA_TREE_PINK,
                WISTERIA_TREE_PURPLE,
                WISTERIA_TREE_WHITE,
                BIG_WISTERIA_TREE_BLUE,
                BIG_WISTERIA_TREE_PINK,
                BIG_WISTERIA_TREE_PURPLE,
                BIG_WISTERIA_TREE_WHITE,
                DELPHINIUMS_BLUE,
                DELPHINIUMS_PINK,
                DELPHINIUMS_PURPLE,
                DELPHINIUMS_WHITE,
                WISTERIA_FLOWERS
        );
    }

    public static void generateFeatures() {
        WisteriaTreeFeature.addFeature();
        DelphiniumFeature.addFeature();
    }
}