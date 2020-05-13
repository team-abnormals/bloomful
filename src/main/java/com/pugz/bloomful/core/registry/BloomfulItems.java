package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.core.Bloomful;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BloomfulItems {
	public static final RegistryHelper HELPER = Bloomful.REGISTRY_HELPER;
	
	public static final RegistryObject<Item> WISTERIA_BOAT = HELPER.createBoatItem("wisteria", BloomfulBlocks.WISTERIA_PLANKS);
    //public static final RegistryObject<Item> BOTTLED_BUTTERFLY = RegistryUtils.createItem("bottled_butterfly", () -> new ButterflyBottleItem(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
}