package tk.valoeghese.blossom.biome;

import modfest.valar.common.biome.BiomeFactory;
import modfest.valar.common.biome.ExtendedBiome;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import tk.valoeghese.blossom.init.BlossomBiomes;
import tk.valoeghese.blossom.init.BlossomFeatures;

public class TropicalIslandCoastBiome extends ExtendedBiome
{
	public TropicalIslandCoastBiome()
	{
		super(BiomeFactory.create(0.025F, 0.025F, Biome.Category.BEACH).setSurfaceBuilder(BlossomBiomes.TROPICAL_BUILDER).setTemperatureDownfall(1.1F, 0.7F).setWaterProperties(4445678, 270131));
		
		this.factory.addDefaultGeneration();
		DefaultBiomeFeatures.addDefaultLakes(this);
		this.factory.addDefaultMineables();
		
		this.populator.treesPerChunk = 2;
		this.populator.extraTreeChance = 0.3F;
		
		this.populator.addTreeFeature(BlossomFeatures.PALM, 1);
		this.populator.addTreeFeature(BlossomFeatures.PALM_GRASSONLY, 1);
		
		this.populator.buildTreeFeatures();
		
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addDefaultGrass(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDesertVegetation(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.WITCH, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
	}

}
