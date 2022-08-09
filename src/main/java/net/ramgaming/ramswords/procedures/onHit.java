package net.ramgaming.ramswords.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.ramgaming.ramswords.item.ModItems;

import static net.minecraft.util.Hand.MAIN_HAND;

public class onHit {
    public static void Identify(PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
        if (!world.isClient()) {
          if(player.getStackInHand(MAIN_HAND).getItem() == ModItems.PRISMARE_SWORD) {
              PrismareResponse(player, world, hand, entity, hitResult);
          }
        }
    }
    private static void PrismareResponse(PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
        ItemStack ITEM = player.getStackInHand(MAIN_HAND);
        NbtCompound NBT = ITEM.getOrCreateNbt();
        while (NBT == null) {NBT = ITEM.getOrCreateNbt();}
        String target = NBT.getString("target");
        double value = NBT.getDouble("value");
        if (entity.getUuidAsString().equals(target)) {} else {NBT.putString("target",entity.getUuidAsString());}


    }
}
