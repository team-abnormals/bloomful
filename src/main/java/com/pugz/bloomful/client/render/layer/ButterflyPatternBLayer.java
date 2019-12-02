package com.pugz.bloomful.client.render.layer;

import com.mojang.blaze3d.platform.GlStateManager;
import com.pugz.bloomful.client.model.ButterflyModel;
import com.pugz.bloomful.common.entity.ButterflyEntity;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ButterflyPatternBLayer extends LayerRenderer<ButterflyEntity, EntityModel<ButterflyEntity>> {
    private final EntityModel<ButterflyEntity> model = new ButterflyModel();

    public ButterflyPatternBLayer(IEntityRenderer<ButterflyEntity, EntityModel<ButterflyEntity>> renderer) {
        super(renderer);
    }

    public void render(ButterflyEntity entity, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
        if (!entity.isInvisible()) {
            bindTexture(entity.getPatternTextureB());
            float[] lvt_10_1_ = entity.func_204222_dD();
            GlStateManager.color3f(lvt_10_1_[0], lvt_10_1_[1], lvt_10_1_[2]);
            getEntityModel().setModelAttributes(model);
            (model).setLivingAnimations(entity, p_212842_2_, p_212842_3_, p_212842_4_);
            (model).render(entity, p_212842_2_, p_212842_3_, p_212842_5_, p_212842_6_, p_212842_7_, p_212842_8_);
        }
    }

    public boolean shouldCombineTextures() {
        return true;
    }
}