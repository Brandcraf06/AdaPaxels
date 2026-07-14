package com.brand.adapaxels.content.paxels;

import com.google.common.base.Suppliers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.Objects;
import java.util.function.Supplier;

public enum PaxelsMaterials implements Tier {
    WOOD(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 59, 2.0F, 0.0F, 15, () -> Ingredient.of(ItemTags.PLANKS)),
    STONE(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 4.0F, 1.0F, 5, () -> Ingredient.of(ItemTags.STONE_TOOL_MATERIALS)),
    IRON(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, () -> Ingredient.of(Items.IRON_INGOT)),
    DIAMOND(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 10, () -> Ingredient.of(Items.DIAMOND)),
    GOLD(BlockTags.INCORRECT_FOR_GOLD_TOOL, 32, 12.0F, 0.0F, 22, () -> Ingredient.of(Items.GOLD_INGOT)),
    NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, () -> Ingredient.of(Items.NETHERITE_INGOT)),

    // Adabranium
    VIBRANIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2701, 11.0F, 6.0F, 12, () -> Ingredient.of(BuiltInRegistries.ITEM.get(adabranium("vibranium_ingot")))),
    ADAMANTIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3346, 14.0F, 8.0F, 10, () -> Ingredient.of(BuiltInRegistries.ITEM.get(adabranium("adamantium_ingot")))),
    NETHER_BRICK(BlockTags.INCORRECT_FOR_IRON_TOOL, 381, 9.0F, 2.0F, 15, () -> Ingredient.of(Items.NETHER_BRICK)),

    // Tech Reborn
    BRONZE(BlockTags.INCORRECT_FOR_IRON_TOOL, 375, 7.0F, 6, 6, () -> Ingredient.of(BuiltInRegistries.ITEM.get(techreborn("bronze_ingot")))),
    RUBY(BlockTags.INCORRECT_FOR_IRON_TOOL, 750, 6.0F, 5, 10, () -> Ingredient.of(BuiltInRegistries.ITEM.get(techreborn("ruby_gem")))),
    SAPPHIRE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1000, 7.0F, 5, 12, () -> Ingredient.of(BuiltInRegistries.ITEM.get(techreborn("sapphire_gem")))),
    PERIDOT(BlockTags.INCORRECT_FOR_IRON_TOOL, 750, 7.0F, 5, 12, () -> Ingredient.of(BuiltInRegistries.ITEM.get(techreborn("peridot_gem")))),

    // Enderite Mod
    ENDERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4096, 15.0F, 2.0F, 17, () -> Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("enderitemod", "enderite_ingot")))),

    // DragonLoot
    DRAGON(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1961, 12.0F, 5.0F, 20, () -> Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("dragonloot", "dragon_scale")))),

    // Additional Additions
    ROSE_GOLD(BlockTags.INCORRECT_FOR_IRON_TOOL, 900, 8.0F, -1.0F, 17, () -> Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("additionaladditions", "rose_gold_ingot"))));

    public static ResourceLocation modid(String modid, String name) {
        return ResourceLocation.fromNamespaceAndPath(modid, name);
    }

    public static ResourceLocation techreborn(String name) {
        return modid("techreborn", name);
    }

    public static ResourceLocation adabranium(String name) {
        return modid("adabranium", name);
    }

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    PaxelsMaterials(final TagKey<Block> tagKey, final int baseDurability, final float miningSpeed, final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient) {
        this.incorrectBlocksForDrops = tagKey;
        this.uses = (baseDurability * 3);
        this.speed = miningSpeed;
        this.damage = attackDamage;
        this.enchantmentValue = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

