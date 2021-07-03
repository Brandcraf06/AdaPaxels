package com.brand.adapaxels;

import com.brand.adapaxels.mixin.AxeItemAccessor;
import com.brand.adapaxels.mixin.ShovelItemAccessor;
import com.brand.adapaxels.paxels.Paxels;
import com.brand.adapaxels.paxels.base.PaxelItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdaPaxels implements ModInitializer {

    public static final String MOD_ID = "adapaxels";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup ADAPAXELS_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "adapaxels_group"), () -> new ItemStack(Paxels.NETHERITE));

    @Override
    public void onInitialize() {
        new Paxels();
        Paxels.init();
    }
}

