package com.pugz.bloomful.core.util;

import com.pugz.bloomful.common.entity.ButterflyEntity;
import com.pugz.bloomful.core.registry.BlockRegistry;
import com.pugz.bloomful.core.registry.EntityRegistry;
import com.pugz.bloomful.core.registry.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

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

    @SubscribeEvent
    public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
        IWorld world = event.getWorld();
        if (event.getSpawner() == null) {
            AxisAlignedBB area;
            List<Entity> entities = new ArrayList<Entity>();
            for (double x = event.getX() - 16; x < event.getX() + 16; ++x) {
                for (double y = event.getY() - 16; y < event.getY() + 16; ++y) {
                    for (double z = event.getZ() - 16; z < event.getZ() + 16; ++z) {
                        BlockPos pos = new BlockPos(x, y, z);
                        area = new AxisAlignedBB(pos);
                        entities = world.getEntitiesWithinAABB(event.getEntity().getClass(), area);
                    }
                }
            }
            for (Entity entity : entities) {
                if (entity instanceof ButterflyEntity) {
                    System.out.println("Butterfly found at " + entity.getPosition());
                    System.out.println("Spawn canceled");
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Entity entity = event.getTarget();
        ItemStack stack = event.getItemStack();
        if (entity.getType() == EntityRegistry.BUTTERFLY && stack.getItem() == Items.GLASS_BOTTLE) {
            event.getPlayer().setHeldItem(event.getHand(), new ItemStack(ItemRegistry.BOTTLED_BUTTERFLY));
            entity.remove(true);
        }
    }
}