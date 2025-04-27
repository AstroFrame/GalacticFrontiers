package com.knoxhack.galacticfrontiers.world.dimension;

import com.knoxhack.galacticfrontiers.GalacticFrontiersMod;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class SpaceStationDimension {

    public static final ResourceKey<Level> SPACE_STATION_LEVEL = ResourceKey.create(
            net.minecraft.core.registries.Registries.DIMENSION,
            new ResourceLocation(GalacticFrontiersMod.MODID, "space_station")
    );

    public static final ResourceKey<DimensionType> SPACE_STATION_TYPE = ResourceKey.create(
            net.minecraft.core.registries.Registries.DIMENSION_TYPE,
            new ResourceLocation(GalacticFrontiersMod.MODID, "space_station_type")
    );
}
