package minecraft.phoenix.cityscape.space;

import minecraft.phoenix.cityscape.space.moon.BiomeGenMoon;
import minecraft.phoenix.cityscape.space.moon.BlockMoonRock;
import minecraft.phoenix.cityscape.space.moon.WorldProviderMoon;
import minecraft.phoenix.cityscape.space.world.Space;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.CommandHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import net.minecraft.src.PlayerAPI;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = CivilizationSpace.modid, name = "21st Century Mod", version = "0.1a")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CivilizationSpace
{
	public static final String modid = "21st_Century_Mod";
	private Space space = new Space();
	
	@SidedProxy(clientSide = "XXIstCenturyMod.space.ClientProxyCivilization", serverSide = "XXIstCenturyMod.space.CommonProxyCivilization")
	public static CommonProxyCivilization proxy;
	public static ClientProxyCivilization proxy1;
	
	public static int moon;
    
    public static final BiomeGenBase moonBiome = (new BiomeGenMoon(30)).setColor(16421912).setBiomeName("Moon").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);
    
    static EnumArmorMaterial EnumArmorMaterialSpace = EnumHelper.addArmorMaterial("Space Armor", 35, new int[] {4,9,7,6}, 15);
    
    public static Item SpaceHelmet = new ItemSpaceHelmet(1000, EnumArmorMaterialSpace, ModLoader.addArmor("spacesuit"), 0).setUnlocalizedName("spacehelm");
    public static Item SpaceChest = new ItemSpaceChest(1001, EnumArmorMaterialSpace, ModLoader.addArmor("spacesuit"), 1).setUnlocalizedName("spacechest");
    public static Item SpaceLegs = new ItemSpaceLegs(1002, EnumArmorMaterialSpace, ModLoader.addArmor("spacesuit"), 2).setUnlocalizedName("spacelegs");
    public static Item SpaceBoots = new ItemSpaceBoots(1003, EnumArmorMaterialSpace, ModLoader.addArmor("spacesuit"), 3).setUnlocalizedName("spaceboots");
    
    public static CreativeTabs tabSpace = new TabSpace(CreativeTabs.getNextID(), "21st Century: Space");
    public static Block moonrock = new BlockMoonRock(250).setUnlocalizedName("moonrock").setCreativeTab(tabSpace);
    public static Block vecBlock = new BlockVecBlock(251, Material.air).setUnlocalizedName("vecBlock");
			 
	@Init
	public void load(FMLInitializationEvent event)
	{
		space.load(event);
		GameRegistry.registerBlock(moonrock, "moonRock");
		LanguageRegistry.addName(moonrock, "Moon Rock");
         
		proxy.registerRenderThings();
        
		moon = DimensionManager.getNextFreeDimId();
        DimensionManager.registerProviderType(moon, WorldProviderMoon.class, false);
        DimensionManager.registerDimension(moon, moon);
        
        GameRegistry.addBiome(moonBiome);
        
        
    	LanguageRegistry.addName(SpaceHelmet, "SpaceSuit Helmet");
    	LanguageRegistry.addName(SpaceChest, "SpaceSuit Chest");
    	LanguageRegistry.addName(SpaceLegs, "SpaceSuit Legs");
    	LanguageRegistry.addName(SpaceBoots, "SpaceSuit Boots");
        
        LanguageRegistry.instance().addStringLocalization("entity.cityscape.Shuttle.name", "Shuttle");
        PlayerAPI.register(modid, EntityPlayerSpace.class);
	}
	
	@ServerStarting
	public void serverStarting(FMLServerStartingEvent event)
	{
		CommandHandler commandManager = (CommandHandler)event.getServer().getCommandManager();
	    commandManager.registerCommand(new CommandTpToDim());
	}

}
