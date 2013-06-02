package minecraft.phoenix.cityscape.space.world;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 21 Century Mod
 * 
 * Space
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class Space
{
	public static int space;
    public static final BiomeGenBase spaceBiome = (new BiomeGenSpace(31)).setColor(16421912).setBiomeName("Space").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);
    
    public void load(){
        
    	space = DimensionManager.getNextFreeDimId();
        DimensionManager.registerProviderType(space, WorldProviderSpace.class, false);
        DimensionManager.registerDimension(space, space);
       
        GameRegistry.addBiome(spaceBiome);
    }
}