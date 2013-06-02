package minecraft.phoenix.cityscape.core.lib;

import net.minecraftforge.common.DimensionManager;

/**
 * 21 Century Mod
 * 
 * Reference
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class Reference {
	
	//All references used in the mod
	public static final String modid 			= "Cityscape";
	public static final String name 				= "21st Century Mod";
	public static final String version 			= "0.1a";
	public static final String ClientProxy		= "minecraft.phoenix.cityscape.core.proxy.ClientProxy";
	public static final String CommonProxy		= "minecraft.phoenix.cityscape.core.proxy.CommonProxy";
	public static final String Language_location= "/mods/Cityscape/lang/";
	public static int moonID 						= DimensionManager.getNextFreeDimId();
}