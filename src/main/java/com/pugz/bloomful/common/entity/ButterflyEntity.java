package com.pugz.bloomful.common.entity;

import com.pugz.bloomful.common.entity.ai.LandOnPlantGoal;
import com.pugz.bloomful.core.util.ButterflyType;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.item.DyeColor;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class ButterflyEntity extends CreatureEntity {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(ButterflyEntity.class, DataSerializers.VARINT);
    private BlockPos spawnPosition;
    private boolean field_204228_bA = true;

    public ButterflyEntity(EntityType<? extends ButterflyEntity> type, World world) {
        super(type, world);
    }

    protected void registerGoals() {
        goalSelector.addGoal(8, new LandOnPlantGoal(this, 0.6D));
        goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 0.6D));
    }

    public static boolean spawnCondition(EntityType<ButterflyEntity> entity, IWorld world, SpawnReason reason, BlockPos pos, Random random) {
        int light = world.getLight(pos);
        if (world.getDimension().getType() == DimensionType.OVERWORLD && world.canBlockSeeSky(pos) && light >= 7) {
            return (world.getBlockState(pos).getBlock() instanceof BushBlock || world.getBlockState(pos.down()).getBlock() instanceof BushBlock || world.getBlockState(pos.north()).getBlock() instanceof BushBlock || world.getBlockState(pos.south()).getBlock() instanceof BushBlock || world.getBlockState(pos.east()).getBlock() instanceof BushBlock || world.getBlockState(pos.west()).getBlock() instanceof BushBlock) && world.getLightSubtracted(pos, 0) > 8;
        }
        else return false;
    }

    protected void registerData() {
        super.registerData();
        dataManager.register(VARIANT, 0);
    }

    @OnlyIn(Dist.CLIENT)
    public static String getBottleName() {
        return "entity.bloomful.butterfly." + Data.toRegistryName(Data.name);
    }

    public void writeAdditional(CompoundNBT p_213281_1_) {
        super.writeAdditional(p_213281_1_);
        p_213281_1_.putInt("Variant", getVariant());
    }

    public void readAdditional(CompoundNBT p_70037_1_) {
        super.readAdditional(p_70037_1_);
        setVariant(p_70037_1_.getInt("Variant"));
    }

    public void setVariant(int variant) {
        dataManager.set(VARIANT, variant);
    }

    public boolean func_204209_c(int p_204209_1_) {
        return !field_204228_bA;
    }

    public int getVariant() {
        return dataManager.get(VARIANT);
    }

    @OnlyIn(Dist.CLIENT)
    public String getPatternColorA() {
        return "#4287f5";
        //return Data.colorA;
    }

    @OnlyIn(Dist.CLIENT)
    public String getPatternColorB() {
        return "#4287f5";
        //return Data.colorB;
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getPatternTextureA() {
        return Data.patternA;
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getPatternTextureB() {
        return Data.patternB;
    }

    public boolean canBePushed() {
        return false;
    }

    protected void collideWithEntity(Entity entity) {
    }

    protected void collideWithNearbyEntities() {
    }

    protected void registerAttributes() {
        super.registerAttributes();
        getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0D);
    }

    public void tick() {
        super.tick();
        setMotion(getMotion().mul(1.0D, 0.6D, 1.0D));
    }

    protected void updateAITasks() {
        super.updateAITasks();
        if (spawnPosition != null && (!world.isAirBlock(spawnPosition) || spawnPosition.getY() < 1)) {
            spawnPosition = null;
        }
        if (spawnPosition == null || rand.nextInt(30) == 0 || spawnPosition.withinDistance(getPositionVec(), 2.0D)) {
            spawnPosition = new BlockPos(posX + (double)rand.nextInt(7) - (double)rand.nextInt(7), posY + (double)rand.nextInt(6) - 2.0D, posZ + (double)rand.nextInt(7) - (double)rand.nextInt(7));
        }
        double x = (double)spawnPosition.getX() + 0.5D - posX;
        double y = (double)spawnPosition.getY() + 0.1D - posY;
        double z = (double)spawnPosition.getZ() + 0.5D - posZ;
        Vec3d lvt_9_1_ = getMotion();
        Vec3d lvt_10_1_ = lvt_9_1_.add((Math.signum(x) * 0.5D - lvt_9_1_.x) * 0.10000000149011612D, (Math.signum(y) * 0.699999988079071D - lvt_9_1_.y) * 0.10000000149011612D, (Math.signum(z) * 0.5D - lvt_9_1_.z) * 0.10000000149011612D);
        setMotion(lvt_10_1_);
        float lvt_11_1_ = (float)(MathHelper.atan2(lvt_10_1_.z, lvt_10_1_.x) * 57.2957763671875D) - 90.0F;
        float lvt_12_1_ = MathHelper.wrapDegrees(lvt_11_1_ - rotationYaw);
        moveForward = 0.5F;
        rotationYaw += lvt_12_1_;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public void fall(float p_180430_1_, float p_180430_2_) {
    }

    protected void updateFallState(double p_184231_1_, boolean p_184231_3_, BlockState state, BlockPos pos) {
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    public boolean attackEntityFrom(DamageSource source, float damage) {
        if (isInvulnerableTo(source)) {
            return false;
        } else {
            return super.attackEntityFrom(source, damage);
        }
    }

    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return size.height / 2.0F;
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        spawnData = super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
        int i;
        int j;
        int k;
        int l;
        if ((double)rand.nextFloat() < 0.9D) {
            ButterflyType type = ButterflyType.types[rand.nextInt(ButterflyType.values().length)];
            ButterflyEntity.Data variant = type.getDataValues().get(rand.nextInt(type.getDataValues().size()));
            int i1 = rand.nextInt(type.getDataValues().size());
            i = i1 & 255;
            j = (i1 & '\uff00') >> 8;
            k = (i1 & 16711680) >> 16;
            l = (i1 & -16777216) >> 24;
        } else {
            field_204228_bA = false;
            i = rand.nextInt(2);
            j = rand.nextInt(6);
            k = rand.nextInt(15);
            l = rand.nextInt(15);
        }
        setVariant(i | j << 8 | k << 16 | l << 24);
        return spawnData;
    }

    public static class Data {
        //display name
        private static String name;
        //primary color
        private static String colorA;
        //secondary color
        private static String colorB;
        //primary pattern texture
        //bloomful:textures/entity/butterfly/brushfoot_a
        private static ResourceLocation patternA = new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_1.png"); //new ResourceLocation("bloomful", "textures/entity/butterfly/" + toRegistryName(name) + "_a");
        //secondary pattern texture
        //bloomful:textures/entity/butterfly/brushfoot_b
        private static ResourceLocation patternB = new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_1.png"); //new ResourceLocation("bloomful", "textures/entity/butterfly/" + toRegistryName(name) + "_b");

        public Data(String nameIn, String a, String b) {
            name = nameIn;
            colorA = a;
            colorB = b;
        }

        private static String toRegistryName(String string) {
            string.toLowerCase().replace(" ", "_").replace("-", "_");
            return string;
        }
    }
}