package net.maxtheminerboy.victoriasbricks;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(VictoriasBricks.MOD_ID)
public class VictoriasBricks {

	public static final String MOD_ID = "victoriasbricks";

	public VictoriasBricks(IEventBus eventBus, ModContainer modContainer) {

		Blocks.BLOCKS.register(eventBus);
		Items.ITEMS.register(eventBus);

	}
}