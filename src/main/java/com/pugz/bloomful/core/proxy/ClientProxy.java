package com.pugz.bloomful.core.proxy;

import com.pugz.bloomful.client.render.ButterflyRenderer;
import com.pugz.bloomful.client.render.TrappedWisteriaChestTileEntityRenderer;
import com.pugz.bloomful.client.render.WisteriaBoatRenderer;
import com.pugz.bloomful.client.render.WisteriaChestTileEntityRenderer;
import com.pugz.bloomful.common.block.WisteriaLeavesBlock;
import com.pugz.bloomful.common.entity.ButterflyEntity;
import com.pugz.bloomful.common.entity.WisteriaBoatEntity;
import com.pugz.bloomful.common.tileentity.TrappedWisteriaChestTileEntity;
import com.pugz.bloomful.common.tileentity.WisteriaChestTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends ServerProxy {
    private static Minecraft mc = Minecraft.getInstance();

    @Override
    public void init() {
        registerSpecialRenderers();
        registerRenderers();
    }

    private static void registerSpecialRenderers() {
        if (ModList.get().isLoaded("quark")) {
            ClientRegistry.bindTileEntitySpecialRenderer(WisteriaChestTileEntity.class, new WisteriaChestTileEntityRenderer());
            ClientRegistry.bindTileEntitySpecialRenderer(TrappedWisteriaChestTileEntity.class, new TrappedWisteriaChestTileEntityRenderer());
        }
    }

    private static void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(WisteriaBoatEntity.class, WisteriaBoatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ButterflyEntity.class, ButterflyRenderer::new);
        WisteriaLeavesBlock.setRenderTranslucent(mc.gameSettings.fancyGraphics);
    }
}