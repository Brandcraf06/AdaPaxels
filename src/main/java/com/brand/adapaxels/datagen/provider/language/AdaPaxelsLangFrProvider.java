package com.brand.adapaxels.datagen.provider.language;

import com.brand.adapaxels.content.AdapaxelsItemGroup;
import com.brand.adapaxels.content.AdapaxelsItems;
import com.brand.adapaxels.content.paxels.Paxels;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class AdaPaxelsLangFrProvider extends FabricLanguageProvider {
    public AdaPaxelsLangFrProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, "fr_fr", registriesFuture);
    }

    public static void addPaxel(TranslationBuilder translationBuilder, Item item, String prep, String string) {
        translationBuilder.add(item, "Piachelle " + prep + " " + string);
    }

    public static void addPaxel(TranslationBuilder translationBuilder, Item item, String string) {
        addPaxel(translationBuilder, item, "en", string);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registriesFuture, TranslationBuilder translationBuilder) {

        translationBuilder.add(AdapaxelsItemGroup.ADAPAXELS_GROUP, "Piachelles");
        translationBuilder.add(AdapaxelsItems.STACKED_NETHERITE, "Netherite empilée");
        addPaxel(translationBuilder, Paxels.WOOD, "bois");
        addPaxel(translationBuilder, Paxels.STONE, "pierre");
        addPaxel(translationBuilder, Paxels.IRON, "fer");
        addPaxel(translationBuilder, Paxels.GOLDEN, "or");
        addPaxel(translationBuilder, Paxels.DIAMOND, "diamant");
        addPaxel(translationBuilder, Paxels.NETHERITE, "netherite");
        addPaxel(translationBuilder, Paxels.VIBRANIUM, "vibranium");
        addPaxel(translationBuilder, Paxels.ADAMANTIUM, "adamantium");
        addPaxel(translationBuilder, Paxels.NETHER_BRICK, "du", "Nether");
        addPaxel(translationBuilder, Paxels.BRONZE, "bronze");
        addPaxel(translationBuilder, Paxels.RUBY, "rubis");
        addPaxel(translationBuilder, Paxels.SAPPHIRE, "saphir");
        addPaxel(translationBuilder, Paxels.PERIDOT, "péridot");
        addPaxel(translationBuilder, Paxels.ENDERITE, "enderite");
        addPaxel(translationBuilder, Paxels.DRAGON, "du", "dragon");
        addPaxel(translationBuilder, Paxels.ROSE_GOLD, "Or de Rose");
    }
}
