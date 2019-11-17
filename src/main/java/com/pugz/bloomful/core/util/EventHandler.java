package com.pugz.bloomful.core.util;

import com.pugz.bloomful.core.registry.BiomeRegistry;
import com.pugz.bloomful.core.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.horse.AbstractChestedHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler {
    @SubscribeEvent
    public static void onBonemeal(BonemealEvent event) {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        Biome biome = world.getBiome(pos);
        Random rand = new Random();
        BlockState state = BlockRegistry.WHITE_DELPHINIUM.getDefaultState();
        if (biome == Biomes.FLOWER_FOREST || biome == BiomeRegistry.WISTERIA_FOREST) {
            for(int i = 0; i < 64; ++i) {
                BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
                if (world.isAirBlock(blockpos) && blockpos.getY() < world.getWorld().getDimension().getHeight() - 2 && state.isValidPosition(world, blockpos)) {
                    if (rand.nextInt(5) == 4) {
                        world.setBlockState(blockpos, state, 3);
                    }
                }
            }
        }
    }

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
    public static void onClickEntity(PlayerInteractEvent.EntityInteractSpecific event) {
        Entity target = event.getTarget();
        PlayerEntity player = event.getPlayer();
        ItemStack held = player.getHeldItem(event.getHand());
        if (!held.isEmpty() && target instanceof AbstractChestedHorseEntity) {
            AbstractChestedHorseEntity horse = (AbstractChestedHorseEntity) target;
            if (!horse.hasChest() && held.getItem() != Items.CHEST) {
                if (held.getItem().isIn(Tags.Items.CHESTS_WOODEN)) {
                    event.setCanceled(true);
                    event.setCancellationResult(ActionResultType.SUCCESS);
                    if (!target.world.isRemote) {
                        ItemStack copy = held.copy();
                        copy.setCount(1);
                        held.shrink(1);
                        horse.getPersistentData().put("Bloomful:WisteriaChest", copy.serializeNBT());
                        horse.setChested(true);
                        //horse.initHorseChest();
                        //horse.playChestEquipSound();
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onFurnaceFuelBurnTime(FurnaceFuelBurnTimeEvent event) {

    }
}