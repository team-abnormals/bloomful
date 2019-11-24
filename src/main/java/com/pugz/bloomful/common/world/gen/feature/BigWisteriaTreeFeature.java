package com.pugz.bloomful.common.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import com.pugz.bloomful.core.registry.BlockRegistry;
import com.pugz.bloomful.core.util.WisteriaColor;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import static com.pugz.bloomful.common.block.WisteriaVineBlock.HALF;
import static com.pugz.bloomful.core.util.WisteriaTreeUtils.*;

public class BigWisteriaTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {
    private final BlockState LOG = BlockRegistry.WISTERIA_LOG.getDefaultState();
    private BlockState LEAF;
    private BlockState VINE_UPPER;
    private BlockState VINE_LOWER;

    public BigWisteriaTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> function, boolean doBlockNofityOnPlace, WisteriaColor color) {
        super(function, doBlockNofityOnPlace);
        setBlocksByColor(color);
    }

    private void setBlocksByColor(WisteriaColor color) {
        switch (color) {
            case PURPLE:
                LEAF = BlockRegistry.PURPLE_WISTERIA_LEAVES.getDefaultState();
                VINE_UPPER = BlockRegistry.PURPLE_WISTERIA_VINE.getDefaultState();
                VINE_LOWER = BlockRegistry.PURPLE_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
                break;
            case WHITE:
                LEAF = BlockRegistry.WHITE_WISTERIA_LEAVES.getDefaultState();
                VINE_UPPER = BlockRegistry.WHITE_WISTERIA_VINE.getDefaultState();
                VINE_LOWER = BlockRegistry.WHITE_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
                break;
            case PINK:
                LEAF = BlockRegistry.PINK_WISTERIA_LEAVES.getDefaultState();
                VINE_UPPER = BlockRegistry.PINK_WISTERIA_VINE.getDefaultState();
                VINE_LOWER = BlockRegistry.PINK_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
                break;
            case BLUE:
                LEAF = BlockRegistry.BLUE_WISTERIA_LEAVES.getDefaultState();
                VINE_UPPER = BlockRegistry.BLUE_WISTERIA_VINE.getDefaultState();
                VINE_LOWER = BlockRegistry.BLUE_WISTERIA_VINE.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
                break;
        }
    }

    @Override
    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundingBox) {
        if (isDirtOrGrassBlock(worldIn, position.down())) {
            for (int i = 0; i < rand.nextInt(6) + 7; ++i) {
                setLogState(changedBlocks, worldIn, position.add(0, i, 0), LOG, boundingBox);
            }
            for (int k = 0; k < 3; ++k) {
                BlockPos pos = new BlockPos(position.add(0, rand.nextInt(3) + 4, 0));
                boolean xNeg = rand.nextBoolean();
                boolean zNeg = rand.nextBoolean();
                int size = rand.nextInt(3) + 5;
                for (int j = 1; j <= size; ++j) {
                    pos = pos.add(rand.nextInt(2) - (xNeg ? 1 : 0), rand.nextInt(2), rand.nextInt(2) - (zNeg ? 1 : 0));
                    setLogState(changedBlocks, worldIn, pos, LOG, boundingBox);
                    if (j == size) {
                        for (int y = 4; y > -4; --y) {
                            for (int x = 4; x > -4; --x) {
                                for (int z = 4; z > -4; --z) {
                                    if (Math.sqrt((x * x) + (y > 0 ? (y * y) : 0) + (z * z)) <= 4) {
                                        BlockPos leafPos = pos.add(x, y, z);
                                        boolean place = true;
                                        if (y < 0) {
                                            place = worldIn.hasBlockState(leafPos.add(0, 1, 0), (state) -> {
                                                return state.isIn(BlockTags.LEAVES);
                                            });
                                            if (place && rand.nextInt(Math.abs(y) + 1) != 0) {
                                                place = false;
                                                if (rand.nextInt(2) == 0) {
                                                    placeVines(changedBlocks, worldIn, rand, leafPos, LEAF, VINE_LOWER, VINE_UPPER, boundingBox);
                                                }
                                            }
                                        }
                                        if (place && isAirOrLeaves(worldIn, leafPos)) {
                                            setLogState(changedBlocks, worldIn, leafPos, LEAF, boundingBox);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void placeVines(Set<BlockPos> changedBlocks, IWorldGenerationReader world, Random random, BlockPos pos, BlockState leaf, BlockState vineLower, BlockState vineUpper, MutableBoundingBox boundingBox) {
        int length = getLengthByNeighbors(world, random, pos);
        if (random.nextInt(6) != 5 && isAir(world, pos)) {
            switch (length) {
                case 0:
                    break;
                case 1:
                    if (isAir(world, pos)) setLogState(changedBlocks, world, pos, vineLower, boundingBox);
                    break;
                case 2:
                    if (isAir(world, pos)) setLogState(changedBlocks, world, pos, vineUpper, boundingBox);
                    if (isAir(world, pos.down())) setLogState(changedBlocks, world, pos.down(), vineLower, boundingBox);
                    break;
                case 3:
                    if (isAir(world, pos)) setLogState(changedBlocks, world, pos, leaf, boundingBox);
                    if (isAir(world, pos.down())) setLogState(changedBlocks, world, pos.down(), vineUpper, boundingBox);
                    if (isAir(world, pos.down(2))) setLogState(changedBlocks, world, pos.down(2), vineLower, boundingBox);
                    break;
                case 4:
                    if (isAir(world, pos)) setLogState(changedBlocks, world, pos, leaf, boundingBox);
                    if (isAir(world, pos.down())) setLogState(changedBlocks, world, pos.down(), leaf, boundingBox);
                    if (isAir(world, pos.down(2))) setLogState(changedBlocks, world, pos.down(2), vineUpper, boundingBox);
                    if (isAir(world, pos.down(3))) setLogState(changedBlocks, world, pos.down(3), vineLower, boundingBox);
                    break;
                case 5:
                    if (isAir(world, pos)) setLogState(changedBlocks, world, pos, leaf, boundingBox);
                    if (isAir(world, pos.down())) setLogState(changedBlocks, world, pos.down(), leaf, boundingBox);
                    if (isAir(world, pos.down(2))) setLogState(changedBlocks, world, pos.down(2), leaf, boundingBox);
                    if (isAir(world, pos.down(3))) setLogState(changedBlocks, world, pos.down(3), vineUpper, boundingBox);
                    if (isAir(world, pos.down(4))) setLogState(changedBlocks, world, pos.down(4), vineLower, boundingBox);
                    break;
            }
        }
    }
}