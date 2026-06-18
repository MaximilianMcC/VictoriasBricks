package net.maxtheminerboy.victoriasbricks;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(VictoriasBricks.MOD_ID)
public class VictoriasBricks {

	public static final String MOD_ID = "victoriasbricks";

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VictoriasBricks.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VictoriasBricks.MOD_ID);

	public VictoriasBricks(IEventBus eventBus, ModContainer modContainer) {

		// Make everything
		CustomBlocks.createblock("test_block", BlockType.BLOCK);
		// CustomBlocks.createblock("test_block_stairs", BlockType.STAIR);
		CustomBlocks.createblock("test_glass", BlockType.GLASS);

		// Add everything to the game
		BLOCKS.register(eventBus);
		ITEMS.register(eventBus);
	}
}