package com.pugz.bloomful.common.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class WisteriaFlowersFeature extends FlowersFeature {
    private static final Block[] FLOWERS = new Block[]{Blocks.DANDELION, Blocks.POPPY, Blocks.AZURE_BLUET, Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP, Blocks.OXEYE_DAISY, Blocks.LILY_OF_THE_VALLEY};

    public WisteriaFlowersFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
        super(config);
    }

    public BlockState getRandomFlower(Random random, BlockPos pos) {
        double d0 = MathHelper.clamp((1.0D + Biome.INFO_NOISE.getValue((double)pos.getX() / 48.0D, (double)pos.getZ() / 48.0D)) / 2.0D, 0.0D, 0.9999D);
        Block block = FLOWERS[(int)(d0 * (double)FLOWERS.length)];
        return block.getDefaultState();
    }
}