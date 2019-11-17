package com.pugz.bloomful.common.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import com.pugz.bloomful.core.util.BiomeFeatures;
import com.pugz.bloomful.core.util.WisteriaTreeUtils;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.DoublePlantConfig;
import net.minecraft.world.gen.feature.DoublePlantFeature;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;
import java.util.function.Function;

public class DelphiniumFeature extends DoublePlantFeature {

    public DelphiniumFeature(Function<Dynamic<?>, ? extends DoublePlantConfig> builder) {
        super(builder);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, DoublePlantConfig config) {
        boolean flag = false;
        for (int i = 0; i < 64; ++i) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            if (worldIn.isAirBlock(blockpos) && blockpos.getY() < worldIn.getWorld().getDimension().getHeight() - 2 && config.state.isValidPosition(worldIn, blockpos)) {
                ((DoublePlantBlock) config.state.getBlock()).placeAt(worldIn, blockpos, 2);
                flag = true;
            }
        }
        return flag;
    }

    public static void addFeature() {
        ForgeRegistries.BIOMES.getValues().forEach(DelphiniumFeature::generate);
    }

    public static void generate(Biome biome) {
        if (biome == Biomes.FLOWER_FOREST) {
            BiomeFeatures.addDelphiniums(biome, 4);
        }
    }
}