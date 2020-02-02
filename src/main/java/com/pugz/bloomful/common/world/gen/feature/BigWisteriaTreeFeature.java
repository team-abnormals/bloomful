package com.pugz.bloomful.common.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import com.pugz.bloomful.core.registry.BlockRegistry;
import com.pugz.bloomful.core.util.WisteriaColor;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorldWriter;
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
    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader world, Random random, BlockPos pos, MutableBoundingBox boundingBox) {
        int height = random.nextInt(7) + 5;
        boolean flag = true;
        if (pos.getY() >= 1 && pos.getY() + height + 1 <= world.getMaxHeight()) {
            for(int j = pos.getY(); j <= pos.getY() + 1 + height; ++j) {
                int k = 1;
                if (j == pos.getY()) {
                    k = 0;
                }
                if (j >= pos.getY() + 1 + height - 2) {
                    k = 2;
                }
                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
                for(int l = pos.getX() - k; l <= pos.getX() + k && flag; ++l) {
                    for(int i1 = pos.getZ() - k; i1 <= pos.getZ() + k && flag; ++i1) {
                        if (j >= 0 && j < world.getMaxHeight()) {
                            if (!func_214587_a(world, blockpos$mutableblockpos.setPos(l, j, i1))) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }
            if (!flag) {
                return false;
            } else if (isSoil(world, pos.down(), getSapling()) && pos.getY() < world.getMaxHeight() - height - 1) {
                setDirtAt(world, pos.down(), pos);
                for (int k = 0; k < 3; ++k) {
                    BlockPos position = new BlockPos(pos.add(0, random.nextInt(3) + 4, 0));
                    boolean xNeg = random.nextBoolean();
                    boolean zNeg = random.nextBoolean();
                    int size = random.nextInt(3) + 5;
                    for (int j = 1; j <= size; j++) {
                        position = position.add(random.nextInt(2) - (xNeg ? 1 : 0), random.nextInt(2), random.nextInt(2) - (zNeg ? 1 : 0));
                        setLogState(changedBlocks, world, position, LOG, boundingBox);
                        if (j == size) {
                            for (int y = 4; y > -4; --y) {
                                for (int x = 4; x > -4; --x) {
                                    for (int z = 4; z > -4; --z) {
                                        if (Math.sqrt((x * x) + (y > 0 ? (y * y) : 0) + (z * z)) <= 4) {
                                            BlockPos leafPos = position.add(x, y, z);
                                            boolean place = true;
                                            if (y < 0) {
                                                place = world.hasBlockState(leafPos.add(0, 1, 0), (state) -> {
                                                    return state.isIn(BlockTags.LEAVES);
                                                });
                                                if (place && random.nextInt(Math.abs(y) + 1) != 0) {
                                                    place = false;
                                                    if (random.nextInt(5) == 0 && !isLog(world, leafPos)) {
                                                        placeVines(changedBlocks, world, random, leafPos, LEAF, VINE_LOWER, VINE_UPPER, boundingBox);
                                                    }
                                                }
                                            }
                                            if (place) {
                                                placeLeafAt(changedBlocks, world, leafPos, boundingBox);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                for(int i2 = 0; i2 < height; ++i2) {
                    if (isAirOrLeavesOrVines(world, pos.up(i2))) {
                        setLogState(changedBlocks, world, pos.up(i2), LOG, boundingBox);
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void placeVines(Set<BlockPos> changedBlocks, IWorldGenerationReader world, Random random, BlockPos pos, BlockState leaf, BlockState vineLower, BlockState vineUpper, MutableBoundingBox boundingBox) {
        int length = getLengthByNeighbors(world, random, pos);
        if (random.nextInt(6) != 5 && isAir(world, pos) && !isLog(world, pos)) {
            switch (length) {
                case 0:
                    break;
                case 1:
                    if (isAir(world, pos)) setForcedState(changedBlocks, world, pos, vineLower, boundingBox);
                    break;
                case 2:
                    if (isAir(world, pos)) setForcedState(changedBlocks, world, pos, vineUpper, boundingBox);
                    if (isAir(world, pos.down())) setForcedState(changedBlocks, world, pos.down(), vineLower, boundingBox);
                    break;
                case 3:
                    if (isAir(world, pos)) placeLeafAt(changedBlocks, world, pos, boundingBox);
                    if (isAir(world, pos.down())) setForcedState(changedBlocks, world, pos.down(), vineUpper, boundingBox);
                    if (isAir(world, pos.down(2))) setForcedState(changedBlocks, world, pos.down(2), vineLower, boundingBox);
                    break;
                case 4:
                    if (isAir(world, pos)) placeLeafAt(changedBlocks, world, pos, boundingBox);
                    if (isAir(world, pos.down())) placeLeafAt(changedBlocks, world, pos.down(), boundingBox);
                    if (isAir(world, pos.down(2))) setForcedState(changedBlocks, world, pos.down(2), vineUpper, boundingBox);
                    if (isAir(world, pos.down(3))) setForcedState(changedBlocks, world, pos.down(3), vineLower, boundingBox);
                    break;
                case 5:
                    if (isAir(world, pos)) placeLeafAt(changedBlocks, world, pos, boundingBox);
                    if (isAir(world, pos.down())) placeLeafAt(changedBlocks, world, pos.down(), boundingBox);
                    if (isAir(world, pos.down(2))) placeLeafAt(changedBlocks, world, pos.down(2), boundingBox);
                    if (isAir(world, pos.down(3))) setForcedState(changedBlocks, world, pos.down(3), vineUpper, boundingBox);
                    if (isAir(world, pos.down(4))) setForcedState(changedBlocks, world, pos.down(4), vineLower, boundingBox);
                    break;
            }
        }
    }

    private void placeLeafAt(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox boundingBox) {
        if (isAirOrLeaves(worldIn, pos)) {
            setLogState(changedBlocks, worldIn, pos, LEAF, boundingBox);
        }
    }

    private void setForcedState(Set<BlockPos> changedBlocks, IWorldWriter worldIn, BlockPos pos, BlockState state, MutableBoundingBox boundingBox) {
        if (doBlockNotify) {
            worldIn.setBlockState(pos, state, 19);
        } else {
            worldIn.setBlockState(pos, state, 18);
        }
        boundingBox.expandTo(new MutableBoundingBox(pos, pos));
        changedBlocks.add(pos.toImmutable());
    }
}