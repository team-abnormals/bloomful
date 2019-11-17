package com.pugz.bloomful.core.proxy;

import com.pugz.bloomful.client.render.WisteriaChestTileEntityRenderer;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy {
    @Override
    public void init() {
        registerSpecialRenderers();
    }

    public static void registerSpecialRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(ChestTileEntity.class, new WisteriaChestTileEntityRenderer());
    }
}