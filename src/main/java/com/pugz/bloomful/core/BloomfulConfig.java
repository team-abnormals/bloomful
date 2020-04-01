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
	
    public static boolean generateWisterias = true;
    
    public static class ServerConfig {
    	public final BooleanValue generateWisterias;
	
	    ServerConfig(ForgeConfigSpec.Builder builder) {
	    	generateWisterias 				= builder.comment("These all require game reload!").define("Generate Wisteria Trees outside of the Wisteria Forest", true);
	    }
    }
    
    public static void refresh() {
    	generateWisterias = SERVER.generateWisterias.get();
    }

    @SubscribeEvent
    public static void onFileChange(ModConfig.Reloading event) {
        ((CommentedFileConfig) event.getConfig().getConfigData()).load();
        refresh();
    }
}