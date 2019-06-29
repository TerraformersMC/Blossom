package tk.valoeghese.blossom.init;

import io.github.terraformersmc.terraform.biomeapi.OverworldBiomesExt;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.world.biome.Biomes;

public final class BlossomGen
{
	public static void init()
	{
		OverworldBiomes.addBiomeVariant(Biomes.DEEP_OCEAN, BlossomBiomes.TROPICAL_REEF, 0.33);
		
		OverworldBiomesExt.addBorderBiome(BlossomBiomes.TROPICAL_REEF, BlossomBiomes.PALM_BEACH);
		
		OverworldBiomes.addHillsBiome(BlossomBiomes.TROPICAL_REEF, BlossomBiomes.TROPICAL_ISLAND, 1);
		OverworldBiomes.addHillsBiome(BlossomBiomes.PALM_BEACH, BlossomBiomes.TROPICAL_REEF, 1);
		
		OverworldBiomes.addShoreBiome(BlossomBiomes.TROPICAL_ISLAND, BlossomBiomes.PALM_BEACH, 1);
		
		OverworldBiomes.setRiverBiome(BlossomBiomes.TROPICAL_ISLAND, null);
		OverworldBiomes.setRiverBiome(BlossomBiomes.PALM_BEACH, null);
		OverworldBiomes.setRiverBiome(BlossomBiomes.TROPICAL_REEF, null);
	}
}
