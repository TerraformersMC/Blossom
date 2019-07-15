package tk.valoeghese.blossom.util;

import java.util.Random;

import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public interface BlossomSaplingGenerator
{
	public AbstractTreeFeature<DefaultFeatureConfig> get(Random rand);
}
