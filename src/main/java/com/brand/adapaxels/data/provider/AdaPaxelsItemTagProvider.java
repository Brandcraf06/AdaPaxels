package com.brand.adapaxels.data.provider;

import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.paxels.Paxels;
import com.brand.adapaxels.utils.APItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.item.Item;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AdaPaxelsItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public AdaPaxelsItemTagProvider(FabricDataGenerator dataGenerator, FabricTagProvider.BlockTagProvider blockTags) {
        super(dataGenerator, blockTags);
    }

    private FabricTagBuilder<Item> getOrCreateTagBuilder(Identifier id) {
        TagKey<Item> tag = TagKey.of(Registry.ITEM_KEY, id);
        return this.getOrCreateTagBuilder(tag);
    }

    @Override
    protected void generateTags() {

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
