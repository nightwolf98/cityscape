package minecraft.phoenix.cityscape.space.block;

import minecraft.phoenix.cityscape.space.CivilizationSpace;
import minecraft.phoenix.cityscape.space.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
 
/**
 * 21 Century Mod
 * 
 * BlockMoodRock
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class BlockMoonRock extends Block{
	
    public BlockMoonRock(int par1){
    	
        super(par1, Material.rock);
        this.setCreativeTab(CivilizationSpace.tabSpace);
        this.setUnlocalizedName(Strings.BLOCK_MOONROCK);
    }
}