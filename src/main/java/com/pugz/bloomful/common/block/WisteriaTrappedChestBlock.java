package com.pugz.bloomful.common.block;

import com.pugz.bloomful.common.tileentity.TrappedWisteriaChestTileEntity;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WisteriaTrappedChestBlock extends TrappedChestBlock {

    public WisteriaTrappedChestBlock(Properties properties) {
        super(properties);
    }

    public TileEntity createNewTileEntity(IBlockReader reader) {
        return new TrappedWisteriaChestTileEntity();
    }

    @OnlyIn(Dist.CLIENT)
    public static void provideItemBlock(Item.Properties properties) {
        WisteriaChestBlock.setTEISR(properties, new ResourceLocation("bloomful", "textures/model/chest/wisteria_normal.png"), new ResourceLocation("bloomful", "textures/model/chest/wisteria_double.png"));
    }
}