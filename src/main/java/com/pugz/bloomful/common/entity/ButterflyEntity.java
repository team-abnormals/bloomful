package com.pugz.bloomful.common.entity;

import com.pugz.bloomful.common.entity.ai.LandOnPlantGoal;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class ButterflyEntity extends CreatureEntity {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(TropicalFishEntity.class, DataSerializers.VARINT);
    private static final ResourceLocation[] PATTERN_TEXTURES_A = new ResourceLocation[]{new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_1.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_2.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_3.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_4.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_5.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_6.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_7.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_8.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_9.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_10.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_11.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_12.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_13.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_14.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_15.png")};
    private static final ResourceLocation[] PATTERN_TEXTURES_B = new ResourceLocation[]{new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_1.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_2.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_3.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_4.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_5.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_6.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_7.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_8.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_9.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_10.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_11.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_12.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_13.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_14.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_15.png")};
    public static final int[] SPECIAL_VARIANTS = new int[]{pack(ButterflyEntity.Type.TIGER, DyeColor.ORANGE, DyeColor.GRAY), pack(ButterflyEntity.Type.MONARCH, DyeColor.GRAY, DyeColor.GRAY), pack(ButterflyEntity.Type.MONARCH, DyeColor.GRAY, DyeColor.BLUE), pack(ButterflyEntity.Type.CABBAGE, DyeColor.WHITE, DyeColor.GRAY), pack(ButterflyEntity.Type.SKIPPER, DyeColor.BLUE, DyeColor.GRAY), pack(ButterflyEntity.Type.COPPER, DyeColor.ORANGE, DyeColor.WHITE), pack(ButterflyEntity.Type.SPANGLED, DyeColor.PINK, DyeColor.LIGHT_BLUE), pack(ButterflyEntity.Type.SWALLOWTAIL, DyeColor.PURPLE, DyeColor.YELLOW), pack(ButterflyEntity.Type.CABBAGE, DyeColor.WHITE, DyeColor.RED), pack(ButterflyEntity.Type.SPANGLED, DyeColor.WHITE, DyeColor.YELLOW), pack(ButterflyEntity.Type.SULPHUR, DyeColor.WHITE, DyeColor.GRAY), pack(ButterflyEntity.Type.CABBAGE, DyeColor.WHITE, DyeColor.ORANGE), pack(ButterflyEntity.Type.SPOTTED, DyeColor.CYAN, DyeColor.PINK), pack(ButterflyEntity.Type.DOGFACE, DyeColor.LIME, DyeColor.LIGHT_BLUE), pack(ButterflyEntity.Type.LONGWING, DyeColor.RED, DyeColor.WHITE), pack(ButterflyEntity.Type.PEARLY_EYE, DyeColor.GRAY, DyeColor.RED), pack(ButterflyEntity.Type.SWALLOWTAIL, DyeColor.RED, DyeColor.WHITE), pack(ButterflyEntity.Type.MONARCH, DyeColor.WHITE, DyeColor.YELLOW), pack(ButterflyEntity.Type.COPPER, DyeColor.RED, DyeColor.WHITE), pack(ButterflyEntity.Type.SKIPPER, DyeColor.GRAY, DyeColor.WHITE), pack(ButterflyEntity.Type.SPOTTED, DyeColor.CYAN, DyeColor.YELLOW), pack(ButterflyEntity.Type.MONARCH, DyeColor.YELLOW, DyeColor.YELLOW), pack(Type.NYPMH, DyeColor.WHITE, DyeColor.BLUE), pack(Type.ADMIRAL, DyeColor.LIGHT_GRAY, DyeColor.RED), pack(Type.BUCKEYE, DyeColor.GREEN, DyeColor.BROWN)};
    private BlockPos spawnPosition;
    private boolean field_204228_bA = true;

    public ButterflyEntity(EntityType<? extends ButterflyEntity> type, World world) {
        super(type, world);
    }

    private static int pack(ButterflyEntity.Type type, DyeColor body, DyeColor pattern) {
        return type.getPatternA() & 255 | (type.getPatternB() & 255) << 8 | (body.getId() & 255) << 16 | (pattern.getId() & 255) << 24;
    }

    protected void registerGoals() {
        goalSelector.addGoal(8, new LandOnPlantGoal(this, 0.6D));
        goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 0.6D));
    }

    protected void registerData() {
        super.registerData();
        dataManager.register(VARIANT, 0);
    }

    public void writeAdditional(CompoundNBT p_213281_1_) {
        super.writeAdditional(p_213281_1_);
        p_213281_1_.putInt("Variant", getVariant());
    }

    public void readAdditional(CompoundNBT p_70037_1_) {
        super.readAdditional(p_70037_1_);
        setVariant(p_70037_1_.getInt("Variant"));
    }

    public void setVariant(int p_204215_1_) {
        dataManager.set(VARIANT, p_204215_1_);
    }

    public boolean func_204209_c(int p_204209_1_) {
        return !field_204228_bA;
    }

    public int getVariant() {
        return dataManager.get(VARIANT);
    }

    @OnlyIn(Dist.CLIENT)
    private static int getPatternColorA(int color) {
        return (color & -16777216) >> 24;
    }

    @OnlyIn(Dist.CLIENT)
    public float[] getPatternColorA() {
        return DyeColor.byId(getPatternColorA(getVariant())).getColorComponentValues();
    }

    @OnlyIn(Dist.CLIENT)
    private static int getPatternColorB(int color) {
        return (color & 16711680) >> 16;
    }

    @OnlyIn(Dist.CLIENT)
    public float[] getPatternColorB() {
        return DyeColor.byId(getPatternColorB(getVariant())).getColorComponentValues();
    }

    @OnlyIn(Dist.CLIENT)
    public static int getTexture(int variant) {
        return Math.min(variant & 255, 1);
    }

    @OnlyIn(Dist.CLIENT)
    private static int getPattern(int p_204213_0_) {
        return Math.min((p_204213_0_ & '\uff00') >> 8, 5);
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getPatternTexture() {
        return getTexture(getVariant()) == 0 ? PATTERN_TEXTURES_A[getPattern(getVariant())] : PATTERN_TEXTURES_B[getPattern(getVariant())];
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getPatternTextureA() {
        return PATTERN_TEXTURES_A[getTexture(getVariant())];
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getPatternTextureB() {
        return PATTERN_TEXTURES_B[getTexture(getVariant())];
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
        Vec3d lvt_9_1_ = this.getMotion();
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
            int i1 = SPECIAL_VARIANTS[rand.nextInt(SPECIAL_VARIANTS.length)];
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

    public enum Type {
        TIGER(1, 1),
        MONARCH(2, 1),
        CABBAGE(3, 1),
        SKIPPER(1, 2),
        COPPER(2, 2),
        SPANGLED(3, 2),
        SWALLOWTAIL(1, 3),
        SULPHUR(2, 3),
        SPOTTED(3, 3),
        DOGFACE(1, 4),
        LONGWING(2, 4),
        PEARLY_EYE(3, 4),
        NYPMH(1, 5),
        ADMIRAL(2, 5),
        BUCKEYE(3, 5);

        private final int patternA;
        private final int patternB;

        Type(int patternAIn, int patternBIn) {
            patternA = patternAIn;
            patternB = patternBIn;
        }

        public int getPatternA() {
            return patternA;
        }

        public int getPatternB() {
            return patternB;
        }
    }
}