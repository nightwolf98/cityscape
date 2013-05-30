package minecraft.phoenix.cityscape.space.block;

import minecraft.phoenix.cityscape.space.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import paulscode.sound.Vector3D;

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
	private Vector3D vector;
	
	public BlockVecBlock(int id, Material material){
		
		super(id, material);
		this.setUnlocalizedName(Strings.BLOCK_VECBLOCK);
	}
	
	
	@Override
	public boolean isAirBlock(World world, int x, int y, int z)	{
		
		return true;
	}
	
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)	{
		
		super.onBlockAdded(world, x, y, z);
		setVector(new Vector3D());
	}
	
	/**
	 * Gets the vector
	 * 
	 * @return vector
	 */
	
	public Vector3D getVector(){
		
		return vector;
	}
	
	/**
	 * Sets the vector
	 * 
	 * @param vector
	 * 			Vector to be set
	 */
	
	public void setVector(Vector3D vector){
		
		this.vector = vector;
	}
}