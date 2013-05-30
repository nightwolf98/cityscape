package minecraft.phoenix.cityscape.space.block;

import minecraft.phoenix.cityscape.space.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 21 Century Mod
 * 
 * ModBlock
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class ModBlock {
   
	//Initializing Blocks
	public static Block moonrock;
    public static Block vecBlock;
    
    /**
     * Adding all blocks to the game
     * 
     */
    
	public static void init(){
		
		moonrock = new BlockMoonRock(250);
		vecBlock = new BlockVecBlock(251, Material.air).setUnlocalizedName("vecBlock");
		
		GameRegistry.registerBlock(moonrock, Strings.BLOCK_MOONROCK);
	}
}