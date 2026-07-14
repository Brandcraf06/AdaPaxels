package com.brand.adapaxels.content;

import com.brand.adapaxels.AdaPaxels;
import com.brand.adapaxels.content.paxels.Paxels;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AdapaxelsItemGroup {
    public static final ResourceKey<CreativeModeTab> ADAPAXELS_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB, AdaPaxels.id("adapaxels_group"));

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ADAPAXELS_GROUP, FabricItemGroup.builder()
                .title(Component.translatable("itemGroup.adapaxels.adapaxels_group"))
                .icon(() -> new ItemStack(Paxels.DIAMOND))
                .build()
        );
    }
}
