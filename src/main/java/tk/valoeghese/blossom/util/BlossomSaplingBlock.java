package tk.valoeghese.blossom.util;

import java.util.Random;

import io.github.terraformersmc.terraform.block.TerraformSaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class BlossomSaplingBlock extends TerraformSaplingBlock
{

	public BlossomSaplingBlock(BlossomSaplingGenerator generator)
	{
		super(new WrapperSaplingGenerator(generator));
	}
	
	private static final class WrapperSaplingGenerator extends SaplingGenerator
	{
		private BlossomSaplingGenerator provider;
		
		public WrapperSaplingGenerator(BlossomSaplingGenerator generator)
		{
			this.provider = generator;
		}
		@Override
		protected AbstractTreeFeature<DefaultFeatureConfig> createTreeFeature(Random rand)
		{
			return provider.get(rand);
		}
		
	}

}
