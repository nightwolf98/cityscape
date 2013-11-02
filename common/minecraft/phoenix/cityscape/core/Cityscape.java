package minecraft.phoenix.cityscape.core;

import java.io.File;
import minecraft.phoenix.cityscape.core.block.CoreModBlock;
import minecraft.phoenix.cityscape.core.handler.ConfigurationHandler;
import minecraft.phoenix.cityscape.core.handler.CustomCommandHandler;
import minecraft.phoenix.cityscape.core.handler.LocalizationHandler;
import minecraft.phoenix.cityscape.core.item.CoreModItem;
import minecraft.phoenix.cityscape.core.lib.Reference;
import minecraft.phoenix.cityscape.core.proxy.CommonProxy;
import minecraft.phoenix.cityscape.space.block.SpaceModBlock;
import minecraft.phoenix.cityscape.space.item.SpaceModItem;
import minecraft.phoenix.cityscape.space.moon.BiomeGenMoon;
import minecraft.phoenix.cityscape.space.moon.Moon;
import minecraft.phoenix.cityscape.space.world.Space;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * 21 Century Mod
 * 
 * CityScape
 * 
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

@Mod(
		modid=Reference.modid, 
		name=Reference.name, 
		version=Reference.version)

@NetworkMod(
		clientSideRequired=true, 
		serverSideRequired=false)

public class Cityscape {
	
        // The instance of your mod that Forge uses.
        @Instance(Reference.modid)
        public static Cityscape instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(
        		clientSide=Reference.ClientProxy, 
        		serverSide=Reference.CommonProxy)
        public static CommonProxy proxy;
        
    	private static Space space = new Space();
    	private static Moon moon = new Moon();
    	
   		public static BiomeGenBase moonBiome = (new BiomeGenMoon(30)).setColor(16421912).setBiomeName("Moon").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);
   		public static EnumArmorMaterial EnumArmorMaterialSpace = EnumHelper.addArmorMaterial("Space Armor", 35, new int[] {4,9,7,6}, 15);
   	 
   		@EventHandler
        public void preInit(FMLPreInitializationEvent event)
        {
        	 //Loading language files
    		LocalizationHandler.loadLanguages();
    		
    		//Registering things which dont have to be in the Main Mod file
    		proxy.registerThings();
    		
    		//Loading the configuration Hanlder
    		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.modid + File.separator + Reference.modid + ".cfg"));
    		
    		//Initializing the Core Items
    	    CoreModItem.init();   
    	    
    	    //Initializing the Core Blocks
    	    CoreModBlock.init();
    	    
    	    //Initializing Space Items
    	    SpaceModItem.init();   
    	    
    	    //Initializing the Space Blocks
    	    SpaceModBlock.init();
    	    
    		space.load();
    		moon.load();
        }
        
   		@EventHandler
        public void load(FMLInitializationEvent event)
        {
        	
        }
        
   		@EventHandler
        public void postInit(FMLPostInitializationEvent event) {

        }
        
   		@EventHandler
    	public void serverStarting(FMLServerStartingEvent event)
    	{
    		CustomCommandHandler.init(event);
    	}

}