package com.brand.adapaxels.datagen.provider;

import com.brand.adapaxels.tags.APBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class AdaPaxelsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public AdaPaxelsBlockTagProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(dataOutput, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.getOrCreateTagBuilder(APBlockTags.MINEABLE_WITH_PAXEL)
                .forceAddTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .forceAddTag(BlockTags.MINEABLE_WITH_AXE)
                .forceAddTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .forceAddTag(BlockTags.MINEABLE_WITH_HOE);

    }
}
