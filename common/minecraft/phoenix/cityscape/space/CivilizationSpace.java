package minecraft.phoenix.cityscape.space;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import minecraft.phoenix.cityscape.space.block.ModBlock;
import minecraft.phoenix.cityscape.space.core.handler.CustomCommandHandler;
import minecraft.phoenix.cityscape.space.core.handler.LocalizationHandler;
import minecraft.phoenix.cityscape.space.core.proxy.CommonProxyCivilization;
import minecraft.phoenix.cityscape.space.creativeTabs.TabSpace;
import minecraft.phoenix.cityscape.space.item.ModItem;
import minecraft.phoenix.cityscape.space.lib.Reference;
import minecraft.phoenix.cityscape.space.lib.Strings;
import minecraft.phoenix.cityscape.space.moon.BiomeGenMoon;
import minecraft.phoenix.cityscape.space.world.Space;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
//import net.minecraft.src.PlayerAPI;

/**
 * 21 Century Mod
 * 
 * CivilizationSpace
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

@Mod(
		modid = Reference.modid,
		name = Reference.name, 
		version = Reference.version)

@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false)

public class CivilizationSpace{
	
	private Space space = new Space();
	
	@SidedProxy(
			clientSide = Reference.ClientProxy,
			serverSide = Reference.CommonProxy)
	public static CommonProxyCivilization proxy;

	 public static BiomeGenBase moonBiome = (new BiomeGenMoon(30)).setColor(16421912).setBiomeName("Moon").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);
	 public static EnumArmorMaterial EnumArmorMaterialSpace = EnumHelper.addArmorMaterial("Space Armor", 35, new int[] {4,9,7,6}, 15);
	 public static CreativeTabs tabSpace = new TabSpace(CreativeTabs.getNextID(), Strings.TAB_SPACE_NAME); 
			 
	@PreInit
	public void load(FMLPreInitializationEvent event)
	{
		//Loading language files
		LocalizationHandler.loadLanguages();
		
		//Registering things which dont have to be in the Main Mod file
		proxy.registerThings();
		
		//Initializing the Mod Items
	    ModItem.init();   
	    
	    //Initializing the Mod Blocks
	    ModBlock.init();
        
		//Please put this in the proxy ;)
      	// PlayerAPI.register(Reference.modid, EntityPlayerSpace.class);
	}
	
	@Init
	public void load(FMLInitializationEvent event)
	{
	    //I dont know yet :P
		space.load(event);
	}

	@ServerStarting
	public void serverStarting(FMLServerStartingEvent event)
	{
		CustomCommandHandler.init(event);
	}

}
