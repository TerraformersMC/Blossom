package tk.valoeghese.blossom.init;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tk.valoeghese.blossom.Blossom;
import tk.valoeghese.blossom.block.FallingCustomBlock;

public final class BlossomBlocks
{
	public static final Block TROPICAL_SAND = new FallingCustomBlock(FabricBlockSettings.of(Material.SAND, MaterialColor.WHITE).sounds(BlockSoundGroup.SAND).hardness(0.1F).resistance(0.1F).build());
	
	public static void init()
	{
		register(TROPICAL_SAND, "tropical_sand").registerItemBlock(ItemGroup.BUILDING_BLOCKS);
	}
	
	public static BlockRegistryManager register(Block block, String id)
	{
		return new BlockRegistryManager(block, Blossom.create(id));
	}
	
	private static final class BlockRegistryManager
	{
		private final Block block;
		private final Identifier id;
		
		BlockRegistryManager(Block block, Identifier id)
		{
			this.block = block;
			this.id = id;
			
			Registry.register(Registry.BLOCK, id, block);
		}
		
		public BlockRegistryManager registerItemBlock(ItemGroup group)
		{
			Registry.register(Registry.ITEM, this.id, new BlockItem(this.block, new Item.Settings().itemGroup(group)));
			return this;
		}
	}
}
