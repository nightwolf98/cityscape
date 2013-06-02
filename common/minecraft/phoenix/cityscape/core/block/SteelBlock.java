package minecraft.phoenix.cityscape.core.block;

import minecraft.phoenix.cityscape.core.lib.Strings;
import minecraft.phoenix.cityscape.core.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * 21 Century Mod
 * 
 * SteelBlock
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class SteelBlock extends Block
{
	public SteelBlock (int i, Material material)
	{
		super(i, material);
		this.setHardness(2.5F);
		this.setStepSound(Block.soundGravelFootstep);
		this.setUnlocalizedName(Strings.BLOCK_STEELBLOCK);
		this.setCreativeTab(CommonProxy.tabCityscape);
	}
}