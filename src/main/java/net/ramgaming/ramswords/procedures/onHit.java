package net.ramgaming.ramswords.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import static net.minecraft.util.Hand.MAIN_HAND;

public class onHit {
    public static TypedActionResult<ItemStack> Identify(PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
       /* if (!world.isClient()) {
          if(player.getStackInHand(MAIN_HAND) == )
        }*/
        return null;
    }
    private static TypedActionResult<ItemStack> PrismareResponse(PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
        return null;
    }
}
