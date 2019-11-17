package com.pugz.bloomful.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class DelphiniumBlock extends DoublePlantBlock {

    public DelphiniumBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            ItemStack held = player.getHeldItem(handIn);
            if (held.getItem() == Items.BONE_MEAL) {
                if (!player.isCreative()) held.shrink(1);
                ItemEntity item  = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
                worldIn.addEntity(item);
                return true;
            }
        }
        return false;
    }
}