package tk.valoeghese.blossom.init;

import modfest.valar.common.biome.ExtendedBiome;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import tk.valoeghese.blossom.Blossom;
import tk.valoeghese.blossom.biome.TropicalIslandBiome;
import tk.valoeghese.blossom.biome.TropicalIslandCoastBiome;
import tk.valoeghese.blossom.biome.TropicalReefBiome;
import tk.valoeghese.blossom.biome.TropicalReefEdgeBiome;
import tk.valoeghese.blossom.gen.TropicalSurfaceBuilder;

public final class BlossomBiomes
{
	public static SurfaceBuilder<TernarySurfaceConfig> TROPICAL_BUILDER;

	public static ExtendedBiome TROPICAL_ISLAND;
	public static ExtendedBiome TROPICAL_ISLAND_COAST;
	public static ExtendedBiome TROPICAL_REEF;
	public static ExtendedBiome TROPICAL_REEF_EDGE;

	public static void init()
	{

		TROPICAL_BUILDER = register(new TropicalSurfaceBuilder(), "tropical_builder");

		TROPICAL_REEF = register(new TropicalReefBiome(), "tropical_reef");
		
		TROPICAL_REEF_EDGE = register(new TropicalReefEdgeBiome(), "tropical_reef_edge");
		
		TROPICAL_ISLAND = register(new TropicalIslandBiome(), "tropical_island");
		TROPICAL_ISLAND_COAST = register(new TropicalIslandCoastBiome(), "tropical_island_coast");
	}

	private static ExtendedBiome register(ExtendedBiome biome, String id)
	{
		return Registry.register(Registry.BIOME, Blossom.create(id), biome);
	}

	private static SurfaceBuilder<TernarySurfaceConfig> register(SurfaceBuilder<TernarySurfaceConfig> builder, String id)
	{
		return Registry.register(Registry.SURFACE_BUILDER, Blossom.create(id), builder);
	}
}
