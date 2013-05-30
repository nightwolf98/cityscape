package minecraft.phoenix.cityscape.space.lib;

import net.minecraftforge.common.DimensionManager;

/**
 * 21 Century Mod
 * 
 * Reference
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class Reference {
	
	//All references used in the mod
	public static final String modid 			= "21st_Century_Mod";
	public static final String name 			= "21st Century Mod";
	public static final String version 			= "0.1a";
	public static final String ClientProxy		= "minecraft.phoenix.cityscape.space.core.proxy.ClientProxyCivilization";
	public static final String CommonProxy		= "minecraft.phoenix.cityscape.space.core.proxy.CommonProxyCivilization";
	public static final String Language_location= "/mods/TwentyFirst_Century_Mod/lang/";
	public static int moonID 					= DimensionManager.getNextFreeDimId();
}