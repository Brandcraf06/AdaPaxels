package com.brand.adapaxels.content;

import com.brand.adapaxels.AdaPaxels;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class AdapaxelsItems {

    public static final Item STACKED_NETHERITE = register("stacked_netherite", new Item(new Item.Settings().maxCount(64)));


    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, AdaPaxels.id(id), item);
    }

}
