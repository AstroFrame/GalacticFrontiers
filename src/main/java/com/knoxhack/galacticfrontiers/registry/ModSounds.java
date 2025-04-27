package com.knoxhack.galacticfrontiers.registry;

import com.knoxhack.galacticfrontiers.GalacticFrontiersMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GalacticFrontiersMod.MODID);

    public static final RegistryObject<SoundEvent> SPACE_AMBIENT = SOUNDS.register("space_ambient",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GalacticFrontiersMod.MODID, "space_ambient")));

    public static void register(net.minecraftforge.eventbus.api.IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
