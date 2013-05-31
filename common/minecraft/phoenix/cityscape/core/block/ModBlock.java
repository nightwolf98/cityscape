package minecraft.phoenix.cityscape.core.block;

import minecraft.phoenix.cityscape.core.Generator;
import minecraft.phoenix.cityscape.core.SteelBlock;
import minecraft.phoenix.cityscape.core.lib.Strings;
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
 * @author jack9515
 *
 */

public class ModBlock {
   
	//Initializing Blocks
	public static Block asphalt_DYH;
	public static Block asphalt_DYV;
	public static Block asphalt_SWB;
	public static Block asphalt_SWH;
	public static Block asphalt_SWL;
	public static Block asphalt_SWR;
	public static Block asphalt_SWT;
	public static Block asphalt_SWV;
	public static Block asphalt;
	public static Block generator;
	public static Block steelBlock;
    
    /**
     * Adding all blocks to the game
     * 
     */
    
	public static void init()
	{
		asphalt = new Asphalt(500, Material.ground).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("asphalt");
		asphalt_DYH = new Asphalt_DYH(501, Material.ground).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("Double Yellow line");
		asphalt_DYV = new Asphalt_DYV(502, Material.ground).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("Double Yellow line");
		asphalt_SWV = new Asphalt_SWV(503, Material.ground).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("Middle White Line");
		asphalt_SWH = new Asphalt_SWH(504, Material.ground).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("Middle White Line");
		asphalt_SWB = new Asphalt_SWB(505, Material.ground).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("Single White Line");
		asphalt_SWL = new Asphalt_SWL(506, Material.ground).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("Single White Line");
		asphalt_SWR = new Asphalt_SWR(507, Material.ground).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("Single White Line");
		asphalt_SWT = new Asphalt_SWT(508, Material.ground).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("Single White Line");
		
		steelBlock = new SteelBlock(511, Material.rock).setHardness(2.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("Steel");
		
		generator = new Generator(514, Material.rock).setHardness(2.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("generator");
		
		GameRegistry.registerBlock(asphalt, Strings.BLOCK_ASPHALT);
	}
}