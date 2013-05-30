package minecraft.phoenix.cityscape.space.item;

import minecraft.phoenix.cityscape.space.CivilizationSpace;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;

public class ModItem{
	
	//Initializing the Items
	public static Item SpaceHelmet;
    public static Item SpaceChest;
    public static Item SpaceLegs;
    public static Item SpaceBoots;
    
    /**
     * Adding the items to the game
     */
    
    public static void init(){
    	
	SpaceHelmet = new ItemSpaceHelmet(1000, CivilizationSpace.EnumArmorMaterialSpace, ModLoader.addArmor("spacesuit"), 0);
    SpaceChest = new ItemSpaceChest(1001, CivilizationSpace.EnumArmorMaterialSpace, ModLoader.addArmor("spacesuit"), 1);
    SpaceLegs = new ItemSpaceLegs(1002, CivilizationSpace.EnumArmorMaterialSpace, ModLoader.addArmor("spacesuit"), 2);
    SpaceBoots = new ItemSpaceBoots(1003, CivilizationSpace.EnumArmorMaterialSpace, ModLoader.addArmor("spacesuit"), 3);
    }
}