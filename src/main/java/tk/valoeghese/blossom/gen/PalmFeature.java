package tk.valoeghese.blossom.gen;

import java.util.Random;

import modfest.valar.common.gen.AbstractTropicalTreeFeature;
import modfest.valar.common.gen.BlockGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;

public class PalmFeature extends AbstractTropicalTreeFeature
{
	private static final BlockState LOG = Blocks.JUNGLE_LOG.getDefaultState();
	private static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();

	public PalmFeature()
	{
		super(false, 6, 9);

		this.setBeachFeature();
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
