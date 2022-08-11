package net.ramgaming.ramswords.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.ramgaming.ramswords.item.ModItems;

public class BlazePowderCauldronBlock extends Block {
    public static final IntProperty VALUE = IntProperty.of("value",1,3);
    public BlazePowderCauldronBlock(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {

        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            player.sendMessage(Text.literal("CALLBACK!"));
            if(world.getBlockState(hitResult.getBlockPos()).getBlock() == Blocks.CAULDRON) {
                player.sendMessage(Text.literal("blazing..."));
                if(player.getStackInHand(Hand.MAIN_HAND).getItem() == Items.BLAZE_POWDER) {
                    int VALUE  = world.getBlockState(hitResult.getBlockPos()).get(BlazePowderCauldronBlock.VALUE);
                    if(VALUE < 3) {
                        BlockState block_buffer = world.getBlockState(hitResult.getBlockPos());
                        if(Math.random() <= 0.25) {block_buffer.with(BlazePowderCauldronBlock.VALUE,VALUE+1);}
                        world.setBlockState(hitResult.getBlockPos(),block_buffer);
                        ItemStack buffer_item = player.getStackInHand(Hand.MAIN_HAND);
                        if (buffer_item.getCount() > 1) {buffer_item.setCount(buffer_item.getCount()-1);} else {buffer_item = Items.AIR.getDefaultStack();}

                        player.setStackInHand(Hand.MAIN_HAND,buffer_item);
                    }
                }
                if(player.getStackInHand(Hand.MAIN_HAND).getItem() == ModItems.WARPED_SWORD) {
                    player.sendMessage(Text.literal("swording..."));
                    int VALUE  = world.getBlockState(hitResult.getBlockPos()).get(BlazePowderCauldronBlock.VALUE);
                    if(VALUE == 3) {
                        world.setBlockState(hitResult.getBlockPos(),Blocks.CAULDRON.getDefaultState());
                        ItemStack buffer_item = ModItems.DIPPED_WARPED_SWORD.getDefaultStack();
                        /**if(player.getStackInHand(Hand.MAIN_HAND).hasCustomName()) {
                         buffer_item.setCustomName(player.getStackInHand(Hand.MAIN_HAND).getName());
                         }**/
                        if(player.getStackInHand(Hand.MAIN_HAND).hasNbt()) {
                            buffer_item.setNbt(player.getStackInHand(Hand.MAIN_HAND).getNbt());
                        }
                        player.setStackInHand(Hand.MAIN_HAND,buffer_item);

                    }
                }
            }
        }

        return super.onUse(state, world, pos, player, hand, hitResult);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VALUE);
    }
}
