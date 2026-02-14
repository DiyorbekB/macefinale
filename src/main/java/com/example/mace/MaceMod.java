package com.example.mace;

import com.example.mace.init.ModItems;
import com.example.mace.init.ModSounds;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MaceMod.MODID)
public class MaceMod {
    public static final String MODID = "mace";
    public static final Logger LOGGER = LogManager.getLogger();

    public MaceMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Register items and sounds
        ModItems.register(bus);
        ModSounds.register(bus);
        
        bus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("MaceMod: setup complete");
    }
}
