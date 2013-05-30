package nightWolf.cityscape;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class SteelBlock extends Block {
	

		static int ICONID = 13;
        public SteelBlock (int i, Material material) {
        	super(i, ICONID, material);
        
        }
        
        
        @Override
        public String getTextureFile () {
                return CommonProxy.BLOCK_PNG;
               
        }
        
        
        


}