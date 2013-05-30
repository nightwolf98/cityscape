package minecraft.phoenix.cityscape.space.world;

import minecraft.phoenix.cityscape.space.util.NullCloudRenderer;
import minecraft.phoenix.cityscape.space.util.SkyRendererUtil;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderSpace extends WorldProvider
{

	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Space.spaceBiome, 0.8F, 0.1F);
		this.dimensionId = Space.space;
		this.setSkyRenderer(new SkyRendererUtil(0));
		this.setCloudRenderer(new NullCloudRenderer());
		this.setAllowedSpawnTypes(false, false);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
	{
		return cameraEntity.worldObj.getWorldVec3Pool().getVecFromPool(0.0F, 0.0F, 0.0F);
	}
	
	@Override
	public double getMovementFactor()
	{
		return 16.0D;
	}
	
	@Override
	public float getStarBrightness(float par1)
	{
		return 1.0F;
	}
	
	public String getDimensionName() 
	{
		return "Space";
	}
	
	public boolean canRespawnHere()
	{
		return false;
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderSpace(worldObj);
	}
	
	@Override
	public float calculateCelestialAngle(long par1, float par3)
	{
		return 0.5F;
	}
	
	public String getWelcomeMessage()
	{
		return "Entering Space!";
	}

	public String getDepartMessage()
	{
		return "Leaving Space!";
	}
}