package com.pugz.bloomful.common.block;

import com.pugz.bloomful.common.tileentity.TrappedWisteriaChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class TrappedChestBlock extends net.minecraft.block.TrappedChestBlock {

    public TrappedChestBlock(Properties properties) {
        super(properties);
    }

    public TileEntity createNewTileEntity(IBlockReader reader) {
        return new TrappedWisteriaChestTileEntity();
    }
}