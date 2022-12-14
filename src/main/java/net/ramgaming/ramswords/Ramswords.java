package net.ramgaming.ramswords;

import net.fabricmc.api.ModInitializer;
import net.ramgaming.ramswords.block.ModBlocks;
import net.ramgaming.ramswords.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ramswords implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "ramswords";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Starting initialization for mod: "+MOD_ID);
		ModItems.registerModItems();
		RamswordsEvents.onInitialize();
		ModBlocks.registerModBlocks();
	}
}
