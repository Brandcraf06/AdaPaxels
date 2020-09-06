package com.brand.adapaxels.paxels;

import java.util.function.Supplier;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import net.minecraft.util.registry.Registry;

public enum PaxelsMaterials implements ToolMaterial {
   WOOD(0, 177, 2.0F, 0.0F, 15, () -> {
      return Ingredient.fromTag(ItemTags.PLANKS);
   }),
   STONE(1, 393, 4.0F, 1.0F, 5, () -> {
      return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
   }),
   IRON(2, 750, 6.0F, 2.0F, 14, () -> {
      return Ingredient.ofItems(Items.IRON_INGOT);
   }),
   DIAMOND(3, 4683, 8.0F, 3.0F, 10, () -> {
      return Ingredient.ofItems(Items.DIAMOND);
   }),
   GOLD(0, 96, 12.0F, 0.0F, 22, () -> {
      return Ingredient.ofItems(Items.GOLD_INGOT);
   }),
   NETHERITE(4, 6093, 9.0F, 4.0F, 15, () -> {
      return Ingredient.ofItems(Items.NETHERITE_INGOT);
   }),
   VIBRANIUM(4, 8970, 20.0F, 10.0F, 12, () -> {
	   return Ingredient.ofItems(Registry.ITEM.get(new Identifier("adabraniummod","vibranium_ingot")));
   }),
   ADAMANTIUM(4, 12840, 35.0F, 16.0F, 10, () -> {
	      return Ingredient.ofItems(Registry.ITEM.get(new Identifier("adabraniummod","adamantium_ingot")));
   }),
   NETHER_BRICK(2, 1143, 8.0F, 2.0F, 15, () -> {
	      return Ingredient.ofItems(Items.NETHER_BRICK);
   });

   private final int miningLevel;
   private final int itemDurability;
   private final float miningSpeed;
   private final float attackDamage;
   private final int enchantability;
   private final Lazy<Ingredient> repairIngredient;

private PaxelsMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
      this.miningLevel = miningLevel;
      this.itemDurability = itemDurability;
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

