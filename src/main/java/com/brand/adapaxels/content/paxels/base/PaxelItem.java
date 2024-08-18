package com.brand.adapaxels.content.paxels.base;

import com.brand.adapaxels.tags.APBlockTags;
import com.google.common.collect.BiMap;
import net.fabricmc.fabric.mixin.content.registry.ShovelItemAccessor;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

@SuppressWarnings({"rawtypes"})
public class PaxelItem extends MiningToolItem {
    private final String materialName;
    private static final Map<Block, BlockState> PATH_STATES;

    public PaxelItem(ToolMaterial material, Item.Settings settings, String materialName) {
        super(material, APBlockTags.PAXEL_MINEABLE, settings);
        this.materialName = materialName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();

        if (shouldCancelStripAttempt(context)) {
            return ActionResult.PASS;
        }

        if (stripBlock(context, world, blockPos, playerEntity)) {
            return ActionResult.success(world.isClient);
        }

        if (context.getSide() == Direction.DOWN) {
            return ActionResult.PASS;
        }

        if (flattenOrExtinguishBlock(context, world, blockPos, playerEntity)) {
            return ActionResult.success(world.isClient);
        }

        return ActionResult.PASS;
    }

    private boolean stripBlock(ItemUsageContext context, World world, BlockPos blockPos, PlayerEntity playerEntity) {
        Optional<BlockState> optional = this.tryStrip(world, blockPos, playerEntity, world.getBlockState(blockPos));
        if (optional.isPresent()) {
            ItemStack itemStack = context.getStack();
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
            }

            BlockState newState = optional.get();
            world.setBlockState(blockPos, newState, 11);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, newState));

            if (playerEntity != null) {
                itemStack.damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
            }

            return true;
        }
        return false;
    }

    private boolean flattenOrExtinguishBlock(ItemUsageContext context, World world, BlockPos blockPos, PlayerEntity playerEntity) {
        BlockState blockState = world.getBlockState(blockPos);
        BlockState blockState2 = PATH_STATES.get(blockState.getBlock());

        if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
            updateBlockState(world, blockPos, blockState2, playerEntity, context);
            return true;
        }

        if (blockState.getBlock() instanceof CampfireBlock && blockState.get(CampfireBlock.LIT)) {
            if (!world.isClient()) {
                world.syncWorldEvent(null, 1009, blockPos, 0);
            }
            CampfireBlock.extinguish(context.getPlayer(), world, blockPos, blockState);
            BlockState blockState3 = blockState.with(CampfireBlock.LIT, false);
            updateBlockState(world, blockPos, blockState3, playerEntity, context);
            return true;
        }

        return false;
    }

    private void updateBlockState(World world, BlockPos blockPos, BlockState newState, PlayerEntity playerEntity, ItemUsageContext context) {
        world.setBlockState(blockPos, newState, 11);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, newState));
        if (playerEntity != null) {
            context.getStack().damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
        }
    }

    private static boolean shouldCancelStripAttempt(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        return context.getHand().equals(Hand.MAIN_HAND) && playerEntity.getOffHandStack().isOf(Items.SHIELD) && !playerEntity.shouldCancelInteraction();
    }

    private Optional<BlockState> tryStrip(World world, BlockPos pos, @Nullable PlayerEntity player, BlockState state) {
        Optional<BlockState> optional = this.getStrippedState(state);
        if (optional.isPresent()) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else {
            Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(state);
            if (optional2.isPresent()) {
                world.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.syncWorldEvent(player, 3005, pos, 0);
                return optional2;
            } else {
                Optional<BlockState> optional3 = Optional.ofNullable((Block) ((BiMap) HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get()).get(state.getBlock())).map((block) -> block.getStateWithProperties(state));
                if (optional3.isPresent()) {
                    world.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    world.syncWorldEvent(player, 3004, pos, 0);
                    return optional3;
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable(AxeItem.STRIPPED_BLOCKS.get(state.getBlock())).map((block) -> block.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
    }

    static {
        PATH_STATES = ShovelItemAccessor.getPathStates();
    }
}