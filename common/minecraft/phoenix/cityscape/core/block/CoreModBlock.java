package minecraft.phoenix.cityscape.core.block;

import minecraft.phoenix.cityscape.core.lib.BlockIds;
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
		asphalt_DYH = new Asphalt(BlockIds.BlockID_Asphalt_DYH, Material.ground).setUnlocalizedName(Strings.BLOCK_ASPHALT_DYH);
		asphalt_DYV = new Asphalt(BlockIds.BlockID_Asphalt_DYV, Material.ground).setUnlocalizedName(Strings.BLOCK_ASPHALT_DYV);
		asphalt_SWV = new Asphalt(BlockIds.BlockID_Asphalt_SWV, Material.ground).setUnlocalizedName(Strings.BLOCK_ASPHALT_SWT);
		asphalt_SWH = new Asphalt(BlockIds.BlockID_Asphalt_SWH, Material.ground).setUnlocalizedName(Strings.BLOCK_ASPHALT_SWH);
		asphalt_SWB = new Asphalt(BlockIds.BlockID_Asphalt_SWB, Material.ground).setUnlocalizedName(Strings.BLOCK_ASPHALT_SWB);
		asphalt_SWL = new Asphalt(BlockIds.BlockID_Asphalt_SWL, Material.ground).setUnlocalizedName(Strings.BLOCK_ASPHALT_SWL);
		asphalt_SWR = new Asphalt(BlockIds.BlockID_Asphalt_SWR, Material.ground).setUnlocalizedName(Strings.BLOCK_ASPHALT_SWR);
		asphalt_SWT = new Asphalt(BlockIds.BlockID_Asphalt_SWT, Material.ground).setUnlocalizedName(Strings.BLOCK_ASPHALT_SWT);
		steelBlock = new SteelBlock(BlockIds.BlockID_SteelBlock, Material.rock);
		generator = new Generator(BlockIds.BlockID_Generator, Material.rock);
		
		GameRegistry.registerBlock(asphalt, Strings.BLOCK_ASPHALT);
		GameRegistry.registerBlock(asphalt_DYH, Strings.BLOCK_ASPHALT_DYH);
		GameRegistry.registerBlock(asphalt_DYV, Strings.BLOCK_ASPHALT_DYV);
		GameRegistry.registerBlock(asphalt_SWV, Strings.BLOCK_ASPHALT_SWV);
		GameRegistry.registerBlock(asphalt_SWH, Strings.BLOCK_ASPHALT_SWH);
		GameRegistry.registerBlock(asphalt_SWB, Strings.BLOCK_ASPHALT_SWB);
		GameRegistry.registerBlock(asphalt_SWL, Strings.BLOCK_ASPHALT_SWL);
		GameRegistry.registerBlock(asphalt_SWR, Strings.BLOCK_ASPHALT_SWR);
		GameRegistry.registerBlock(asphalt_SWT, Strings.BLOCK_ASPHALT_SWT);
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