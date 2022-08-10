package net.ramgaming.ramswords;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.ramgaming.ramswords.procedures.onHit;

public class RamswordsEvents {
    public static void onInitialize() {
    AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
        if (!world.isClient()) {
            player.sendMessage(Text.literal("EVENT!"));
            onHit.Identify(player, world, hand, entity, hitResult);}
            return ActionResult.PASS;

    });

    }
}
