package minecraft.phoenix.cityscape.space.block;

import minecraft.phoenix.cityscape.core.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * 21 Century Mod
 * 
 * BlockVecBlock
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class BlockVecBlock extends Block{
	
	//Initizalizing a 3D vector
	private Vec3 vector;
	
	public BlockVecBlock(int id, Material material){
		
		super(id, material);
		this.setUnlocalizedName(Strings.BLOCK_VECBLOCK_NAME);
	}
	
	@Override
	public boolean isAirBlock(World world, int x, int y, int z)	{
		
		return true;
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)	{
		
		super.onBlockAdded(world, x, y, z);
		setVector(Vec3.createVectorHelper(0.0D, 0.0D, 0.0D));
	}
	
	/**
	 * Gets the vector
	 * 
	 * @return vector
	 */
	public Vec3 getVector(){
		
		return vector;
	}
	
	/**
	 * Sets the vector
	 * 
	 * @param vector
	 * 			Vector to be set
	 */
	public void setVector(Vec3 vector){
		
		this.vector = vector;
	}
}