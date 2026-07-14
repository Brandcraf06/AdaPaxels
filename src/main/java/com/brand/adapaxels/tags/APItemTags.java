package com.brand.adapaxels.tags;

import com.brand.adapaxels.AdaPaxels;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class APItemTags {
    public static final TagKey<Item> PAXELS = register("paxels");

    private APItemTags() {
    }

    private static TagKey<Item> register(String id) {
        return TagKey.create(Registries.ITEM, AdaPaxels.id(id));
    }
}

