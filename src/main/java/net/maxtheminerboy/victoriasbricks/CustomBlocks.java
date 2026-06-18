package net.maxtheminerboy.victoriasbricks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CustomBlocks {

	public static void registerBlock(String name, BlockType type) {
		
		// Create the block
		DeferredBlock<Block> block = VictoriasBricks.BLOCKS.register(name, () -> getBaseBlock(type));
		
		// Create the item to go along with the block
		VictoriasBricks.ITEMS.registerSimpleBlockItem(name, block);
	}

	// Register a block, stair, and slab
	public static void registerBlockSet(String name) {

		registerBlock(name, BlockType.BLOCK);
		registerBlock(name + "_stairs", BlockType.STAIR);
		registerBlock(name + "_slab", BlockType.SLAB);
	}
	
	// Depending on the block type, decide what base the block should inherit from
	private static Block getBaseBlock(BlockType type) {

		Block base = null;

		switch (type) {
			case BlockType.BLOCK:
				base = new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));
				break;
		
			case BlockType.SLAB:
				base = new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_SLAB));
				break;

			case BlockType.STAIR:
				base = new StairBlock(Blocks.BRICK_STAIRS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS));
				break;

			case BlockType.GLASS:
				base = new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
				break;
				
			case BlockType.GLASS_PANE:
				base = new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE));
				break;

			default:
				System.err.println("Invalid block type used when registering (" + type + ")");
				break;
		}

		return base;
	}
}

enum BlockType {
	BLOCK,
	SLAB,
	STAIR,

	GLASS,
	GLASS_PANE
}