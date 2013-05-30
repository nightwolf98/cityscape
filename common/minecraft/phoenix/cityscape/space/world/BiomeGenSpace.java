package minecraft.phoenix.cityscape.space.world;

import net.minecraft.world.biome.BiomeGenBase;

/**
 * 21 Century Mod
 * 
 * BiomeGenSpace
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class BiomeGenSpace extends BiomeGenBase{
	
    public BiomeGenSpace(int par1){
    	
        super(par1);
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
    }
}
