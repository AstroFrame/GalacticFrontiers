package com.knoxhack.galacticfrontiers.registry;

import com.knoxhack.galacticfrontiers.GalacticFrontiersMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GalacticFrontiersMod.MODID);

    public static final RegistryObject<Item> LAUNCH_PAD_BLOCK_ITEM = ITEMS.register("launch_pad_block",
            () -> new BlockItem(ModBlocks.LAUNCH_PAD_BLOCK.get(), new Item.Properties()));

    public static void register(net.minecraftforge.eventbus.api.IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
