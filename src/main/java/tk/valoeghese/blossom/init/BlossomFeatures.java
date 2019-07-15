package tk.valoeghese.blossom.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.BirchTreeFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import tk.valoeghese.blossom.Blossom;
import tk.valoeghese.blossom.gen.PalmFeature;
import tk.valoeghese.blossom.gen.PalmFeature2;

public final class BlossomFeatures
{
	public static Feature<DefaultFeatureConfig> PALM;
	public static Feature<DefaultFeatureConfig> PALM_GRASSONLY;
	public static Feature<DefaultFeatureConfig> ASPEN;
	
	
	public static void init()
	{
		PALM = register(new PalmFeature(), "palm");
		PALM_GRASSONLY = register(new PalmFeature2(), "palm2");
		ASPEN = Feature.BIRCH_TREE;
	}
	
	private static <E extends FeatureConfig> Feature<E> register(Feature<E> feature, String id)
	{
		return Registry.register(Registry.FEATURE, Blossom.create(id), feature);
	}
}
