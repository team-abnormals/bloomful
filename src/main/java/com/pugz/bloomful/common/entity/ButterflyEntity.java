package com.pugz.bloomful.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.Goal;
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
import java.util.EnumSet;
import java.util.Locale;

public class ButterflyEntity extends AbstractGroupButterflyEntity {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(ButterflyEntity.class, DataSerializers.VARINT);
    private static final ResourceLocation[] PATTERN_TEXTURES_A = new ResourceLocation[]{new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_1.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_2.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_3.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_4.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_5.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_6.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_7.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_8.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_9.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_10.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_11.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_12.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_13.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_14.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_a_pattern_15.png")};
    private static final ResourceLocation[] PATTERN_TEXTURES_B = new ResourceLocation[]{new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_1.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_2.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_3.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_4.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_5.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_6.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_7.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_8.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_9.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_10.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_11.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_12.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_13.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_14.png"), new ResourceLocation("bloomful", "textures/entity/butterfly/butterfly_b_pattern_15.png")};
    public static final int[] SPECIAL_VARIANTS = new int[]{pack(ButterflyEntity.Type.TIGER, DyeColor.ORANGE, DyeColor.GRAY), pack(ButterflyEntity.Type.MONARCH, DyeColor.GRAY, DyeColor.GRAY), pack(ButterflyEntity.Type.MONARCH, DyeColor.GRAY, DyeColor.BLUE), pack(ButterflyEntity.Type.CABBAGE, DyeColor.WHITE, DyeColor.GRAY), pack(ButterflyEntity.Type.SKIPPER, DyeColor.BLUE, DyeColor.GRAY), pack(ButterflyEntity.Type.COPPER, DyeColor.ORANGE, DyeColor.WHITE), pack(ButterflyEntity.Type.SPANGLED, DyeColor.PINK, DyeColor.LIGHT_BLUE), pack(ButterflyEntity.Type.SWALLOWTAIL, DyeColor.PURPLE, DyeColor.YELLOW), pack(ButterflyEntity.Type.CABBAGE, DyeColor.WHITE, DyeColor.RED), pack(ButterflyEntity.Type.SPANGLED, DyeColor.WHITE, DyeColor.YELLOW), pack(ButterflyEntity.Type.SULPHUR, DyeColor.WHITE, DyeColor.GRAY), pack(ButterflyEntity.Type.CABBAGE, DyeColor.WHITE, DyeColor.ORANGE), pack(ButterflyEntity.Type.SPOTTED, DyeColor.CYAN, DyeColor.PINK), pack(ButterflyEntity.Type.DOGFACE, DyeColor.LIME, DyeColor.LIGHT_BLUE), pack(ButterflyEntity.Type.LONGWING, DyeColor.RED, DyeColor.WHITE), pack(ButterflyEntity.Type.PEARLY_EYE, DyeColor.GRAY, DyeColor.RED), pack(ButterflyEntity.Type.SWALLOWTAIL, DyeColor.RED, DyeColor.WHITE), pack(ButterflyEntity.Type.MONARCH, DyeColor.WHITE, DyeColor.YELLOW), pack(ButterflyEntity.Type.COPPER, DyeColor.RED, DyeColor.WHITE), pack(ButterflyEntity.Type.SKIPPER, DyeColor.GRAY, DyeColor.WHITE), pack(ButterflyEntity.Type.SPOTTED, DyeColor.CYAN, DyeColor.YELLOW), pack(ButterflyEntity.Type.MONARCH, DyeColor.YELLOW, DyeColor.YELLOW), pack(Type.NYPMH, DyeColor.WHITE, DyeColor.BLUE), pack(Type.ADMIRAL, DyeColor.LIGHT_GRAY, DyeColor.RED), pack(Type.BUCKEYE, DyeColor.GREEN, DyeColor.BROWN)};
    private BlockPos spawnPosition;
    private Vec3d orbitOffset;
    private BlockPos orbitPosition;
    private boolean field_204228_bA = true;

    public ButterflyEntity(EntityType<? extends ButterflyEntity> type, World world) {
        super(type, world);
        orbitOffset = Vec3d.ZERO;
        orbitPosition = BlockPos.ZERO;
    }

    protected void registerGoals() {
        goalSelector.addGoal(3, new ButterflyEntity.OrbitPointGoal());
    }

    private static int pack(ButterflyEntity.Type type, DyeColor body, DyeColor pattern) {
        return type.getPatternA() & 255 | (type.getPatternB() & 255) << 8 | (body.getId() & 255) << 16 | (pattern.getId() & 255) << 24;
    }

    @OnlyIn(Dist.CLIENT)
    public static String func_212324_b(int p_212324_0_) {
        return "entity.bloomful.butterfly.predefined." + p_212324_0_;
    }

    @OnlyIn(Dist.CLIENT)
    public static DyeColor func_212326_d(int p_212326_0_) {
        return DyeColor.byId(getPatternAColor(p_212326_0_));
    }

    @OnlyIn(Dist.CLIENT)
    public static DyeColor func_212323_p(int p_212323_0_) {
        return DyeColor.byId(getPatternBColor(p_212323_0_));
    }

    @OnlyIn(Dist.CLIENT)
    public static String func_212327_q(int p_212327_0_) {
        int lvt_1_1_ = func_212325_s(p_212327_0_);
        int lvt_2_1_ = getPattern(p_212327_0_);
        return "entity.bloomful.butterfly.type." + ButterflyEntity.Type.func_212548_a(lvt_1_1_, lvt_2_1_);
    }

    protected void registerData() {
        super.registerData();
        dataManager.register(VARIANT, 0);
    }

    public void writeAdditional(CompoundNBT compoundNBT) {
        super.writeAdditional(compoundNBT);
        compoundNBT.putInt("Variant", getVariant());
    }

    public void readAdditional(CompoundNBT compoundNBT) {
        super.readAdditional(compoundNBT);
        setVariant(compoundNBT.getInt("Variant"));
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
    private static int getPatternAColor(int variant) {
        return (variant & 16711680) >> 16;
    }

    @OnlyIn(Dist.CLIENT)
    private static int getPatternBColor(int variant) {
        return (variant & -16777216) >> 24;
    }

    @OnlyIn(Dist.CLIENT)
    public float[] func_204222_dD() {
        return DyeColor.byId(getPatternBColor(getVariant())).getColorComponentValues();
    }

    @OnlyIn(Dist.CLIENT)
    public static int func_212325_s(int p_212325_0_) {
        return Math.min(p_212325_0_ & 255, 1);
    }

    @OnlyIn(Dist.CLIENT)
    private static int getPattern(int p_204213_0_) {
        return Math.min((p_204213_0_ & '\uff00') >> 8, 5);
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getPatternTextureA() {
        return PATTERN_TEXTURES_A[getPattern(getVariant())];
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getPatternTextureB() {
        return PATTERN_TEXTURES_B[getPattern(getVariant())];
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
        getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
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
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        if (dataTag != null) {
            return spawnDataIn;
        } else {
            int i;
            int k;
            int l;
            if (spawnDataIn instanceof ButterflyEntity.ButterflyData) {
                ButterflyEntity.ButterflyData butterflyentity$butterflydata = (ButterflyEntity.ButterflyData)spawnDataIn;
                i = butterflyentity$butterflydata.size;
                k = butterflyentity$butterflydata.patternAColor;
                l = butterflyentity$butterflydata.patternBColor;
            } else if ((double)this.rand.nextFloat() < 0.9D) {
                int i1 = SPECIAL_VARIANTS[rand.nextInt(SPECIAL_VARIANTS.length)];
                i = i1 & 255;
                k = (i1 & 16711680) >> 16;
                l = (i1 & -16777216) >> 24;
                spawnDataIn = new ButterflyEntity.ButterflyData(this, i, k, l);
            } else {
                field_204228_bA = false;
                i = rand.nextInt(2);
                k = rand.nextInt(15);
                l = rand.nextInt(15);
            }
            setVariant(i | k << 16 | l << 24);
            return spawnDataIn;
        }
    }

    abstract class MoveGoal extends Goal {
        public MoveGoal() {
            setMutexFlags(EnumSet.of(Flag.MOVE));
        }

        protected boolean func_203146_f() {
            return ButterflyEntity.this.orbitOffset.squareDistanceTo(ButterflyEntity.this.posX, ButterflyEntity.this.posY, ButterflyEntity.this.posZ) < 4.0D;
        }
    }

    class OrbitPointGoal extends ButterflyEntity.MoveGoal {
        private float field_203150_c;
        private float field_203151_d;
        private float field_203152_e;
        private float field_203153_f;

        private OrbitPointGoal() {
            super();
        }

        public boolean shouldExecute() {
            return true;
        }

        public void startExecuting() {
            field_203151_d = 5.0F + ButterflyEntity.this.rand.nextFloat() * 10.0F;
            field_203152_e = -4.0F + ButterflyEntity.this.rand.nextFloat() * 9.0F;
            field_203153_f = ButterflyEntity.this.rand.nextBoolean() ? 1.0F : -1.0F;
            func_203148_i();
        }

        public void tick() {
            if (ButterflyEntity.this.rand.nextInt(350) == 0) {
                field_203152_e = -4.0F + ButterflyEntity.this.rand.nextFloat() * 9.0F;
            }
            if (ButterflyEntity.this.rand.nextInt(250) == 0) {
                ++field_203151_d;
                if (field_203151_d > 15.0F) {
                    field_203151_d = 5.0F;
                    field_203153_f = -field_203153_f;
                }
            }
            if (ButterflyEntity.this.rand.nextInt(450) == 0) {
                field_203150_c = ButterflyEntity.this.rand.nextFloat() * 2.0F * 3.1415927F;
                func_203148_i();
            }
            if (func_203146_f()) {
                func_203148_i();
            }
            if (ButterflyEntity.this.orbitOffset.y < ButterflyEntity.this.posY && !ButterflyEntity.this.world.isAirBlock((new BlockPos(ButterflyEntity.this)).down(1))) {
                field_203152_e = Math.max(1.0F, field_203152_e);
                func_203148_i();
            }
            if (ButterflyEntity.this.orbitOffset.y > ButterflyEntity.this.posY && !ButterflyEntity.this.world.isAirBlock((new BlockPos(ButterflyEntity.this)).up(1))) {
                field_203152_e = Math.min(-1.0F, field_203152_e);
                func_203148_i();
            }
        }
        private void func_203148_i() {
            if (BlockPos.ZERO.equals(ButterflyEntity.this.orbitPosition)) {
                ButterflyEntity.this.orbitPosition = new BlockPos(ButterflyEntity.this);
            }
            field_203150_c += field_203153_f * 15.0F * 0.017453292F;
            ButterflyEntity.this.orbitOffset = (new Vec3d(ButterflyEntity.this.orbitPosition)).add((double)(field_203151_d * MathHelper.cos(field_203150_c)), (double)(-4.0F + field_203152_e), (double)(field_203151_d * MathHelper.sin(field_203150_c)));
        }
    }

    static class ButterflyData extends AbstractGroupButterflyEntity.GroupData {
        private final int size;
        private final int patternAColor;
        private final int patternBColor;

        private ButterflyData(AbstractGroupButterflyEntity entity, int sizeIn, int patternAColorIn, int patternBColorIn) {
            super(entity);
            size = sizeIn;
            patternAColor = patternAColorIn;
            patternBColor = patternBColorIn;
        }
    }

    enum Type {
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
        private static final ButterflyEntity.Type[] field_212554_o = values();

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

        @OnlyIn(Dist.CLIENT)
        public static String func_212548_a(int p_212548_0_, int p_212548_1_) {
            return field_212554_o[p_212548_1_ + 6 * p_212548_0_].func_212549_c();
        }

        @OnlyIn(Dist.CLIENT)
        public String func_212549_c() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }
}