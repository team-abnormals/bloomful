package com.pugz.bloomful.core.proxy;

import com.pugz.bloomful.client.render.TrappedWisteriaChestTileEntityRenderer;
import com.pugz.bloomful.client.render.WisteriaChestTileEntityRenderer;
import com.pugz.bloomful.common.tileentity.TrappedWisteriaChestTileEntity;
import com.pugz.bloomful.common.tileentity.WisteriaChestTileEntity;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy {
    @Override
    public void init() {
        registerSpecialRenderers();
    }

    public static void registerSpecialRenderers() {
        if (ModList.get().isLoaded("quark")) {
            //ClientRegistry.bindTileEntitySpecialRenderer(WisteriaChestTileEntity.class, new WisteriaChestTileEntityRenderer());
            //ClientRegistry.bindTileEntitySpecialRenderer(TrappedWisteriaChestTileEntity.class, new TrappedWisteriaChestTileEntityRenderer());
        }
    }
}