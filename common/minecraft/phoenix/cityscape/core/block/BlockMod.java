package minecraft.phoenix.cityscape.core.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * 21 Century Mod
 * 
 * BlockMod
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class BlockMod extends ItemBlock
{
       public BlockMod(int par1)
       {
             super(par1);
             setHasSubtypes(true);
       }
      
       public String getUnlocalizedName(ItemStack itemstack)
       {
             String name = "";
             switch(itemstack.getItemDamage())
             {
                    case 0:{  name = "";  break; }
                    case 1:{  name = "_DYH";  break; }
                    case 2:{  name = "_DYV";  break; }
                    case 3:{  name = "_SWV";  break; }
                    case 4:{  name = "_SWH";  break; }
                    case 5:{  name = "_SWB";  break; }
                    case 6:{  name = "_SWL";  break; }
                    case 7:{  name = "_SWR";  break; }
                    case 8:{  name = "_SWT";  break; }
                    default: name = "";
             }
             return getUnlocalizedName()+ name;
       }
      
       public int getMetadata(int par1)
       {
             return par1;
       }
}