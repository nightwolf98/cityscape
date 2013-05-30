package minecraft.phoenix.cityscape.space.moon;

import minecraft.phoenix.cityscape.space.CivilizationSpace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
 
public class BlockMoonRock extends Block
{
    public BlockMoonRock(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(CivilizationSpace.tabSpace);
    }
    
    public void func_94332_a(IconRegister iconRegister)
    {
    	this.blockIcon = iconRegister.registerIcon(CivilizationSpace.modid + ":moonrock");
    }
}