package com.brand.adapaxels.datagen.provider;

import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.content.paxels.Paxels;
import com.brand.adapaxels.tags.APItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;

import java.util.concurrent.CompletableFuture;

public class AdaPaxelsItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public AdaPaxelsItemTagProvider(FabricDataOutput dataGenerator, CompletableFuture<HolderLookup.Provider> completableFuture, FabricTagProvider.BlockTagProvider blockTags) {
        super(dataGenerator, completableFuture, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.getOrCreateTagBuilder(APItemTags.PAXELS)
                .add(Paxels.WOOD)
                .add(Paxels.STONE)
                .add(Paxels.IRON)
                .add(Paxels.GOLDEN)
                .add(Paxels.DIAMOND)
                .add(Paxels.NETHERITE)

                .addOptional(moddedPaxel("vibranium"))
                .addOptional(moddedPaxel("adamantium"))
                .addOptional(moddedPaxel("nether"))

                .addOptional(moddedPaxel("tech_reborn_bronze"))
                .addOptional(moddedPaxel("ruby"))
                .addOptional(moddedPaxel("sapphire"))
                .addOptional(moddedPaxel("peridot"))

                .addOptional(moddedPaxel("enderite"))

                .addOptional(moddedPaxel("dragon"))

                .addOptional(moddedPaxel("rose_gold"));

        this.getOrCreateTagBuilder(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("dragonloot", "explosion_resistant")))
                .addOptional(moddedPaxel("dragon"));

        this.getOrCreateTagBuilder(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("enderitemod", "enderite_tools")))
                .addOptional(moddedPaxel("enderite"));

        this.getOrCreateTagBuilder(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("enderitemod", "enderite_items")))
                .addOptional(moddedPaxel("enderite"));

        this.getOrCreateTagBuilder(ItemTags.AXES)
                .addTag(APItemTags.PAXELS);

        this.getOrCreateTagBuilder(ItemTags.PICKAXES)
                .addTag(APItemTags.PAXELS);

        this.getOrCreateTagBuilder(ItemTags.SHOVELS)
                .addTag(APItemTags.PAXELS);

        this.getOrCreateTagBuilder(ItemTags.HOES)
                .addTag(APItemTags.PAXELS);

        this.getOrCreateTagBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES)
                .addTag(APItemTags.PAXELS);

        this.getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
                .add(Paxels.GOLDEN);
    }

    public ResourceLocation moddedPaxel(String material) {
        return AdaPaxels.id(material + "_paxel");
    }
}
