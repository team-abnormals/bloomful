package com.pugz.bloomful.common.block;

import com.pugz.bloomful.common.tileentity.WisteriaChestTileEntity;
import net.minecraft.block.Block;

import net.minecraft.block.ChestBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class WisteriaChestBlock extends ChestBlock {

    public WisteriaChestBlock(Block .Properties properties) {
        super(properties);
    }

    public TileEntity createNewTileEntity(IBlockReader reader) {
        return new WisteriaChestTileEntity();
    }
}