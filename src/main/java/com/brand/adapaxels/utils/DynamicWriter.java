package com.brand.adapaxels.utils;

import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

public class DynamicWriter {
    public static JsonObject createSmithingRecipeJson(Identifier base, Identifier addition, Identifier result) {
        JsonObject recipe = new JsonObject();
        recipe.addProperty("type", "minecraft:smithing");

        JsonObject baseJson = new JsonObject();
        baseJson.addProperty("item", String.valueOf(base));
        recipe.add("base", baseJson);

        JsonObject additionJson = new JsonObject();
        additionJson.addProperty("item", String.valueOf(addition));
        recipe.add("addition", additionJson);

        JsonObject resultJson = new JsonObject();
        resultJson.addProperty("item", String.valueOf(result));
        recipe.add("result", resultJson);

        return recipe;
    }
}
