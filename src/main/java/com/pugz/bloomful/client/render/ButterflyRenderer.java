package com.pugz.bloomful.client.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.pugz.bloomful.client.model.ButterflyModel;
import com.pugz.bloomful.client.render.layer.ButterflyPatternALayer;
import com.pugz.bloomful.client.render.layer.ButterflyPatternBLayer;
import com.pugz.bloomful.common.entity.ButterflyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ButterflyRenderer extends MobRenderer<ButterflyEntity, EntityModel<ButterflyEntity>> {
    private static final ResourceLocation BODY = new ResourceLocation("bloomful", "textures/entity/butterfly/body.png");

    public ButterflyRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new ButterflyModel(),0.25F);
        addLayer(new ButterflyPatternALayer<>(this));
        addLayer(new ButterflyPatternBLayer<>(this));
    }

    protected ResourceLocation getEntityTexture(ButterflyEntity entity) {
        return BODY;
    }

    protected void applyRotations(ButterflyEntity entity, float f, float f1, float f2) {
        GlStateManager.translatef(0.0F, MathHelper.cos(f * 0.3F) * 0.1F, 0.0F);
        super.applyRotations(entity, f, f1, f2);
    }
}