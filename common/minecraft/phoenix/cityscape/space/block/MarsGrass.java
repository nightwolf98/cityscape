package minecraft.phoenix.cityscape.space.block;

import java.util.List;

import iad4m.iAd4m;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class MarsGrass extends Block {

	public MarsGrass(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		icons = new Icon[4];

		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(iAd4m.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		switch(par2)
		{
			case 0:
			{
				switch(par1)
				{
					case 0:
						return icons[1];
					case 1:
						return icons[2];
					default:
						return icons[3];
				}
			}
			default: 
			{
				switch(par1)
				{
					case 0:
						return icons[1];
					case 1:
						return icons[2];
					default:
						return icons[3];
				}
			}
		}
	}
}
