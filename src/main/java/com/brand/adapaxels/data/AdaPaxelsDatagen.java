package com.brand.adapaxels.data;


import com.brand.adapaxels.data.provider.AdaPaxelsRecipesProvider;
import com.brand.adapaxels.data.provider.AdaPaxelsItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;

public class AdaPaxelsDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        dataGenerator.addProvider(AdaPaxelsRecipesProvider::new);
        dataGenerator.addProvider(new AdaPaxelsItemTagProvider(dataGenerator));

    }
}