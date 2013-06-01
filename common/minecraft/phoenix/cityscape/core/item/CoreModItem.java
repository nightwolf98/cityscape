package minecraft.phoenix.cityscape.core.item;

import net.minecraft.item.Item;

/**
 * 21 Century Mod
 * 
 * CoreModItem
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class CoreModItem{
	
	//Initializing the Items
	public static Item roadPainter;
	public static Item humvee;
	public static Item spaceRifle;
    
    /**
     * Adding the items to the game
     */
    
    public static void init()
    {
    	roadPainter= new RoadPainterItem(5001);
    	humvee = new ItemHumvee(5002);
    	spaceRifle = new ItemSpaceRifle(5003, 15, 12, 2001, 0, "bow.ogg", "");
    }
}