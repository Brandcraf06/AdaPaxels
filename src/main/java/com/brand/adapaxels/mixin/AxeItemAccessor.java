package com.brand.adapaxels.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.AxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import java.util.Set;

@Mixin(AxeItem.class)
public interface AxeItemAccessor {

    @Accessor("EFFECTIVE_MATERIALS")
    static Set<Material> getEffectiveMaterials() {
        return null;
    }

    @Accessor("EFFECTIVE_BLOCKS")
    static Set<Block> getEffectiveBlocks() {
        return null;
    }

    @Accessor("STRIPPED_BLOCKS")
    static Map<Block, Block> getStrippedBlocks() {
        return null;
    }
}
