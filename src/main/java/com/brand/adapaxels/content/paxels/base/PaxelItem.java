package com.brand.adapaxels.content.paxels.base;

import com.brand.adapaxels.tags.APBlockTags;
import com.google.common.collect.BiMap;
import net.fabricmc.fabric.mixin.content.registry.AxeItemAccessor;
import net.fabricmc.fabric.mixin.content.registry.ShovelItemAccessor;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Map;
import java.util.Optional;

public class PaxelItem extends Item {
    public static final Map<Block, BlockState> FLATTENABLES;
    public static final Map<Block, Block> STRIPPABLES;

    public PaxelItem(final ToolMaterial material, final float attackDamageBaseline, final float attackSpeedBaseline, final Item.Properties properties) {
        super(properties.tool(material, APBlockTags.MINEABLE_WITH_PAXEL, attackDamageBaseline, attackSpeedBaseline, 0.0F));
    }

    public InteractionResult useOn(final UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        if (playerHasBlockingItemUseIntent(context)) {
            return InteractionResult.PASS;
        }

        if (stripBlock(context, level, pos, player)) {
            return InteractionResult.SUCCESS;
        }

        if (context.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        }

        if (flattenOrExtinguishBlock(context, level, pos, player)) {
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private boolean stripBlock(UseOnContext context, Level level, BlockPos pos, Player player) {
        Optional<BlockState> newBlock = this.evaluateNewBlockState(level, pos, player, level.getBlockState(pos));
        if (newBlock.isEmpty()) {
            return false;
        } else {
            ItemStack itemInHand = context.getItemInHand();
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, itemInHand);
            }

            level.setBlock(pos, newBlock.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newBlock.get()));
            if (player != null) {
                itemInHand.hurtAndBreak(1, player, context.getHand().asEquipmentSlot());
            }

            return true;
        }
    }

    private boolean flattenOrExtinguishBlock(UseOnContext context, Level level, BlockPos pos, Player player) {
        BlockState blockState = level.getBlockState(pos);
        BlockState newState = FLATTENABLES.get(blockState.getBlock());
        BlockState updatedState = null;
        if (newState != null && level.getBlockState(pos.above()).isAir()) {
            level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
            updatedState = newState;
        } else if (blockState.getBlock() instanceof CampfireBlock && blockState.getValue(CampfireBlock.LIT)) {
            if (!level.isClientSide()) {
                level.levelEvent(null, 1009, pos, 0);
            }

            CampfireBlock.dowse(context.getPlayer(), level, pos, blockState);
            updatedState = blockState.setValue(CampfireBlock.LIT, false);
        }

        if (updatedState != null) {
            if (!level.isClientSide()) {
                level.setBlock(pos, updatedState, 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, updatedState));
                if (player != null) {
                    context.getItemInHand().hurtAndBreak(1, player, context.getHand().asEquipmentSlot());
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private static boolean playerHasBlockingItemUseIntent(final UseOnContext context) {
        Player player = context.getPlayer();
        return context.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().has(DataComponents.BLOCKS_ATTACKS) && !player.isSecondaryUseActive();
    }

    private Optional<BlockState> evaluateNewBlockState(final Level level, final BlockPos pos, final @org.jspecify.annotations.Nullable Player player, final BlockState oldState) {
        Optional<BlockState> strippedBlock = this.getStripped(oldState);
        if (strippedBlock.isPresent()) {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return strippedBlock;
        } else {
            Optional<BlockState> scrapedBlock = WeatheringCopper.getPrevious(oldState);
            if (scrapedBlock.isPresent()) {
                spawnSoundAndParticle(level, pos, player, oldState, SoundEvents.AXE_SCRAPE, 3005);
                return scrapedBlock;
            } else {
                Optional<BlockState> waxoffBlock = Optional.ofNullable((Block) ((BiMap) HoneycombItem.WAX_OFF_BY_BLOCK.get()).get(oldState.getBlock())).map((b) -> b.withPropertiesOf(oldState));
                if (waxoffBlock.isPresent()) {
                    spawnSoundAndParticle(level, pos, player, oldState, SoundEvents.AXE_WAX_OFF, 3004);
                    return waxoffBlock;
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    private static void spawnSoundAndParticle(final Level level, final BlockPos pos, final @org.jspecify.annotations.Nullable Player player, final BlockState oldState, final SoundEvent soundEvent, final int particle) {
        level.playSound(player, pos, soundEvent, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.levelEvent(player, particle, pos, 0);
        if (oldState.getBlock() instanceof ChestBlock && oldState.getValue(ChestBlock.TYPE) != ChestType.SINGLE) {
            BlockPos neighborPos = ChestBlock.getConnectedBlockPos(pos, oldState);
            level.gameEvent(GameEvent.BLOCK_CHANGE, neighborPos, GameEvent.Context.of(player, level.getBlockState(neighborPos)));
            level.levelEvent(player, particle, neighborPos, 0);
        }

    }

    private Optional<BlockState> getStripped(final BlockState state) {
        return Optional.ofNullable(STRIPPABLES.get(state.getBlock())).map((block) -> block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)));
    }

    static {
        STRIPPABLES = AxeItemAccessor.getStrippables();
        FLATTENABLES = ShovelItemAccessor.getFlattenables();
    }
}