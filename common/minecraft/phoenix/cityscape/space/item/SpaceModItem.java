package minecraft.phoenix.cityscape.space.item;

import minecraft.phoenix.cityscape.core.proxy.CommonProxy;
import net.minecraft.item.Item;

public class SpaceModItem{
	
	//Initializing the Items
	public static Item SpaceHelmet;
    public static Item SpaceChest;
    public static Item SpaceLegs;
    public static Item SpaceBoots;
    
    /**
     * Adding the items to the game
     */
    
    public static void init()
    {
    	SpaceHelmet = new ItemSpaceHelmet(1000, CommonProxy.EnumArmorMaterialSpace, 0, 0);
    	SpaceChest = new ItemSpaceChest(1001, CommonProxy.EnumArmorMaterialSpace, 1, 0);
    	SpaceLegs = new ItemSpaceLegs(1002, CommonProxy.EnumArmorMaterialSpace, 2, 0);
    	SpaceBoots = new ItemSpaceBoots(1003, CommonProxy.EnumArmorMaterialSpace, 3, 0);
    }
}