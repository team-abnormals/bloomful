package com.pugz.bloomful.core.registry;

import com.google.common.collect.Maps;
import com.pugz.bloomful.common.block.BloomfulSaplingBlock;
import com.pugz.bloomful.common.block.BookshelfBlock;
import com.pugz.bloomful.common.block.HangingWisteriaLeavesBlock;
import com.pugz.bloomful.common.block.LadderBlock;
import com.pugz.bloomful.common.block.LeafCarpetBlock;
import com.pugz.bloomful.common.block.VerticalSlabBlock;
import com.pugz.bloomful.common.block.WisteriaLeavesBlock;
import com.pugz.bloomful.common.world.gen.feature.trees.WisteriaTree;
import com.pugz.bloomful.core.util.BlockProperties;
import com.pugz.bloomful.core.util.RegistryUtils;
import com.pugz.bloomful.core.util.WisteriaColor;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BloomfulBlocks {
	public static final DeferredRegister<Block> BLOCKS =  new DeferredRegister<>(ForgeRegistries.BLOCKS, "bloomful");
	
    public static final RegistryObject<Block> WISTERIA_LOG 					= RegistryUtils.createBlock("wisteria_log", () -> new LogBlock(MaterialColor.WHITE_TERRACOTTA, BlockProperties.WISTERIA_LOG(false)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_WISTERIA_LOG 		= RegistryUtils.createBlock("stripped_wisteria_log", () -> new LogBlock(MaterialColor.WHITE_TERRACOTTA, BlockProperties.WISTERIA_LOG(true)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_WOOD 				= RegistryUtils.createBlock("wisteria_wood", () -> new RotatedPillarBlock(BlockProperties.WISTERIA_LOG(false)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_WISTERIA_WOOD 		= RegistryUtils.createBlock("stripped_wisteria_wood", () -> new RotatedPillarBlock(BlockProperties.WISTERIA_LOG(true)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_PLANKS 				= RegistryUtils.createBlock("wisteria_planks", () -> new Block(BlockProperties.WISTERIA_PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> PINK_WISTERIA_SAPLING 		= RegistryUtils.createBlock("pink_wisteria_sapling", () -> new BloomfulSaplingBlock(BlockProperties.SAPLING, new WisteriaTree(WisteriaColor.PINK)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLUE_WISTERIA_SAPLING 		= RegistryUtils.createBlock("blue_wisteria_sapling", () -> new BloomfulSaplingBlock(BlockProperties.SAPLING, new WisteriaTree(WisteriaColor.BLUE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_WISTERIA_SAPLING 		= RegistryUtils.createBlock("purple_wisteria_sapling", () -> new BloomfulSaplingBlock(BlockProperties.SAPLING, new WisteriaTree(WisteriaColor.PURPLE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WHITE_WISTERIA_SAPLING 		= RegistryUtils.createBlock("white_wisteria_sapling", () -> new BloomfulSaplingBlock(BlockProperties.SAPLING, new WisteriaTree(WisteriaColor.WHITE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> POTTED_PINK_WISTERIA_SAPLING	= RegistryUtils.createBlockNoItem("potted_pink_wisteria_sapling", () -> new FlowerPotBlock(PINK_WISTERIA_SAPLING.get(), BlockProperties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_BLUE_WISTERIA_SAPLING 	= RegistryUtils.createBlockNoItem("potted_blue_wisteria_sapling", () -> new FlowerPotBlock(BLUE_WISTERIA_SAPLING.get(), BlockProperties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_PURPLE_WISTERIA_SAPLING= RegistryUtils.createBlockNoItem("potted_purple_wisteria_sapling", () -> new FlowerPotBlock(PURPLE_WISTERIA_SAPLING.get(), BlockProperties.FLOWER_POT));
	public static final RegistryObject<Block> POTTED_WHITE_WISTERIA_SAPLING = RegistryUtils.createBlockNoItem("potted_white_wisteria_sapling", () -> new FlowerPotBlock(WHITE_WISTERIA_SAPLING.get(), BlockProperties.FLOWER_POT));
    public static final RegistryObject<Block> PINK_WISTERIA_LEAVES 			= RegistryUtils.createBlock("pink_wisteria_leaves", () -> new WisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PINK)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLUE_WISTERIA_LEAVES 			= RegistryUtils.createBlock("blue_wisteria_leaves", () -> new WisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.BLUE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_WISTERIA_LEAVES 		= RegistryUtils.createBlock("purple_wisteria_leaves", () -> new WisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PURPLE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WHITE_WISTERIA_LEAVES 		= RegistryUtils.createBlock("white_wisteria_leaves", () -> new WisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.SNOW)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PINK_HANGING_WISTERIA_LEAVES	= RegistryUtils.createBlock("pink_hanging_wisteria_leaves", () -> new HangingWisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PINK)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLUE_HANGING_WISTERIA_LEAVES 	= RegistryUtils.createBlock("blue_hanging_wisteria_leaves", () -> new HangingWisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.BLUE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_HANGING_WISTERIA_LEAVES= RegistryUtils.createBlock("purple_hanging_wisteria_leaves", () -> new HangingWisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PURPLE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WHITE_HANGING_WISTERIA_LEAVES = RegistryUtils.createBlock("white_hanging_wisteria_leaves", () -> new HangingWisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.SNOW)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WISTERIA_STAIRS				= RegistryUtils.createBlock("wisteria_stairs", () -> new StairsBlock(WISTERIA_PLANKS.get().getDefaultState(), BlockProperties.WISTERIA_PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_SLAB 				= RegistryUtils.createBlock("wisteria_slab", () -> new SlabBlock(BlockProperties.WISTERIA_PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_FENCE 				= RegistryUtils.createBlock("wisteria_fence", () -> new FenceBlock(BlockProperties.WISTERIA_PLANKS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WISTERIA_FENCE_GATE 			= RegistryUtils.createBlock("wisteria_fence_gate", () -> new FenceGateBlock(BlockProperties.WISTERIA_PLANKS), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> WISTERIA_TRAPDOOR 			= RegistryUtils.createBlock("wisteria_trapdoor", () -> new TrapDoorBlock(BlockProperties.WISTERIA_DOORS), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> WISTERIA_DOOR 				= RegistryUtils.createBlock("wisteria_door", () -> new DoorBlock(BlockProperties.WISTERIA_DOORS), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> WISTERIA_PRESSURE_PLATE 		= RegistryUtils.createBlock("wisteria_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> WISTERIA_BUTTON 				= RegistryUtils.createBlock("wisteria_button", () -> new WoodButtonBlock(BlockProperties.WOOD_BUTTON), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> PINK_DELPHINIUM 				= RegistryUtils.createBlock("pink_delphinium", () -> new TallFlowerBlock(BlockProperties.DELPHINIUMS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLUE_DELPHINIUM 				= RegistryUtils.createBlock("blue_delphinium", () -> new TallFlowerBlock(BlockProperties.DELPHINIUMS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_DELPHINIUM 			= RegistryUtils.createBlock("purple_delphinium", () -> new TallFlowerBlock(BlockProperties.DELPHINIUMS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WHITE_DELPHINIUM 				= RegistryUtils.createBlock("white_delphinium", () -> new TallFlowerBlock(BlockProperties.DELPHINIUMS), ItemGroup.DECORATIONS);
    
	public static final RegistryObject<Block> POTTED_WHITE_DELPHINIUM     	= RegistryUtils.createBlockNoItem("potted_white_delphinium", () -> new FlowerPotBlock(ModList.get().isLoaded("bloomful") ? WHITE_DELPHINIUM.get() : Blocks.AIR, BlockProperties.FLOWER_POT));
	public static final RegistryObject<Block> POTTED_BLUE_DELPHINIUM     	= RegistryUtils.createBlockNoItem("potted_blue_delphinium", () -> new FlowerPotBlock(ModList.get().isLoaded("bloomful") ? BLUE_DELPHINIUM.get() : Blocks.AIR, BlockProperties.FLOWER_POT));
	public static final RegistryObject<Block> POTTED_PINK_DELPHINIUM     	= RegistryUtils.createBlockNoItem("potted_pink_delphinium", () -> new FlowerPotBlock(ModList.get().isLoaded("bloomful") ? PINK_DELPHINIUM.get() : Blocks.AIR, BlockProperties.FLOWER_POT));
	public static final RegistryObject<Block> POTTED_PURPLE_DELPHINIUM		= RegistryUtils.createBlockNoItem("potted_purple_delphinium", () -> new FlowerPotBlock(ModList.get().isLoaded("bloomful") ? PURPLE_DELPHINIUM.get() : Blocks.AIR, BlockProperties.FLOWER_POT));
	
    //quark
    public static final RegistryObject<Block> WISTERIA_BOOKSHELF 			= RegistryUtils.createCompatBlock("quark", "wisteria_bookshelf", () -> new BookshelfBlock(BlockProperties.BOOKSHELF), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WISTERIA_LADDER 				= RegistryUtils.createCompatBlock("quark", "wisteria_ladder", () -> new LadderBlock(BlockProperties.LADDER), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> VERTICAL_WISTERIA_PLANKS 		= RegistryUtils.createCompatBlock("quark", "vertical_wisteria_planks", () -> new Block(BlockProperties.WISTERIA_PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_VERTICAL_SLAB 		= RegistryUtils.createCompatBlock("quark", "wisteria_vertical_slab", () -> new VerticalSlabBlock(BlockProperties.WISTERIA_PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> PINK_WISTERIA_LEAF_CARPET 	= RegistryUtils.createCompatBlock("quark", "pink_wisteria_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PINK)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLUE_WISTERIA_LEAF_CARPET 	= RegistryUtils.createCompatBlock("quark", "blue_wisteria_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.BLUE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_WISTERIA_LEAF_CARPET 	= RegistryUtils.createCompatBlock("quark", "purple_wisteria_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PURPLE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WHITE_WISTERIA_LEAF_CARPET 	= RegistryUtils.createCompatBlock("quark", "white_wisteria_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.SNOW)), ItemGroup.DECORATIONS);

    public static void registerBlockData() {
        //compostable blocks
        registerCompostable(BLUE_DELPHINIUM.get(),0.75F);
        registerCompostable(WHITE_DELPHINIUM.get(),0.75F);
        registerCompostable(PINK_DELPHINIUM.get(),0.75F);
        registerCompostable(PURPLE_DELPHINIUM.get(),0.75F);
        registerCompostable(BLUE_WISTERIA_LEAVES.get(),0.35F);
        registerCompostable(WHITE_WISTERIA_LEAVES.get(),0.35F);
        registerCompostable(PINK_WISTERIA_LEAVES.get(),0.35F);
        registerCompostable(PURPLE_WISTERIA_LEAVES.get(),0.35F);
        registerCompostable(BLUE_HANGING_WISTERIA_LEAVES.get(),0.35F);
        registerCompostable(WHITE_HANGING_WISTERIA_LEAVES.get(),0.35F);
        registerCompostable(PINK_HANGING_WISTERIA_LEAVES.get(),0.35F);
        registerCompostable(PURPLE_HANGING_WISTERIA_LEAVES.get(),0.35F);
        registerCompostable(BLUE_WISTERIA_SAPLING.get(),0.35F);
        registerCompostable(WHITE_WISTERIA_SAPLING.get(),0.35F);
        registerCompostable(PINK_WISTERIA_SAPLING.get(),0.35F);
        registerCompostable(PURPLE_WISTERIA_SAPLING.get(),0.35F);
        registerCompostable(BLUE_WISTERIA_LEAF_CARPET.get(),0.35F);
        registerCompostable(WHITE_WISTERIA_LEAF_CARPET.get(),0.35F);
        registerCompostable(PINK_WISTERIA_LEAF_CARPET.get(),0.35F);
        registerCompostable(PURPLE_WISTERIA_LEAF_CARPET.get(),0.35F);

        //strippable blocks
        registerStrippable(WISTERIA_LOG.get(), STRIPPED_WISTERIA_LOG.get());
        registerStrippable(WISTERIA_WOOD.get(), STRIPPED_WISTERIA_WOOD.get());

        //flammable blocks
        registerFlammable(BLUE_WISTERIA_LEAVES.get(), 30, 60);
        registerFlammable(WHITE_WISTERIA_LEAVES.get(), 30, 60);
        registerFlammable(PINK_WISTERIA_LEAVES.get(), 30, 60);
        registerFlammable(PURPLE_WISTERIA_LEAVES.get(), 30, 60);
        registerFlammable(BLUE_HANGING_WISTERIA_LEAVES.get(), 30, 60);
        registerFlammable(WHITE_HANGING_WISTERIA_LEAVES.get(), 30, 60);
        registerFlammable(PINK_HANGING_WISTERIA_LEAVES.get(), 30, 60);
        registerFlammable(PURPLE_HANGING_WISTERIA_LEAVES.get(), 30, 60);
        registerFlammable(WISTERIA_LOG.get(), 5, 5);
        registerFlammable(WISTERIA_WOOD.get(), 5, 5);
        registerFlammable(STRIPPED_WISTERIA_LOG.get(), 5, 5);
        registerFlammable(STRIPPED_WISTERIA_WOOD.get(), 5, 5);
        registerFlammable(WISTERIA_PLANKS.get(), 5, 20);
        registerFlammable(WISTERIA_SLAB.get(), 5, 20);
        registerFlammable(WISTERIA_STAIRS.get(), 5, 20);
        registerFlammable(WISTERIA_FENCE.get(), 5, 20);
        registerFlammable(WISTERIA_FENCE_GATE.get(), 5, 20);
        registerFlammable(BLUE_DELPHINIUM.get(), 60, 100);
        registerFlammable(WHITE_DELPHINIUM.get(), 60, 100);
        registerFlammable(PINK_DELPHINIUM.get(), 60, 100);
        registerFlammable(PURPLE_DELPHINIUM.get(), 60, 100);
        registerFlammable(VERTICAL_WISTERIA_PLANKS.get(), 5, 20);
        registerFlammable(BLUE_WISTERIA_LEAF_CARPET.get(), 30, 60);
        registerFlammable(WHITE_WISTERIA_LEAF_CARPET.get(), 30, 60);
        registerFlammable(PINK_WISTERIA_LEAF_CARPET.get(), 30, 60);
        registerFlammable(PURPLE_WISTERIA_LEAF_CARPET.get(), 30, 60);
        registerFlammable(WISTERIA_VERTICAL_SLAB.get(), 5, 20);
        registerFlammable(WISTERIA_BOOKSHELF.get(), 5, 20);
    }
    
    public static void setupRenderLayer()
	{
		//Doors and Trapdoors
    	RenderTypeLookup.setRenderLayer(WISTERIA_DOOR.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(WISTERIA_TRAPDOOR.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(WISTERIA_LADDER.get(),RenderType.getCutout());
		
		RenderTypeLookup.setRenderLayer(WHITE_WISTERIA_LEAVES.get(),RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(BLUE_WISTERIA_LEAVES.get(),RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PINK_WISTERIA_LEAVES.get(),RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PURPLE_WISTERIA_LEAVES.get(),RenderType.getCutoutMipped());
		
		RenderTypeLookup.setRenderLayer(WHITE_DELPHINIUM.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BLUE_DELPHINIUM.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(PINK_DELPHINIUM.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(PURPLE_DELPHINIUM.get(),RenderType.getCutout());
		
		RenderTypeLookup.setRenderLayer(POTTED_WHITE_DELPHINIUM.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(POTTED_BLUE_DELPHINIUM.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(POTTED_PINK_DELPHINIUM.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(POTTED_PURPLE_DELPHINIUM.get(),RenderType.getCutout());
		
		RenderTypeLookup.setRenderLayer(WHITE_HANGING_WISTERIA_LEAVES.get(),RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(BLUE_HANGING_WISTERIA_LEAVES.get(),RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PINK_HANGING_WISTERIA_LEAVES.get(),RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PURPLE_HANGING_WISTERIA_LEAVES.get(),RenderType.getCutoutMipped());

		RenderTypeLookup.setRenderLayer(WHITE_WISTERIA_LEAF_CARPET.get(),RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(BLUE_WISTERIA_LEAF_CARPET.get(),RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PINK_WISTERIA_LEAF_CARPET.get(),RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PURPLE_WISTERIA_LEAF_CARPET.get(),RenderType.getCutoutMipped());
		
		//Flowers
		RenderTypeLookup.setRenderLayer(WHITE_WISTERIA_SAPLING.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BLUE_WISTERIA_SAPLING.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(PINK_WISTERIA_SAPLING.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(PURPLE_WISTERIA_SAPLING.get(),RenderType.getCutout());
		
		//Potted Flowers
		RenderTypeLookup.setRenderLayer(POTTED_WHITE_WISTERIA_SAPLING.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(POTTED_BLUE_WISTERIA_SAPLING.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(POTTED_PINK_WISTERIA_SAPLING.get(),RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(POTTED_PURPLE_WISTERIA_SAPLING.get(),RenderType.getCutout());
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