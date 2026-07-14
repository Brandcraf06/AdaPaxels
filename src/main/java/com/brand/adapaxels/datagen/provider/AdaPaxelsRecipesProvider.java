package com.brand.adapaxels.datagen.provider;

import com.brand.adapaxels.content.AdapaxelsItems;
import com.brand.adapaxels.content.paxels.Paxels;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class AdaPaxelsRecipesProvider extends FabricRecipeProvider {
    public AdaPaxelsRecipesProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput output) {

        offerPaxelRecipe(output, Paxels.WOOD, Items.WOODEN_AXE, Items.WOODEN_PICKAXE, Items.WOODEN_SHOVEL, Items.STICK);
        offerPaxelRecipe(output, Paxels.STONE, Items.STONE_AXE, Items.STONE_PICKAXE, Items.STONE_SHOVEL, Items.STICK);
        offerPaxelRecipe(output, Paxels.IRON, Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.STICK);
        offerPaxelRecipe(output, Paxels.GOLDEN, Items.GOLDEN_AXE, Items.GOLDEN_PICKAXE, Items.GOLDEN_SHOVEL, Items.STICK);
        offerPaxelRecipe(output, Paxels.DIAMOND, Items.DIAMOND_AXE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.STICK);
        offerPaxelRecipe(output, Paxels.NETHERITE, Items.NETHERITE_AXE, Items.NETHERITE_PICKAXE, Items.NETHERITE_SHOVEL, Items.STICK);
        offerSmithingUpgradeRecipe(output, Paxels.DIAMOND, Paxels.NETHERITE, AdapaxelsItems.STACKED_NETHERITE);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AdapaxelsItems.STACKED_NETHERITE).requires(Items.NETHERITE_INGOT).requires(Items.NETHERITE_INGOT).requires(Items.NETHERITE_INGOT).unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT)).save(output);
    }

    public void offerPaxelRecipe(RecipeOutput output, ItemLike result, ItemLike axe, ItemLike pickaxe, ItemLike shovel, ItemLike rod) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result).define('A', axe).define('B', pickaxe).define('C', shovel).define('S', rod).pattern("ABC").pattern(" S ").pattern(" S ").unlockedBy(getHasName(pickaxe), has(pickaxe)).save(output);
    }

    public void offerSmithingUpgradeRecipe(RecipeOutput output, Item input, Item result, ItemLike ingot) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(input), Ingredient.of(ingot), RecipeCategory.TOOLS, result).unlocks(getHasName(ingot), has(ingot)).save(output, getItemName(result) + "_smithing");
    }
}
