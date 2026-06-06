package com.brand.adapaxels.datagen.provider.language;

import com.brand.adapaxels.content.AdapaxelsItemGroup;
import com.brand.adapaxels.content.AdapaxelsItems;
import com.brand.adapaxels.content.paxels.Paxels;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class AdaPaxelsLangEnProvider extends FabricLanguageProvider {
    public AdaPaxelsLangEnProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void addPaxel(TranslationBuilder translationBuilder, Item item, String string) {
        translationBuilder.add(item, string + " Paxel");
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registriesFuture, TranslationBuilder translationBuilder) {

        translationBuilder.add(AdapaxelsItemGroup.ADAPAXELS_GROUP, "Paxels");
        translationBuilder.add(AdapaxelsItems.STACKED_NETHERITE, "Stacked Netherite");
        addPaxel(translationBuilder, Paxels.WOOD, "Wooden");
        addPaxel(translationBuilder, Paxels.STONE, "Stone");
        addPaxel(translationBuilder, Paxels.COPPER, "Copper");
        addPaxel(translationBuilder, Paxels.IRON, "Iron");
        addPaxel(translationBuilder, Paxels.GOLDEN, "Golden");
        addPaxel(translationBuilder, Paxels.DIAMOND, "Diamond");
        addPaxel(translationBuilder, Paxels.NETHERITE, "Netherite");
        addPaxel(translationBuilder, Paxels.VIBRANIUM, "Vibranium");
        addPaxel(translationBuilder, Paxels.ADAMANTIUM, "Adamantium");
        addPaxel(translationBuilder, Paxels.NETHER_BRICK, "Nether");
        addPaxel(translationBuilder, Paxels.BRONZE, "Bronze");
        addPaxel(translationBuilder, Paxels.RUBY, "Ruby");
        addPaxel(translationBuilder, Paxels.SAPPHIRE, "Sapphire");
        addPaxel(translationBuilder, Paxels.PERIDOT, "Peridot");
        addPaxel(translationBuilder, Paxels.ENDERITE, "Enderite");
        addPaxel(translationBuilder, Paxels.DRAGON, "Dragon");

    }
}
