package minecraft.phoenix.cityscape.core.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CoreModItem{
	
	//Initializing the Items
	public static Item roadPainter;
    
    /**
     * Adding the items to the game
     */
    
    public static void init()
    {
    	roadPainter= new RoadPainterItem(5001).setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("roadPainter");
    }
}