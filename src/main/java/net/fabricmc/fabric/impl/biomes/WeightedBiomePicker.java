package net.fabricmc.fabric.impl.biomes;

import com.google.common.base.Preconditions;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Picks biomes with arbitrary double weights using a binary search.
 */
public class WeightedBiomePicker {
	private double currentTotal;
	private List<BaseBiomeEntry> entries;

	public WeightedBiomePicker() {
		currentTotal = 0;
		entries = new ArrayList<>();
	}

	public void addBiome(final Biome biome, final double weight) {
		currentTotal += weight;

		entries.add(new BaseBiomeEntry(biome, weight, currentTotal));
	}

	public double getCurrentWeightTotal() {
		return currentTotal;
	}

	public Biome pickRandom(LayerRandomnessSource random) {
		double target = (double) random.nextInt(Integer.MAX_VALUE) * getCurrentWeightTotal() / Integer.MAX_VALUE;

		return search(target).getBiome();
	}

	/**
	 * Searches with the specified target value
	 * @param target The target value, must satisfy the constraint 0 <= target <= currentTotal
	 * @return The result of the search
	 */
	public BaseBiomeEntry search(final double target) {
		// Sanity checks, fail fast if stuff is going wrong.
		Preconditions.checkArgument(target <= currentTotal, "The provided target value for biome selection must be less than or equal to the weight total");
		Preconditions.checkArgument(target >= 0, "The provided target value for biome selection cannot be negative");

		int low = 0;
		int high = entries.size() - 1;

		while (low < high) {
			int mid = (high + low) >>> 1;
			if (target < entries.get(mid).getUpperWeightBound()) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}

		return entries.get(low);
	}
}
