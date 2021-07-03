package com.brand.adapaxels.utils;

import com.brand.adapaxels.AdaPaxels;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class APBlockTags {
    public static final Tag<Block> PAXEL_MINEABLE = TagRegistry.block(new Identifier(AdaPaxels.MOD_ID, "mineable/paxel"));
}
