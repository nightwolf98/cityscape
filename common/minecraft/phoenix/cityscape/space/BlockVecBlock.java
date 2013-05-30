package minecraft.phoenix.cityscape.space;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import paulscode.sound.Vector3D;

public class BlockVecBlock extends Block
{
	private Vector3D vector;
	
	public BlockVecBlock(int id, Material material)
	{
		super(id, material);
	}
	
	@Override
	public boolean isAirBlock(World world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		setVector(new Vector3D());
	}
	
	public Vector3D getVector()
	{
		return vector;
	}
	
	public void setVector(Vector3D vector)
	{
		this.vector = vector;
	}
}
