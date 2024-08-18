package com.brand.adapaxels.content.paxels;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.function.Supplier;

public enum PaxelsMaterials implements ToolMaterial {
    WOOD(BlockTags.INCORRECT_FOR_WOODEN_TOOL,59, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    STONE(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 4.0F, 1.0F, 5, () -> {
        return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
    }),
    IRON(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    DIAMOND(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    GOLD(BlockTags.INCORRECT_FOR_GOLD_TOOL, 32, 12.0F, 0.0F, 22, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),

    // Adabranium - wait & see
    VIBRANIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2990, 17.0F, 6.0F, 12, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(adabranium("vibranium_ingot")));
    }),
    ADAMANTIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4280, 25.0F, 9.0F, 10, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(adabranium("adamantium_ingot")));
    }),
    NETHER_BRICK(BlockTags.INCORRECT_FOR_IRON_TOOL, 381, 8.0F, 2.0F, 15, () -> {
        return Ingredient.ofItems(Items.NETHER_BRICK);
    }),

    // Industrial Revolution - Probably discontinued but wait & see
    TIN(BlockTags.INCORRECT_FOR_IRON_TOOL, 200, 4.0f, 1.0f, 14, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(indrev("tin_ingots")));
    }),
    STEEL(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 600, 4.5f, 2.0f, 14, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(indrev("steel_ingot")));
    }),
    SILVER(BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 5.0f, 1.0f, 24, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(indrev("silver_ingot")));
    }),
    LEAD(BlockTags.INCORRECT_FOR_IRON_TOOL, 900, 3.0f, 2.0f, 8, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(indrev("lead_ingot")));
    }),
    COPPER(BlockTags.INCORRECT_FOR_IRON_TOOL, 300, 4.5f, 1.0f, 14, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(indrev("copper_ingot")));
    }),
    BRONZE(BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 3.5f, 2.5f, 12, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(indrev("bronze_ingot")));
    }),


    // Applied Energistics 2 - Definitely abandonned Fabric for 1.21 but wait & see
    CERTUS_QUARTZ(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(Identifier.of("appliedenergistics2", "certus_quartz_crystal")));
    }),
    NETHER_QUARTZ(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(Items.QUARTZ);
    }),

    // Tech Reborn - Updated for 1.21.1
    TR_BRONZE(BlockTags.INCORRECT_FOR_IRON_TOOL, 375, 7.0F, 2.25f, 6, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(techreborn("bronze_ingot")));
    }),
    RUBY(BlockTags.INCORRECT_FOR_IRON_TOOL, 750, 6.0F, 1.5F, 10, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(techreborn("ruby_gem")));
    }),
    SAPPHIRE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1000, 7.0F, 1.5F, 12, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(techreborn("sapphire_gem")));
    }),
    PERIDOT(BlockTags.INCORRECT_FOR_IRON_TOOL, 750, 7.0F, 1.5F, 12, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(techreborn("peridot_gem")));
    }),

    // Enderite Mod - Last update for 1.20.6 (15-06-24) so wait & see
    ENDERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4096, 15.0F, 2.0F, 17, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(Identifier.of("enderitemod", "enderite_ingot")));
    }),

    // DragonLoot - Updated for 1.21
    DRAGON(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1961, 12.0F, 5.0F, 20, () -> {
        return Ingredient.ofItems(Registries.ITEM.get(Identifier.of("dragonloot", "dragon_scale")));
    }),

    // Additional Additions - Probably discontinued but wait & see
    GILDED_NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 6000, 9.0F, 2.0F, 24, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    ROSE_GOLD(BlockTags.INCORRECT_FOR_IRON_TOOL, 2700, 9.0F, 2.0F, 17, () -> {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    });

    public static Identifier modid(String modid, String name) {
        return Identifier.of(modid, name);
    }

    public static Identifier techreborn(String name) {
        return modid("techreborn", name);
    }

    public static Identifier indrev(String name) {
        return modid("indrev", name);
    }

    public static Identifier adabranium(String name) {
        return modid("adabraniummod", name);
    }

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    PaxelsMaterials(final TagKey inverseTag, int baseDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = (baseDurability * 3);
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

