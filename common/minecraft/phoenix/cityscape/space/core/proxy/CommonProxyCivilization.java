package minecraft.phoenix.cityscape.space.core.proxy;

import minecraft.phoenix.cityscape.space.CivilizationSpace;

import minecraft.phoenix.cityscape.space.lib.Reference;
import minecraft.phoenix.cityscape.space.moon.WorldProviderMoon;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 21 Century Mod
 * 
 * CommonProxyCivilization
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class CommonProxyCivilization {

	/**
	 * Registers things which don't have a specific place.
	 */
	
	public void registerThings(){
		
        DimensionManager.registerProviderType(Reference.moonID, WorldProviderMoon.class, false);
        DimensionManager.registerDimension(Reference.moonID, Reference.moonID);
        
        GameRegistry.addBiome(CivilizationSpace.moonBiome);
	}
}