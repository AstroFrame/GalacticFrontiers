package com.knoxhack.galacticfrontiers.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class MeteorEntity extends Projectile {

    public MeteorEntity(EntityType<? extends MeteorEntity> type, Level level) {
        super(type, level);
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 motion = this.getDeltaMovement();
        this.setDeltaMovement(motion.x, motion.y - 0.05, motion.z);
        this.move(net.minecraft.world.entity.MoverType.SELF, this.getDeltaMovement());

        if (this.onGround()) {
            if (!this.level().isClientSide) {
                this.level().explode(this, this.getX(), this.getY(), this.getZ(), 3.0F, Level.ExplosionInteraction.TNT);
                this.discard();
            }
        }
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(net.minecraft.nbt.CompoundTag tag) {}

    @Override
    protected void addAdditionalSaveData(net.minecraft.nbt.CompoundTag tag) {}
}
