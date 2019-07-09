package tk.valoeghese.blossom.init;

import io.github.terraformersmc.terraform.biomeapi.OverworldBiomesExt;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.world.biome.Biomes;

public final class BlossomGen
{
	public static void init()
	{
		// Tropical Island
		OverworldBiomes.addBiomeVariant(Biomes.DEEP_OCEAN, BlossomBiomes.TROPICAL_REEF, 0.3);
		
		OverworldBiomesExt.addBorderBiome(BlossomBiomes.TROPICAL_REEF, BlossomBiomes.TROPICAL_REEF_EDGE);
		OverworldBiomes.addHillsBiome(BlossomBiomes.TROPICAL_REEF, BlossomBiomes.TROPICAL_ISLAND, 1);
		OverworldBiomes.addShoreBiome(BlossomBiomes.TROPICAL_ISLAND, BlossomBiomes.TROPICAL_ISLAND_COAST, 1);
		
		OverworldBiomes.setRiverBiome(BlossomBiomes.TROPICAL_ISLAND, null);
		OverworldBiomes.setRiverBiome(BlossomBiomes.TROPICAL_ISLAND_COAST, null);
		OverworldBiomes.setRiverBiome(BlossomBiomes.TROPICAL_REEF, null);
		OverworldBiomes.setRiverBiome(BlossomBiomes.TROPICAL_REEF_EDGE, null);
		
		// Aspen Woodland
		OverworldBiomes.addBaseBiome(BlossomBiomes.ASPEN_WOODLAND, OverworldClimate.COOL, 1);
	}
}
