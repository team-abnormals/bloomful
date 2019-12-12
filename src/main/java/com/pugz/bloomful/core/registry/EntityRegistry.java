package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.common.entity.ButterflyEntity;
import com.pugz.bloomful.common.entity.WisteriaBoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLPlayMessages;

import java.util.function.BiFunction;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
    public static Item BUTTERFLY_SPAWN_EGG;

    public static EntityType<WisteriaBoatEntity> WISTERIA_BOAT = createBasicEntity(WisteriaBoatEntity::new, WisteriaBoatEntity::new, EntityClassification.MISC, "wisteria_boat", 1.375F, 0.5625F);
    public static EntityType<ButterflyEntity> BUTTERFLY = createEntity(ButterflyEntity::new, EntityClassification.AMBIENT, "butterfly", 0.75F, 0.25F, 0x070316, 0xE56F03);

    private static <T extends Entity> EntityType<T> createEntity(EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height, int eggPrimary, int eggSecondary) {
        ResourceLocation location = new ResourceLocation("bloomful", name);
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification).size(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).build(location.toString());
        entity.setRegistryName(location);
        BUTTERFLY_SPAWN_EGG = new SpawnEggItem(entity, eggPrimary, eggSecondary, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(entity.getRegistryName() + "_spawn_egg");
        return entity;
    }

    private static <T extends Entity> EntityType<T> createBasicEntity(EntityType.IFactory<T> factory, BiFunction<FMLPlayMessages.SpawnEntity, World, T> clientFactory, EntityClassification entityClassification, String name, float width, float height) {
        ResourceLocation location = new ResourceLocation("bloomful", name);
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification).size(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).setCustomClientFactory(clientFactory).build(location.toString());
        entity.setRegistryName(location);
        return entity;
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(
                WISTERIA_BOAT,
                BUTTERFLY
        );
    }

    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                BUTTERFLY_SPAWN_EGG
        );
    }

    public static void registerSpawns() {
        EntitySpawnPlacementRegistry.register(BUTTERFLY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, ButterflyEntity::spawnCondition);
    }
}