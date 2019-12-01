package com.pugz.bloomful.core.util;

import com.pugz.bloomful.core.registry.BlockRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler {
    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(new ItemStack(BlockRegistry.BLUE_WISTERIA_SAPLING), 5, 1, 8, 1, 0.05F));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(new ItemStack(BlockRegistry.PINK_WISTERIA_SAPLING), 5, 1, 8, 1, 0.05F));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(new ItemStack(BlockRegistry.PURPLE_WISTERIA_SAPLING), 5, 1, 8, 1, 0.05F));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(new ItemStack(BlockRegistry.WHITE_WISTERIA_SAPLING), 5, 1, 8, 1, 0.05F));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(new ItemStack(BlockRegistry.BLUE_DELPHINIUM), 2, 1, 6, 1, 0.05F));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(new ItemStack(BlockRegistry.PINK_DELPHINIUM), 2, 1, 6, 1, 0.05F));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(new ItemStack(BlockRegistry.PURPLE_DELPHINIUM), 2, 1, 6, 1, 0.05F));
        event.getGenericTrades().add(new EntityUtils.ItemsForEmeraldsTrade(new ItemStack(BlockRegistry.WHITE_DELPHINIUM), 2, 1, 6, 1, 0.05F));
    }

    private static final ThreadLocal<ItemStack> WAIT_TO_REPLACE_CHEST = new ThreadLocal<>();

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        Entity target = event.getEntity();
        if (target instanceof ItemEntity && ((ItemEntity) target).getItem().getItem() == Items.CHEST) {
            ItemStack local = WAIT_TO_REPLACE_CHEST.get();
            if (local != null && !local.isEmpty()) {
                ((ItemEntity) target).setItem(local);
            }
            WAIT_TO_REPLACE_CHEST.remove();
        }
    }
}