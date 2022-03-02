package com.brand.adapaxels.utils;

import com.brand.adapaxels.AdaPaxels;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class APBlockTags {
    public static final Tag.Identified<Block> PAXEL_MINEABLE = create("mineable/paxel");

    private APBlockTags() {
        return;
    }

    private static Tag.Identified<Block> create(String path) {
        return TagFactory.BLOCK.create(new Identifier(AdaPaxels.MOD_ID, path));

    }
}

