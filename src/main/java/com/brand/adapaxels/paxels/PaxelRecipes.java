package com.brand.adapaxels.paxels;

import com.brand.adapaxels.utils.Recipe;
import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class PaxelRecipes {
    protected static final ArrayList<Recipe> PAXEL_RECIPES = new ArrayList<>();

    public static void addPaxelRecipe(JsonObject recipe, Identifier recipeIdentifier) {
        PAXEL_RECIPES.add(new Recipe(recipe, recipeIdentifier));
    }

    public static ArrayList<Recipe> getPaxelRecipes() {
        return PAXEL_RECIPES;
    }
}
