package com.pugz.bloomful.core.util;

import com.pugz.bloomful.core.registry.BiomeRegistry;
import com.pugz.bloomful.core.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.entity.player.BonemealEvent;
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
}