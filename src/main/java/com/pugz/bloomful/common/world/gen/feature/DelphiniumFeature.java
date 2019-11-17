package com.pugz.bloomful.common.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import com.pugz.bloomful.core.util.BiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.DoublePlantConfig;
import net.minecraft.world.gen.feature.DoublePlantFeature;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;

public class DelphiniumFeature extends DoublePlantFeature {

    public DelphiniumFeature(Function<Dynamic<?>, ? extends DoublePlantConfig> builder) {
        super(builder);
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