package minecraft.phoenix.cityscape.core;

import minecraft.phoenix.cityscape.core.block.CoreModBlock;
import minecraft.phoenix.cityscape.core.handler.LocalizationHandler;
import minecraft.phoenix.cityscape.core.item.CoreModItem;
import minecraft.phoenix.cityscape.core.proxy.CommonProxyCivilization;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="cityScape", name="21st Century Mod", version="1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Cityscape {
	
        // The instance of your mod that Forge uses.
        @Instance("cityScape")
        public static Cityscape instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="nightWolf.cityscape.client.ClientProxy", serverSide="nightWolf.cityscape.CommonProxy")
        public static CommonProxyCivilization proxy;
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @Init
        public void load(FMLInitializationEvent event)
        {
                //Loading language files
        		LocalizationHandler.loadLanguages();
        		
        		//Registering things which dont have to be in the Main Mod file
        		proxy.registerThings();
        		
        		//Initializing the Mod Items
        	    CoreModItem.init();   
        	    
        	    //Initializing the Mod Blocks
        	    CoreModBlock.init();
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}