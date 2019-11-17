package com.pugz.bloomful.core.util;

import com.pugz.bloomful.core.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;

import java.util.Random;

public class WisteriaTreeUtils {
    public static BlockPos[] WISTERIA_TREE_POSITIONS;

    public static void placeVines(IWorldGenerationReader world, Random random, BlockPos pos, BlockState leaf, BlockState vineLower, BlockState vineUpper) {
        int length = getLengthByNeighbors(world, random, pos);
        if (random.nextInt(6) != 5 && isAir(world, pos)) {
            switch (length) {
                case 0:
                    break;
                case 1:
                    if (isAir(world, pos)) world.setBlockState(pos, vineLower, 18);
                    break;
                case 2:
                    if (isAir(world, pos)) world.setBlockState(pos, vineUpper, 18);
                    if (isAir(world, pos.down())) world.setBlockState(pos.down(), vineLower, 18);
                    break;
                case 3:
                    if (isAir(world, pos)) world.setBlockState(pos, leaf, 18);
                    if (isAir(world, pos.down())) world.setBlockState(pos.down(), vineUpper, 18);
                    if (isAir(world, pos.down(2))) world.setBlockState(pos.down(2), vineLower, 18);
                    break;
                case 4:
                    if (isAir(world, pos)) world.setBlockState(pos, leaf, 18);
                    if (isAir(world, pos.down())) world.setBlockState(pos.down(), leaf, 18);
                    if (isAir(world, pos.down(2))) world.setBlockState(pos.down(2), vineUpper, 18);
                    if (isAir(world, pos.down(3))) world.setBlockState(pos.down(3), vineLower, 18);
                    break;
                case 5:
                    if (isAir(world, pos)) world.setBlockState(pos, leaf, 18);
                    if (isAir(world, pos.down())) world.setBlockState(pos, leaf, 18);
                    if (isAir(world, pos.down(2))) world.setBlockState(pos.down(), leaf, 18);
                    if (isAir(world, pos.down(3))) world.setBlockState(pos.down(2), vineUpper, 18);
                    if (isAir(world, pos.down(4))) world.setBlockState(pos.down(3), vineLower, 18);
                    break;
            }
        }
    }

    /*
    public static void generateDelphiniums(Biome biome) {
        for (BlockPos pos : WISTERIA_TREE_POSITIONS) {
            BiomeFeatures.addDelphiniums(biome, 4);
        }
    }
    */

    public static int getLengthByNeighbors(IWorldGenerationReader world, Random random, BlockPos pos) {
        int length = random.nextInt(6); // max 4
        for (Direction direction : Direction.values()) {
            if (direction != Direction.UP && direction != Direction.DOWN) {
                if (isAir(world, pos.offset(direction))) length++; // max 2 min 1
                else if (isLeaves(world, pos.offset(direction))) length--; // max 4 min 2
            }
        }
        return length;
    }

    protected static boolean isAir(IWorldGenerationBaseReader worldIn, BlockPos pos) {
        if (!(worldIn instanceof net.minecraft.world.IBlockReader)) // FORGE: Redirect to state method when possible
            return worldIn.hasBlockState(pos, BlockState::isAir);
        else return worldIn.hasBlockState(pos, state -> state.isAir((net.minecraft.world.IBlockReader)worldIn, pos));
    }

    protected static boolean isLeaves(IWorldGenerationBaseReader worldIn, BlockPos pos) {
        return worldIn.hasBlockState(pos, (p_214579_0_) -> {
            return p_214579_0_.isIn(BlockTags.LEAVES);
        });
    }
}