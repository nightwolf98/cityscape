package minecraft.phoenix.cityscape.core.item;

import minecraft.phoenix.cityscape.core.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * 21 Century Mod
 * 
 * RoadPainterItem
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class RoadPainterItem extends Item {

        public RoadPainterItem(int id) {
                super(id);
                this.setMaxStackSize(1);
                this.setCreativeTab(CreativeTabs.tabMisc);
                this.setUnlocalizedName(Strings.ITEM_ROADPAINTER_NAME);
        }
}