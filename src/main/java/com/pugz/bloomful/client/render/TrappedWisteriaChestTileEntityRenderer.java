package com.pugz.bloomful.client.render;

import com.pugz.bloomful.common.block.WisteriaTrappedChestBlock;
import com.pugz.bloomful.common.tileentity.TrappedWisteriaChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.ChestTileEntityRenderer;
import net.minecraft.util.ResourceLocation;

public class TrappedWisteriaChestTileEntityRenderer extends ChestTileEntityRenderer<TrappedWisteriaChestTileEntity> {
    private TrappedWisteriaChestTileEntity tile;
    public static ResourceLocation forceNormal = new ResourceLocation("bloomful", "textures/model/chest/wisteria_normal.png");
    public static ResourceLocation forceDouble = new ResourceLocation("bloomful", "textures/model/chest/wisteria_double.png");

    @Override
    public void render(TrappedWisteriaChestTileEntity tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
        tile = tileEntityIn;
        super.render(tileEntityIn, x, y, z, partialTicks, destroyStage);
    }

    @Override
    protected void bindTexture(ResourceLocation location) {
        boolean isDouble = location.getPath().contains("double");
        if(tile != null && tile.hasWorld()) {
            if(location.getPath().contains("normal")) {
                Block block = tile.getBlockState().getBlock();
                if(block instanceof WisteriaTrappedChestBlock) {
                    location = isDouble ? forceDouble : forceNormal;
                }
            }
        }
        else {
            ResourceLocation forced = isDouble ? forceDouble : forceNormal;
            if(forced != null) {
                location = forced;
            }
        }
        super.bindTexture(location);
    }
}