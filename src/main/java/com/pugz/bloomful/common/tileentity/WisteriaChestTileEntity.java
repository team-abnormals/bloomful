package com.pugz.bloomful.common.tileentity;

import com.pugz.bloomful.core.registry.BlockRegistry;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;

public class WisteriaChestTileEntity extends ChestTileEntity {
    public static TileEntityType<WisteriaChestTileEntity> WISTERIA_CHEST = TileEntityType.Builder.create(WisteriaChestTileEntity::new, BlockRegistry.WISTERIA_CHEST).build(null);

    public WisteriaChestTileEntity(TileEntityType<?> type) {
        super(type);
    }

    public WisteriaChestTileEntity() {
        super(WISTERIA_CHEST);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2);
    }
}