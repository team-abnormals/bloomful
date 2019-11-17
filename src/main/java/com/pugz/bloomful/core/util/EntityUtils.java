package com.pugz.bloomful.core.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;

import java.util.Random;

public class EntityUtils {
    public static class ItemsForEmeraldsTrade implements VillagerTrades.ITrade {
        private final ItemStack itemstack;
        private final int stackSize;
        private final int recievedSize;
        private final int maxUses;
        private final int givenExp;
        private final float priceMultiplier;

        public ItemsForEmeraldsTrade(ItemStack stack, int size, int recieved, int max, int exp, float multiplier) {
            itemstack = stack;
            stackSize = size;
            recievedSize = recieved;
            maxUses = max;
            givenExp = exp;
            priceMultiplier = multiplier;
        }

        public MerchantOffer getOffer(Entity entity, Random random) {
            return new MerchantOffer(new ItemStack(Items.EMERALD, stackSize), new ItemStack(itemstack.getItem(), recievedSize), maxUses, givenExp, priceMultiplier);
        }
    }
}