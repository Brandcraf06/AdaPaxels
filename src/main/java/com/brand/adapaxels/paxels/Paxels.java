package com.brand.adapaxels.paxels;


import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.paxels.base.BasePaxel;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.registry.Registry;

public class Paxels {

    public static Item WOOD = register(PaxelsMaterials.WOOD, 0, -2.8f, "wooden");
    public static Item STONE = register(PaxelsMaterials.STONE, 0, -2.8f, "stone");
    public static Item IRON = register(PaxelsMaterials.IRON, 0, -2.8f, "iron");
    public static Item GOLDEN = register(PaxelsMaterials.GOLD, 0, -2.8f, "golden");
    public static Item DIAMOND = register(PaxelsMaterials.DIAMOND, 0, -2.8f, "diamond");
    public static Item NETHERITE = register(PaxelsMaterials.NETHERITE, 0, -2.8f, "netherite");


    private static Item register(ToolMaterial material, int attackDamage, float attackSpeed, String materialname) {
        return Registry.register(Registry.ITEM, AdaPaxels.id(materialname + "_paxel"), new BasePaxel(material, attackDamage, attackSpeed));
    }
}
