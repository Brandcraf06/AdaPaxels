package com.brand.adapaxels.utils;

import com.brand.adapaxels.AdaPaxels;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class APItemTags {
    public static final Tag.Identified<Item> PAXELS = create("paxels");

    private APItemTags() {
        return;
    }

    private static Tag.Identified<Item> create(String path) {
        return TagFactory.ITEM.create(new Identifier(AdaPaxels.MOD_ID, path));

    }
}

