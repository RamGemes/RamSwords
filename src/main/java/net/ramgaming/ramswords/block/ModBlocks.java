package net.ramgaming.ramswords.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.ramgaming.ramswords.Ramswords;
import net.ramgaming.ramswords.block.custom.BlazePowderCauldronBlock;

public class ModBlocks {

    public static final Block BLAZE_POWDER_CAULDRON = registerBlock("blaze_powder_cauldron",new BlazePowderCauldronBlock(FabricBlockSettings.of(Material.METAL).strength(4).requiresTool().luminance(
            state -> state.get(BlazePowderCauldronBlock.VALUE) == 1 ? 4 : state.get(BlazePowderCauldronBlock.VALUE) == 2 ? 8 : 12
    )),null);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name,block,tab);
        return Registry.register(Registry.BLOCK, new Identifier(Ramswords.MOD_ID,name),block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM,new Identifier(Ramswords.MOD_ID,name),new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        Ramswords.LOGGER.debug("Registering blocks for mod: "+Ramswords.MOD_ID);}
}
