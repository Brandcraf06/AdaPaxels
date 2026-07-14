package com.brand.adapaxels.datagen;


import com.brand.adapaxels.datagen.provider.AdaPaxelsBlockTagProvider;
import com.brand.adapaxels.datagen.provider.AdaPaxelsItemTagProvider;
import com.brand.adapaxels.datagen.provider.AdaPaxelsModelProvider;
import com.brand.adapaxels.datagen.provider.AdaPaxelsRecipesProvider;
import com.brand.adapaxels.datagen.provider.language.AdaPaxelsLangEnProvider;
import com.brand.adapaxels.datagen.provider.language.AdaPaxelsLangFrProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AdaPaxelsDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {

        final FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(AdaPaxelsRecipesProvider::new);

        AdaPaxelsBlockTagProvider blockTags = pack.addProvider(AdaPaxelsBlockTagProvider::new);
        pack.addProvider((output, registries) -> new AdaPaxelsItemTagProvider(output, registries, blockTags));

        pack.addProvider(AdaPaxelsModelProvider::new);
        pack.addProvider(AdaPaxelsLangEnProvider::new);
        pack.addProvider(AdaPaxelsLangFrProvider::new);
    }
}
