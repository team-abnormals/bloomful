package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.common.world.biome.WisteriaForestBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeRegistry {
    public static Biome WISTERIA_FOREST = new WisteriaForestBiome(new Biome.Builder().surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1F).scale(0.4F).temperature(0.7F).downfall(0.8F).waterColor(4159204).waterFogColor(329011).parent("forest")).setRegistryName("wisteria_forest");

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().registerAll(
                WISTERIA_FOREST
        );
    }

    public static void registerBiomeDictionaries() {
        BiomeDictionary.addTypes(WISTERIA_FOREST, BiomeDictionary.Type.RARE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(WISTERIA_FOREST, 6));
    }
}