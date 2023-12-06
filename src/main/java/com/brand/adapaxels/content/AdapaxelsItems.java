package com.brand.adapaxels.content;

import com.brand.adapaxels.AdaPaxels;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class AdapaxelsItems {

    public static final Item STACKED_NETHERITE = register("stacked_netherite", new Item(new Item.Settings().maxCount(64).fireproof()));


    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, AdaPaxels.id(id), item);
    }

    public static void init() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.NETHERITE_INGOT, STACKED_NETHERITE);
        });
    }
}

