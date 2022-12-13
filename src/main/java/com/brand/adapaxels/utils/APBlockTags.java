package com.brand.adapaxels.utils;

import com.brand.adapaxels.AdaPaxels;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class APBlockTags {
    public static final TagKey<Block> PAXEL_MINEABLE = register("mineable/paxel");

    private APBlockTags() {
        return;
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(RegistryKeys.BLOCK, AdaPaxels.id(id));
    }
}

