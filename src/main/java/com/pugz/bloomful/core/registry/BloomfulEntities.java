package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.client.render.WisteriaBoatRenderer;
import com.pugz.bloomful.common.entity.WisteriaBoatEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BloomfulEntities
{
	public static EntityType<WisteriaBoatEntity> BOAT;
	
    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
    {
    	BOAT = EntityType.Builder.<WisteriaBoatEntity>create(WisteriaBoatEntity::new, EntityClassification.MISC).setTrackingRange(80).setUpdateInterval(3).setShouldReceiveVelocityUpdates(true).size(1.375f, 0.5625f).build("buzzierbees:boat");
        BOAT.setRegistryName("boat");
        ForgeRegistries.ENTITIES.register(BOAT);
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRendering()
    {
        RenderingRegistry.registerEntityRenderingHandler((EntityType<? extends WisteriaBoatEntity>)BOAT, WisteriaBoatRenderer::new);
    }
}