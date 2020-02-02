package com.pugz.bloomful.core.util;

import com.pugz.bloomful.core.registry.BlockRegistry;
import com.pugz.bloomful.core.registry.FeatureRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class BiomeFeatures {

    public static void addDelphiniums(Biome biome, int count) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_RANDOM_SELECTOR, new MultipleWithChanceRandomFeatureConfig(new Feature[]{FeatureRegistry.DELPHINIUMS_WHITE, FeatureRegistry.DELPHINIUMS_BLUE, FeatureRegistry.DELPHINIUMS_PURPLE, FeatureRegistry.DELPHINIUMS_PINK}, new IFeatureConfig[]{new DoublePlantConfig(BlockRegistry.PURPLE_DELPHINIUM.getDefaultState()), new DoublePlantConfig(BlockRegistry.WHITE_DELPHINIUM.getDefaultState()), new DoublePlantConfig(BlockRegistry.BLUE_DELPHINIUM.getDefaultState()), new DoublePlantConfig(BlockRegistry.PINK_DELPHINIUM.getDefaultState())}, 0), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(count)));
    }

    public static void addWisteriaTrees(Biome biome, int count, float extraChance) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{FeatureRegistry.WISTERIA_TREE_PURPLE, FeatureRegistry.WISTERIA_TREE_WHITE, FeatureRegistry.WISTERIA_TREE_BLUE, FeatureRegistry.WISTERIA_TREE_PINK}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F, 0.2F, 0.2F, 0.2F}, Feature.SUPER_BIRCH_TREE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count, extraChance, 1)));
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{FeatureRegistry.BIG_WISTERIA_TREE_PURPLE, FeatureRegistry.BIG_WISTERIA_TREE_WHITE, FeatureRegistry.BIG_WISTERIA_TREE_BLUE, FeatureRegistry.BIG_WISTERIA_TREE_PINK}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.1F, 0.1F, 0.1F, 0.1F}, Feature.SUPER_BIRCH_TREE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count / 2, extraChance, 1)));
    }

    @SuppressWarnings({ "unchecked", "static-access" })
	public static void addWisteriaFlowers(Biome biome, int count) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, biome.createDecoratedFeature(FeatureRegistry.WISTERIA_FLOWERS, new NoFeatureConfig(), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(count)));
    }

    public static void addWisteriaTree(Biome biome, WisteriaColor color, int count, float extraChance) {
        switch (color) {
            case BLUE:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{FeatureRegistry.BIG_WISTERIA_TREE_BLUE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F}, FeatureRegistry.WISTERIA_TREE_BLUE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count, extraChance, 1)));
                break;
            case PINK:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{FeatureRegistry.BIG_WISTERIA_TREE_PINK}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F}, FeatureRegistry.WISTERIA_TREE_PINK, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count, extraChance, 1)));
                break;
            case WHITE:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{FeatureRegistry.BIG_WISTERIA_TREE_WHITE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F}, FeatureRegistry.WISTERIA_TREE_WHITE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count, extraChance, 1)));
                break;
            case PURPLE:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{FeatureRegistry.BIG_WISTERIA_TREE_PURPLE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F}, FeatureRegistry.WISTERIA_TREE_PURPLE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(count, extraChance, 1)));
                break;
        }
    }
}