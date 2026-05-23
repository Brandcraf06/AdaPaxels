package com.brand.adapaxels.content;

import com.brand.adapaxels.AdaPaxels;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class AdapaxelsItems {

    public static final Item STACKED_NETHERITE = register("stacked_netherite", Item::new, (new Item.Properties().stacksTo(64).fireResistant()));

    public static Item register(String id, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(ResourceKey.create(Registries.ITEM, AdaPaxels.id(id))));
        return Registry.register(BuiltInRegistries.ITEM, AdaPaxels.id(id), item);
    }

    public static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties settings) {
        return Registry.register(BuiltInRegistries.ITEM, key, factory.apply(settings.setId(key)));
    }

    public static Item register(String id, Item.Properties settings) {
        return register(ResourceKey.create(Registries.ITEM, AdaPaxels.id(id)), Item::new, settings);
    }

    public static void init() {

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(content -> {
            content.insertAfter(Items.NETHERITE_INGOT, STACKED_NETHERITE);
        });
    }
}

