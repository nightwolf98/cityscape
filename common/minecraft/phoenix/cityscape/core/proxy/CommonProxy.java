package minecraft.phoenix.cityscape.core.proxy;

import minecraft.phoenix.cityscape.core.creativeTabs.TabCityscape;
import minecraft.phoenix.cityscape.core.creativeTabs.TabSpace;
import minecraft.phoenix.cityscape.core.lib.Reference;
import minecraft.phoenix.cityscape.core.lib.Strings;
import minecraft.phoenix.cityscape.space.entity.EntityPlayerSpace;
import minecraft.phoenix.cityscape.space.moon.WorldProviderMoon;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
//import net.minecraft.src.PlayerAPI;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 21 Century Mod
 * 
 * CommonProxyCivilization
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class CommonProxy {

	 public static BiomeGenBase moonBiome;
	 public static EnumArmorMaterial EnumArmorMaterialSpace = EnumHelper.addArmorMaterial("spaceSuit", 1000, new int[]{0, 0, 0, 0}, 0);
	 public static CreativeTabs tabSpace = new TabSpace(CreativeTabs.getNextID(), Strings.TAB_SPACE_NAME);
	 public static CreativeTabs tabCityscape = new TabCityscape(CreativeTabs.getNextID(), Strings.TAB_CITYSCAPE_NAME);
	 
	/**
	 * Registers things which don't have a specific place.
	 */
	
	public void registerThings()
	{
		DimensionManager.registerProviderType(Reference.moonID, WorldProviderMoon.class, false);
        DimensionManager.registerDimension(Reference.moonID, Reference.moonID);
        
        GameRegistry.addBiome(moonBiome);
        
       // PlayerAPI.register(Reference.modid, EntityPlayerSpace.class);
	}
}