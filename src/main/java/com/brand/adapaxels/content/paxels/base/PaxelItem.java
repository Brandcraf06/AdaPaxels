package com.brand.adapaxels.content.paxels.base;

import com.brand.adapaxels.tags.APBlockTags;
import com.google.common.collect.BiMap;
import net.fabricmc.fabric.mixin.content.registry.AxeItemAccessor;
import net.fabricmc.fabric.mixin.content.registry.ShovelItemAccessor;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

@SuppressWarnings({"rawtypes"})
public class PaxelItem extends DiggerItem {
    public final String materialName;
    public static final Map<Block, BlockState> FLATTENABLES;
    public static final Map<Block, Block> STRIPPABLES;

    public PaxelItem(Tier tier, Item.Properties properties, String materialName) {
        super(tier, APBlockTags.MINEABLE_WITH_PAXEL, properties);
        this.materialName = materialName;
    }

    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Player player = context.getPlayer();

        if (playerHasShieldUseIntent(context)) {
            return InteractionResult.PASS;
        }

        if (stripBlock(context, level, blockPos, player)) {
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        if (context.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        }

        if (flattenOrExtinguishBlock(context, level, blockPos, player)) {
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    private boolean stripBlock(UseOnContext context, Level level, BlockPos blockPos, Player player) {
        Optional<BlockState> optional = this.evaluateNewBlockState(level, blockPos, player, level.getBlockState(blockPos));
        if (optional.isPresent()) {
            ItemStack itemInHand = context.getItemInHand();
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockPos, itemInHand);
            }

            BlockState newState = optional.get();
            level.setBlock(blockPos, newState, 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, newState));

            if (player != null) {
                itemInHand.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
            }

            return true;
        }
        return false;
    }

    private boolean flattenOrExtinguishBlock(UseOnContext context, Level level, BlockPos blockPos, Player player) {
        BlockState blockState = level.getBlockState(blockPos);
        BlockState blockState2 = FLATTENABLES.get(blockState.getBlock());

        if (blockState2 != null && level.getBlockState(blockPos.above()).isAir()) {
            level.playSound(player, blockPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
            updateBlockState(level, blockPos, blockState2, player, context);
            return true;
        }

        if (blockState.getBlock() instanceof CampfireBlock && blockState.getValue(CampfireBlock.LIT)) {
            if (!level.isClientSide()) {
                level.levelEvent(null, 1009, blockPos, 0);
            }
            CampfireBlock.dowse(context.getPlayer(), level, blockPos, blockState);
            BlockState blockState3 = blockState.setValue(CampfireBlock.LIT, false);
            updateBlockState(level, blockPos, blockState3, player, context);
            return true;
        }

        return false;
    }

    private void updateBlockState(Level level, BlockPos blockPos, BlockState newState, Player player, UseOnContext context) {
        level.setBlock(blockPos, newState, 11);
        level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, newState));
        if (player != null) {
            context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
        }
    }

    private static boolean playerHasShieldUseIntent(UseOnContext context) {
        Player player = context.getPlayer();
        return context.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
    }

    private Optional<BlockState> evaluateNewBlockState(Level level, BlockPos blockPos, @Nullable Player player, BlockState blockState) {
        Optional<BlockState> optional = this.getStripped(blockState);
        if (optional.isPresent()) {
            level.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else {
            Optional<BlockState> optional2 = WeatheringCopper.getPrevious(blockState);
            if (optional2.isPresent()) {
                level.playSound(player, blockPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, blockPos, 0);
                return optional2;
            } else {
                Optional<BlockState> optional3 = Optional.ofNullable((Block) ((BiMap) HoneycombItem.WAX_OFF_BY_BLOCK.get()).get(blockState.getBlock())).map((block) -> block.withPropertiesOf(blockState));
                if (optional3.isPresent()) {
                    level.playSound(player, blockPos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.levelEvent(player, 3004, blockPos, 0);
                    return optional3;
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    private Optional<BlockState> getStripped(BlockState blockState) {
        return Optional.ofNullable(STRIPPABLES.get(blockState.getBlock())).map((block) -> block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, blockState.getValue(RotatedPillarBlock.AXIS)));
    }

    static {
        FLATTENABLES = ShovelItemAccessor.getPathStates();
        STRIPPABLES = AxeItemAccessor.getStrippedBlocks();
    }
}