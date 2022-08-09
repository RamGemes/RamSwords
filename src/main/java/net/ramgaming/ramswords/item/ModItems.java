package net.ramgaming.ramswords.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.ramgaming.ramswords.item.ToolMaterials;
import net.ramgaming.ramswords.Ramswords;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    public static final Item PRISMARE_SWORD = registerItem("prismare_sword", new SwordItem(ToolMaterials.PRISM, 0, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT)));
    public static final Item ANGELIC_SWORD = registerItem("angelic_sword", new SwordItem(ToolMaterials.PRISM, 0, -2.4F, (new Item.Settings()).group(ItemGroup.COMBAT)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Ramswords.MOD_ID,name),item);
    }

    public static void registerModItems() {
        Ramswords.LOGGER.debug("Registering items for mod: "+Ramswords.MOD_ID);
    }
}
