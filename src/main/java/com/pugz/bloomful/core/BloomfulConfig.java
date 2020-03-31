package com.pugz.bloomful.core;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;

@EventBusSubscriber(bus = Bus.MOD)
public final class BloomfulConfig {
	
	public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;
    static {
        final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER_SPEC = specPair.getRight();
        SERVER = specPair.getLeft();
    }
	
    public static boolean generateWisterias = false;
    public static boolean wisteriasInJungle = true;
    public static boolean wisteriasInSwamp = true;
    public static boolean wisteriasInPlains = true;
    public static boolean wisteriasInFlowerForest = true;
    public static boolean delphiniumsInFlowerForest = true;
    public static boolean wisteriasInDarkOak = true;
    public static boolean wisteriasElsewhere = true;
    
    public static class ServerConfig {
    	public final BooleanValue generateWisterias;
    	public final BooleanValue wisteriasInJungle;
    	public final BooleanValue wisteriasInSwamp;
    	public final BooleanValue wisteriasInPlains;
    	public final BooleanValue wisteriasInFlowerForest;
    	public final BooleanValue delphiniumsInFlowerForest;
    	public final BooleanValue wisteriasInDarkOak;
    	public final BooleanValue wisteriasElsewhere;
	
	    ServerConfig(ForgeConfigSpec.Builder builder) {
	    	generateWisterias 				= builder.comment("These all require game reload!").define("Generate Wisteria Trees outside of the Wisteria Forest", true);
	    	
	    	wisteriasInJungle 			= builder.define("- Wisteria Trees in Jungles", false);
	    	wisteriasInSwamp 			= builder.define("- Wisteria Trees in Swamps", true);
	    	wisteriasInPlains 			= builder.define("- Wisteria Trees in Plains", true);
	    	wisteriasInFlowerForest 	= builder.define("- Wisteria Trees in Flower Forest'", true);
	    	delphiniumsInFlowerForest 	= builder.define("- Delphiniums in Flower Forests", true);
	    	wisteriasInDarkOak 		= builder.define("- Wisteria Trees in Dark Forests", true);
	    	wisteriasElsewhere 			= builder.define("- Wisteria Trees in misc biomes", true);
	    }
    }
    
    public static void refresh() {
    	generateWisterias = SERVER.generateWisterias.get();
    	wisteriasInJungle = SERVER.wisteriasInJungle.get();
    	wisteriasInSwamp = SERVER.wisteriasInSwamp.get();
    	wisteriasInPlains = SERVER.wisteriasInPlains.get();
    	wisteriasInFlowerForest = SERVER.delphiniumsInFlowerForest.get();
    	delphiniumsInFlowerForest = SERVER.delphiniumsInFlowerForest.get();
    	wisteriasInDarkOak = SERVER.wisteriasInDarkOak.get();
    	wisteriasElsewhere = SERVER.wisteriasElsewhere.get();
    }

    @SubscribeEvent
    public static void onFileChange(ModConfig.Reloading event) {
        ((CommentedFileConfig) event.getConfig().getConfigData()).load();
        refresh();
    }
}