package minecraft.phoenix.cityscape.space;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabSpace extends CreativeTabs
{
	public TabSpace(int position,String tabId)
	{
		super(position, tabId);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return CivilizationSpace.moonrock.blockID;
	}
	
	public String getTranslatedTabLabel()
	{
		return "Modern Civilizations";
	}

}
