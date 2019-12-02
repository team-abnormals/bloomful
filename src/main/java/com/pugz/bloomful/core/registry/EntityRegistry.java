package com.pugz.bloomful.core.registry;

import com.google.common.collect.Lists;
import com.pugz.bloomful.common.entity.ButterflyEntity;
import com.pugz.bloomful.common.entity.WisteriaBoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLPlayMessages;

import java.util.List;
import java.util.function.BiFunction;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry {
    private static List<Item> spawnEggs = Lists.newArrayList();

    public static EntityType<WisteriaBoatEntity> WISTERIA_BOAT = createBasicEntity(WisteriaBoatEntity::new, WisteriaBoatEntity::new, EntityClassification.MISC, "wisteria_boat", 1.375F, 0.5625F);
    public static EntityType<ButterflyEntity> BUTTERFLY = createEntity(ButterflyEntity::new, EntityClassification.AMBIENT, "butterfly", 1.375F, 0.5625F, 0x77D4D9, 0xF1A6F5);

    private static <T extends Entity> EntityType<T> createEntity(EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height, int eggPrimary, int eggSecondary) {
        ResourceLocation location = new ResourceLocation("bloomful", name);
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification).size(width, height).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).setUpdateInterval(3).build(location.toString());
        entity.setRegistryName(location);
        spawnEggs.add(new SpawnEggItem(entity, eggPrimary, eggSecondary, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(entity.getRegistryName() + "_spawn_egg"));
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
        for(Item spawnEgg : spawnEggs) {
            event.getRegistry().register(spawnEgg);
        }
    }
}