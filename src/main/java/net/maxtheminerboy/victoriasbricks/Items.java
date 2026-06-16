package net.maxtheminerboy.victoriasbricks;

import net.minecraft.core.Holder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(VictoriasBricks.MOD_ID);

	public static final Holder<Item> TEST_BLOCK = ITEMS.register("test_block", () -> new BlockItem(
		Blocks.TEST_BLOCK.value(),
		new Item.Properties()
	));
}