package com.knoxhack.galacticfrontiers;

import com.knoxhack.galacticfrontiers.registry.ModBlocks;
import com.knoxhack.galacticfrontiers.registry.ModItems;
import com.knoxhack.galacticfrontiers.registry.ModEntities;
import com.knoxhack.galacticfrontiers.registry.ModSounds;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GalacticFrontiersMod.MODID)
public class GalacticFrontiersMod {
    public static final String MODID = "galacticfrontiers";

    public GalacticFrontiersMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModEntities.ENTITY_TYPES.register(eventBus);
        ModSounds.SOUNDS.register(eventBus);
    }
}
