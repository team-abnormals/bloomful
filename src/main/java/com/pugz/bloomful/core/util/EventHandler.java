package com.pugz.bloomful.core.util;

import com.pugz.bloomful.core.registry.BloomfulBlocks;
import com.teamabnormals.abnormals_core.core.utils.TradeUtils;

import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "bloomful")
public class EventHandler {
	
    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
        event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(BloomfulBlocks.BLUE_WISTERIA_SAPLING.get(), 5, 1, 8, 1));
        event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(BloomfulBlocks.PINK_WISTERIA_SAPLING.get(), 5, 1, 8, 1));
        event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(BloomfulBlocks.PURPLE_WISTERIA_SAPLING.get(), 5, 1, 8, 1));
        event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(BloomfulBlocks.WHITE_WISTERIA_SAPLING.get(), 5, 1, 8, 1));
        event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(BloomfulBlocks.BLUE_DELPHINIUM.get(), 2, 1, 6, 1));
        event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(BloomfulBlocks.PINK_DELPHINIUM.get(), 2, 1, 6, 1));
        event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(BloomfulBlocks.PURPLE_DELPHINIUM.get(), 2, 1, 6, 1));
        event.getGenericTrades().add(new TradeUtils.ItemsForEmeraldsTrade(BloomfulBlocks.WHITE_DELPHINIUM.get(), 2, 1, 6, 1));
    }

    /*
    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Entity entity = event.getTarget();
        ItemStack stack = event.getItemStack();
        if (entity.getType() == EntityRegistry.BUTTERFLY && stack.getItem() == Items.GLASS_BOTTLE) {
            event.getPlayer().setHeldItem(event.getHand(), new ItemStack(ItemRegistry.BOTTLED_BUTTERFLY));
            entity.remove(true);
        }
    }
    */
}