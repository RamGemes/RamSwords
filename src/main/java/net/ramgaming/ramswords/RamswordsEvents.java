package net.ramgaming.ramswords;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.ramgaming.ramswords.block.custom.BlazePowderCauldronBlock;
import net.ramgaming.ramswords.item.ModItems;
import net.ramgaming.ramswords.procedures.onHit;

import java.util.Collection;

public class RamswordsEvents {
    public static void onInitialize() {
    AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
        if (!world.isClient()) {
            player.sendMessage(Text.literal("EVENT!"));
            onHit.Identify(player, world, hand, entity, hitResult);}
            return ActionResult.PASS;

    });
        UseBlockCallback.EVENT.register((player,world,hand,hitResult)-> {

            if (!world.isClient() && hand == Hand.MAIN_HAND) {}
        return ActionResult.PASS;
        });
    }
}
