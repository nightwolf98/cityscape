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
			BlockIds.BlockID_Asphalt_DYV = config.getBlock(Strings.BLOCK_ASPHALT_DYV, BlockIds.BlockID_Asphalt_SWB_Default).getInt(BlockIds.BlockID_Asphalt_SWB_Default);
			BlockIds.BlockID_Asphalt_SWB = config.getBlock(Strings.BLOCK_ASPHALT_SWB, BlockIds.BlockID_Asphalt_SWB_Default).getInt(BlockIds.BlockID_Asphalt_SWB_Default);
			BlockIds.BlockID_Asphalt_DYH = config.getBlock(Strings.BLOCK_ASPHALT_DYH, BlockIds.BlockID_Asphalt_DYH_Default).getInt(BlockIds.BlockID_Asphalt_DYH_Default);
			BlockIds.BlockID_Asphalt_SWH = config.getBlock(Strings.BLOCK_ASPHALT_SWH, BlockIds.BlockID_Asphalt_SWH_Default).getInt(BlockIds.BlockID_Asphalt_SWH_Default);
			BlockIds.BlockID_Asphalt_SWL = config.getBlock(Strings.BLOCK_ASPHALT_SWL, BlockIds.BlockID_Asphalt_SWL_Default).getInt(BlockIds.BlockID_Asphalt_SWL_Default);
			BlockIds.BlockID_Asphalt_SWR = config.getBlock(Strings.BLOCK_ASPHALT_SWR, BlockIds.BlockID_Asphalt_SWR_Default).getInt(BlockIds.BlockID_Asphalt_SWR_Default);
			BlockIds.BlockID_Asphalt_SWT = config.getBlock(Strings.BLOCK_ASPHALT_SWT, BlockIds.BlockID_Asphalt_SWT_Default).getInt(BlockIds.BlockID_Asphalt_SWT_Default);
			BlockIds.BlockID_Asphalt_SWV = config.getBlock(Strings.BLOCK_ASPHALT_SWV, BlockIds.BlockID_Asphalt_SWV_Default).getInt(BlockIds.BlockID_Asphalt_SWV_Default);
			BlockIds.BlockID_Generator = config.getBlock(Strings.BLOCK_GENERATOR, BlockIds.BlockID_Generator_Default).getInt(BlockIds.BlockID_Generator_Default);
			BlockIds.BlockID_SteelBlock = config.getBlock(Strings.BLOCK_STEELBLOCK, BlockIds.BlockID_SteelBlock_Default).getInt(BlockIds.BlockID_SteelBlock_Default);
			
			
			
		}
		catch(Exception e){
			
			FMLLog.log(Level.SEVERE, e, Reference.modid + "has a problem loading the config file");
		}
		finally{
			
			config.save();
		}
		
	}
}