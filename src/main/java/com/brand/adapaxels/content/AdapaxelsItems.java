package com.brand.adapaxels.content;

import com.brand.adapaxels.AdaPaxels;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class AdapaxelsItems {

    public static final Item STACKED_NETHERITE = register("stacked_netherite", new Item(new Item.Properties().stacksTo(64).fireResistant()));


    public static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, AdaPaxels.id(id), item);
    }

    public static void init() {

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.NETHERITE_INGOT, STACKED_NETHERITE);
        });
    }
}

