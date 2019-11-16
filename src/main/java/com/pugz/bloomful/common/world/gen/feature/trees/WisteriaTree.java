package com.pugz.bloomful.common.world.gen.feature.trees;

import com.pugz.bloomful.common.world.gen.feature.BigWisteriaTreeFeature;
import com.pugz.bloomful.common.world.gen.feature.WisteriaTreeFeature;
import com.pugz.bloomful.core.util.WisteriaColor;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class WisteriaTree extends Tree {
    private WisteriaColor color;

    public WisteriaTree(WisteriaColor colorIn) {
        color = colorIn;
    }

    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return (random.nextInt(10) == 0 ? new BigWisteriaTreeFeature(NoFeatureConfig::deserialize, true, color) : new WisteriaTreeFeature(NoFeatureConfig::deserialize, true, color));
    }
}