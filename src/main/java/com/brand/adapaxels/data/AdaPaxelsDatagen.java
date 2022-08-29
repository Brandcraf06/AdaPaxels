package com.brand.adapaxels.data;


import com.brand.adapaxels.data.provider.AdaPaxelsBlockTagProvider;
import com.brand.adapaxels.data.provider.AdaPaxelsItemTagProvider;
import com.brand.adapaxels.data.provider.AdaPaxelsRecipesProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class AdaPaxelsDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        dataGenerator.addProvider(AdaPaxelsRecipesProvider::new);
        FabricTagProvider.BlockTagProvider blockTags = new AdaPaxelsBlockTagProvider(dataGenerator);
        dataGenerator.addProvider(blockTags);
        dataGenerator.addProvider(new AdaPaxelsItemTagProvider(dataGenerator, blockTags));


    }
}