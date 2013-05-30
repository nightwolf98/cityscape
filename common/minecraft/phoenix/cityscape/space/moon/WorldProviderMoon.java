package minecraft.phoenix.cityscape.space.moon;

import minecraft.phoenix.cityscape.space.CivilizationSpace;
import minecraft.phoenix.cityscape.space.util.NullCloudRenderer;
import minecraft.phoenix.cityscape.space.util.SkyRendererUtil;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderMoon extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(CivilizationSpace.moonBiome, 0.8F, 0.1F);
		this.dimensionId = CivilizationSpace.moon;
		this.setCloudRenderer(new NullCloudRenderer());
		this.setSkyRenderer(new SkyRendererUtil(0));
	}
	
	public String getDimensionName() 
	{
		return "Moon";
	}
	
	@Override
	public boolean canRespawnHere()
	{
		return false;
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderMoon(worldObj, worldObj.getSeed(), true);
	}
	
	@Override
	public float calculateCelestialAngle(long par1, float par3)
	{
		return 0.5F;
	}
	
	public String getWelcomeMessage()
	{
		return "Entering Moon! ";
	}

	public String getDepartMessage()
	{
		return "Leaving Moon! ";
	}
	
	public float getStarBrightness(float par1)
	{
		return 1.0F;
	}
}