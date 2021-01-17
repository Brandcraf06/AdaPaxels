package com.brand.adapaxels.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.Block;
import net.minecraft.item.PickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;


@Mixin(PickaxeItem.class)
public interface PickaxeItemAccessor {
    @Accessor("BLOCK_MINING_LEVELS")
    static Object2IntMap<Block> getEffectiveBlocks() {
        return null;
    }
}
