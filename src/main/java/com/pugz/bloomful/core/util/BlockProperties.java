package com.pugz.bloomful.core.util;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockProperties {
    public static Block.Properties WISTERIA_PLANKS = Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);
    public static Block.Properties WISTERIA_LEAVES(MaterialColor color) {
        return Block.Properties.create(Material.LEAVES, color).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT);
    }
    public static Block.Properties DELPHINIUMS = Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT);
    public static Block.Properties WOOD_BUTTON = Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD);
    public static Block.Properties WISTERIA_DOORS = Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD);
    public static Block.Properties FLOWER_POT = Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0F);
    public static Block.Properties SAPLING = Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT);
    public static Block.Properties WISTERIA_LOG(boolean stripped) {
        MaterialColor color = stripped ? MaterialColor.WHITE_TERRACOTTA : MaterialColor.GRAY;
        return Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    }
}