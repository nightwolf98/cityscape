package minecraft.phoenix.cityscape.core.item;

import minecraft.phoenix.cityscape.core.lib.Reference;
import minecraft.phoenix.cityscape.core.lib.Strings;
import minecraft.phoenix.cityscape.core.proxy.CommonProxy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 21 Century Mod
 * 
 * RoadPainterItem
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 * 
 */
public class RoadPainterItem extends Item
{	
	public RoadPainterItem(int id)
	{
		super(id);
		this.setMaxStackSize(1);
		this.setCreativeTab(CommonProxy.tabCityscape);
		this.setUnlocalizedName(Strings.ITEM_ROADPAINTER);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(Reference.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}