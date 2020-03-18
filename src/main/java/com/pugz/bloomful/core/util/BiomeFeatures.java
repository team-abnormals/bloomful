package com.pugz.bloomful.core.util;

import com.google.common.collect.ImmutableList;
import com.pugz.bloomful.common.block.HangingWisteriaLeavesBlock;
import com.pugz.bloomful.core.registry.BloomfulBlocks;
import com.pugz.bloomful.core.registry.BloomfulFeatures;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;

public class BiomeFeatures {
	public static final BlockState WISTERIA_LOG = BloomfulBlocks.WISTERIA_LOG.get().getDefaultState();
	
	public static final BlockState BLUE_WISTERIA_LEAVES = BloomfulBlocks.BLUE_WISTERIA_LEAVES.get().getDefaultState().with(LeavesBlock.DISTANCE, 1);
	public static final BlockState PINK_WISTERIA_LEAVES = BloomfulBlocks.PINK_WISTERIA_LEAVES.get().getDefaultState().with(LeavesBlock.DISTANCE, 1);
	public static final BlockState WHITE_WISTERIA_LEAVES = BloomfulBlocks.WHITE_WISTERIA_LEAVES.get().getDefaultState().with(LeavesBlock.DISTANCE, 1);
	public static final BlockState PURPLE_WISTERIA_LEAVES = BloomfulBlocks.PURPLE_WISTERIA_LEAVES.get().getDefaultState().with(LeavesBlock.DISTANCE, 1);

	public static final BlockState BLUE_HANGING_WISTERIA_LEAVES_TOP = BloomfulBlocks.BLUE_HANGING_WISTERIA_LEAVES.get().getDefaultState().with(HangingWisteriaLeavesBlock.HALF, DoubleBlockHalf.UPPER);
	public static final BlockState PINK_HANGING_WISTERIA_LEAVES_TOP  = BloomfulBlocks.PINK_HANGING_WISTERIA_LEAVES.get().getDefaultState().with(HangingWisteriaLeavesBlock.HALF, DoubleBlockHalf.UPPER);
	public static final BlockState WHITE_HANGING_WISTERIA_LEAVES_TOP  = BloomfulBlocks.WHITE_HANGING_WISTERIA_LEAVES.get().getDefaultState().with(HangingWisteriaLeavesBlock.HALF, DoubleBlockHalf.UPPER);
	public static final BlockState PURPLE_HANGING_WISTERIA_LEAVES_TOP  = BloomfulBlocks.PURPLE_HANGING_WISTERIA_LEAVES.get().getDefaultState().with(HangingWisteriaLeavesBlock.HALF, DoubleBlockHalf.UPPER);
	
	public static final BlockState BLUE_HANGING_WISTERIA_LEAVES_BOTTOM = BloomfulBlocks.BLUE_HANGING_WISTERIA_LEAVES.get().getDefaultState().with(HangingWisteriaLeavesBlock.HALF, DoubleBlockHalf.LOWER);
	public static final BlockState PINK_HANGING_WISTERIA_LEAVES_BOTTOM = BloomfulBlocks.PINK_HANGING_WISTERIA_LEAVES.get().getDefaultState().with(HangingWisteriaLeavesBlock.HALF, DoubleBlockHalf.LOWER);
	public static final BlockState WHITE_HANGING_WISTERIA_LEAVES_BOTTOM = BloomfulBlocks.WHITE_HANGING_WISTERIA_LEAVES.get().getDefaultState().with(HangingWisteriaLeavesBlock.HALF, DoubleBlockHalf.LOWER);
	public static final BlockState PURPLE_HANGING_WISTERIA_LEAVES_BOTTOM = BloomfulBlocks.PURPLE_HANGING_WISTERIA_LEAVES.get().getDefaultState().with(HangingWisteriaLeavesBlock.HALF, DoubleBlockHalf.LOWER);
	
	public static final BlockClusterFeatureConfig WHITE_DELPHINIUM = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BloomfulBlocks.WHITE_DELPHINIUM.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig PINK_DELPHINIUM = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BloomfulBlocks.PINK_DELPHINIUM.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig PURPLE_DELPHINIUM = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BloomfulBlocks.PURPLE_DELPHINIUM.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig BLUE_DELPHINIUM = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BloomfulBlocks.BLUE_DELPHINIUM.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();

	public static final TreeFeatureConfig BLUE_WISTERIA_NO_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(BLUE_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.BLUE_WISTERIA_SAPLING.get()).build();
	public static final TreeFeatureConfig BLUE_WISTERIA_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(BLUE_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.BLUE_WISTERIA_SAPLING.get()).build();
	public static final TreeFeatureConfig BLUE_WISTERIA_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(BLUE_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.BLUE_WISTERIA_SAPLING.get()).build();
	
	public static final TreeFeatureConfig PINK_WISTERIA_NO_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(PINK_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.PINK_WISTERIA_SAPLING.get()).build();
	public static final TreeFeatureConfig PINK_WISTERIA_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(PINK_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.PINK_WISTERIA_SAPLING.get()).build();
	public static final TreeFeatureConfig PINK_WISTERIA_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG),new SimpleBlockStateProvider(PINK_WISTERIA_LEAVES),new BlobFoliagePlacer(2, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.PINK_WISTERIA_SAPLING.get()).build();
	
	public static final TreeFeatureConfig PURPLE_WISTERIA_NO_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(PURPLE_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.PURPLE_WISTERIA_SAPLING.get()).build();
	public static final TreeFeatureConfig PURPLE_WISTERIA_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(PURPLE_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.PURPLE_WISTERIA_SAPLING.get()).build();
	public static final TreeFeatureConfig PURPLE_WISTERIA_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(PURPLE_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.PURPLE_WISTERIA_SAPLING.get()).build();
	
	public static final TreeFeatureConfig WHITE_WISTERIA_NO_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(WHITE_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.WHITE_WISTERIA_SAPLING.get()).build();
	public static final TreeFeatureConfig WHITE_WISTERIA_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(WHITE_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.WHITE_WISTERIA_SAPLING.get()).build();
	public static final TreeFeatureConfig WHITE_WISTERIA_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(WISTERIA_LOG), new SimpleBlockStateProvider(WHITE_WISTERIA_LEAVES), new BlobFoliagePlacer(2, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable)BloomfulBlocks.WHITE_WISTERIA_SAPLING.get()).build();

	   
    public static void addDelphiniums(Biome biome, int count) {
    	biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_RANDOM_SELECTOR.withConfiguration(
    			new MultipleWithChanceRandomFeatureConfig(ImmutableList.of(
    					Feature.RANDOM_PATCH.withConfiguration(WHITE_DELPHINIUM), 
    					Feature.RANDOM_PATCH.withConfiguration(PINK_DELPHINIUM), 
    					Feature.RANDOM_PATCH.withConfiguration(PURPLE_DELPHINIUM), 
    					Feature.RANDOM_PATCH.withConfiguration(BLUE_DELPHINIUM)), 0))
    			.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(count))));
    }

    public static void addWisteriaTrees(Biome biome, int count, float extraChance) {
    	biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
        		new MultipleRandomFeatureConfig(
        				ImmutableList.of(
        						BloomfulFeatures.WISTERIA_TREE.withConfiguration(BLUE_WISTERIA_NO_BEEHIVES_CONFIG).func_227227_a_(0.15F), 
        						BloomfulFeatures.WISTERIA_TREE.withConfiguration(WHITE_WISTERIA_NO_BEEHIVES_CONFIG).func_227227_a_(0.15F),
        						BloomfulFeatures.WISTERIA_TREE.withConfiguration(PINK_WISTERIA_NO_BEEHIVES_CONFIG).func_227227_a_(0.15F)), 
        						BloomfulFeatures.WISTERIA_TREE.withConfiguration(PURPLE_WISTERIA_NO_BEEHIVES_CONFIG)))
        .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, extraChance, 1))));
    	
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
        		new MultipleRandomFeatureConfig(
        				ImmutableList.of(
        						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(BLUE_WISTERIA_NO_BEEHIVES_CONFIG).func_227227_a_(0.5F), 
        						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(WHITE_WISTERIA_NO_BEEHIVES_CONFIG).func_227227_a_(0.5F),
        						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(PINK_WISTERIA_NO_BEEHIVES_CONFIG).func_227227_a_(0.5F)), 
        						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(PURPLE_WISTERIA_NO_BEEHIVES_CONFIG)))
        .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count / 2, extraChance, 1))));
    }
    
    public static void addWisteriaTreesBeehive(Biome biome, int count, float extraChance) {
    	biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
        		new MultipleRandomFeatureConfig(
        				ImmutableList.of(
        						BloomfulFeatures.WISTERIA_TREE.withConfiguration(BLUE_WISTERIA_CONFIG).func_227227_a_(0.15F), 
        						BloomfulFeatures.WISTERIA_TREE.withConfiguration(WHITE_WISTERIA_CONFIG).func_227227_a_(0.15F),
        						BloomfulFeatures.WISTERIA_TREE.withConfiguration(PINK_WISTERIA_CONFIG).func_227227_a_(0.15F)), 
        						BloomfulFeatures.WISTERIA_TREE.withConfiguration(PURPLE_WISTERIA_CONFIG)))
        .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, extraChance, 1))));
    	
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
        		new MultipleRandomFeatureConfig(
        				ImmutableList.of(
        						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(BLUE_WISTERIA_CONFIG).func_227227_a_(0.5F), 
        						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(WHITE_WISTERIA_CONFIG).func_227227_a_(0.5F),
        						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(PINK_WISTERIA_CONFIG).func_227227_a_(0.5F)), 
        						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(PURPLE_WISTERIA_CONFIG)))
        .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count / 2, extraChance, 1))));
    }

    public static void addWisteriaTreeBeehive(Biome biome, WisteriaColor color, int count, float extraChance) {
        switch (color) {
            case BLUE:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
                		new MultipleRandomFeatureConfig(
                				ImmutableList.of(
                						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(BLUE_WISTERIA_CONFIG).func_227227_a_(0.2F)), 
                				BloomfulFeatures.WISTERIA_TREE.withConfiguration(BLUE_WISTERIA_CONFIG)))
                		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, extraChance, 1))));
                break;
            case PINK:
            	biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
                		new MultipleRandomFeatureConfig(
                				ImmutableList.of(
                						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(WHITE_WISTERIA_CONFIG).func_227227_a_(0.2F)), 
                				BloomfulFeatures.WISTERIA_TREE.withConfiguration(WHITE_WISTERIA_CONFIG)))
                		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, extraChance, 1))));
                break;
            case WHITE:
            	biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
                		new MultipleRandomFeatureConfig(
                				ImmutableList.of(
                						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(PINK_WISTERIA_CONFIG).func_227227_a_(0.2F)), 
                				BloomfulFeatures.WISTERIA_TREE.withConfiguration(PINK_WISTERIA_CONFIG)))
                		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, extraChance, 1))));
                break;
            case PURPLE:
            	biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
                		new MultipleRandomFeatureConfig(
                				ImmutableList.of(
                						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(PURPLE_WISTERIA_CONFIG).func_227227_a_(0.2F)), 
                				BloomfulFeatures.WISTERIA_TREE.withConfiguration(PURPLE_WISTERIA_CONFIG)))
                		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, extraChance, 1))));
                break;
        }
    }
    
    public static void addWisteriaTree(Biome biome, WisteriaColor color, int count, float extraChance) {
        switch (color) {
            case BLUE:
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
                		new MultipleRandomFeatureConfig(
                				ImmutableList.of(
                						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(BLUE_WISTERIA_CONFIG).func_227227_a_(0.2F)), 
                				BloomfulFeatures.WISTERIA_TREE.withConfiguration(BLUE_WISTERIA_NO_BEEHIVES_CONFIG)))
                		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, extraChance, 1))));
                break;
            case PINK:
            	biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
                		new MultipleRandomFeatureConfig(
                				ImmutableList.of(
                						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(WHITE_WISTERIA_CONFIG).func_227227_a_(0.2F)), 
                				BloomfulFeatures.WISTERIA_TREE.withConfiguration(WHITE_WISTERIA_NO_BEEHIVES_CONFIG)))
                		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, extraChance, 1))));
                break;
            case WHITE:
            	biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
                		new MultipleRandomFeatureConfig(
                				ImmutableList.of(
                						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(PINK_WISTERIA_CONFIG).func_227227_a_(0.2F)), 
                				BloomfulFeatures.WISTERIA_TREE.withConfiguration(PINK_WISTERIA_NO_BEEHIVES_CONFIG)))
                		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, extraChance, 1))));
                break;
            case PURPLE:
            	biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(
                		new MultipleRandomFeatureConfig(
                				ImmutableList.of(
                						BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(PURPLE_WISTERIA_CONFIG).func_227227_a_(0.2F)), 
                				BloomfulFeatures.WISTERIA_TREE.withConfiguration(PURPLE_WISTERIA_NO_BEEHIVES_CONFIG)))
                		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, extraChance, 1))));
                break;
        }
    }
}