package minecraft.phoenix.cityscape.core.block;

import minecraft.phoenix.cityscape.core.Cityscape;
import minecraft.phoenix.cityscape.core.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

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
		this.setUnlocalizedName(Strings.BLOCK_ASPHALT);
		this.setCreativeTab(Cityscape.tabSpace);
	}
}