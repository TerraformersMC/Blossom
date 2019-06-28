package tk.valoeghese.blossom.init;

import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.world.biome.Biomes;

public final class BlossomGen
{
	public static void init()
	{
		OverworldBiomes.addBiomeVariant(Biomes.DEEP_OCEAN, BlossomBiomes.TROPICAL_ISLAND, 0.33, OverworldClimate.DRY, OverworldClimate.TEMPERATE);
		OverworldBiomes.addEdgeBiome(BlossomBiomes.TROPICAL_ISLAND, BlossomBiomes.PALM_BEACH, 1);
	}
}
