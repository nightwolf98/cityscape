package minecraft.phoenix.cityscape.space.moon;

import minecraft.phoenix.cityscape.space.lib.Strings;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * 21 Century Mod
 * 
 * BiomeGenMoon
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class BiomeGenMoon extends BiomeGenBase{
	
	/**
	 * Adds Biome Moon Generation Code
	 * @param BiomeID
	 * 			ID of the biome
	 */
    public BiomeGenMoon(int BiomeID){
    	
        super(BiomeID);
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        this.setColor(16421912);
        this.setBiomeName(Strings.BIOME_NAME);
        this.setDisableRain();
        this.setTemperatureRainfall(2.0F, 0.0F);
        this.setMinMaxHeight(0.1F, 0.2F);
    }
}