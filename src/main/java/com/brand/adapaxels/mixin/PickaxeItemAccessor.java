package com.brand.adapaxels.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.Block;
import net.minecraft.item.PickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;


@Mixin(PickaxeItem.class)
public interface PickaxeItemAccessor {
	
    @Accessor("BLOCK_MINING_LEVELS")
    static Object2IntMap<Block> getBlockMiningLevels() {
        return null;
    }

    @Accessor("EFFECTIVE_BLOCKS")
    static Set<Block> getEffectiveBlocks() {
        return null;
    }
}
