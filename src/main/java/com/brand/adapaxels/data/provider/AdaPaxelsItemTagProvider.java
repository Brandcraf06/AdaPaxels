package com.brand.adapaxels.data.provider;

import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.content.paxels.Paxels;
import com.brand.adapaxels.utils.APItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class AdaPaxelsItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public AdaPaxelsItemTagProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, FabricTagProvider.BlockTagProvider blockTags) {
        super(dataGenerator, completableFuture, blockTags);
    }

    private FabricTagBuilder getOrCreateTagBuilder(Identifier id) {
        TagKey<Item> tag = TagKey.of(RegistryKeys.ITEM, id);
        return this.getOrCreateTagBuilder(tag);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
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

                .addOptional(moddedPaxel("tin"))
                .addOptional(moddedPaxel("steel"))
                .addOptional(moddedPaxel("silver"))
                .addOptional(moddedPaxel("lead"))
                .addOptional(moddedPaxel("copper"))
                .addOptional(moddedPaxel("bronze"))

                .addOptional(moddedPaxel("certus_quartz"))
                .addOptional(moddedPaxel("nether_quartz"))

                .addOptional(moddedPaxel("tech_reborn_bronze"))
                .addOptional(moddedPaxel("ruby"))
                .addOptional(moddedPaxel("sapphire"))
                .addOptional(moddedPaxel("peridot"))

                .addOptional(moddedPaxel("pendorite"))

                .addOptional(moddedPaxel("enderite"))

                .addOptional(moddedPaxel("dragon"))

                .addOptional(moddedPaxel("gilded_netherite"))
                .addOptional(moddedPaxel("rose_gold"));

        this.getOrCreateTagBuilder(new Identifier("dragonloot", "explosion_resistant"))
                .addOptional(moddedPaxel("dragon"));

        this.getOrCreateTagBuilder(new Identifier("enderitemod", "enderite_items"))
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
                .add(Paxels.GOLDEN)
                .addOptional(moddedPaxel("gilded_netherite"));
    }

    private Identifier moddedPaxel(String material) {
        return AdaPaxels.id(material + "_paxel");
    }
}
