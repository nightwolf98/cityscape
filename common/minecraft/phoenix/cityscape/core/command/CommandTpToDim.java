package minecraft.phoenix.cityscape.core.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import minecraft.phoenix.cityscape.space.util.NoPortalTeleporter;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

/**
 * 21 Century Mod
 * 
 * CommandTpToDim
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class CommandTpToDim extends CommandBase{
	
	@Override
	public String getCommandName()
	{	
		return "tptodim";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/" + this.getCommandName() + " [Dimension Name]";
	}
	
    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

	@Override
	public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr){
		
		String dimName = ""; //Setting Dimension name
		
   		for(String dim : par2ArrayOfStr)
   			dimName += dim + " ";
   		
   		dimName = dimName.trim();
   		
   		//Starting to send player to dimension
		HashMap<String, Integer> dims = new HashMap<String, Integer>();
		
		//Getting dimension name: Space is this code
		for(int dimID : DimensionManager.getIDs()){
			dims.put(WorldProvider.getProviderForDimension(dimID).getDimensionName(), dimID);
		}
		
		//Send player to other dimension
       	if(par1ICommandSender instanceof EntityPlayerMP && dims.get(dimName) != null){
       		EntityPlayerMP entityplayermp = getCommandSenderAsPlayer(par1ICommandSender);
       		ChunkCoordinates var2 = entityplayermp.mcServer.worldServerForDimension(dims.get(dimName)).getEntrancePortalLocation();
            
       		if (var2 != null){
       			//Setting new player location, I think?
                entityplayermp.playerNetServerHandler.setPlayerLocation((double)var2.posX, (double)var2.posY, (double)var2.posZ, 0.0F, 0.0F);
            }
       		
       		//Server config for sending player to dimension
            entityplayermp.mcServer.getConfigurationManager().transferPlayerToDimension(entityplayermp, dims.get(dimName), new NoPortalTeleporter(entityplayermp.mcServer.worldServerForDimension(dims.get(dimName))));
       	}
       	
       	//Used the command wrong catch
       	else throw new WrongUsageException(getCommandUsage(par1ICommandSender), new Object[0]);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
	{
		ArrayList<String> dims = new ArrayList<String>();
		
		for(int dimId : DimensionManager.getIDs()){
			dims.add(DimensionManager.getProvider(dimId).getDimensionName());
		}
		
		return astring.length == 1 ? getListOfStringsMatchingLastWord(astring, dims.toArray(new String[DimensionManager.getIDs().length])) : null;
	
	}
	
	//End of all code here 30/5/13
}