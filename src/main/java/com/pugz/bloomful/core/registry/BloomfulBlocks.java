package com.pugz.bloomful.core.registry;

import com.mojang.datafixers.util.Pair;
import com.pugz.bloomful.common.block.HangingWisteriaLeavesBlock;
import com.pugz.bloomful.common.block.WisteriaLeavesBlock;
import com.pugz.bloomful.common.world.gen.feature.trees.WisteriaTree;
import com.pugz.bloomful.core.Bloomful;
import com.pugz.bloomful.core.util.BlockProperties;
import com.pugz.bloomful.core.util.WisteriaColor;
import com.teamabnormals.abnormals_core.common.blocks.AbnormalsLadderBlock;
import com.teamabnormals.abnormals_core.common.blocks.AbnormalsTallFlowerBlock;
import com.teamabnormals.abnormals_core.common.blocks.BookshelfBlock;
import com.teamabnormals.abnormals_core.common.blocks.LeafCarpetBlock;
import com.teamabnormals.abnormals_core.common.blocks.VerticalSlabBlock;
import com.teamabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.teamabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.AbnormalsLogBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.AbnormalsSaplingBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.AbnormalsWoodButtonBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.PlanksBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.StrippedLogBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.StrippedWoodBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.WoodBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.WoodDoorBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.WoodFenceBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.WoodFenceGateBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.WoodPressurePlateBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.WoodSlabBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.WoodStairsBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.WoodTrapDoorBlock;
import com.teamabnormals.abnormals_core.core.utils.DataUtils;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BloomfulBlocks {
	public static final RegistryHelper HELPER = Bloomful.REGISTRY_HELPER;
	
    public static final RegistryObject<Block> STRIPPED_WISTERIA_LOG 		= HELPER.createBlock("stripped_wisteria_log", () -> new StrippedLogBlock(BlockProperties.WISTERIA_LOG(true)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_LOG 					= HELPER.createBlock("wisteria_log", () -> new AbnormalsLogBlock(STRIPPED_WISTERIA_LOG, MaterialColor.WHITE_TERRACOTTA, BlockProperties.WISTERIA_LOG(false)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_WISTERIA_WOOD 		= HELPER.createBlock("stripped_wisteria_wood", () -> new StrippedWoodBlock(BlockProperties.WISTERIA_LOG(true)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_WOOD 				= HELPER.createBlock("wisteria_wood", () -> new WoodBlock(STRIPPED_WISTERIA_WOOD, BlockProperties.WISTERIA_LOG(false)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_PLANKS 				= HELPER.createBlock("wisteria_planks", () -> new PlanksBlock(BlockProperties.WISTERIA_PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> PINK_WISTERIA_SAPLING 		= HELPER.createBlock("pink_wisteria_sapling", () -> new AbnormalsSaplingBlock(new WisteriaTree(WisteriaColor.PINK), BlockProperties.SAPLING), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLUE_WISTERIA_SAPLING 		= HELPER.createBlock("blue_wisteria_sapling", () -> new AbnormalsSaplingBlock(new WisteriaTree(WisteriaColor.BLUE), BlockProperties.SAPLING), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_WISTERIA_SAPLING 		= HELPER.createBlock("purple_wisteria_sapling", () -> new AbnormalsSaplingBlock(new WisteriaTree(WisteriaColor.PURPLE), BlockProperties.SAPLING), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WHITE_WISTERIA_SAPLING 		= HELPER.createBlock("white_wisteria_sapling", () -> new AbnormalsSaplingBlock(new WisteriaTree(WisteriaColor.WHITE), BlockProperties.SAPLING), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> POTTED_PINK_WISTERIA_SAPLING	= HELPER.createBlockNoItem("potted_pink_wisteria_sapling", () -> new FlowerPotBlock(PINK_WISTERIA_SAPLING.get(), BlockProperties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_BLUE_WISTERIA_SAPLING 	= HELPER.createBlockNoItem("potted_blue_wisteria_sapling", () -> new FlowerPotBlock(BLUE_WISTERIA_SAPLING.get(), BlockProperties.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_PURPLE_WISTERIA_SAPLING= HELPER.createBlockNoItem("potted_purple_wisteria_sapling", () -> new FlowerPotBlock(PURPLE_WISTERIA_SAPLING.get(), BlockProperties.FLOWER_POT));
	public static final RegistryObject<Block> POTTED_WHITE_WISTERIA_SAPLING = HELPER.createBlockNoItem("potted_white_wisteria_sapling", () -> new FlowerPotBlock(WHITE_WISTERIA_SAPLING.get(), BlockProperties.FLOWER_POT));
    public static final RegistryObject<Block> PINK_WISTERIA_LEAVES 			= HELPER.createBlock("pink_wisteria_leaves", () -> new WisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PINK)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLUE_WISTERIA_LEAVES 			= HELPER.createBlock("blue_wisteria_leaves", () -> new WisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.BLUE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_WISTERIA_LEAVES 		= HELPER.createBlock("purple_wisteria_leaves", () -> new WisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PURPLE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WHITE_WISTERIA_LEAVES 		= HELPER.createBlock("white_wisteria_leaves", () -> new WisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.SNOW)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PINK_HANGING_WISTERIA_LEAVES	= HELPER.createBlock("pink_hanging_wisteria_leaves", () -> new HangingWisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PINK)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLUE_HANGING_WISTERIA_LEAVES 	= HELPER.createBlock("blue_hanging_wisteria_leaves", () -> new HangingWisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.BLUE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_HANGING_WISTERIA_LEAVES= HELPER.createBlock("purple_hanging_wisteria_leaves", () -> new HangingWisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PURPLE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WHITE_HANGING_WISTERIA_LEAVES = HELPER.createBlock("white_hanging_wisteria_leaves", () -> new HangingWisteriaLeavesBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.SNOW)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WISTERIA_STAIRS				= HELPER.createBlock("wisteria_stairs", () -> new WoodStairsBlock(WISTERIA_PLANKS.get().getDefaultState(), BlockProperties.WISTERIA_PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_SLAB 				= HELPER.createBlock("wisteria_slab", () -> new WoodSlabBlock(BlockProperties.WISTERIA_PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_FENCE 				= HELPER.createBlock("wisteria_fence", () -> new WoodFenceBlock(BlockProperties.WISTERIA_PLANKS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WISTERIA_FENCE_GATE 			= HELPER.createBlock("wisteria_fence_gate", () -> new WoodFenceGateBlock(BlockProperties.WISTERIA_PLANKS), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> WISTERIA_TRAPDOOR 			= HELPER.createBlock("wisteria_trapdoor", () -> new WoodTrapDoorBlock(BlockProperties.WISTERIA_DOORS), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> WISTERIA_DOOR 				= HELPER.createBlock("wisteria_door", () -> new WoodDoorBlock(BlockProperties.WISTERIA_DOORS), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> WISTERIA_PRESSURE_PLATE 		= HELPER.createBlock("wisteria_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> WISTERIA_BUTTON 				= HELPER.createBlock("wisteria_button", () -> new AbnormalsWoodButtonBlock(BlockProperties.WOOD_BUTTON), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> PINK_DELPHINIUM 				= HELPER.createBlock("pink_delphinium", () -> new AbnormalsTallFlowerBlock(BlockProperties.DELPHINIUMS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLUE_DELPHINIUM 				= HELPER.createBlock("blue_delphinium", () -> new AbnormalsTallFlowerBlock(BlockProperties.DELPHINIUMS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_DELPHINIUM 			= HELPER.createBlock("purple_delphinium", () -> new AbnormalsTallFlowerBlock(BlockProperties.DELPHINIUMS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WHITE_DELPHINIUM 				= HELPER.createBlock("white_delphinium", () -> new AbnormalsTallFlowerBlock(BlockProperties.DELPHINIUMS), ItemGroup.DECORATIONS);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> WISTERIA_SIGN = HELPER.createSignBlock("wisteria", MaterialColor.WHITE_TERRACOTTA);

    public static final RegistryObject<Block> WISTERIA_BOOKSHELF 			= HELPER.createCompatBlock("quark", "wisteria_bookshelf", () -> new BookshelfBlock(BlockProperties.BOOKSHELF), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WISTERIA_LADDER 				= HELPER.createCompatBlock("quark", "wisteria_ladder", () -> new AbnormalsLadderBlock(BlockProperties.LADDER), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> VERTICAL_WISTERIA_PLANKS 		= HELPER.createCompatBlock("quark", "vertical_wisteria_planks", () -> new Block(BlockProperties.WISTERIA_PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> WISTERIA_VERTICAL_SLAB 		= HELPER.createCompatBlock("quark", "wisteria_vertical_slab", () -> new VerticalSlabBlock(BlockProperties.WISTERIA_PLANKS), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> PINK_WISTERIA_LEAF_CARPET 	= HELPER.createCompatBlock("quark", "pink_wisteria_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PINK)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BLUE_WISTERIA_LEAF_CARPET 	= HELPER.createCompatBlock("quark", "blue_wisteria_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.BLUE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> PURPLE_WISTERIA_LEAF_CARPET 	= HELPER.createCompatBlock("quark", "purple_wisteria_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.PURPLE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> WHITE_WISTERIA_LEAF_CARPET 	= HELPER.createCompatBlock("quark", "white_wisteria_leaf_carpet", () -> new LeafCarpetBlock(BlockProperties.WISTERIA_LEAVES(MaterialColor.SNOW)), ItemGroup.DECORATIONS);

    public static void registerCompostables() {
        DataUtils.registerCompostable(0.75F,BLUE_DELPHINIUM.get());
        DataUtils.registerCompostable(0.75F,WHITE_DELPHINIUM.get());
        DataUtils.registerCompostable(0.75F,PINK_DELPHINIUM.get());
        DataUtils.registerCompostable(0.75F,PURPLE_DELPHINIUM.get());
        DataUtils.registerCompostable(0.35F,BLUE_WISTERIA_LEAVES.get());
        DataUtils.registerCompostable(0.35F,WHITE_WISTERIA_LEAVES.get());
        DataUtils.registerCompostable(0.35F,PINK_WISTERIA_LEAVES.get());
        DataUtils.registerCompostable(0.35F,PURPLE_WISTERIA_LEAVES.get());
        DataUtils.registerCompostable(0.35F,BLUE_HANGING_WISTERIA_LEAVES.get());
        DataUtils.registerCompostable(0.35F,WHITE_HANGING_WISTERIA_LEAVES.get());
        DataUtils.registerCompostable(0.35F,PINK_HANGING_WISTERIA_LEAVES.get());
        DataUtils.registerCompostable(0.35F,PURPLE_HANGING_WISTERIA_LEAVES.get());
        DataUtils.registerCompostable(0.35F,BLUE_WISTERIA_SAPLING.get());
        DataUtils.registerCompostable(0.35F,WHITE_WISTERIA_SAPLING.get());
        DataUtils.registerCompostable(0.35F,PINK_WISTERIA_SAPLING.get());
        DataUtils.registerCompostable(0.35F,PURPLE_WISTERIA_SAPLING.get());
        DataUtils.registerCompostable(0.35F,BLUE_WISTERIA_LEAF_CARPET.get());
        DataUtils.registerCompostable(0.35F,WHITE_WISTERIA_LEAF_CARPET.get());
        DataUtils.registerCompostable(0.35F,PINK_WISTERIA_LEAF_CARPET.get());
        DataUtils.registerCompostable(0.35F,PURPLE_WISTERIA_LEAF_CARPET.get());
    }
    
    public static void registerFlammables() {
        DataUtils.registerFlammable(BLUE_WISTERIA_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(WHITE_WISTERIA_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(PINK_WISTERIA_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(PURPLE_WISTERIA_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(BLUE_HANGING_WISTERIA_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(WHITE_HANGING_WISTERIA_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(PINK_HANGING_WISTERIA_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(PURPLE_HANGING_WISTERIA_LEAVES.get(), 30, 60);
        DataUtils.registerFlammable(WISTERIA_LOG.get(), 5, 5);
        DataUtils.registerFlammable(WISTERIA_WOOD.get(), 5, 5);
        DataUtils.registerFlammable(STRIPPED_WISTERIA_LOG.get(), 5, 5);
        DataUtils.registerFlammable(STRIPPED_WISTERIA_WOOD.get(), 5, 5);
        DataUtils.registerFlammable(WISTERIA_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(WISTERIA_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(WISTERIA_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(WISTERIA_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(WISTERIA_FENCE_GATE.get(), 5, 20);
        DataUtils.registerFlammable(BLUE_DELPHINIUM.get(), 60, 100);
        DataUtils.registerFlammable(WHITE_DELPHINIUM.get(), 60, 100);
        DataUtils.registerFlammable(PINK_DELPHINIUM.get(), 60, 100);
        DataUtils.registerFlammable(PURPLE_DELPHINIUM.get(), 60, 100);
        DataUtils.registerFlammable(VERTICAL_WISTERIA_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(BLUE_WISTERIA_LEAF_CARPET.get(), 30, 60);
        DataUtils.registerFlammable(WHITE_WISTERIA_LEAF_CARPET.get(), 30, 60);
        DataUtils.registerFlammable(PINK_WISTERIA_LEAF_CARPET.get(), 30, 60);
        DataUtils.registerFlammable(PURPLE_WISTERIA_LEAF_CARPET.get(), 30, 60);
        DataUtils.registerFlammable(WISTERIA_VERTICAL_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(WISTERIA_BOOKSHELF.get(), 5, 20);
    }
    
    public static void setupRenderLayer() {
		boolean fancy = Minecraft.isFancyGraphicsEnabled();
    	
    	RenderTypeLookup.setRenderLayer(WISTERIA_DOOR.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(WISTERIA_TRAPDOOR.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(WISTERIA_LADDER.get(), RenderType.getCutoutMipped());
		
		RenderTypeLookup.setRenderLayer(WHITE_WISTERIA_LEAVES.get(), fancy ? RenderType.getCutoutMipped() : RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BLUE_WISTERIA_LEAVES.get(), fancy ? RenderType.getCutoutMipped() : RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(PINK_WISTERIA_LEAVES.get(), fancy ? RenderType.getCutoutMipped() : RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(PURPLE_WISTERIA_LEAVES.get(), fancy ? RenderType.getCutoutMipped() : RenderType.getSolid());
		
		RenderTypeLookup.setRenderLayer(WHITE_DELPHINIUM.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(BLUE_DELPHINIUM.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PINK_DELPHINIUM.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PURPLE_DELPHINIUM.get(), RenderType.getCutoutMipped());
		
		RenderTypeLookup.setRenderLayer(WHITE_HANGING_WISTERIA_LEAVES.get(), fancy ? RenderType.getCutoutMipped() : RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BLUE_HANGING_WISTERIA_LEAVES.get(), fancy ? RenderType.getCutoutMipped() : RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(PINK_HANGING_WISTERIA_LEAVES.get(), fancy ? RenderType.getCutoutMipped() : RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(PURPLE_HANGING_WISTERIA_LEAVES.get(), fancy ? RenderType.getCutoutMipped() : RenderType.getSolid());

		RenderTypeLookup.setRenderLayer(WHITE_WISTERIA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(BLUE_WISTERIA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PINK_WISTERIA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PURPLE_WISTERIA_LEAF_CARPET.get(), RenderType.getCutoutMipped());
		
		RenderTypeLookup.setRenderLayer(WHITE_WISTERIA_SAPLING.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(BLUE_WISTERIA_SAPLING.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PINK_WISTERIA_SAPLING.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(PURPLE_WISTERIA_SAPLING.get(), RenderType.getCutoutMipped());
		
		RenderTypeLookup.setRenderLayer(POTTED_WHITE_WISTERIA_SAPLING.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(POTTED_BLUE_WISTERIA_SAPLING.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(POTTED_PINK_WISTERIA_SAPLING.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(POTTED_PURPLE_WISTERIA_SAPLING.get(), RenderType.getCutoutMipped());
	}
}