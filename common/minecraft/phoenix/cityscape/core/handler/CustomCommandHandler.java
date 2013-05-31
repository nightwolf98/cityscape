package minecraft.phoenix.cityscape.core.handler;

import minecraft.phoenix.cityscape.core.command.CommandTpToDim;
import net.minecraft.command.CommandHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * 21 Century Mod
 * 
 * CustomCommandHandler
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class CustomCommandHandler {
	
	/**
	 * Adds commands
	 * @param event
	 */
	
	public static void init(FMLServerStartingEvent event){
		
		CommandHandler commandManager = (CommandHandler)event.getServer().getCommandManager();
	    commandManager.registerCommand(new CommandTpToDim());
	}
}