package minecraft.phoenix.cityscape.core.block;

import minecraft.phoenix.cityscape.core.lib.BlockIds;
import minecraft.phoenix.cityscape.core.lib.Reference;
import minecraft.phoenix.cityscape.core.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 21 Century Mod
 * 
 * CoreModBlock
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
		asphalt = new Asphalt(BlockIds.BlockID_Asphalt, Material.ground).setUnlocalizedName(Strings.BLOCK_ASPHALT);
		steelBlock = new SteelBlock(BlockIds.BlockID_SteelBlock, Material.rock);
		generator = new Generator(BlockIds.BlockID_Generator, Material.rock);

		GameRegistry.registerBlock(asphalt, BlockMod.class, Reference.modid + (asphalt.getUnlocalizedName()));
		GameRegistry.registerBlock(steelBlock, "steelBlock");
		GameRegistry.registerBlock(generator, "generator");
		
		MinecraftForge.setBlockHarvestLevel(asphalt, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(asphalt_DYH, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(asphalt_DYV, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWV, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWH, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWB, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWL, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWR, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(asphalt_SWT, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(steelBlock, "pickaxe", 2);		
		MinecraftForge.setBlockHarvestLevel(generator, "pickaxe", 1);
	}
}