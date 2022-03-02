package com.brand.adapaxels.paxels;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public enum PaxelsMaterials implements ToolMaterial {
    WOOD(0, 59, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    STONE(1, 131, 4.0F, 1.0F, 5, () -> {
        return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
    }),
    IRON(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    DIAMOND(3, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    GOLD(0, 32, 12.0F, 0.0F, 22, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    NETHERITE(4, 2031, 9.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),

    // Adabranium
    VIBRANIUM(4, 2990, 17.0F, 6.0F, 12, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("adabraniummod", "vibranium_ingot")));
    }),
    ADAMANTIUM(4, 4280, 25.0F, 9.0F, 10, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("adabraniummod", "adamantium_ingot")));
    }),
    NETHER_BRICK(2, 381, 8.0F, 2.0F, 15, () -> {
        return Ingredient.ofItems(Items.NETHER_BRICK);
    }),

    // Industrial Revolution
    TIN(1, 200, 4.0f, 1.0f, 14, () -> {
        return Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:tin_ingots")));
    }),
    STEEL(3, 600, 4.5f, 2.0f, 14, () -> {
        return Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:steel_ingots")));
    }),
    SILVER(2, 500, 5.0f, 1.0f, 24, () -> {
        return Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:silver_ingots")));
    }),
    LEAD(2, 900, 3.0f, 2.0f, 8, () -> {
        return Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:lead_ingots")));
    }),
    COPPER(2, 300, 4.5f, 1.0f, 14, () -> {
        return Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:copper_ingots")));
    }),
    BRONZE(2, 500, 3.5f, 2.5f, 12, () -> {
        return Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:bronze_ingots")));
    }),


    // Applied Energistics 2

    CERTUS_QUARTZ(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("appliedenergistics2", "certus_quartz_crystal")));
    }),
    NETHER_QUARTZ(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(Items.QUARTZ);
    }),

    // Tech Reborn
    TR_BRONZE(2, 375, 7.0F, 2.25f, 6, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("techreborn", "bronze_ingot")));
    }),
    RUBY(2, 750, 6.0F, 1.5F, 10, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("techreborn", "ruby_gem")));
    }),
    SAPPHIRE(3, 1000, 7.0F, 1.5F, 12, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("techreborn", "sapphire_gem")));
    }),
    PERIDOT(2, 750, 7.0F, 1.5F, 12, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("techreborn", "peridot_gem")));
    }),

    // BYG
    PENDORITE(5, 2500, 10.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("byg", "pendorite_scraps")));
    }),

    // Enderite Mod
    ENDERITE(4, 4096, 15.0F, 2.0F, 17, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("enderitemod", "enderite_ingot")));
    }),

    // Gilded Netherite
    DRAGON(5, 67 * 37, 12.0F, 5.0F, 20, () -> {
        return Ingredient.ofItems(Registry.ITEM.get(new Identifier("dragonloot", "dragon_scale")));
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    PaxelsMaterials(int miningLevel, int baseDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = (baseDurability * 3);
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
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

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

