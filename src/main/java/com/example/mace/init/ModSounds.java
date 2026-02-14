package com.example.mace.init;

import com.example.mace.MaceMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = 
        DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MaceMod.MODID);

    public static final RegistryObject<SoundEvent> MACE_HIT = SOUNDS.register("mace_hit",
        () -> new SoundEvent(new ResourceLocation(MaceMod.MODID, "mace_hit")));

    public static void register(IEventBus bus) {
        SOUNDS.register(bus);
    }
}
