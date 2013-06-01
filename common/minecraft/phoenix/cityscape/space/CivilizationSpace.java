package minecraft.phoenix.cityscape.space;

import minecraft.phoenix.cityscape.core.handler.CustomCommandHandler;
import minecraft.phoenix.cityscape.core.lib.Strings;
import minecraft.phoenix.cityscape.core.proxy.CommonProxy;
import minecraft.phoenix.cityscape.space.block.SpaceModBlock;
import minecraft.phoenix.cityscape.space.creativeTabs.TabSpace;
import minecraft.phoenix.cityscape.space.item.SpaceModItem;
import minecraft.phoenix.cityscape.space.moon.BiomeGenMoon;
import minecraft.phoenix.cityscape.space.world.Space;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;


/**
 * 21 Century Mod
 * 
 * CivilizationSpace
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class CivilizationSpace
{
	
	private Space space = new Space();
	
	public static CommonProxy proxy;

	 public static BiomeGenBase moonBiome = (new BiomeGenMoon(30)).setColor(16421912).setBiomeName("Moon").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);
	 public static EnumArmorMaterial EnumArmorMaterialSpace = EnumHelper.addArmorMaterial("Space Armor", 35, new int[] {4,9,7,6}, 15);
	 public static CreativeTabs tabSpace = new TabSpace(CreativeTabs.getNextID(), Strings.TAB_SPACE_NAME); 
			 
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	public void init(FMLInitializationEvent event)
	{
		//Initializing the Mod Items
	    SpaceModItem.init();   
	    
	    //Initializing the Mod Blocks
	    SpaceModBlock.init();
		
	    //I dont know yet :P
		space.load(event);
	}

	@ServerStarting
	public void serverStarting(FMLServerStartingEvent event)
	{
		CustomCommandHandler.init(event);
	}

}
