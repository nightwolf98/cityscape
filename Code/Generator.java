package nightWolf.cityscape;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class Generator extends Block {
	


        public Generator (int i, Material material) {
        	super(i, material);
        
        }
        
        public int getBlockTextureFromSide(int i){
        	
        	int a1 = 18;
        	int a2 = 19;
        	int a3 = 16;
        	int a4 = 17;
        	int a5 = 21;
        	int a6 = 20;
        	

			if (i == 0)
        	return a1;

        	else if (i == 1)
        	return a2;

        	else if (i == 2)
        	return a3;

        	else if (i == 3)
        	return a4;

        	else if (i == 4)
        	return a5;

        	else if (i == 5)
        	return a6;

        	else
        	return a1;

        	}
        
        @Override
        public String getTextureFile () {
                return CommonProxy.BLOCK_PNG;
               
        }
        
        
        


}