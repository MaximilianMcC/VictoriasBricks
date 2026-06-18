package net.maxtheminerboy.victoriasbricks;

import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CustomBlocks {

	public static void createblock(String name, BlockType type) {
		
		// Create the block
		DeferredBlock<Block> block = VictoriasBricks.BLOCKS.register(name, () -> getBaseBlock(type));
		
		// Create the item to go along with the block
		VictoriasBricks.ITEMS.registerSimpleBlockItem(name, block);
	}

	// Register a block, stair, and slab
	public static void createBlockSet(String name) {

		createblock(name, BlockType.BLOCK);
		createblock(name + "_stairs", BlockType.STAIR);
		createblock(name + "_slab", BlockType.SLAB);
	}
	
	// Depending on the block type, decide what base the block should inherit from
	private static Block getBaseBlock(BlockType type) {

		Block base = null;

		// TODO: Make this like final or something yk
		BlockBehaviour.Properties brickProperties = BlockBehaviour.Properties.of()
			.instrument(NoteBlockInstrument.BASEDRUM)
			.requiresCorrectToolForDrops()
			.strength(2.0F, 6.0F);

		// TODO: Make this like final or something yk
		BlockBehaviour.Properties glassProperties = BlockBehaviour.Properties.of()
			.instrument(NoteBlockInstrument.HAT)
			.strength(0.3F)
			.sound(SoundType.GLASS)
			.noOcclusion();

		switch (type) {
			case BlockType.BLOCK:
				base = new Block(brickProperties);
				break;
		
			case BlockType.SLAB:
				base = new SlabBlock(brickProperties);
				break;

			case BlockType.STAIR:
				Block baseBlock = new Block(brickProperties);
				base = new StairBlock(baseBlock.defaultBlockState(), brickProperties);
				break;

			case BlockType.GLASS:
				base = new TransparentBlock(glassProperties);
				break;
				
			case BlockType.GLASS_PANE:
				base = new IronBarsBlock(glassProperties);
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