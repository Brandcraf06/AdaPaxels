package com.brand.adapaxels.utils;

import com.brand.adapaxels.AdaPaxels;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class APBlockTags {
    public static final TagKey<Block> PAXEL_MINEABLE = register("mineable/paxel");

    private APBlockTags() {
        return;
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, AdaPaxels.id(id));
    }
}

