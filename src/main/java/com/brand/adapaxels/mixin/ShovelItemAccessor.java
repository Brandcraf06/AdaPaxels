package com.brand.adapaxels.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ShovelItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(ShovelItem.class)
public interface ShovelItemAccessor {
	@Accessor("PATH_STATES")
	public static Map<Block, BlockState> getEffectiveBlocks() {
		return null;
	}
}
