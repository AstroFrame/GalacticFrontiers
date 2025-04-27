package com.knoxhack.galacticfrontiers.event;

import com.knoxhack.galacticfrontiers.GalacticFrontiersMod;
import com.knoxhack.galacticfrontiers.registry.ModEntities;
import com.knoxhack.galacticfrontiers.entity.MeteorEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = GalacticFrontiersMod.MODID)
public class EventHandlers {

    private static final Random random = new Random();
    private static int meteorTimer = 0;

    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.level.isClientSide()) {
            return;
        }

        meteorTimer++;
        if (meteorTimer >= 6000) { // Aproximadamente cada 5 minutos de juego
            spawnMeteor(event.level);
            meteorTimer = 0;
        }
    }

    private static void spawnMeteor(Level level) {
        if (level.dimension().location().getPath().equals("space_station")) {
            int x = random.nextInt(2000) - 1000;
            int z = random.nextInt(2000) - 1000;
            int y = 100 + random.nextInt(50);

            MeteorEntity meteor = new MeteorEntity(ModEntities.METEOR.get(), level);
            meteor.setPos(x, y, z);
            level.addFreshEntity(meteor);
        }
    }

    @SubscribeEvent
    public static void onLevelLoad(LevelEvent.Load event) {
        if (event.getLevel().isClientSide()) return;

        Level level = (Level) event.getLevel();

        if (level.dimension().location().getPath().equals("space_station")) {
            generateRuins(level);
        }
    }

    private static void generateRuins(Level level) {
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(2000) - 1000;
            int z = random.nextInt(2000) - 1000;
            BlockPos pos = level.getHeightmapPos(Heightmap.Types.WORLD_SURFACE, new BlockPos(x, 0, z));

            level.setBlock(pos, Blocks.IRON_BLOCK.defaultBlockState(), 3);
            level.setBlock(pos.above(), Blocks.CHEST.defaultBlockState(), 3);
        }
    }
}
