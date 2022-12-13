package com.brand.adapaxels.utils;

import com.brand.adapaxels.AdaPaxels;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public class APItemTags {
    public static final TagKey<Item> PAXELS = register("paxels");

    private APItemTags() {
        return;
    }

    private static TagKey<Item> register(String id) {
        return TagKey.of(Registry.ITEM_KEY, AdaPaxels.id(id));
    }
}

