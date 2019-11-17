package com.pugz.bloomful.core.registry;

import com.google.common.collect.Maps;
import com.pugz.bloomful.common.block.*;
import com.pugz.bloomful.common.block.ChestBlock;
import com.pugz.bloomful.common.block.LadderBlock;
import com.pugz.bloomful.common.block.TrappedChestBlock;
import com.pugz.bloomful.common.world.gen.feature.trees.WisteriaTree;
import com.pugz.bloomful.core.util.BlockProperties;
import com.pugz.bloomful.core.util.WisteriaColor;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {
    public static Block WISTERIA_LOG = new LogBlock(MaterialColor.WHITE_TERRACOTTA, BlockProperties.WISTERIA_LOG(false)).setRegistryName("wisteria_log");
    public static Block STRIPPED_WISTERIA_LOG = new LogBlock(MaterialColor.WHITE_TERRACOTTA, BlockProperties.WISTERIA_LOG(true)).setRegistryName("stripped_wisteria_log");
    public static Block WISTERIA_WOOD = new RotatedPillarBlock(BlockProperties.WISTERIA_LOG(false)).setRegistryName("wisteria_wood");
    public static Block STRIPPED_WISTERIA_WOOD = new RotatedPillarBlock(BlockProperties.WISTERIA_LOG(true)).setRegistryName("stripped_wisteria_wood");
    public static Block WISTERIA_PLANKS = new Block(BlockProperties.WISTERIA_PLANKS).setRegistryName("wisteria_planks");
    public static Block PINK_WISTERIA_SAPLING = new BloomfulSaplingBlock(BlockProperties.SAPLING, new WisteriaTree(WisteriaColor.PINK)).setRegistryName("pink_wisteria_sapling");
    public static Block BLUE_WISTERIA_SAPLING = new BloomfulSaplingBlock(BlockProperties.SAPLING, new WisteriaTree(WisteriaColor.BLUE)).setRegistryName("blue_wisteria_sapling");
    public static Block PURPLE_WISTERIA_SAPLING = new BloomfulSaplingBlock(BlockProperties.SAPLING, new WisteriaTree(WisteriaColor.PURPLE)).setRegistryName("purple_wisteria_sapling");
    public static Block WHITE_WISTERIA_SAPLING = new BloomfulSaplingBlock(BlockProperties.SAPLING, new WisteriaTree(WisteriaColor.WHITE)).setRegistryName("white_wisteria_sapling");
    public static Block POTTED_PINK_WISTERIA_SAPLING = new FlowerPotBlock(PINK_WISTERIA_SAPLING, BlockProperties.FLOWER_POT).setRegistryName("potted_pink_wisteria_sapling");
    public static Block POTTED_BLUE_WISTERIA_SAPLING = new FlowerPotBlock(BLUE_WISTERIA_SAPLING, BlockProperties.FLOWER_POT).setRegistryName("potted_blue_wisteria_sapling");
    public static Block POTTED_PURPLE_WISTERIA_SAPLING = new FlowerPotBlock(PURPLE_WISTERIA_SAPLING, BlockProperties.FLOWER_POT).setRegistryName("potted_purple_wisteria_sapling");
    public static Block POTTED_WHITE_WISTERIA_SAPLING = new FlowerPotBlock(WHITE_WISTERIA_SAPLING, BlockProperties.FLOWER_POT).setRegistryName("potted_white_wisteria_sapling");
    public static Block PINK_WISTERIA_LEAVES = new LeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PINK)).setRegistryName("pink_wisteria_leaves");
    public static Block BLUE_WISTERIA_LEAVES = new LeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.BLUE)).setRegistryName("blue_wisteria_leaves");
    public static Block PURPLE_WISTERIA_LEAVES = new LeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PURPLE)).setRegistryName("purple_wisteria_leaves");
    public static Block WHITE_WISTERIA_LEAVES = new LeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.SNOW)).setRegistryName("white_wisteria_leaves");
    public static Block PINK_WISTERIA_VINE = new WisteriaVineBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PINK)).setRegistryName("pink_wisteria_vine");
    public static Block BLUE_WISTERIA_VINE = new WisteriaVineBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.BLUE)).setRegistryName("blue_wisteria_vine");
    public static Block PURPLE_WISTERIA_VINE = new WisteriaVineBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PURPLE)).setRegistryName("purple_wisteria_vine");
    public static Block WHITE_WISTERIA_VINE = new WisteriaVineBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.SNOW)).setRegistryName("white_wisteria_vine");
    public static Block WISTERIA_STAIRS = new StairsBlock(WISTERIA_PLANKS.getDefaultState(), BlockProperties.WISTERIA_PLANKS).setRegistryName("wisteria_stairs");
    public static Block WISTERIA_SLAB = new SlabBlock(BlockProperties.WISTERIA_PLANKS).setRegistryName("wisteria_slab");
    //public static Block WISTERIA_SIGN = new AbstractColormaticSignBlock.StandingSign(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD)).setRegistryName("wisteria_sign");
    //public static Block WISTERIA_WALL_SIGN = new AbstractColormaticSignBlock.WallSign(Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(WISTERIA_SIGN)).setRegistryName("wisteria_wall_sign");
    public static Block WISTERIA_FENCE = new FenceBlock(BlockProperties.WISTERIA_PLANKS).setRegistryName("wisteria_fence");
    public static Block WISTERIA_FENCE_GATE = new FenceGateBlock(BlockProperties.WISTERIA_PLANKS).setRegistryName("wisteria_fence_gate");
    public static Block WISTERIA_TRAPDOOR = new TrapDoorBlock(BlockProperties.WISTERIA_DOORS).setRegistryName("wisteria_trapdoor");
    public static Block WISTERIA_DOOR = new DoorBlock(BlockProperties.WISTERIA_DOORS).setRegistryName("wisteria_door");
    public static Block WISTERIA_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("wisteria_pressure_plate");
    public static Block WISTERIA_BUTTON = new WoodButtonBlock(BlockProperties.WOOD_BUTTON).setRegistryName("wisteria_button");
    public static Block PINK_DELPHINIUM = new DoublePlantBlock(BlockProperties.DELPHINIUMS).setRegistryName("pink_delphinium");
    public static Block BLUE_DELPHINIUM = new DoublePlantBlock(BlockProperties.DELPHINIUMS).setRegistryName("blue_delphinium");
    public static Block PURPLE_DELPHINIUM = new DoublePlantBlock(BlockProperties.DELPHINIUMS).setRegistryName("purple_delphinium");
    public static Block WHITE_DELPHINIUM = new DoublePlantBlock(BlockProperties.DELPHINIUMS).setRegistryName("white_delphinium");

    //quark
    public static Block WISTERIA_BOOKSHELF = new BookshelfBlock(BlockProperties.BOOKSHELF).setRegistryName("wisteria_bookshelf");
    public static Block WISTERIA_CHEST = new ChestBlock(BlockProperties.CHEST).setRegistryName("wisteria_chest");
    public static Block TRAPPED_WISTERIA_CHEST = new TrappedChestBlock(BlockProperties.CHEST).setRegistryName("trapped_wisteria_chest");
    public static Block WISTERIA_LADDER = new LadderBlock(BlockProperties.LADDER).setRegistryName("wisteria_ladder");
    //vertical slabs

    //florist
    //delphinium flower pots

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                WISTERIA_LOG, STRIPPED_WISTERIA_LOG, WISTERIA_WOOD, STRIPPED_WISTERIA_WOOD, WISTERIA_PLANKS,
                PINK_WISTERIA_SAPLING, BLUE_WISTERIA_SAPLING, PURPLE_WISTERIA_SAPLING, WHITE_WISTERIA_SAPLING,
                POTTED_PINK_WISTERIA_SAPLING, POTTED_BLUE_WISTERIA_SAPLING, POTTED_PURPLE_WISTERIA_SAPLING, POTTED_WHITE_WISTERIA_SAPLING,
                PINK_WISTERIA_LEAVES, BLUE_WISTERIA_LEAVES, PURPLE_WISTERIA_LEAVES, WHITE_WISTERIA_LEAVES,
                PINK_WISTERIA_VINE, BLUE_WISTERIA_VINE, PURPLE_WISTERIA_VINE, WHITE_WISTERIA_VINE,
                WISTERIA_STAIRS, WISTERIA_SLAB, WISTERIA_FENCE, WISTERIA_FENCE_GATE,
                WISTERIA_TRAPDOOR, WISTERIA_DOOR, WISTERIA_PRESSURE_PLATE, WISTERIA_BUTTON,
                PINK_DELPHINIUM, BLUE_DELPHINIUM, PURPLE_DELPHINIUM, WHITE_DELPHINIUM
        );
        //if (ModList.get().isLoaded("quark")) {
            event.getRegistry().registerAll(
                    WISTERIA_BOOKSHELF, WISTERIA_CHEST, TRAPPED_WISTERIA_CHEST, WISTERIA_LADDER
            );
        //}
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        Item.Properties buildingBlocks = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);
        Item.Properties decorations = new Item.Properties().group(ItemGroup.DECORATIONS);
        Item.Properties redstone = new Item.Properties().group(ItemGroup.REDSTONE);
        event.getRegistry().registerAll(
                new BlockItem(WISTERIA_LOG, buildingBlocks).setRegistryName(WISTERIA_LOG.getRegistryName()),
                new BlockItem(STRIPPED_WISTERIA_LOG, buildingBlocks).setRegistryName(STRIPPED_WISTERIA_LOG.getRegistryName()),
                new BlockItem(WISTERIA_WOOD, buildingBlocks).setRegistryName(WISTERIA_WOOD.getRegistryName()),
                new BlockItem(STRIPPED_WISTERIA_WOOD, buildingBlocks).setRegistryName(STRIPPED_WISTERIA_WOOD.getRegistryName()),
                new BlockItem(WISTERIA_PLANKS, buildingBlocks).setRegistryName(WISTERIA_PLANKS.getRegistryName()),
                new BlockItem(WISTERIA_SLAB, buildingBlocks).setRegistryName(WISTERIA_SLAB.getRegistryName()),
                new BlockItem(WISTERIA_STAIRS, buildingBlocks).setRegistryName(WISTERIA_STAIRS.getRegistryName()),
                new BlockItem(WISTERIA_FENCE, decorations).setRegistryName(WISTERIA_FENCE.getRegistryName()),
                new BlockItem(PINK_WISTERIA_LEAVES, decorations).setRegistryName(PINK_WISTERIA_LEAVES.getRegistryName()),
                new BlockItem(BLUE_WISTERIA_LEAVES, decorations).setRegistryName(BLUE_WISTERIA_LEAVES.getRegistryName()),
                new BlockItem(PURPLE_WISTERIA_LEAVES, decorations).setRegistryName(PURPLE_WISTERIA_LEAVES.getRegistryName()),
                new BlockItem(WHITE_WISTERIA_LEAVES, decorations).setRegistryName(WHITE_WISTERIA_LEAVES.getRegistryName()),
                new BlockItem(PINK_WISTERIA_VINE, decorations).setRegistryName(PINK_WISTERIA_VINE.getRegistryName()),
                new BlockItem(BLUE_WISTERIA_VINE, decorations).setRegistryName(BLUE_WISTERIA_VINE.getRegistryName()),
                new BlockItem(PURPLE_WISTERIA_VINE, decorations).setRegistryName(PURPLE_WISTERIA_VINE.getRegistryName()),
                new BlockItem(WHITE_WISTERIA_VINE, decorations).setRegistryName(WHITE_WISTERIA_VINE.getRegistryName()),
                new BlockItem(PINK_WISTERIA_SAPLING, decorations).setRegistryName(PINK_WISTERIA_SAPLING.getRegistryName()),
                new BlockItem(BLUE_WISTERIA_SAPLING, decorations).setRegistryName(BLUE_WISTERIA_SAPLING.getRegistryName()),
                new BlockItem(PURPLE_WISTERIA_SAPLING, decorations).setRegistryName(PURPLE_WISTERIA_SAPLING.getRegistryName()),
                new BlockItem(WHITE_WISTERIA_SAPLING, decorations).setRegistryName(WHITE_WISTERIA_SAPLING.getRegistryName()),
                //new BlockItem(WISTERIA_SIGN, decorations).setRegistryName(WISTERIA_SIGN.getRegistryName()),
                new BlockItem(WISTERIA_FENCE_GATE, redstone).setRegistryName(WISTERIA_FENCE_GATE.getRegistryName()),
                new BlockItem(WISTERIA_TRAPDOOR, redstone).setRegistryName(WISTERIA_TRAPDOOR.getRegistryName()),
                new BlockItem(WISTERIA_DOOR, redstone).setRegistryName(WISTERIA_DOOR.getRegistryName()),
                new BlockItem(WISTERIA_PRESSURE_PLATE, redstone).setRegistryName(WISTERIA_PRESSURE_PLATE.getRegistryName()),
                new BlockItem(WISTERIA_BUTTON, redstone).setRegistryName(WISTERIA_BUTTON.getRegistryName()),
                new BlockItem(PINK_DELPHINIUM, decorations).setRegistryName(PINK_DELPHINIUM.getRegistryName()),
                new BlockItem(BLUE_DELPHINIUM, decorations).setRegistryName(BLUE_DELPHINIUM.getRegistryName()),
                new BlockItem(PURPLE_DELPHINIUM, decorations).setRegistryName(PURPLE_DELPHINIUM.getRegistryName()),
                new BlockItem(WHITE_DELPHINIUM, decorations).setRegistryName(WHITE_DELPHINIUM.getRegistryName())
        );
        //if (ModList.get().isLoaded("quark")) {
            event.getRegistry().registerAll(
                new BlockItem(WISTERIA_BOOKSHELF, buildingBlocks).setRegistryName(WISTERIA_BOOKSHELF.getRegistryName()),
                new BlockItem(WISTERIA_CHEST, decorations).setRegistryName(WISTERIA_CHEST.getRegistryName()),
                new BlockItem(TRAPPED_WISTERIA_CHEST, decorations).setRegistryName(TRAPPED_WISTERIA_CHEST.getRegistryName()),
                new BlockItem(WISTERIA_LADDER, decorations).setRegistryName(WISTERIA_LADDER.getRegistryName())
            );
        //}
    }

    public static void registerBlockData() {
        //compostable blocks
        registerCompostable(BLUE_DELPHINIUM,0.75F);
        registerCompostable(WHITE_DELPHINIUM,0.75F);
        registerCompostable(PINK_DELPHINIUM,0.75F);
        registerCompostable(PURPLE_DELPHINIUM,0.75F);
        registerCompostable(BLUE_WISTERIA_LEAVES,0.35F);
        registerCompostable(WHITE_WISTERIA_LEAVES,0.35F);
        registerCompostable(PINK_WISTERIA_LEAVES,0.35F);
        registerCompostable(PURPLE_WISTERIA_LEAVES,0.35F);
        registerCompostable(BLUE_WISTERIA_VINE,0.35F);
        registerCompostable(WHITE_WISTERIA_VINE,0.35F);
        registerCompostable(PINK_WISTERIA_VINE,0.35F);
        registerCompostable(PURPLE_WISTERIA_VINE,0.35F);
        registerCompostable(BLUE_WISTERIA_SAPLING,0.35F);
        registerCompostable(WHITE_WISTERIA_SAPLING,0.35F);
        registerCompostable(PINK_WISTERIA_SAPLING,0.35F);
        registerCompostable(PURPLE_WISTERIA_SAPLING,0.35F);

        //strippable blocks
        registerStrippable(WISTERIA_LOG, STRIPPED_WISTERIA_LOG);
        registerStrippable(WISTERIA_WOOD, STRIPPED_WISTERIA_WOOD);

        //flammable blocks
        registerFlammable(BLUE_WISTERIA_LEAVES, 30, 60);
        registerFlammable(WHITE_WISTERIA_LEAVES, 30, 60);
        registerFlammable(PINK_WISTERIA_LEAVES, 30, 60);
        registerFlammable(PURPLE_WISTERIA_LEAVES, 30, 60);
        registerFlammable(BLUE_WISTERIA_VINE, 30, 60);
        registerFlammable(WHITE_WISTERIA_VINE, 30, 60);
        registerFlammable(PINK_WISTERIA_VINE, 30, 60);
        registerFlammable(PURPLE_WISTERIA_VINE, 30, 60);
        registerFlammable(WISTERIA_LOG, 5, 5);
        registerFlammable(WISTERIA_WOOD, 5, 5);
        registerFlammable(STRIPPED_WISTERIA_LOG, 5, 5);
        registerFlammable(STRIPPED_WISTERIA_WOOD, 5, 5);
        registerFlammable(WISTERIA_PLANKS, 5, 20);
        registerFlammable(WISTERIA_SLAB, 5, 20);
        registerFlammable(WISTERIA_STAIRS, 5, 20);
        registerFlammable(WISTERIA_FENCE, 5, 20);
        registerFlammable(WISTERIA_FENCE_GATE, 5, 20);
        registerFlammable(BLUE_DELPHINIUM, 60, 100);
        registerFlammable(WHITE_DELPHINIUM, 60, 100);
        registerFlammable(PINK_DELPHINIUM, 60, 100);
        registerFlammable(PURPLE_DELPHINIUM, 60, 100);
    }

    public static void registerFlammable(Block block, int encouragement, int flammability) {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFireInfo(block, encouragement, flammability);
    }

    public static void registerCompostable(IItemProvider item, float chance) {
        ComposterBlock.CHANCES.put(item.asItem(), chance);
    }

    public static void registerStrippable(Block log, Block stripped) {
        AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
        AxeItem.BLOCK_STRIPPING_MAP.put(log, stripped);
    }
}