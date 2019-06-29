package tk.valoeghese.blossom.biome;

import modfest.valar.common.biome.BiomeFactory;
import modfest.valar.common.biome.ExtendedBiome;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.feature.OceanRuinFeature;
import net.minecraft.world.gen.feature.OceanRuinFeatureConfig;
import net.minecraft.world.gen.feature.ShipwreckFeatureConfig;

public class TropicalReefBiome extends ExtendedBiome
{

	public TropicalReefBiome()
	{
		super(BiomeFactory.create(-0.5F, 0.01F, Biome.Category.OCEAN).setTemperatureDownfall(1.1F, 0.7F).setWaterProperties(4445678, 270131));

		this.setUnderwaterBlock(Blocks.SAND.getDefaultState());

		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();

		this.addStructureFeature(Feature.OCEAN_RUIN, new OceanRuinFeatureConfig(OceanRuinFeature.BiomeType.WARM, 0.33F, 0.95F));
		this.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL));
		this.addStructureFeature(Feature.SHIPWRECK, new ShipwreckFeatureConfig(false));

		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addDefaultGrass(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDesertVegetation(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);

		this.addSpawn(EntityCategory.WATER_CREATURE, new Biome.SpawnEntry(EntityType.SQUID, 9, 4, 4));
		this.addSpawn(EntityCategory.WATER_CREATURE, new Biome.SpawnEntry(EntityType.PUFFERFISH, 18, 1, 3));
		this.addSpawn(EntityCategory.WATER_CREATURE, new Biome.SpawnEntry(EntityType.TROPICAL_FISH, 26, 8, 8));
		this.addSpawn(EntityCategory.WATER_CREATURE, new Biome.SpawnEntry(EntityType.DOLPHIN, 5, 1, 2));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.WITCH, 5, 1, 1));
	}

}
