package tk.valoeghese.blossom.init;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
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
	public static final Block PALM_LOG = new LogBlock(MaterialColor.WOOD, FabricBlockSettings.copy(Blocks.OAK_LOG).materialColor(MaterialColor.CYAN_TERRACOTTA).build());
	public static final Block PALM_WOOD = new LogBlock(MaterialColor.CYAN_TERRACOTTA, FabricBlockSettings.copy(Blocks.OAK_LOG).materialColor(MaterialColor.CYAN_TERRACOTTA).build());
	public static final Block PALM_PLANKS = new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).materialColor(MaterialColor.WOOD).build());
	public static final Block PALM_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).materialColor(MaterialColor.LIME).build());
	
	public static void init()
	{
		register(TROPICAL_SAND, "tropical_sand").registerItemBlock(ItemGroup.BUILDING_BLOCKS);
		
		register(PALM_LOG, "palm_log").registerItemBlock(ItemGroup.BUILDING_BLOCKS);
		register(PALM_WOOD, "palm_wood").registerItemBlock(ItemGroup.BUILDING_BLOCKS);
		register(PALM_PLANKS, "palm_planks").registerItemBlock(ItemGroup.BUILDING_BLOCKS);
		register(PALM_LEAVES, "palm_leaves").registerItemBlock(ItemGroup.DECORATIONS);
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
			Registry.register(Registry.ITEM, this.id, new BlockItem(this.block, new Item.Settings().group(group)));
			return this;
		}
	}
}
