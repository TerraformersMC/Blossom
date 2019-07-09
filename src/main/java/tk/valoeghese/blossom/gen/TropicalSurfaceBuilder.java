package tk.valoeghese.blossom.gen;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import tk.valoeghese.blossom.init.BlossomBlocks;

public class TropicalSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig>
{
	protected final BlockState TROPICAL_SAND = BlossomBlocks.TROPICAL_SAND.getDefaultState();
	protected final BlockState WATER = Blocks.WATER.getDefaultState();
	protected final BlockState SAND = Blocks.SAND.getDefaultState();
	
	public TropicalSurfaceBuilder()
	{
		super(TernarySurfaceConfig::deserialize);
	}
	
	@Override
	public void generate(Random rand, Chunk chunk, Biome biome, int x, int z, int worldHeight, double noiseVal, BlockState var9, BlockState var10, int var11, long seed, TernarySurfaceConfig config)
	{	
		int localX = x & 15;
		int localZ = z & 15;
		
		for (int y = worldHeight; y >= 0; --y)
		{
			BlockPos pos = new BlockPos(localX, y, localZ);
			BlockState chunkBlock = chunk.getBlockState(pos);

			if (chunkBlock == STONE) {
				BlockState toSet = STONE;
				
				if (y < 255) {
					if (chunk.getBlockState(pos.up()) == AIR) {
						toSet = (y < 66) ? TROPICAL_SAND : GRASS_BLOCK;
					} else if (chunk.getBlockState(pos.up()) == WATER) {
						toSet = SAND;
					} else if (y < 253) {
						if (chunk.getBlockState(pos.up(3)) == AIR) {
							toSet = (y < 66) ? TROPICAL_SAND : DIRT;
						}
					}
				}

				chunk.setBlockState(pos, toSet, false);

			} else {
				chunk.setBlockState(pos, chunkBlock, false);
			}
		}
	}

}
