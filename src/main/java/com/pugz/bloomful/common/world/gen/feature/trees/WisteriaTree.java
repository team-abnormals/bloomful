package com.pugz.bloomful.common.world.gen.feature.trees;

import com.pugz.bloomful.core.registry.BloomfulFeatures;
import com.pugz.bloomful.core.util.BiomeFeatures;
import com.pugz.bloomful.core.util.WisteriaColor;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class WisteriaTree extends Tree {
    private WisteriaColor color;

    public WisteriaTree(WisteriaColor colorIn) {
        color = colorIn;
    }
    
    private TreeFeatureConfig setConfigByColor(WisteriaColor color, boolean beehive) {
        switch (color) {
            case PURPLE:
            	default:
            	return beehive ? BiomeFeatures.PURPLE_WISTERIA_MORE_BEEHIVES_CONFIG : BiomeFeatures.PURPLE_WISTERIA_CONFIG;
            case WHITE:
            	return beehive ? BiomeFeatures.WHITE_WISTERIA_MORE_BEEHIVES_CONFIG : BiomeFeatures.WHITE_WISTERIA_CONFIG;
            case PINK:
            	return beehive ? BiomeFeatures.PINK_WISTERIA_MORE_BEEHIVES_CONFIG : BiomeFeatures.PINK_WISTERIA_CONFIG;
            case BLUE:
            	return beehive ? BiomeFeatures.BLUE_WISTERIA_MORE_BEEHIVES_CONFIG : BiomeFeatures.BLUE_WISTERIA_CONFIG;
        }
    }

    /**
     * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of tree
     */
    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean beehive) {
       return randomIn.nextInt(10) == 0 ? BloomfulFeatures.BIG_WISTERIA_TREE.withConfiguration(setConfigByColor(color, beehive)) : BloomfulFeatures.WISTERIA_TREE.withConfiguration(setConfigByColor(color, beehive));
    }
}