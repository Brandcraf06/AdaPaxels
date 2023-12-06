package com.brand.adapaxels;

import com.brand.adapaxels.content.paxels.Paxels;
import com.brand.adapaxels.content.AdapaxelsItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdaPaxels implements ModInitializer {

    public static final String MOD_ID = "adapaxels";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final RegistryKey<ItemGroup> ADAPAXELS_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "adapaxels_group"));

    @Override
    public void onInitialize() {
        new Paxels();
        Paxels.init();
        new AdapaxelsItems();
    }

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }
}
