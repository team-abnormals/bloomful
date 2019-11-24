package com.pugz.bloomful.core.proxy;

import com.pugz.bloomful.client.render.WisteriaBoatRenderer;
import com.pugz.bloomful.common.entity.WisteriaBoatEntity;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

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
        RenderingRegistry.registerEntityRenderingHandler(WisteriaBoatEntity.class, WisteriaBoatRenderer::new);
    }
}