package tk.valoeghese.blossom.gen;

import java.util.Random;

import modfest.valar.common.gen.AbstractTropicalTreeFeature;
import modfest.valar.common.gen.BlockGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;

public class AspenFeature extends AbstractTropicalTreeFeature
{
	private static final BlockState LOG = Blocks.BIRCH_LOG.getDefaultState();
	private static final BlockState LEAVES = Blocks.BIRCH_LEAVES.getDefaultState();

	public AspenFeature()
	{
		super(false, 6, 8);
	}

	@Override
	protected void generateBlocks(ModifiableTestableWorld world, BlockGenerator generator, int height, Random rand, BlockPos pos)
	{
		BlockPos origin = pos.up();
		
		for (int i = 0; i <= height; ++i)
		{
			if (i == height) {
				generator.setBlock(origin.up(i), LEAVES, true);
			} else if (i == height - 1 || i == 0) {
				generator.setBlock(origin.add(0, i, -1), LEAVES, true);
				generator.setBlock(origin.add(0, i, 1), LEAVES, true);
				generator.setBlock(origin.add(-1, i, 0), LEAVES, true);
				generator.setBlock(origin.add(1, i, 0), LEAVES, true);
			} else {
				for (int x = -1; x < 2; ++x)
					for (int z = -1; x < 2; ++z)
						if(x != 0 && z !=0)
							generator.setBlock(origin.add(x, i, z), LEAVES, true); // happened here twice
				if (i == 1 || i == height - 2) {
					generator.setBlock(origin.add(0, i, -2), LEAVES, true); // It happened here once
					                                                        // appears to crash either with leaves or at a certain distance away? :thonkjang:
					generator.setBlock(origin.add(0, i, 2), LEAVES, true);
					generator.setBlock(origin.add(-2, i, 0), LEAVES, true);
					generator.setBlock(origin.add(2, i, 0), LEAVES, true);
				}
			}
		}
		
		for (int i = 0; i < height; ++i) generator.setBlock(pos.add(0, i, 0), LOG, false);
	}
}
