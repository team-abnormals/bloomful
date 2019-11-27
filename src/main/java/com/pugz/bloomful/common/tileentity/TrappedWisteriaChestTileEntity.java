package com.pugz.bloomful.common.tileentity;

import com.pugz.bloomful.core.registry.BlockRegistry;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;

public class TrappedWisteriaChestTileEntity extends WisteriaChestTileEntity {
    public static TileEntityType<TrappedWisteriaChestTileEntity> TRAPPED_WISTERIA_CHEST = TileEntityType.Builder.create(TrappedWisteriaChestTileEntity::new, BlockRegistry.TRAPPED_WISTERIA_CHEST).build(null);

    public TrappedWisteriaChestTileEntity() {
        super(TRAPPED_WISTERIA_CHEST);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2);
    }
}