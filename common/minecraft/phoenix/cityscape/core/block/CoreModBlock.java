package minecraft.phoenix.cityscape.core.block;

import minecraft.phoenix.cityscape.core.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
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

public class CoreModBlock {
   
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
		MinecraftForge.setBlockHarvestLevel(asphalt, "shovel", 0);
		GameRegistry.registerBlock(asphalt_DYH, Strings.BLOCK_ASPHALT_DYH);
		MinecraftForge.setBlockHarvestLevel(asphalt_DYH, "shovel", 0);
		GameRegistry.registerBlock(asphalt_DYV, Strings.BLOCK_ASPHALT_DYV);
		MinecraftForge.setBlockHarvestLevel(asphalt_DYV, "shovel", 0);
		GameRegistry.registerBlock(asphalt_SWV, Strings.BLOCK_ASPHALT_SWV);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWV, "shovel", 0);
		GameRegistry.registerBlock(asphalt_SWH, Strings.BLOCK_ASPHALT_SWH);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWH, "shovel", 0);
		GameRegistry.registerBlock(asphalt_SWB, Strings.BLOCK_ASPHALT_SWB);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWB, "shovel", 0);
		GameRegistry.registerBlock(asphalt_SWL, Strings.BLOCK_ASPHALT_SWL);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWL, "shovel", 0);
		GameRegistry.registerBlock(asphalt_SWR, Strings.BLOCK_ASPHALT_SWR);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWR, "shovel", 0);
		GameRegistry.registerBlock(asphalt_SWT, Strings.BLOCK_ASPHALT_SWT);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWT, "shovel", 0);
		
		GameRegistry.registerBlock(steelBlock, "steelBlock");
		MinecraftForge.setBlockHarvestLevel(steelBlock, "pickaxe", 2);
		
		GameRegistry.registerBlock(generator, "generator");
		MinecraftForge.setBlockHarvestLevel(generator, "pickaxe", 1);
	}
}