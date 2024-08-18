package com.brand.adapaxels.content.paxels;


import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.content.paxels.base.PaxelItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class Paxels {

    protected static final List<Item> items = new ArrayList<>();
    public static Item WOOD = register(PaxelsMaterials.WOOD, 1, -2.8f, "wooden");
    public static Item STONE = register(PaxelsMaterials.STONE, 1, -2.8f, "stone");
    public static Item IRON = register(PaxelsMaterials.IRON, 1, -2.8f, "iron");
    public static Item GOLDEN = register(PaxelsMaterials.GOLD, 1, -2.8f, "golden");
    public static Item DIAMOND = register(PaxelsMaterials.DIAMOND, 1, -2.8f, "diamond");
    public static Item NETHERITE = register(PaxelsMaterials.NETHERITE, 1, -2.8f, "netherite", true);
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
    public static Item ENDERITE;
    public static Item DRAGON;
    public static Item GILDED_NETHERITE;
    public static Item ROSE_GOLD;

    public static void init() {

        // Adabranium https://www.curseforge.com/minecraft/mc-mods/adabranium
        if (FabricLoader.getInstance().isModLoaded("adabraniummod")) {
            VIBRANIUM = register(PaxelsMaterials.VIBRANIUM, 1, -2.8f, "vibranium");
            ADAMANTIUM = register(PaxelsMaterials.ADAMANTIUM, 1, -2.8f, "adamantium");
            NETHER_BRICK = register(PaxelsMaterials.NETHER_BRICK, 1, -2.8f, "nether", true);
        }

        // Industrial Revolution https://www.curseforge.com/minecraft/mc-mods/industrial-revolution
        if (FabricLoader.getInstance().isModLoaded("indrev")) {
            TIN = register(PaxelsMaterials.TIN, 1, -1.0f, "tin");
            STEEL = register(PaxelsMaterials.STEEL, 2, -1.8f, "steel");
            SILVER = register(PaxelsMaterials.SILVER, 1, -1.0f, "silver");
            LEAD = register(PaxelsMaterials.LEAD, 1, -1.0f, "lead");
            COPPER = register(PaxelsMaterials.COPPER, 1, -1.0f, "copper");
            BRONZE = register(PaxelsMaterials.BRONZE, 1, -1.0f, "bronze");
        }

        // Applied Energistics 2 https://www.curseforge.com/minecraft/mc-mods/applied-energistics-2
        if (FabricLoader.getInstance().isModLoaded("appliedenergistics2")) {
            CERTUS_QUARTZ = register(PaxelsMaterials.CERTUS_QUARTZ, 1, -2.8f, "certus_quartz");
            NETHER_QUARTZ = register(PaxelsMaterials.NETHER_QUARTZ, 1, -2.8f, "nether_quartz");
        }

        // Tech Reborn https://www.curseforge.com/minecraft/mc-mods/techreborn
        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
            TR_BRONZE = register(PaxelsMaterials.TR_BRONZE, 1, -2.8f, "tech_reborn_bronze");
            RUBY = register(PaxelsMaterials.RUBY, 1, -2.8f, "ruby");
            SAPPHIRE = register(PaxelsMaterials.SAPPHIRE, 1, -2.8f, "sapphire");
            PERIDOT = register(PaxelsMaterials.PERIDOT, 1, -2.8f, "peridot");
        }

        // Enderite Mod https://www.curseforge.com/minecraft/mc-mods/enderite-mod-for-fabric
        if (FabricLoader.getInstance().isModLoaded("enderitemod")) {
            ENDERITE = register(PaxelsMaterials.ENDERITE, 4, -2.8f, "enderite", true);
        }

        // DragonLoot https://www.curseforge.com/minecraft/mc-mods/dragonloot
        if (FabricLoader.getInstance().isModLoaded("dragonloot")) {
            DRAGON = register(PaxelsMaterials.DRAGON, 1, -2.8f, "dragon", true);
        }

        // Additional Additions https://www.curseforge.com/minecraft/mc-mods/additional-additions
        if (FabricLoader.getInstance().isModLoaded("additionaladditions")) {
            GILDED_NETHERITE = register(PaxelsMaterials.GILDED_NETHERITE, 3, -2.6f, "gilded_netherite");
            ROSE_GOLD = register(PaxelsMaterials.ROSE_GOLD, 1, -2.8f, "rose_gold", true);
        }

        Registry.register(Registries.ITEM_GROUP, AdaPaxels.ADAPAXELS_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.adapaxels.adapaxels_group"))
                .icon(() -> new ItemStack(Paxels.NETHERITE))
                .build()
        );

        ItemGroupEvents.modifyEntriesEvent(AdaPaxels.ADAPAXELS_GROUP).register(content -> {
            for (Item item : items) {
                content.add(item);
            }
        });
    }

    public static Item register(ToolMaterial material, int attackDamage, float attackSpeed, String materialname, boolean isFireproof) {
        Item.Settings settings = new Item.Settings();
        if (isFireproof)
            settings = settings.fireproof();

        var item = new PaxelItem(material, settings.attributeModifiers(ShovelItem.createAttributeModifiers(material, attackDamage, attackSpeed)), materialname);
        Registry.register(Registries.ITEM, id(materialname + "_paxel"), item);
        items.add(item);
        return item;
    }

    public static Item register(ToolMaterial material, int attackDamage, float attackSpeed, String materialname) {
        return register(material, attackDamage, attackSpeed, materialname, false);
    }

    public static Identifier id(String name) {
        return AdaPaxels.id(name);
    }
}
