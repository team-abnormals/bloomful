package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.common.entity.WisteriaBoatEntity;
import com.pugz.bloomful.common.item.WisteriaBoatItem;
import com.pugz.bloomful.core.util.RegistryUtils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BloomfulItems {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "bloomful");

    public static final RegistryObject<Item> WISTERIA_BOAT = RegistryUtils.createItem("wisteria_boat", () -> new WisteriaBoatItem(WisteriaBoatEntity.Type.WISTERIA, new Item.Properties().group(ItemGroup.TRANSPORTATION).maxStackSize(1)));
    //public static final RegistryObject<Item> BOTTLED_BUTTERFLY = RegistryUtils.createItem("bottled_butterfly", () -> new ButterflyBottleItem(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
}