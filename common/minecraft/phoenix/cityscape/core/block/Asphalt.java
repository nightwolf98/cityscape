package minecraft.phoenix.cityscape.core.block;

import java.util.List;
import minecraft.phoenix.cityscape.core.lib.Reference;
import minecraft.phoenix.cityscape.core.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 21 Century Mod
 * 
 * Asphalt
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class Asphalt extends Block
{	
	public Asphalt (int i, Material material)
	{
		super(i, material);
		this.setHardness(0.5F);
		this.setStepSound(Block.soundGravelFootstep);
		this.setCreativeTab(CommonProxy.tabCityscape);
	}
	
	@SideOnly(Side.CLIENT)
    private Icon[] icons;
	
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister par1IconRegister)
	 {
		 icons = new Icon[9];
	            
		 for(int i = 0; i < icons.length; i++){
	                    icons[i] = par1IconRegister.registerIcon(Reference.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
	             }
	    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
          return icons[par2];
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 9; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
	
}