package minecraft.phoenix.cityscape.core.creativeTabs;

import minecraft.phoenix.cityscape.core.block.CoreModBlock;
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
 * @author jack9515
 * 
 */

public class TabCityscape extends CreativeTabs
{
	
	public TabCityscape(int position, String tabId)
	{
		
		super(position, tabId);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		
		return CoreModBlock.steelBlock.blockID;
	}
	
	public String getTranslatedTabLabel()
	{
		// XXX check
		
		return "Modern Civilizations";
	}
}