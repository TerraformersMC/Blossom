package tk.valoeghese.blossom;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import tk.valoeghese.blossom.init.BlossomBiomes;
import tk.valoeghese.blossom.init.BlossomFeatures;
import tk.valoeghese.blossom.init.BlossomGen;

public class Blossom implements ModInitializer
{
	
	@Override
	public void onInitialize()
	{
		BlossomFeatures.init();
		BlossomBiomes.init();
		BlossomGen.init();
	}
	
	public static final Identifier create(String id)
	{
		return new Identifier("blossom", id);
	}

}
