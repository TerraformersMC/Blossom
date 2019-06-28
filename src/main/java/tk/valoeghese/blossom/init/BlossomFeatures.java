package tk.valoeghese.blossom.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import tk.valoeghese.blossom.Blossom;
import tk.valoeghese.blossom.gen.PalmFeature;

public final class BlossomFeatures
{
	public static Feature<DefaultFeatureConfig> PALM;
	
	public static void init()
	{
		PALM = register(new PalmFeature(), "palm");
	}
	
	private static Feature<DefaultFeatureConfig> register(Feature<DefaultFeatureConfig> feature, String id)
	{
		return Registry.register(Registry.FEATURE, Blossom.create(id), feature);
	}
}
