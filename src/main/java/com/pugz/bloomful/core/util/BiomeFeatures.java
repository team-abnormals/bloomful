package com.pugz.bloomful.core.util;

import com.pugz.bloomful.core.registry.BloomfulBlocks;
import com.pugz.bloomful.core.registry.BloomfulFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class BiomeFeatures {

    public static void addDelphiniums(Biome biome, int count) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(
        		Feature.RANDOM_RANDOM_SELECTOR, 
        		new MultipleWithChanceRandomFeatureConfig(
        				new Feature[]{
        						Feature.DOUBLE_PLANT, 
        						Feature.DOUBLE_PLANT, 
        						Feature.DOUBLE_PLANT,
        						Feature.DOUBLE_PLANT}, 
        				new IFeatureConfig[]{new DoublePlantConfig(
        						BloomfulBlocks.PURPLE_DELPHINIUM.get().getDefaultState()), 
        						new DoublePlantConfig(
        								BloomfulBlocks.WHITE_DELPHINIUM.get().getDefaultState()), 
        						new DoublePlantConfig(
        								BloomfulBlocks.BLUE_DELPHINIUM.get().getDefaultState()), 
        						new DoublePlantConfig(
        								BloomfulBlocks.PINK_DELPHINIUM.get().getDefaultState())}, 0), 
        		Placement.COUNT_HEIGHTMAP_32, 
        		new FrequencyConfig(count)));
    }

    public static void addWisteriaTrees(Biome biome, int count, float extraChance) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{BloomfulFeatures.WISTERIA_TREE_PURPLE, BloomfulFeatures.WISTERIA_TREE_WHITE, BloomfulFeatures.WISTERIA_TREE_BLUE, BloomfulFeatures.WISTERIA_TREE_PINK}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F, 0.2F, 0.2F, 0.2F}, Feature.SUPER_BIRCH_TREE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count, extraChance, 1)));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{BloomfulFeatures.BIG_WISTERIA_TREE_PURPLE, BloomfulFeatures.BIG_WISTERIA_TREE_WHITE, BloomfulFeatures.BIG_WISTERIA_TREE_BLUE, BloomfulFeatures.BIG_WISTERIA_TREE_PINK}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.1F, 0.1F, 0.1F, 0.1F}, Feature.SUPER_BIRCH_TREE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count / 2, extraChance, 1)));
    }
    
    public static void addNoBirchTrees(Biome biome, int count, float extraChance) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, 
        		new MultipleRandomFeatureConfig(new Feature[]{
        				BloomfulFeatures.WISTERIA_TREE_PURPLE, 
        				BloomfulFeatures.WISTERIA_TREE_WHITE, 
        				BloomfulFeatures.WISTERIA_TREE_BLUE}, 
        				new IFeatureConfig[]{
        						IFeatureConfig.NO_FEATURE_CONFIG, 
        						IFeatureConfig.NO_FEATURE_CONFIG, 
        						IFeatureConfig.NO_FEATURE_CONFIG}, 
        				new float[]{0.15F, 0.15F, 0.15F}, 
                		BloomfulFeatures.WISTERIA_TREE_PINK, 
                		IFeatureConfig.NO_FEATURE_CONFIG), 
        		Placement.COUNT_EXTRA_HEIGHTMAP, 
        		new AtSurfaceWithExtraConfig(count, extraChance, 1)));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, 
        		new MultipleRandomFeatureConfig(new Feature[]{
        				BloomfulFeatures.BIG_WISTERIA_TREE_PURPLE, 
        				BloomfulFeatures.BIG_WISTERIA_TREE_WHITE,
        				BloomfulFeatures.BIG_WISTERIA_TREE_BLUE}, 
        				new IFeatureConfig[]{
        						IFeatureConfig.NO_FEATURE_CONFIG, 
        						IFeatureConfig.NO_FEATURE_CONFIG, 
        						IFeatureConfig.NO_FEATURE_CONFIG}, 
        				new float[]{0.5F, 0.5F, 0.5F},
        				BloomfulFeatures.BIG_WISTERIA_TREE_PINK, 
        				IFeatureConfig.NO_FEATURE_CONFIG), 
        		Placement.COUNT_EXTRA_HEIGHTMAP, 
        		new AtSurfaceWithExtraConfig(count / 2, extraChance, 1)));
    }

	public static void addWisteriaFlowers(Biome biome, int count) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(BloomfulFeatures.WISTERIA_FLOWERS, new NoFeatureConfig(), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(count)));
    }

    public static void addWisteriaTree(Biome biome, WisteriaColor color, int count, float extraChance) {
        switch (color) {
            case BLUE:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{BloomfulFeatures.BIG_WISTERIA_TREE_BLUE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F}, BloomfulFeatures.WISTERIA_TREE_BLUE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count, extraChance, 1)));
                break;
            case PINK:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{BloomfulFeatures.BIG_WISTERIA_TREE_PINK}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F}, BloomfulFeatures.WISTERIA_TREE_PINK, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count, extraChance, 1)));
                break;
            case WHITE:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{BloomfulFeatures.BIG_WISTERIA_TREE_WHITE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F}, BloomfulFeatures.WISTERIA_TREE_WHITE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count, extraChance, 1)));
                break;
            case PURPLE:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{BloomfulFeatures.BIG_WISTERIA_TREE_PURPLE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F}, BloomfulFeatures.WISTERIA_TREE_PURPLE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count, extraChance, 1)));
                break;
        }
    }
}