package tk.valoeghese.blossom.biome;

import modfest.valar.common.biome.BiomeFactory;
import modfest.valar.common.biome.ExtendedBiome;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import tk.valoeghese.blossom.init.BlossomFeatures;

public class AspenWoodlandBiome extends ExtendedBiome
{
	public AspenWoodlandBiome()
	{
		super(BiomeFactory.create(0.1F, 0.2F, Biome.Category.FOREST).setTemperatureDownfall(0.5F, 0.72F));
		
		this.factory.addDefaultGeneration();
		DefaultBiomeFeatures.addDefaultLakes(this);
		this.factory.addDefaultMineables();
		
		this.populator.treesPerChunk = 4;
		this.populator.addTreeFeature(BlossomFeatures.ASPEN, 1);
		this.populator.buildTreeFeatures();
		
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addDefaultGrass(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDesertVegetation(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.RABBIT, 1, 2, 3));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.PARROT, 1, 2, 3));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.CHICKEN, 5, 2, 5));
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
