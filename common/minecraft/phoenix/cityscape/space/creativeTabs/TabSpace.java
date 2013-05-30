package minecraft.phoenix.cityscape.space.creativeTabs;

import minecraft.phoenix.cityscape.space.block.ModBlock;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 21 Century Mod
 * 
 * TabSpace
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class TabSpace extends CreativeTabs{
	
	public TabSpace(int position,String tabId){
		
		super(position, tabId);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex(){
		
		return ModBlock.moonrock.blockID;
	}
	
	public String getTranslatedTabLabel(){
		
		return "Modern Civilizations";
	}
}