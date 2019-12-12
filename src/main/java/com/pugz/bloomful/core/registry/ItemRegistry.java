package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.common.entity.WisteriaBoatEntity;
import com.pugz.bloomful.common.item.ButterflyBottleItem;
import com.pugz.bloomful.common.item.WisteriaBoatItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {
    public static Item WISTERIA_BOAT = new WisteriaBoatItem(WisteriaBoatEntity.Type.WISTERIA, new Item.Properties().group(ItemGroup.TRANSPORTATION).maxStackSize(1)).setRegistryName("wisteria_boat");
    public static Item BOTTLED_BUTTERFLY = new ButterflyBottleItem(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)).setRegistryName("bottled_butterfly");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                WISTERIA_BOAT,
                BOTTLED_BUTTERFLY
        );
    }
}