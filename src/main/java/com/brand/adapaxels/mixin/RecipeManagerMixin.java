package com.brand.adapaxels.mixin;

import com.brand.adapaxels.paxels.PaxelRecipes;
import com.brand.adapaxels.utils.Recipe;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {
    @Inject(method = "apply", at = @At("HEAD"))
    public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo callbackInfo) {
        if (PaxelRecipes.getPaxelRecipes() != null) {
            for(Recipe recipe : PaxelRecipes.getPaxelRecipes()) {
                if (recipe.getRecipeIdentifier() != null) {
                    map.put(recipe.getRecipeIdentifier(), recipe.getRecipe());
                }
            }
        }
    }
}
