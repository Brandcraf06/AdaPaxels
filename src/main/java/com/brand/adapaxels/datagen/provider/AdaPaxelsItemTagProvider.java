package com.brand.adapaxels.datagen.provider;

import com.brand.adapaxels.content.paxels.Paxels;
import com.brand.adapaxels.tags.APItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class AdaPaxelsItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public AdaPaxelsItemTagProvider(FabricPackOutput dataGenerator, CompletableFuture<HolderLookup.Provider> completableFuture, FabricTagsProvider.BlockTagsProvider blockTags) {
        super(dataGenerator, completableFuture, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.valueLookupBuilder(APItemTags.PAXELS)
                .add(Paxels.WOOD)
                .add(Paxels.STONE)
                .add(Paxels.COPPER)
                .add(Paxels.IRON)
                .add(Paxels.GOLDEN)
                .add(Paxels.DIAMOND)
                .add(Paxels.NETHERITE)

                .addOptional(Paxels.VIBRANIUM)
                .addOptional(Paxels.ADAMANTIUM)
                .addOptional(Paxels.NETHER_BRICK)

                .addOptional(Paxels.BRONZE)
                .addOptional(Paxels.RUBY)
                .addOptional(Paxels.SAPPHIRE)
                .addOptional(Paxels.PERIDOT)
                .addOptional(Paxels.ENDERITE)
                .addOptional(Paxels.DRAGON);

        this.valueLookupBuilder(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dragonloot", "explosion_resistant")))
                .addOptional(Paxels.DRAGON);

        this.valueLookupBuilder(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("enderitemod", "enderite_tools")))
                .addOptional(Paxels.ENDERITE);

        this.valueLookupBuilder(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("enderitemod", "enderite_items")))
                .addOptional(Paxels.ENDERITE);

        this.valueLookupBuilder(ItemTags.AXES)
                .addTag(APItemTags.PAXELS);

        this.valueLookupBuilder(ItemTags.PICKAXES)
                .addTag(APItemTags.PAXELS);

        this.valueLookupBuilder(ItemTags.SHOVELS)
                .addTag(APItemTags.PAXELS);

        this.valueLookupBuilder(ItemTags.HOES)
                .addTag(APItemTags.PAXELS);

        this.valueLookupBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES)
                .addTag(APItemTags.PAXELS);

        this.valueLookupBuilder(ItemTags.PIGLIN_LOVED)
                .add(Paxels.GOLDEN);

        this.valueLookupBuilder(APItemTags.NETHER_BRICK_TOOL_MATERIALS)
                .add(Items.NETHER_BRICK);
    }
}
