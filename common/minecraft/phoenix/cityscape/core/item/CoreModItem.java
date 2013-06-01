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
    
    /**
     * Adding the items to the game
     */
    
    public static void init()
    {
    	roadPainter= new RoadPainterItem(5001);
    }
}