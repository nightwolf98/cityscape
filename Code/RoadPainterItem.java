package nightWolf.cityscape;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RoadPainterItem extends Item {

        public RoadPainterItem(int id) {
                super(id);
                // TODO Auto-generated constructor stub
                
             
        }
        
        @Override
        public String getTextureFile () {
                return CommonProxy.ITEMS_PNG;
        }

}