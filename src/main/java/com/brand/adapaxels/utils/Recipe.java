package com.brand.adapaxels.utils;

import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

public class Recipe {
    private final JsonObject recipe;
    private final Identifier recipeIdentifier;

    public Recipe(JsonObject recipe, Identifier recipeIdentifier) {
        this.recipe = recipe;
        this.recipeIdentifier = recipeIdentifier;
    }

    public JsonObject getRecipe() {
        return recipe;
    }

    public Identifier getRecipeIdentifier() {
        return recipeIdentifier;
    }
}
