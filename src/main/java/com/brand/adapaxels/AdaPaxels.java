package com.brand.adapaxels;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.brand.adapaxels.paxels.Paxels;

public class AdaPaxels implements ModInitializer {
	
	public static final String MOD_ID = "adapaxels";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final ItemGroup ADAPAXELS_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "adapaxels_group"), () -> new ItemStack(Paxels.NETHERITE));
	
	@Override
	public void onInitialize() {
		new Paxels();
		Paxels.init();
		
	}

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}
}

