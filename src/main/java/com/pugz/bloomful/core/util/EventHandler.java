package com.pugz.bloomful.core.util;

import com.pugz.bloomful.core.registry.BlockRegistry;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "bloomful")
public class EventHandler {
	
    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(BlockRegistry.BLUE_WISTERIA_SAPLING, 5, 1, 8, 1));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(BlockRegistry.PINK_WISTERIA_SAPLING, 5, 1, 8, 1));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(BlockRegistry.PURPLE_WISTERIA_SAPLING, 5, 1, 8, 1));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(BlockRegistry.WHITE_WISTERIA_SAPLING, 5, 1, 8, 1));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(BlockRegistry.BLUE_DELPHINIUM, 2, 1, 6, 1));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(BlockRegistry.PINK_DELPHINIUM, 2, 1, 6, 1));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(BlockRegistry.PURPLE_DELPHINIUM, 2, 1, 6, 1));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(BlockRegistry.WHITE_DELPHINIUM, 2, 1, 6, 1));
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