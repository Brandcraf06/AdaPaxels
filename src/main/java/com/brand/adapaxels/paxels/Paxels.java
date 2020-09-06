package com.brand.adapaxels.paxels;


import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.paxels.base.PaxelBase;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.registry.Registry;

public class Paxels {

    public static Item WOOD = register(PaxelsMaterials.WOOD, 1, -2.8f, "wooden", (new Item.Settings()).group(AdaPaxels.ADAPAXELS_GROUP));
    public static Item STONE = register(PaxelsMaterials.STONE, 1, -2.8f, "stone", (new Item.Settings()).group(AdaPaxels.ADAPAXELS_GROUP));
    public static Item IRON = register(PaxelsMaterials.IRON, 1, -2.8f, "iron", (new Item.Settings()).group(AdaPaxels.ADAPAXELS_GROUP));
    public static Item GOLDEN = register(PaxelsMaterials.GOLD, 1, -2.8f, "golden", (new Item.Settings()).group(AdaPaxels.ADAPAXELS_GROUP));
    public static Item DIAMOND = register(PaxelsMaterials.DIAMOND, 1, -2.8f, "diamond", (new Item.Settings()).group(AdaPaxels.ADAPAXELS_GROUP));
    public static Item NETHERITE = register(PaxelsMaterials.NETHERITE, 1, -2.8f, "netherite", (new Item.Settings()).group(AdaPaxels.ADAPAXELS_GROUP).fireproof());
    public static Item VIBRANIUM;
    public static Item ADAMANTIUM;
    public static Item NETHER_BRICK;
    
    public static void init() {
        if(FabricLoader.getInstance().isModLoaded("adabraniummod")) {
        	VIBRANIUM = register(PaxelsMaterials.VIBRANIUM, 5, -2.3f, "vibranium", (new Item.Settings()).group(AdaPaxels.ADAPAXELS_GROUP));
        	ADAMANTIUM = register(PaxelsMaterials.ADAMANTIUM, 10, -2.9f, "adamantium", (new Item.Settings()).group(AdaPaxels.ADAPAXELS_GROUP));
        	NETHER_BRICK = register(PaxelsMaterials.NETHER_BRICK, 10, -2.9f, "nether", (new Item.Settings()).group(AdaPaxels.ADAPAXELS_GROUP).fireproof());
            }
        }


    private static Item register(ToolMaterial material, int attackDamage, float attackSpeed, String materialname, Item.Settings settings) {
        return Registry.register(Registry.ITEM, AdaPaxels.id(materialname + "_paxel"), new PaxelBase(material, attackDamage, attackSpeed, settings));
    }
}
