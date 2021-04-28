package com.brand.adapaxels.paxels.base;

import com.brand.adapaxels.mixin.AxeItemAccessor;
import com.brand.adapaxels.mixin.PickaxeItemAccessor;
import com.brand.adapaxels.mixin.ShovelItemAccessor;
import com.google.common.collect.BiMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings({"rawtypes"})
public class PaxelItem extends MiningToolItem {
    public static Set<Block> EFFECTIVE_BLOCKS = new HashSet<>();
    private static final Object2IntMap<Block> BLOCK_MINING_LEVELS;
    private static final Map<Block, Block> STRIPPED_BLOCKS;
    private static final Map<Block, BlockState> PATH_STATES;
    private static final Set<Material> EFFECTIVE_MATERIALS;

    public PaxelItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, material, EFFECTIVE_BLOCKS, settings);
    }

    public boolean isSuitableFor(BlockState state) {
        Block block = state.getBlock();
        int i = this.getMaterial().getMiningLevel();
        int j = BLOCK_MINING_LEVELS.getInt(state.getBlock());
        if (j != -1) {
            return i >= j;
        } else {
            Material material = state.getMaterial();
            return material == Material.STONE || material == Material.METAL || material == Material.REPAIR_STATION || block == Blocks.SNOW || block == Blocks.SNOW_BLOCK;
        }
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) {
            return 15.0F;
        }
        if (state.isIn(BlockTags.WOOL)) {
            return 10.0F;
        } else {
            Material material = state.getMaterial();
            return (material == Material.METAL || material == Material.REPAIR_STATION || material == Material.STONE || !state.isIn(BlockTags.LEAVES) ||
                    EFFECTIVE_MATERIALS.contains(material) ? this.miningSpeed : super.getMiningSpeedMultiplier(stack, state));
        }
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);
        Optional<BlockState> optional = this.getStrippedState(blockState);
        Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(blockState);
        Optional<BlockState> optional3 = Optional.ofNullable((HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get()).get(blockState.getBlock())).map((block) -> {
            return block.getStateWithProperties(blockState);
        });
        Optional<BlockState> optional4 = Optional.empty();
        if (optional.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            optional4 = optional;
        } else if (optional2.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(playerEntity, 3005, blockPos, 0);
            optional4 = optional2;
        } else if (optional3.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(playerEntity, 3004, blockPos, 0);
            optional4 = optional3;
        }

        if (optional4.isPresent()) {
            world.setBlockState(blockPos, optional4.get(), 11);
            if (playerEntity != null) {
                context.getStack().damage(1, playerEntity, (p) -> {
                    p.sendToolBreakStatus(context.getHand());
                });
            }

            return ActionResult.success(world.isClient);
        }
        if (context.getSide() == Direction.DOWN) {
            return ActionResult.PASS;
        } else {
            BlockState blockState2 = PATH_STATES.get(blockState.getBlock());
            BlockState blockState3 = null;
            if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
                world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                blockState3 = blockState2;
            } else if (blockState.getBlock() instanceof CampfireBlock && blockState.get(CampfireBlock.LIT)) {
                if (!world.isClient()) {
                    world.syncWorldEvent(null, 1009, blockPos, 0);
                }

                CampfireBlock.extinguish(context.getPlayer(), world, blockPos, blockState);
                blockState3 = blockState.with(CampfireBlock.LIT, false);
            }

            if (blockState3 != null) {
                if (!world.isClient) {
                    world.setBlockState(blockPos, blockState3, 11);
                    if (playerEntity != null) {
                        context.getStack().damage(1, playerEntity, (p) -> {
                            p.sendToolBreakStatus(context.getHand());
                        });
                    }
                }

                return ActionResult.success(world.isClient);
            } else {
                return ActionResult.PASS;
            }
        }
    }

    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable(STRIPPED_BLOCKS.get(state.getBlock())).map((block) -> {
            return block.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS));
        });
    }

    static {
        EFFECTIVE_MATERIALS = AxeItemAccessor.getEffectiveMaterials();
        BLOCK_MINING_LEVELS = PickaxeItemAccessor.getBlockMiningLevels();
        STRIPPED_BLOCKS = AxeItemAccessor.getStrippedBlocks();
        PATH_STATES = ShovelItemAccessor.getPathStates();
    }
}