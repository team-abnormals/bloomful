package com.pugz.bloomful.common.block;

import com.pugz.bloomful.common.world.gen.feature.trees.WisteriaTree;
import net.minecraft.block.SaplingBlock;

public class BloomfulSaplingBlock extends SaplingBlock {

    public BloomfulSaplingBlock(Properties properties, WisteriaTree tree) {
        super(tree, properties);
    }
}