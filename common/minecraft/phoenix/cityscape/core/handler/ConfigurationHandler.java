package minecraft.phoenix.cityscape.core.handler;

import java.io.File;
import java.util.logging.Level;

import minecraft.phoenix.cityscape.core.lib.BlockIds;
import minecraft.phoenix.cityscape.core.lib.Reference;
import minecraft.phoenix.cityscape.core.lib.Strings;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

/**
 * 21 Century Mod
 * 
 * ConfigurationHandler
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class ConfigurationHandler {
	
	public static Configuration config;
	
	public static void init(File file){
		
		config = new Configuration(file);
		
		try{
			
			config.load();
			
			BlockIds.BlockID_Asphalt = config.getBlock(Strings.BLOCK_ASPHALT, BlockIds.BlockID_Asphalt_Default).getInt(BlockIds.BlockID_Asphalt_Default);
			
			
			
		}
		catch(Exception e){
			
			FMLLog.log(Level.SEVERE, e, Reference.modid + "has a problem loading the config file");
		}
		finally{
			
			config.save();
		}
		
	}
}