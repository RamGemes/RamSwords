package net.ramgaming.ramswords;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;

public class RamswordsEvents {
    public static void onInitialize() {
    AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
        return null;
    });

    }
}
