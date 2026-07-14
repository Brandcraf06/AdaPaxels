package com.brand.adapaxels.tags;

import com.brand.adapaxels.AdaPaxels;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class APBlockTags {
    public static final TagKey<Block> MINEABLE_WITH_PAXEL = register("mineable/paxel");

    private APBlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.create(Registries.BLOCK, AdaPaxels.id(id));
    }
}

