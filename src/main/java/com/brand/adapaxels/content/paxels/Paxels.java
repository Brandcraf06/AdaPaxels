package com.brand.adapaxels.content.paxels;


import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.content.AdapaxelsItemGroup;
import com.brand.adapaxels.content.paxels.base.PaxelItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Paxels {

    public static final List<Item> items = new ArrayList<>();
    public static Item WOOD = register(PaxelsMaterials.WOOD, 1, -2.8f, "wooden");
    public static Item STONE = register(PaxelsMaterials.STONE, 1, -2.8f, "stone");
    public static Item COPPER = register(PaxelsMaterials.COPPER, 1, -2.8f, "copper");
    public static Item IRON = register(PaxelsMaterials.IRON, 1, -2.8f, "iron");
    public static Item GOLDEN = register(PaxelsMaterials.GOLD, 1, -2.8f, "golden");
    public static Item DIAMOND = register(PaxelsMaterials.DIAMOND, 1, -2.8f, "diamond");
    public static Item NETHERITE = register(PaxelsMaterials.NETHERITE, 1, -2.8f, "netherite", true);
    public static Item VIBRANIUM;
    public static Item ADAMANTIUM;
    public static Item NETHER_BRICK;
    public static Item BRONZE;
    public static Item RUBY;
    public static Item SAPPHIRE;
    public static Item PERIDOT;
    public static Item ENDERITE;
    public static Item DRAGON;

    public static void init() {

        // Adabranium https://www.curseforge.com/minecraft/mc-mods/adabranium
        if (isModLoaded("adabranium")) {
            VIBRANIUM = register(PaxelsMaterials.VIBRANIUM, 1, -2.8f, "vibranium");
            ADAMANTIUM = register(PaxelsMaterials.ADAMANTIUM, 1, -2.8f, "adamantium");
            NETHER_BRICK = register(PaxelsMaterials.NETHER_BRICK, 1, -2.8f, "nether", true);
        }

        // Tech Reborn https://www.curseforge.com/minecraft/mc-mods/techreborn
        if (isModLoaded("techreborn")) {
            BRONZE = register(PaxelsMaterials.BRONZE, -2, -2.8f, "bronze");
            RUBY = register(PaxelsMaterials.RUBY, -2, -2.8f, "ruby");
            SAPPHIRE = register(PaxelsMaterials.SAPPHIRE, -2, -2.8f, "sapphire");
            PERIDOT = register(PaxelsMaterials.PERIDOT, -2, -2.8f, "peridot");
        }

        // Enderite Mod https://www.curseforge.com/minecraft/mc-mods/enderite-mod-for-fabric
        if (isModLoaded("enderitemod")) {
            ENDERITE = register(PaxelsMaterials.ENDERITE, 1, -2.8f, "enderite", true);
        }

        // DragonLoot https://www.curseforge.com/minecraft/mc-mods/dragonloot
        if (isModLoaded("dragonloot")) {
            DRAGON = register(PaxelsMaterials.DRAGON, 1, -2.8f, "dragon", true);
        }

        CreativeModeTabEvents.modifyOutputEvent(AdapaxelsItemGroup.ADAPAXELS_GROUP).register(content -> {
            for (Item item : items) {
                content.accept(item);
            }
        });
    }

    public static boolean isModLoaded(String id) {
        return FabricLoader.getInstance().isDevelopmentEnvironment() || FabricLoader.getInstance().isModLoaded(id);
    }

    public static Item register(Function<Item.Properties, Item> factory, String materialname, boolean isFireproof) {
        Item.Properties settings = new Item.Properties();
        if (isFireproof)
            settings = settings.fireResistant();
        Item item = register(ResourceKey.create(Registries.ITEM, AdaPaxels.id(materialname + "_paxel")), factory, settings);
        items.add(item);
        return item;
    }

    public static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static Item register(ToolMaterial material, int attackDamage, float attackSpeed, String materialname, boolean isFireproof) {
        return register((settings) -> new PaxelItem(material, attackDamage, attackSpeed, settings), materialname, isFireproof);
    }

    public static Item register(ToolMaterial material, int attackDamage, float attackSpeed, String materialname) {
        return register((settings) -> new PaxelItem(material, attackDamage, attackSpeed, settings), materialname, false);
    }
}
