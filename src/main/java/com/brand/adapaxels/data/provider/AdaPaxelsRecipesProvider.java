package com.brand.adapaxels.data.provider;

import com.brand.adapaxels.paxels.Paxels;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class AdaPaxelsRecipesProvider extends FabricRecipeProvider {
    public AdaPaxelsRecipesProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

        offerPaxelRecipe(exporter, Paxels.WOOD, Items.WOODEN_AXE, Items.WOODEN_PICKAXE, Items.WOODEN_SHOVEL, Items.STICK);
        offerPaxelRecipe(exporter, Paxels.STONE, Items.STONE_AXE, Items.STONE_PICKAXE, Items.STONE_SHOVEL, Items.STICK);
        offerPaxelRecipe(exporter, Paxels.IRON, Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.STICK);
        offerPaxelRecipe(exporter, Paxels.GOLDEN, Items.GOLDEN_AXE, Items.GOLDEN_PICKAXE, Items.GOLDEN_SHOVEL, Items.STICK);
        offerPaxelRecipe(exporter, Paxels.DIAMOND, Items.DIAMOND_AXE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.STICK);
        offerPaxelRecipe(exporter, Paxels.NETHERITE, Items.NETHERITE_AXE, Items.NETHERITE_PICKAXE, Items.NETHERITE_SHOVEL, Items.STICK);
        
    }

    public static void offerPaxelRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible axe, ItemConvertible pickaxe, ItemConvertible shovel, ItemConvertible rod) {
        ShapedRecipeJsonBuilder.create(output).input('A', axe).input('B', pickaxe).input('C', shovel).input('S', rod).pattern("ABC").pattern(" S ").pattern(" S ").criterion(hasItem(pickaxe), conditionsFromItem(pickaxe)).offerTo(exporter);
    }
}
