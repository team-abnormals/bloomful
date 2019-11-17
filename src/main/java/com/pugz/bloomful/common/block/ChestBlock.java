package com.pugz.bloomful.common.block;

import com.pugz.bloomful.common.tileentity.WisteriaChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ChestBlock extends net.minecraft.block.ChestBlock {

    public ChestBlock(Block .Properties properties) {
        super(properties);
    }

    public TileEntity createNewTileEntity(IBlockReader reader) {
        return new WisteriaChestTileEntity();
    }
}