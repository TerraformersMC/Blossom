package tk.valoeghese.blossom.gen;

import java.util.Random;
import java.util.Set;

import modfest.valar.common.gen.AbstractTropicalTreeFeature;
import modfest.valar.common.gen.BlockGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableIntBoundingBox;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import tk.valoeghese.blossom.init.BlossomBlocks;

public class PalmFeature extends AbstractTropicalTreeFeature
{
	private static final BlockState LOG = BlossomBlocks.PALM_LOG.getDefaultState();
	private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();
	
	public PalmFeature()
	{
		super(false, 6, 9);
	}
	
	@Override
	protected boolean generate(Set<BlockPos> set_1, ModifiableTestableWorld world, Random rand, BlockPos blockPos_1, MutableIntBoundingBox mibb)
	{
		int height = 6 + rand.nextInt(9);
		
		blockPos_1 = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, blockPos_1);

		BlockGenerator generator = new BlockGenerator(world, set_1, mibb);
		
		if (blockPos_1.getY() >= 1 && blockPos_1.getY() + height + 1 <= 256 &&
				(this.isTropicalSand(world, blockPos_1.down()) || (super.isNaturalDirtOrGrass(world, blockPos_1.down()))))
		{
			
			this.generateBlocks(world, generator, height, rand, blockPos_1);
			
			return generator.generate(this);
		}
		else
		{
			return false;
		}
	}
	
	private boolean isTropicalSand(TestableWorld world, BlockPos down)
	{
		return world.testBlockState(down, (blockState_1) -> {
			Block block_1 = blockState_1.getBlock();
			return block_1 == BlossomBlocks.TROPICAL_SAND;
		});
	}
	
	@Override
	protected void generateBlocks(ModifiableTestableWorld world, BlockGenerator generator, int height, Random rand, BlockPos pos)
	{
		BlockPos origin = pos.add(0, height - 1, 0);

		for (int i = -1; i < 2; ++i)
		{
			generator.setBlock(origin.add(1, i, 0), LEAVES, true);
			generator.setBlock(origin.add(-1, i, 0), LEAVES, true);
			generator.setBlock(origin.add(0, i, 1), LEAVES, true);
			generator.setBlock(origin.add(0, i, -1), LEAVES, true);
		}

		generator.setBlock(origin.add(1, 0, 1), LEAVES, true);
		generator.setBlock(origin.add(-1, 0, 1), LEAVES, true);
		generator.setBlock(origin.add(1, 0, -1), LEAVES, true);
		generator.setBlock(origin.add(-1, 0, -1), LEAVES, true);

		for (int i = -2; i < 2; ++i)
		{
			if (i == 0) continue;
			generator.setBlock(origin.add(2, i, 0), LEAVES, true);
			generator.setBlock(origin.add(-2, i, 0), LEAVES, true);
			generator.setBlock(origin.add(0, i, 2), LEAVES, true);
			generator.setBlock(origin.add(0, i, -2), LEAVES, true);
		}

		generator.setBlock(origin.add(0, 1, 0), LEAVES, true);

		for (int i = 0; i <= height - 1; ++i) generator.setBlock(pos.add(0, i, 0), LOG, false);
	}
}
