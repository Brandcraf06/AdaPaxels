package com.brand.adapaxels.paxels.base;

import com.brand.adapaxels.AdaPaxels;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class BasePaxel extends PaxelItem
{
    public BasePaxel(ToolMaterial material, int attackDamage, float attackSpeed)
    {
        super(material, attackDamage, attackSpeed, new Item.Settings().group(AdaPaxels.ADAPAXELS_GROUP));
    }
}
