package com.knoxhack.galacticfrontiers.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class MiniDroneEntity extends Mob {

    public MiniDroneEntity(EntityType<? extends MiniDroneEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(net.minecraft.nbt.CompoundTag tag) {}

    @Override
    protected void addAdditionalSaveData(net.minecraft.nbt.CompoundTag tag) {}

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 6.0F));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.setDeltaMovement(this.getDeltaMovement().add(
                (this.random.nextDouble() - 0.5) * 0.02,
                (this.random.nextDouble() - 0.5) * 0.02,
                (this.random.nextDouble() - 0.5) * 0.02
            ));
            this.move(net.minecraft.world.entity.MoverType.SELF, this.getDeltaMovement());
        }
    }
}
