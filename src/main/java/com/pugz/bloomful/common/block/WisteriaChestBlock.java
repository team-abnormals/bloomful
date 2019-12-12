package com.pugz.bloomful.common.block;

import com.pugz.bloomful.client.render.WisteriaChestTileEntityRenderer;
import com.pugz.bloomful.common.tileentity.WisteriaChestTileEntity;
import net.minecraft.block.Block;

import net.minecraft.block.ChestBlock;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WisteriaChestBlock extends ChestBlock {

    public WisteriaChestBlock(Block .Properties properties) {
        super(properties);
    }

    public TileEntity createNewTileEntity(IBlockReader reader) {
        return new WisteriaChestTileEntity();
    }

    @OnlyIn(Dist.CLIENT)
    public static void setTEISR(Item.Properties properties, ResourceLocation modelNormal, ResourceLocation modelDouble) {
        properties.setTEISR(() -> () -> new ItemStackTileEntityRenderer() {
            private final TileEntity tile = new WisteriaChestTileEntity();

            @Override
            public void renderByItem(ItemStack itemStackIn) {
                WisteriaChestTileEntityRenderer.forceNormal = modelNormal;
                WisteriaChestTileEntityRenderer.forceDouble = modelDouble;
                TileEntityRendererDispatcher.instance.renderAsItem(tile);
            }
        });
    }
}