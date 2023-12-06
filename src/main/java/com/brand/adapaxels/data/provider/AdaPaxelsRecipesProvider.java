package com.brand.adapaxels.data.provider;

import com.brand.adapaxels.content.AdapaxelsItems;
import com.brand.adapaxels.content.paxels.Paxels;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

public class AdaPaxelsRecipesProvider extends FabricRecipeProvider {
    public AdaPaxelsRecipesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerPaxelRecipe(exporter, Paxels.WOOD, Items.WOODEN_AXE, Items.WOODEN_PICKAXE, Items.WOODEN_SHOVEL, Items.STICK);
        offerPaxelRecipe(exporter, Paxels.STONE, Items.STONE_AXE, Items.STONE_PICKAXE, Items.STONE_SHOVEL, Items.STICK);
        offerPaxelRecipe(exporter, Paxels.IRON, Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.STICK);
        offerPaxelRecipe(exporter, Paxels.GOLDEN, Items.GOLDEN_AXE, Items.GOLDEN_PICKAXE, Items.GOLDEN_SHOVEL, Items.STICK);
        offerPaxelRecipe(exporter, Paxels.DIAMOND, Items.DIAMOND_AXE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.STICK);
        offerPaxelRecipe(exporter, Paxels.NETHERITE, Items.NETHERITE_AXE, Items.NETHERITE_PICKAXE, Items.NETHERITE_SHOVEL, Items.STICK);
        offerSmithingUpgradeRecipe(exporter, Paxels.DIAMOND, Paxels.NETHERITE, AdapaxelsItems.STACKED_NETHERITE);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, AdapaxelsItems.STACKED_NETHERITE).input(Items.NETHERITE_INGOT).input(Items.NETHERITE_INGOT).input(Items.NETHERITE_INGOT).criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT)).offerTo(exporter);
    }

    public static void offerPaxelRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible axe, ItemConvertible pickaxe, ItemConvertible shovel, ItemConvertible rod) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output).input('A', axe).input('B', pickaxe).input('C', shovel).input('S', rod).pattern("ABC").pattern(" S ").pattern(" S ").criterion(hasItem(pickaxe), conditionsFromItem(pickaxe)).offerTo(exporter);
    }

    public static void offerSmithingUpgradeRecipe(RecipeExporter exporter, Item input, Item result, ItemConvertible ingot) {
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(input), Ingredient.ofItems(ingot), RecipeCategory.TOOLS, result).criterion(hasItem(ingot), conditionsFromItem(ingot)).offerTo(exporter, getItemPath(result) + "_smithing");
    }

}
