package com.brand.adapaxels.utils;

import com.brand.adapaxels.AdaPaxels;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class APItemTags {
    public static final TagKey<Item> PAXELS = register("paxels");

    private APItemTags() {
        return;
    }

    private static TagKey<Item> register(String id) {
        return TagKey.of(RegistryKeys.ITEM, AdaPaxels.id(id));
    }
}

