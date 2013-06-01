package iad4m;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.client.GuiModList;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import iad4m.blocks.*;
import iad4m.dimensions.BiomeGenMars;
import iad4m.dimensions.WorldProviderMars;
import iad4m.entity.EntityBullet;
import iad4m.entity.EntityHumvee;
import iad4m.entity.render.RenderBullet;
import iad4m.entity.render.RenderHumvee;
import iad4m.items.ItemHumvee;
import iad4m.items.ItemSpaceRifle;
import iad4m.models.ModelBullet;


@Mod(modid = iAd4m.modid, name = "iAd4m", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class iAd4m
{
       public static final String modid = "iAd4m";
       
       public static MarsGrass marsGrass = (MarsGrass)new MarsGrass(200, Material.grass).setUnlocalizedName("marsGrass");
       public static Block marsPortal;
       
       public static final Item spaceRifle = new ItemSpaceRifle(203, 15, 12, 2001, 0, "bow.ogg", "").setUnlocalizedName("spaceRifle");
       public static final Item spaceRifleAmmo = new Item(204).setMaxStackSize(1).setUnlocalizedName("spaceRifleAmmo").setCreativeTab(CreativeTabs.tabCombat);
       public static final Item humvee = (new ItemHumvee(205)).setUnlocalizedName("humvee");
       
       public static int marsid = -20;
       
       public static final BiomeGenBase mars = new BiomeGenMars(25);
       
       Minecraft getMinecraftInstance() {
           return mc;
       }
       
       Minecraft mc = getMinecraftInstance();
       
       @Init
       public void load(FMLInitializationEvent event)
       {
    	   
    	   marsPortal = new MarsPortal(202).setUnlocalizedName("marsPortal");
    	   
    	   GameRegistry.registerBlock(marsGrass, modid + (marsGrass.getUnlocalizedName().substring(5)));
    	   GameRegistry.registerBlock(marsPortal, modid + (marsPortal.getUnlocalizedName()));
    	   
    	   LanguageRegistry.addName(marsGrass, "Mars Grass");
    	   LanguageRegistry.addName(marsPortal, "Mars Portal");
    	   LanguageRegistry.addName(spaceRifle, "Space Rifle");
    	   LanguageRegistry.addName(spaceRifleAmmo, "Space Rifle Ammo");
    	   LanguageRegistry.addName(humvee, "Humvee");
    	   
    	   RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet(new ModelBullet(), 1.0F));
    	   RenderingRegistry.registerEntityRenderingHandler(EntityHumvee.class, new RenderHumvee());
    	   EntityRegistry.registerModEntity(EntityHumvee.class, "Humvee", 180, this, 40, 1, true);
    	   
    	   DimensionManager.registerProviderType(marsid, WorldProviderMars.class, true);
    	   DimensionManager.registerDimension(marsid, marsid);
       }
}