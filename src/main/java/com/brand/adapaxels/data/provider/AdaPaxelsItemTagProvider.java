package com.brand.adapaxels.data.provider;

import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.paxels.Paxels;
import com.brand.adapaxels.utils.APItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
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
                .addOptional(AdaPaxels.id("vibranium_paxel"))
                .addOptional(AdaPaxels.id( "adamantium_paxel"))
                .addOptional(AdaPaxels.id( "nether_paxel"))

                .addOptional(AdaPaxels.id( "tin_paxel"))
                .addOptional(AdaPaxels.id( "steel_paxel"))
                .addOptional(AdaPaxels.id( "silver_paxel"))
                .addOptional(AdaPaxels.id( "lead_paxel"))
                .addOptional(AdaPaxels.id( "copper_paxel"))
                .addOptional(AdaPaxels.id( "bronze_paxel"))

                .addOptional(AdaPaxels.id( "certus_quartz_paxel"))
                .addOptional(AdaPaxels.id( "nether_quartz_paxel"))

                .addOptional(AdaPaxels.id( "tech_reborn_bronze_paxel"))
                .addOptional(AdaPaxels.id( "ruby_paxel"))
                .addOptional(AdaPaxels.id( "sapphire_paxel"))
                .addOptional(AdaPaxels.id( "peridot_paxel"))

                .addOptional(AdaPaxels.id( "pendorite_paxel"))

                .addOptional(AdaPaxels.id( "enderite_paxel"))

                .addOptional(AdaPaxels.id( "dragon_paxel"))

                .addOptional(AdaPaxels.id( "gilded_netherite_paxel"))
                .addOptional(AdaPaxels.id( "rose_gold_paxel"));

        this.getOrCreateTagBuilder(new Identifier("dragonloot", "explosion_resistant"))
                .addOptional(AdaPaxels.id( "dragon_paxel"));

        this.getOrCreateTagBuilder(new Identifier("enderitemod", "enderite_items"))
                .addOptional(AdaPaxels.id( "enderite_paxel"));

        this.getOrCreateTagBuilder(ConventionalItemTags.AXES)
                .addTag(APItemTags.PAXELS);

        this.getOrCreateTagBuilder(ConventionalItemTags.PICKAXES)
                .addTag(APItemTags.PAXELS);

        this.getOrCreateTagBuilder(ConventionalItemTags.SHOVELS)
                .addTag(APItemTags.PAXELS);

        this.getOrCreateTagBuilder(ConventionalItemTags.HOES)
                .addTag(APItemTags.PAXELS);

        this.getOrCreateTagBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES)
                .addTag(APItemTags.PAXELS);

        this.getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
                .add(Paxels.GOLDEN)
                .addOptional(AdaPaxels.id( "gilded_netherite_paxel"));


    }
}
