package com.pugz.bloomful.core.proxy;

import com.pugz.bloomful.client.render.ButterflyRenderer;
import com.pugz.bloomful.client.render.WisteriaBoatRenderer;
import com.pugz.bloomful.common.entity.ButterflyEntity;
import com.pugz.bloomful.common.entity.WisteriaBoatEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends ServerProxy {
    @Override
    public void init() {
        registerRenderers();
    }

    private static void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(WisteriaBoatEntity.class, WisteriaBoatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ButterflyEntity.class, ButterflyRenderer::new);
    }
}