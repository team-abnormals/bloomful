package com.pugz.bloomful.client.render;

import com.pugz.bloomful.common.block.WisteriaChestBlock;
import com.pugz.bloomful.common.block.WisteriaTrappedChestBlock;
import com.pugz.bloomful.common.tileentity.TrappedWisteriaChestTileEntity;
import com.pugz.bloomful.common.tileentity.WisteriaChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TileEntityItemRenderer extends ItemStackTileEntityRenderer {
    private static final WisteriaChestTileEntity CHEST = new WisteriaChestTileEntity();
    private static final TrappedWisteriaChestTileEntity TRAPPED_CHEST = new TrappedWisteriaChestTileEntity();

    @Override
    public void renderByItem(ItemStack itemStackIn) {
        Item item = itemStackIn.getItem();
        if (Block.getBlockFromItem(item) instanceof WisteriaChestBlock) {
            TileEntityRendererDispatcher.instance.renderAsItem(CHEST);
        }
        else if(Block.getBlockFromItem(item) instanceof WisteriaTrappedChestBlock) {
            TileEntityRendererDispatcher.instance.renderAsItem(TRAPPED_CHEST);
        }
    }
}