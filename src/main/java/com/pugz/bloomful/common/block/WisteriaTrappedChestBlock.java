package com.pugz.bloomful.common.block;

import com.pugz.bloomful.common.tileentity.TrappedWisteriaChestTileEntity;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class WisteriaTrappedChestBlock extends TrappedChestBlock {

    public WisteriaTrappedChestBlock(Properties properties) {
        super(properties);
    }

    public TileEntity createNewTileEntity(IBlockReader reader) {
        return new TrappedWisteriaChestTileEntity();
    }
}