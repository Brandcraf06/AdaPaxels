package com.brand.adapaxels.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.PickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import it.unimi.dsi.fastutil.objects.Object2IntMap;


@Mixin(PickaxeItem.class)
public interface PickaxeItemAccessor {
	@Accessor("field_27078")
	public static Object2IntMap<Block> getEffectiveBlocks() {
		return null;
	}
}
