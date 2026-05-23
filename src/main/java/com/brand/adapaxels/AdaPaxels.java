package com.brand.adapaxels;

import com.brand.adapaxels.content.AdapaxelsItemGroup;
import com.brand.adapaxels.content.AdapaxelsItems;
import com.brand.adapaxels.content.paxels.Paxels;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdaPaxels implements ModInitializer {

    public static final String MOD_ID = "adapaxels";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        new Paxels();
        Paxels.init();
        new AdapaxelsItems();
        AdapaxelsItems.init();
        AdapaxelsItemGroup.init();

    }

    public static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }
}
