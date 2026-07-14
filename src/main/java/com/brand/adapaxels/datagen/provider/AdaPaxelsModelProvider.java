package com.brand.adapaxels.datagen.provider;

import com.brand.adapaxels.content.AdapaxelsItems;
import com.brand.adapaxels.content.paxels.Paxels;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;

public class AdaPaxelsModelProvider extends FabricModelProvider {

    public AdaPaxelsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators modelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerators modelGenerator) {
        modelGenerator.generateFlatItem(AdapaxelsItems.STACKED_NETHERITE, ModelTemplates.FLAT_ITEM);

        for (Item paxel : Paxels.items) {
            modelGenerator.generateFlatItem(paxel.asItem(), ModelTemplates.FLAT_HANDHELD_ITEM);
        }
    }
}
