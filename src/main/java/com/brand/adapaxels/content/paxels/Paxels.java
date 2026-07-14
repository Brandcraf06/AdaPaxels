package com.brand.adapaxels.content.paxels;


import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.content.AdapaxelsItemGroup;
import com.brand.adapaxels.content.paxels.base.PaxelItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

import java.util.ArrayList;
import java.util.List;

public class Paxels {

    public static final List<Item> items = new ArrayList<>();
    public static Item WOOD = register(PaxelsMaterials.WOOD, 1, -2.8f, "wooden");
    public static Item STONE = register(PaxelsMaterials.STONE, 1, -2.8f, "stone");
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
    public static Item ROSE_GOLD;

    public static void init() {

        // Adabranium https://modrinth.com/mod/adabranium
        if (isModLoaded("adabranium")) {
            VIBRANIUM = register(PaxelsMaterials.VIBRANIUM, 1, -2.8f, "vibranium");
            ADAMANTIUM = register(PaxelsMaterials.ADAMANTIUM, 1, -2.8f, "adamantium");
            NETHER_BRICK = register(PaxelsMaterials.NETHER_BRICK, 1, -2.8f, "nether", true);
        }

        // Tech Reborn https://modrinth.com/mod/techreborn
        if (isModLoaded("techreborn")) {
            BRONZE = register(PaxelsMaterials.BRONZE, -2, -2.8f, "tech_reborn_bronze");
            RUBY = register(PaxelsMaterials.RUBY, -2, -2.8f, "ruby");
            SAPPHIRE = register(PaxelsMaterials.SAPPHIRE, -2, -2.8f, "sapphire");
            PERIDOT = register(PaxelsMaterials.PERIDOT, -2, -2.8f, "peridot");
        }

        // Enderite Mod https://modrinth.com/mod/enderite-mod
        if (isModLoaded("enderitemod")) {
            ENDERITE = register(PaxelsMaterials.ENDERITE, 1, -2.8f, "enderite", true);
        }

        // DragonLoot https://modrinth.com/mod/dragonloot
        if (isModLoaded("dragonloot")) {
            DRAGON = register(PaxelsMaterials.DRAGON, 1, -2.8f, "dragon", true);
        }

        // Additional Additions https://modrinth.com/mod/addadd
        if (isModLoaded("additionaladditions")) {
            ROSE_GOLD = register(PaxelsMaterials.ROSE_GOLD, 4, -2.8f, "rose_gold");
        }

        ItemGroupEvents.modifyEntriesEvent(AdapaxelsItemGroup.ADAPAXELS_GROUP).register(content -> {
            for (Item item : items) {
                content.accept(item);
            }
        });
    }

    public static boolean isModLoaded(String id) {
        return FabricLoader.getInstance().isDevelopmentEnvironment() || FabricLoader.getInstance().isModLoaded(id);
    }

    public static Item register(Tier material, int attackDamage, float attackSpeed, String materialname, boolean isFireproof) {
        Item.Properties settings = new Item.Properties();
        if (isFireproof)
            settings = settings.fireResistant();

        var item = new PaxelItem(material, settings.attributes(ShovelItem.createAttributes(material, attackDamage, attackSpeed)), materialname);
        Registry.register(BuiltInRegistries.ITEM, id(materialname + "_paxel"), item);
        items.add(item);
        return item;
    }

    public static Item register(Tier material, int attackDamage, float attackSpeed, String materialname) {
        return register(material, attackDamage, attackSpeed, materialname, false);
    }

    public static ResourceLocation id(String name) {
        return AdaPaxels.id(name);
    }
}
