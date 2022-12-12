package com.brand.adapaxels.paxels;


import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.paxels.base.PaxelItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class Paxels {

    public static Item WOOD = register(PaxelsMaterials.WOOD, 1, -2.8f, "wooden", (new Item.Settings()));
    public static Item STONE = register(PaxelsMaterials.STONE, 1, -2.8f, "stone", (new Item.Settings()));
    public static Item IRON = register(PaxelsMaterials.IRON, 1, -2.8f, "iron", (new Item.Settings()));
    public static Item GOLDEN = register(PaxelsMaterials.GOLD, 1, -2.8f, "golden", (new Item.Settings()));
    public static Item DIAMOND = register(PaxelsMaterials.DIAMOND, 1, -2.8f, "diamond", (new Item.Settings()));
    public static Item NETHERITE = register(PaxelsMaterials.NETHERITE, 1, -2.8f, "netherite", (new Item.Settings()));
    public static Item VIBRANIUM;
    public static Item ADAMANTIUM;
    public static Item NETHER_BRICK;
    public static Item TIN;
    public static Item STEEL;
    public static Item SILVER;
    public static Item LEAD;
    public static Item COPPER;
    public static Item BRONZE;
    public static Item CERTUS_QUARTZ;
    public static Item NETHER_QUARTZ;
    public static Item TR_BRONZE;
    public static Item RUBY;
    public static Item SAPPHIRE;
    public static Item PERIDOT;
    public static Item PENDORITE;
    public static Item ENDERITE;
    public static Item DRAGON;
    public static Item GILDED_NETHERITE;
    public static Item ROSE_GOLD;
    public static List<Item> items = null;



    public static void init() {

        // Adabranium
        if (FabricLoader.getInstance().isModLoaded("adabraniummod")) {
            VIBRANIUM = register(PaxelsMaterials.VIBRANIUM, 1, -2.8f, "vibranium", (new FabricItemSettings()));
            ADAMANTIUM = register(PaxelsMaterials.ADAMANTIUM, 1, -2.8f, "adamantium", (new Item.Settings()));
            NETHER_BRICK = register(PaxelsMaterials.NETHER_BRICK, 1, -2.8f, "nether", (new Item.Settings()).fireproof());
        }

        // Industrial Revolution
        if (FabricLoader.getInstance().isModLoaded("indrev")) {
            TIN = register(PaxelsMaterials.TIN,  1, -1.0f, "tin", (new Item.Settings()));
            STEEL = register(PaxelsMaterials.STEEL, 2, -1.8f, "steel", (new Item.Settings()));
            SILVER = register(PaxelsMaterials.SILVER,  1, -1.0f, "silver", (new Item.Settings()));
            LEAD = register(PaxelsMaterials.LEAD, 1, -1.0f, "lead", (new Item.Settings()));
            COPPER = register(PaxelsMaterials.COPPER, 1, -1.0f, "copper", (new Item.Settings()));
            BRONZE = register(PaxelsMaterials.BRONZE,  1, -1.0f, "bronze", (new Item.Settings()));
        }

        // Applied Energistics 2
        if (FabricLoader.getInstance().isModLoaded("appliedenergistics2")) {
            CERTUS_QUARTZ = register(PaxelsMaterials.CERTUS_QUARTZ, 1, -2.8f, "certus_quartz", (new Item.Settings()));
            NETHER_QUARTZ = register(PaxelsMaterials.NETHER_QUARTZ, 1, -2.8f, "nether_quartz", (new Item.Settings()));
        }

        // Tech Reborn
        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
            TR_BRONZE = register(PaxelsMaterials.TR_BRONZE, 1, -2.8f, "tech_reborn_bronze", (new Item.Settings()));
            RUBY = register(PaxelsMaterials.RUBY, 1, -2.8f, "ruby", (new Item.Settings()));
            SAPPHIRE = register(PaxelsMaterials.SAPPHIRE, 1, -2.8f, "sapphire", (new Item.Settings()));
            PERIDOT = register(PaxelsMaterials.PERIDOT, 1, -2.8f, "peridot", (new Item.Settings()));
        }

        // BYG
        if (FabricLoader.getInstance().isModLoaded("byg")) {
            PENDORITE = register(PaxelsMaterials.PENDORITE, 2, -2.8F, "pendorite", (new Item.Settings()));
        }

        // Enderite Mod
        if (FabricLoader.getInstance().isModLoaded("enderitemod")) {
            ENDERITE = register(PaxelsMaterials.ENDERITE, 4, -2.8f, "enderite", (new Item.Settings()).fireproof());
        }

        // DragonLoot
        if (FabricLoader.getInstance().isModLoaded("dragonloot")) {
            DRAGON = register(PaxelsMaterials.DRAGON, 1, -2.8f, "dragon", (new Item.Settings()).fireproof());
        }

        // Additional Additions
        if (FabricLoader.getInstance().isModLoaded("additionaladditions")) {
            GILDED_NETHERITE = register(PaxelsMaterials.GILDED_NETHERITE,  3, -2.6f, "gilded_netherite", (new Item.Settings()));
            ROSE_GOLD = register(PaxelsMaterials.ROSE_GOLD, 1, -2.8f, "rose_gold", (new Item.Settings()).fireproof());
        }

        ItemGroupEvents.modifyEntriesEvent(AdaPaxels.ADAPAXELS_GROUP).register(content -> {
            for (Item item : items) {
                content.add(item);
            }
        });
    }

    private static Item register(ToolMaterial material, int attackDamage, float attackSpeed, String materialname, Item.Settings settings) {
        var item = Registry.register(Registries.ITEM, id(materialname + "_paxel"), new PaxelItem(material, attackDamage, attackSpeed, settings));
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
        return item;
    }

    public static Identifier id(String name) {
        return new Identifier(AdaPaxels.MOD_ID, name);
    }
}
