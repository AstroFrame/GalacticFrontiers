package com.knoxhack.galacticfrontiers.registry;

import com.knoxhack.galacticfrontiers.GalacticFrontiersMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GalacticFrontiersMod.MODID);

    public static final RegistryObject<Block> LAUNCH_PAD_BLOCK = BLOCKS.register("launch_pad_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));

    public static void register(net.minecraftforge.eventbus.api.IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
