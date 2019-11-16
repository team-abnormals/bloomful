package com.pugz.bloomful.common.world.biome;

import com.pugz.bloomful.core.util.BiomeFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

import static net.minecraft.entity.EntityClassification.MONSTER;

public class WisteriaForestBiome extends Biome {

    public WisteriaForestBiome(Builder builder) {
        super(builder);
        addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addStructures(this);
        DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSedimentDisks(this);
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.JUNGLE_GRASS, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(4)));
        DefaultBiomeFeatures.addMushrooms(this);
        DefaultBiomeFeatures.addReedsAndPumpkins(this);
        DefaultBiomeFeatures.addSprings(this);
        DefaultBiomeFeatures.addFreezeTopLayer(this);
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.RANDOM_RANDOM_SELECTOR, new MultipleWithChanceRandomFeatureConfig(new Feature[]{Feature.DOUBLE_PLANT, Feature.DOUBLE_PLANT, Feature.DOUBLE_PLANT, Feature.GENERAL_FOREST_FLOWER}, new IFeatureConfig[]{new DoublePlantConfig(Blocks.LILAC.getDefaultState()), new DoublePlantConfig(Blocks.ROSE_BUSH.getDefaultState()), new DoublePlantConfig(Blocks.PEONY.getDefaultState()), IFeatureConfig.NO_FEATURE_CONFIG}, 2), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(5)));
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{Feature.BIRCH_TREE, Feature.FANCY_TREE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.2F, 0.05F}, Feature.NORMAL_TREE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(6, 0.1F, 1)));
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.FOREST_FLOWER, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(111)));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 4, 2, 3));
        addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        addSpawn(MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        addSpawn(MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        addSpawn(MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        addSpawn(MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        addSpawn(MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        addSpawn(MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        addSpawn(MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        addSpawn(MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        BiomeFeatures.addDelphiniums(this, 8);
        BiomeFeatures.addWisteriaTrees(this, 20, 0.05F);
    }
}