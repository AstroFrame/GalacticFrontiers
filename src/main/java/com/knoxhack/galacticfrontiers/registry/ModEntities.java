package com.knoxhack.galacticfrontiers.registry;

import com.knoxhack.galacticfrontiers.GalacticFrontiersMod;
import com.knoxhack.galacticfrontiers.entity.MeteorEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GalacticFrontiersMod.MODID);

    public static final RegistryObject<EntityType<MeteorEntity>> METEOR = ENTITY_TYPES.register("meteor",
            () -> EntityType.Builder.of(MeteorEntity::new, MobCategory.MISC)
                    .sized(1.0f, 1.0f)
                    .build());

    public static void register(net.minecraftforge.eventbus.api.IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
