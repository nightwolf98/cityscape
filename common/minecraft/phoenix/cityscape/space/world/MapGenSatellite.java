package minecraft.phoenix.cityscape.space.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * 21 Century Mod
 * 
 * MapGenSatellite
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class MapGenSatellite extends WorldGenerator
{
	private ChunkPosition location;
	/*
	 * Sol - sun
	 * Belisama - lakes and rivers, fire, crafts and light
	 * Icaunus -  river
	 * OverWorld - Sticks out a bit
	 * Lona - lunar deity
	 * Belenus - healing
	 * Camalos - war and sky
	 * Ve - god of creation
	 * Ku - war
	 * Sif - gold hair, goddess of home, field, crop
	 */
	enum satellite {Sol, Belisama, Icaunus, Overworld, Lona, Lenus, Juventus, Ve, Ku, Sif}
	private satellite solarbody;
	
	public MapGenSatellite(satellite sat) 
	{
		solarbody = sat;
	}

	@Override
	public boolean generate(World world, Random random, int i, int j, int k)
	{
		location = new ChunkPosition(i, j, k);
		switch(solarbody)
		{
		case Sol:
			this.generateSatellite(world, random, i, j, k, 19, Block.glowStone);
			break;
		case Belisama:
			this.generateSatellite(world, random, i, j, k, 3, Block.stone);
			break;
		case Icaunus:
			this.generateSatellite(world, random, i, j, k, 5, Block.dirt);
			break;
		case Overworld:
			this.generateSatellite(world, random, i, j, k, 5, Block.cobblestone);
			break;
		case Lona:
			this.generateSatellite(world, random, i, j, k, 1, Block.wood);
			break;
		case Lenus:
			this.generateSatellite(world, random, i, j, k, 5, Block.blockDiamond);
			break;
		case Juventus:
			this.generateSatellite(world, random, i, j, k, 9, Block.planks);
			break;
		case Ve:
			this.generateSatellite(world, random, i, j, k, 1, Block.blockLapis);
			break;
		case Ku:
			this.generateSatellite(world, random, i, j, k, 1, Block.bedrock);
			break;
		case Sif:
			this.generateSatellite(world, random, i, j, k, 1, Block.blockGold);
			break;
		}
		return true;
	}

	public ChunkPosition getCoords()
	{
		return location;
	}
	
	private void generateSatellite(World world, Random random, int i, int j, int k, int diameter, Block block)
	{
		int radius = (diameter-1)/2;
		for(int x = -radius; x<=radius; x++)
			for(int y = -radius; y<=radius; y++)
				for(int z = -radius; z<= radius; z++)
					world.setBlock(x+i, y+j, z+k, block.blockID, 0, 2);
	}
}
