package com.brand.adapaxels.tags;

import com.brand.adapaxels.AdaPaxels;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class APItemTags {
    public static final TagKey<Item> PAXELS = register("paxels");

    public static final TagKey<Item> VIBRANIUM_TOOL_MATERIALS = register("vibranium_tool_materials");
    public static final TagKey<Item> ADAMANTIUM_TOOL_MATERIALS = register("adamantium_tool_materials");
    public static final TagKey<Item> NETHER_BRICK_TOOL_MATERIALS = register("nether_brick_tool_materials");

    public static final TagKey<Item> BRONZE_TOOL_MATERIALS = register("bronze_tool_materials");
    public static final TagKey<Item> RUBY_TOOL_MATERIALS = register("ruby_tool_materials");
    public static final TagKey<Item> SAPPHIRE_TOOL_MATERIALS = register("sapphire_tool_materials");
    public static final TagKey<Item> PERIDOT_TOOL_MATERIALS = register("peridot_tool_materials");

    public static final TagKey<Item> ENDERITE_TOOL_MATERIALS = register("enderite_tool_materials");

    public static final TagKey<Item> DRAGON_TOOL_MATERIALS = register("dragon_tool_materials");

    private APItemTags() {
    }

    private static TagKey<Item> register(String id) {
        return TagKey.create(Registries.ITEM, AdaPaxels.id(id));
    }
}

