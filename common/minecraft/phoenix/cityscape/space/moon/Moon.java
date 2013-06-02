package minecraft.phoenix.cityscape.space.moon;

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

public class Moon
{
	public static int moon;
    public static final BiomeGenBase moonBiome = (new BiomeGenMoon(32)).setColor(0).setBiomeName("Moon").setDisableRain().setMinMaxHeight(-0.1F, 1.0F).setTemperatureRainfall(0.0F, 0.0F);
    
    public void load(){
        
    	moon = DimensionManager.getNextFreeDimId();
        DimensionManager.registerProviderType(moon, WorldProviderMoon.class, false);
        DimensionManager.registerDimension(moon, moon);
       
        GameRegistry.addBiome(moonBiome);
    }
}