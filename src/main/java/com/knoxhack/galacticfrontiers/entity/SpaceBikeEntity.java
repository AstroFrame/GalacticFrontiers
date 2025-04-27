package com.knoxhack.galacticfrontiers.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;

public class SpaceBikeEntity extends Entity {

    public SpaceBikeEntity(EntityType<? extends SpaceBikeEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(net.minecraft.nbt.CompoundTag tag) {}

    @Override
    protected void addAdditionalSaveData(net.minecraft.nbt.CompoundTag tag) {}

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            Vec3 forward = this.getLookAngle().scale(0.05D);
            this.move(net.minecraft.world.entity.MoverType.SELF, forward);
        }
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (!this.level().isClientSide()) {
            player.startRiding(this);
        }
        return InteractionResult.sidedSuccess(this.level().isClientSide());
    }
}
