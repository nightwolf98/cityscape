package minecraft.phoenix.cityscape.space.item;

import minecraft.phoenix.cityscape.core.proxy.CommonProxy;
import minecraft.phoenix.cityscape.core.lib.Strings;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

/**
 * 21 Century Mod
 * 
 * ItemSpaceBoots
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class ItemSpaceBoots extends ItemArmor{
	
	public ItemSpaceBoots(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4){

		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(CommonProxy.tabSpace);
		this.setUnlocalizedName(Strings.ITEM_SPACEBOOTS);
	}
}