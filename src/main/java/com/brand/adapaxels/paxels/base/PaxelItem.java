package com.brand.adapaxels.paxels.base;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.brand.adapaxels.mixin.AxeItemAccessor;
import com.brand.adapaxels.mixin.ShovelItemAccessor;
import com.google.common.collect.ImmutableMap.Builder;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class PaxelItem extends MiningToolItem {
	   private static final Set<Block> EFFECTIVE_BLOCKS;
	   private static final Set<Material> THESE_MATERIALS;
	   protected static final Map<Block, Block> STRIPPED_BLOCKS;
	   protected static final Map<Block, Block> CRACKED_STONE_BLOCKS;
	   protected static final Map<Block, Block> CRACKED_STONE_SLABS;
	   protected static final Map<Block, BlockState> PATH_BLOCKSTATES;

	   public PaxelItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
	      super((float)attackDamage, attackSpeed, material, EFFECTIVE_BLOCKS, settings);
	   }
	   
	   public boolean isEffectiveOn(BlockState state) {
		      Block block = state.getBlock();
		      int i = this.getMaterial().getMiningLevel();
		      if (!state.isOf(Blocks.OBSIDIAN) && !state.isOf(Blocks.CRYING_OBSIDIAN) && !state.isOf(Blocks.NETHERITE_BLOCK) && !state.isOf(Blocks.RESPAWN_ANCHOR) && !state.isOf(Blocks.ANCIENT_DEBRIS)) {
		          if (!state.isOf(Blocks.DIAMOND_BLOCK) && !state.isOf(Blocks.DIAMOND_ORE) && !state.isOf(Blocks.EMERALD_ORE) && !state.isOf(Blocks.EMERALD_BLOCK) && !state.isOf(Blocks.GOLD_BLOCK) && !state.isOf(Blocks.GOLD_ORE) && !state.isOf(Blocks.REDSTONE_ORE)) {
		             if (!state.isOf(Blocks.IRON_BLOCK) && !state.isOf(Blocks.IRON_ORE) && !state.isOf(Blocks.LAPIS_BLOCK) && !state.isOf(Blocks.LAPIS_ORE)) {
		                Material material = state.getMaterial();
		                return material == Material.STONE || material == Material.METAL || material == Material.REPAIR_STATION || state.isOf(Blocks.NETHER_GOLD_ORE) || block == Blocks.SNOW || block == Blocks.SNOW_BLOCK || block == Blocks.COBWEB;
		            } else {
		               return i >= 1;
		            }
		         } else {
		            return i >= 2;
		         }
		      } else {
		         return i >= 3;
		      }
		   }
	   
	   public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
	      Material material = state.getMaterial();
	      Block block = state.getBlock();
	      if (state.isIn(BlockTags.WOOL)) {
	          return state.isIn(BlockTags.WOOL) ? 10.0F : super.getMiningSpeedMultiplier(stack, state);
	       } else if (state.isIn(BlockTags.LEAVES)) {
		          return state.isIn(BlockTags.LEAVES) ? 10.0F : super.getMiningSpeedMultiplier(stack, state);
	       } else if (block == Blocks.COBWEB) {
		          return block == Blocks.COBWEB ? 200.0F : super.getMiningSpeedMultiplier(stack, state);
	       } else {
	    	   return THESE_MATERIALS.contains(material) ? this.miningSpeed : super.getMiningSpeedMultiplier(stack, state);
	       }
	    }
 
	   
	   public ActionResult useOnBlock(ItemUsageContext context) {
		      World world = context.getWorld();
		      BlockPos blockPos = context.getBlockPos();
		      BlockState blockState = world.getBlockState(blockPos);
		      Block block = (Block)STRIPPED_BLOCKS.get(blockState.getBlock());
		      Block crackblock = (Block)CRACKED_STONE_BLOCKS.get(blockState.getBlock());
		      Block crackslab= (Block)CRACKED_STONE_SLABS.get(blockState.getBlock());
		      if (context.getSide() == Direction.DOWN) {
			         return ActionResult.PASS;
		      } else if (crackslab != null) {
            	  PlayerEntity playerEntity = context.getPlayer();
      	      world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 0.5F, 1.0F);
      	          if (!world.isClient) {
	        	 world.setBlockState(blockPos, crackslab.getDefaultState().with(SlabBlock.TYPE, blockState.get(SlabBlock.TYPE)), 11);
	        	 if (playerEntity != null) {
	                 context.getStack().damage(1, (LivingEntity)playerEntity, (Consumer)((p) -> {
	                    ((LivingEntity) p).sendToolBreakStatus(context.getHand());
	                 }));
	              }
	           }
		      } else if (crackblock != null) {
            	  PlayerEntity playerEntity = context.getPlayer();
      	      world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 0.5F, 1.0F);
      	          if (!world.isClient) {
	        	 world.setBlockState(blockPos, crackblock.getDefaultState(), 11);
	        	 if (playerEntity != null) {
	                 context.getStack().damage(1, (LivingEntity)playerEntity, (Consumer)((p) -> {
	                    ((LivingEntity) p).sendToolBreakStatus(context.getHand());
	                 }));
	              }
	           }
	         } else if (block != null) {
            	 PlayerEntity playerEntity = context.getPlayer();
	         world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
	         if (!world.isClient) {
	        	 world.setBlockState(blockPos, (BlockState)block.getDefaultState().with(PillarBlock.AXIS, blockState.get(PillarBlock.AXIS)), 11);
	        	 if (playerEntity != null) {
	                 context.getStack().damage(1, (LivingEntity)playerEntity, (Consumer)((p) -> {
	                    ((LivingEntity) p).sendToolBreakStatus(context.getHand());
	                 }));
	              }
	           }
	         } else if (context.getSide() == Direction.DOWN) {
		         return ActionResult.PASS;
		      } else {
		         PlayerEntity playerEntity = context.getPlayer();
		         BlockState blockState2 = (BlockState)PATH_BLOCKSTATES.get(blockState.getBlock());
		         BlockState blockState3 = null;
		         if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
		            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
		            blockState3 = blockState2;
		         } else if (blockState.getBlock() instanceof CampfireBlock && (Boolean)blockState.get(CampfireBlock.LIT)) {
		            world.syncWorldEvent((PlayerEntity)null, 1009, blockPos, 0);
		            blockState3 = (BlockState)blockState.with(CampfireBlock.LIT, false);
		         }
		         if (blockState3 != null) {
		            if (!world.isClient) {
		               world.setBlockState(blockPos, blockState3, 11);
		               if (playerEntity != null) {
		                  context.getStack().damage(1, (LivingEntity)playerEntity, (Consumer)((p) -> {
		                     ((LivingEntity) p).sendToolBreakStatus(context.getHand());
		                  }));
		               }
		            }

		            return ActionResult.SUCCESS;
		         } else {
		            return ActionResult.PASS;
		         }
		      }
		    return ActionResult.SUCCESS;
		   }

		   static {
	      EFFECTIVE_BLOCKS = ImmutableSet.of(
	    		  
          // pickaxe
	    		             Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, new Block[]{Blocks.POWERED_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.NETHER_GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.GRANITE, Blocks.POLISHED_GRANITE, Blocks.DIORITE, Blocks.POLISHED_DIORITE, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, Blocks.STONE_SLAB, Blocks.SMOOTH_STONE_SLAB, Blocks.SANDSTONE_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.BRICK_SLAB, Blocks.STONE_BRICK_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.QUARTZ_SLAB, Blocks.RED_SANDSTONE_SLAB, Blocks.PURPUR_SLAB, Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_STONE, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, Blocks.POLISHED_GRANITE_SLAB, Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.POLISHED_DIORITE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.END_STONE_BRICK_SLAB, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_QUARTZ_SLAB, Blocks.GRANITE_SLAB, Blocks.ANDESITE_SLAB, Blocks.RED_NETHER_BRICK_SLAB, Blocks.POLISHED_ANDESITE_SLAB, Blocks.DIORITE_SLAB, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.PISTON, Blocks.STICKY_PISTON, Blocks.PISTON_HEAD,
	      // shovel           		 
	    	    		     Blocks.CLAY, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.FARMLAND, Blocks.GRASS_BLOCK, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.RED_SAND, Blocks.SNOW_BLOCK, Blocks.SNOW, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.WHITE_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER, Blocks.SOUL_SOIL,	
	      // axe		             
	    	    		     Blocks.LADDER, Blocks.SCAFFOLDING, Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON, Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.ACACIA_BUTTON, Blocks.CRIMSON_BUTTON, Blocks.WARPED_BUTTON,
	      // hoe
	    		             Blocks.NETHER_WART_BLOCK, Blocks.WARPED_WART_BLOCK, Blocks.HAY_BLOCK, Blocks.DRIED_KELP_BLOCK, Blocks.TARGET, Blocks.SHROOMLIGHT, Blocks.SPONGE, Blocks.WET_SPONGE
	    		  });
	      
	      THESE_MATERIALS = Sets.newHashSet(new Material[]{
	    		             Material.METAL, Material.REPAIR_STATION, Material.STONE,                                   
	    		             Material.WOOD, Material.NETHER_WOOD, Material.PLANT, Material.REPLACEABLE_PLANT, Material.BAMBOO, Material.GOURD
	    		  });
	      
	      STRIPPED_BLOCKS = AxeItemAccessor.getStrippedBlocks();
	      CRACKED_STONE_BLOCKS = (new Builder()).put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS).put(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS).put(Blocks.CUT_SANDSTONE, Blocks.SANDSTONE).put(Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE).put(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS).build();
	      CRACKED_STONE_SLABS = (new Builder()).put(Blocks.CUT_SANDSTONE_SLAB, Blocks.SANDSTONE_SLAB).put(Blocks.CUT_RED_SANDSTONE_SLAB, Blocks.RED_SANDSTONE_SLAB).build();
	      PATH_BLOCKSTATES = ShovelItemAccessor.getEffectiveBlocks();
	   }
	}