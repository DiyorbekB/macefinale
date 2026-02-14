package com.example.mace.init;

import com.example.mace.MaceMod;
import com.example.mace.items.MaceItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, MaceMod.MODID);

    public static final RegistryObject<Item> MACE = ITEMS.register("mace",
        () -> new MaceItem(ModTiers.MACE_TIER, 7, -2.8F, 
            new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
