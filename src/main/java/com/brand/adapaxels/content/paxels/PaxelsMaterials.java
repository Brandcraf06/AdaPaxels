package com.brand.adapaxels.content.paxels;

import com.brand.adapaxels.tags.APItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;

public class PaxelsMaterials {
    public PaxelsMaterials() {
        throw new AssertionError();
    }

    public static final ToolMaterial WOOD = toolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 59, 2.0F, 0.0F, 15, ItemTags.WOODEN_TOOL_MATERIALS);
    public static final ToolMaterial STONE = toolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 4.0F, 1.0F, 5, ItemTags.STONE_TOOL_MATERIALS);
    public static final ToolMaterial COPPER = toolMaterial(BlockTags.INCORRECT_FOR_COPPER_TOOL, 190, 5.0F, 1.0F, 13, ItemTags.COPPER_TOOL_MATERIALS);
    public static final ToolMaterial IRON = toolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, ItemTags.IRON_TOOL_MATERIALS);
    public static final ToolMaterial DIAMOND = toolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 10, ItemTags.DIAMOND_TOOL_MATERIALS);
    public static final ToolMaterial GOLD = toolMaterial(BlockTags.INCORRECT_FOR_GOLD_TOOL, 32, 12.0F, 0.0F, 22, ItemTags.GOLD_TOOL_MATERIALS);
    public static final ToolMaterial NETHERITE = toolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, ItemTags.NETHERITE_TOOL_MATERIALS);

    // Adabranium - Updated for 1.21.11
    public static final ToolMaterial VIBRANIUM = toolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2701, 11.0F, 6.0F, 12, APItemTags.VIBRANIUM_TOOL_MATERIALS);
    public static final ToolMaterial ADAMANTIUM = toolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3346, 14.0F, 8.0F, 10, APItemTags.ADAMANTIUM_TOOL_MATERIALS);
    public static final ToolMaterial NETHER_BRICK = toolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 381, 9.0F, 2.0F, 15, APItemTags.NETHER_BRICK_TOOL_MATERIALS);

    // Tech Reborn - Updated for 26.1
    public static final ToolMaterial BRONZE = toolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 375, 7.0F, 6, 6, APItemTags.BRONZE_TOOL_MATERIALS);
    public static final ToolMaterial RUBY = toolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 750, 6.0F, 5, 10, APItemTags.RUBY_TOOL_MATERIALS);
    public static final ToolMaterial SAPPHIRE = toolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1000, 7.0F, 5, 12, APItemTags.SAPPHIRE_TOOL_MATERIALS);
    public static final ToolMaterial PERIDOT = toolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 750, 7.0F, 5, 12, APItemTags.PERIDOT_TOOL_MATERIALS);

    // Enderite Mod - Updated for 26.1
    public static final ToolMaterial ENDERITE = toolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4096, 15.0F, 5.0F, 17, APItemTags.ENDERITE_TOOL_MATERIALS);

    // DragonLoot - Wait & see (1.21.1)
    public static final ToolMaterial DRAGON = toolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1961, 12.0F, 5.0F, 20, APItemTags.DRAGON_TOOL_MATERIALS);

    private static ToolMaterial toolMaterial(TagKey<Block> incorrectBlocksForDrops, int baseDurability, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems) {
        return new ToolMaterial(incorrectBlocksForDrops, baseDurability * 3, speed, attackDamageBonus, enchantmentValue, repairItems);
    }


}

