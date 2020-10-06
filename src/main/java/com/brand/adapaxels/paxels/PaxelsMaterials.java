package com.brand.adapaxels.paxels;

import java.util.function.Supplier;

import net.fabricmc.fabric.api.tag.TagRegistry;
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
   
// Adabranium	
   VIBRANIUM(4, 8970, 20.0F, 10.0F, 12, () -> {
	   return Ingredient.ofItems(Registry.ITEM.get(new Identifier("adabraniummod","vibranium_ingot")));
   }),
   ADAMANTIUM(4, 12840, 35.0F, 16.0F, 10, () -> {
	   return Ingredient.ofItems(Registry.ITEM.get(new Identifier("adabraniummod","adamantium_ingot")));
   }),
   NETHER_BRICK(2, 1143, 8.0F, 2.0F, 15, () -> {
	   return Ingredient.ofItems(Items.NETHER_BRICK);
   }),
   
// Astromine
   COPPER(1, 600, 4f, 1.5f, 10, () -> {
	   return Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:copper_ingots")));
   }),
   TIN(1, 600, 5f, 1.0f, 10, () -> {
	   return Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:tin_ingots")));
   }),
   SILVER(2, 1386, 6.5f, 2.0f, 20, () -> {
	   return Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:silver_ingots")));
   }),
   LEAD(2, 1488, 4.5f, 1.5f, 5, () -> {
	   return Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:lead_ingots")));
   }),
   BRONZE(2, 1617, 7f, 2.5f, 18, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:bronze_ingots")));
   }),
   STEEL(3, 3129, 7.5f, 3f, 16, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:steel_ingots")));
   }),
   ELECTRUM(2, 555, 11f, 1.0f, 21, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:electrum_ingots")));
   }),
   ROSE_GOLD(1, 192, 10.0F, 0.5F, 24, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:rose_gold_ingots")));
   }),
   STERLING_SILVER(2, 2091, 7f, 2.5f, 20, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:sterling_silver_ingots")));
   }),
   FOOLS_GOLD(2, 750, 6.5F, 2.0F, 16, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:fools_gold_ingots")));
   }),

   METITE(1, 2559, 13f, 4.0f, 5, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:metite_ingots")));
   }),
   ASTERITE(5, 6045, 10f, 5.0f, 20, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:asterites")));
   }),
   STELLUM(5, 7929, 8f, 6.0f, 15, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:stellum_ingots")));
   }),
   GALAXIUM(6, 9216, 11f, 5.0f, 18, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:galaxiums")));
   }),
   UNIVITE(7, 11754, 12f, 6.0f, 22, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:univite_ingots")));
   }),
   LUNUM(4, 4146, 7f, 4.5f, 18, () -> {
	   return  Ingredient.fromTag(TagRegistry.item(Identifier.tryParse("c:lunum_ingots")));
   }),
   
// Tech Reborn	
   TR_BRONZE(2, 1125, 7.0F, 2.25f, 12, () -> {
	   return Ingredient.ofItems(Registry.ITEM.get(new Identifier("techreborn","bronze_ingot")));
   }),
   RUBY(2, 4953, 6.0F, 4.7F, 10, () -> {
	   return Ingredient.ofItems(Registry.ITEM.get(new Identifier("techreborn","ruby_gem")));
   }),
   SAPPHIRE(3, 4953, 14.0F, 1.8F, 8, () -> {
	   return Ingredient.ofItems(Registry.ITEM.get(new Identifier("techreborn","sapphire_gem")));
   }),	
   PERIDOT(2, 1719, 7.0F, 2.4F, 24, () -> {
	   return Ingredient.ofItems(Registry.ITEM.get(new Identifier("techreborn","peridot_gem")));
   }),
   
// Enderite Mod
   ENDERITE(4, 12288, 15.0F, 2.0F, 17, () -> {
   return Ingredient.ofItems(Registry.ITEM.get(new Identifier("enderitemod","enderite_ingot")));
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

