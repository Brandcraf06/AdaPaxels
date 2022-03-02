package com.brand.adapaxels.data.provider;

import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.paxels.Paxels;
import com.brand.adapaxels.utils.APItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.util.Identifier;

public class AdaPaxelsItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public AdaPaxelsItemTagProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
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
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "vibranium_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "adamantium_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "nether_paxel"))

                .addOptional(new Identifier(AdaPaxels.MOD_ID, "tin_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "steel_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "silver_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "lead_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "copper_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "bronze_paxel"))

                .addOptional(new Identifier(AdaPaxels.MOD_ID, "certus_quartz_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "nether_quartz_paxel"))

                .addOptional(new Identifier(AdaPaxels.MOD_ID, "tech_reborn_bronze_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "ruby_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "sapphire_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "peridot_paxel"))

                .addOptional(new Identifier(AdaPaxels.MOD_ID, "pendorite_paxel"))

                .addOptional(new Identifier(AdaPaxels.MOD_ID, "enderite_paxel"))
                .addOptional(new Identifier(AdaPaxels.MOD_ID, "dragon_paxel"));

    }
}
