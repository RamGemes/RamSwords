package net.ramgaming.ramswords.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.ramgaming.ramswords.item.ModItems;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.util.Hand.MAIN_HAND;

public class onHit {
    public static void Identify(@NotNull PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
        player.sendMessage(Text.literal("onHit processing..."));
      if(player.getStackInHand(MAIN_HAND).getItem() == ModItems.PRISMARE_SWORD) {
          PrismareResponse(player, world, hand, entity, hitResult);
      }
        if(player.getStackInHand(MAIN_HAND).getItem() == ModItems.DIPPED_WARPED_SWORD) {
            DippedWarpedResponse(player, world, hand, entity, hitResult);
        }

    }
    private static void PrismareResponse(@NotNull PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
        player.sendMessage(Text.literal("prismare response!"));
        int max = 18; int min = 14;
        ItemStack ITEM = player.getStackInHand(MAIN_HAND);
        NbtCompound NBT = ITEM.getOrCreateNbt();
        while (NBT == null) {NBT = ITEM.getOrCreateNbt();}
        String target = NBT.getString("target");
        double value = NBT.getDouble("beam");
        if (entity.getUuidAsString().equals(target)) {
            double new_value = Math.pow(value,(Math.random()* (max - min) + min)/10);
            entity.damage(DamageSource.player(player),(float)new_value);
            value = new_value;
        } else {target = entity.getUuidAsString();value=1;}
        ITEM.setDamage(ITEM.getDamage()-1);
        NBT.putString("target",target);
        NBT.putDouble("beam",value);
        ITEM.setNbt(NBT);
        player.setStackInHand(MAIN_HAND,ITEM);
    }
    private static void DippedWarpedResponse(@NotNull PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
        entity.setFireTicks(60);
        ItemStack ITEM = player.getStackInHand(MAIN_HAND);
        ITEM.setDamage(ITEM.getDamage()-1);
        player.setStackInHand(MAIN_HAND,ITEM);
    }
}
