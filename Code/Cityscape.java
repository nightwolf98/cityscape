package nightWolf.cityscape;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="cityScape", name="21st Century Mod", version="1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Cityscape {
		
		//ASPHALT BLOCKS
		public final static Block asphalt = new Asphalt(500, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("asphalt").setCreativeTab(CreativeTabs.tabBlock);
		
		public final static Block asphalt_DYH = new Asphalt_DYH(501, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("Double Yellow line").setCreativeTab(CreativeTabs.tabBlock);
		
		public final static Block asphalt_DYV = new Asphalt_DYV(502, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("Double Yellow line").setCreativeTab(CreativeTabs.tabBlock);
		
		public final static Block asphalt_SWV = new Asphalt_SWV(503, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("Middle White Line").setCreativeTab(CreativeTabs.tabBlock);
		
		public final static Block asphalt_SWH = new Asphalt_SWH(504, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("Middle White Line").setCreativeTab(CreativeTabs.tabBlock);
		
		public final static Block asphalt_SWB = new Asphalt_SWB(505, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("Single White Line").setCreativeTab(CreativeTabs.tabBlock);
		
		public final static Block asphalt_SWL = new Asphalt_SWL(506, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("Single White Line").setCreativeTab(CreativeTabs.tabBlock);
		
		public final static Block asphalt_SWR = new Asphalt_SWR(507, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("Single White Line").setCreativeTab(CreativeTabs.tabBlock);
		
		public final static Block asphalt_SWT = new Asphalt_SWT(508, Material.ground)
		.setHardness(0.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("Single White Line").setCreativeTab(CreativeTabs.tabBlock);
		
		//STEEl
		public final static Block steelBlock = new SteelBlock(511, Material.rock)
		.setHardness(2.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("Steel").setCreativeTab(CreativeTabs.tabBlock);
		
		//GENERATOR
		public final static Block generator = new Generator(514, Material.rock)
		.setHardness(2.5F).setStepSound(Block.soundGravelFootstep)
		.setBlockName("generator").setCreativeTab(CreativeTabs.tabBlock);
		
		
		
		public  final static Item roadPainterItem = new RoadPainterItem(5001).setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setIconIndex(0).setItemName("roadPainter");
		
	
        // The instance of your mod that Forge uses.
        @Instance("cityScape")
        public static Cityscape instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="nightWolf.cityscape.client.ClientProxy", serverSide="nightWolf.cityscape.CommonProxy")
        public static CommonProxy proxy;
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        @Init
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                //ASPHALT
                GameRegistry.registerBlock(asphalt, "asphat");
                LanguageRegistry.addName(asphalt, "Asphalt");
                MinecraftForge.setBlockHarvestLevel(asphalt, "shovel", 0);
                
                GameRegistry.registerBlock(asphalt_DYH, "asphat_DYH");
                LanguageRegistry.addName(asphalt_DYH, "Double Yellow Line");
                MinecraftForge.setBlockHarvestLevel(asphalt_DYH, "shovel", 0);
                
                GameRegistry.registerBlock(asphalt_DYV, "asphat_DYV");
                LanguageRegistry.addName(asphalt_DYV, "Double Yellow Line");
                MinecraftForge.setBlockHarvestLevel(asphalt_DYV, "shovel", 0);
                
                GameRegistry.registerBlock(asphalt_SWV, "asphat_SWV");
                LanguageRegistry.addName(asphalt_SWV, "Single White Line");
                MinecraftForge.setBlockHarvestLevel(asphalt_SWV, "shovel", 0);
                
                GameRegistry.registerBlock(asphalt_SWH, "asphat_SWH");
                LanguageRegistry.addName(asphalt_SWH, "Single White Line");
                MinecraftForge.setBlockHarvestLevel(asphalt_SWH, "shovel", 0);
                
                GameRegistry.registerBlock(asphalt_SWB, "asphat_SWB");
                LanguageRegistry.addName(asphalt_SWB, "Single White Line");
                MinecraftForge.setBlockHarvestLevel(asphalt_SWB, "shovel", 0);
                
                GameRegistry.registerBlock(asphalt_SWL, "asphat_SWL");
                LanguageRegistry.addName(asphalt_SWL, "Single White Line");
                MinecraftForge.setBlockHarvestLevel(asphalt_SWL, "shovel", 0);
                
                GameRegistry.registerBlock(asphalt_SWR, "asphat_SWR");
                LanguageRegistry.addName(asphalt_SWR, "Single White Line");
                MinecraftForge.setBlockHarvestLevel(asphalt_SWR, "shovel", 0);
                
                GameRegistry.registerBlock(asphalt_SWT, "asphat_SWT");
                LanguageRegistry.addName(asphalt_SWT, "Single White Line");
                MinecraftForge.setBlockHarvestLevel(asphalt_SWT, "shovel", 0);
                
                //STEEL
                GameRegistry.registerBlock(steelBlock, "steelBlock");
                LanguageRegistry.addName(steelBlock, "Steel");
                MinecraftForge.setBlockHarvestLevel(steelBlock, "pickaxe", 2);
                
                //GENERATOR
                GameRegistry.registerBlock(generator, "generator");
                LanguageRegistry.addName(generator, "generator");
                MinecraftForge.setBlockHarvestLevel(generator, "pickaxe", 1);
                
                LanguageRegistry.addName(roadPainterItem, "Road Painter");
               
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}