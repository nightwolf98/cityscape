package minecraft.phoenix.cityscape.space.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class ChunkProviderSpace implements IChunkProvider
{
	private ArrayList<ChunkPosition> solCoords = new ArrayList<ChunkPosition>(3);
	
	private MapGenSatellite solGenerator = new MapGenSatellite(MapGenSatellite.satellite.Sol);
    private MapGenSatellite belisamaGenerator = new MapGenSatellite(MapGenSatellite.satellite.Belisama);
    private MapGenSatellite icaunusGenerator = new MapGenSatellite(MapGenSatellite.satellite.Icaunus);
    private MapGenSatellite overworldGenerator = new MapGenSatellite(MapGenSatellite.satellite.Overworld);
    private MapGenSatellite lonaGenerator = new MapGenSatellite(MapGenSatellite.satellite.Lona);
    private MapGenSatellite lenusGenerator = new MapGenSatellite(MapGenSatellite.satellite.Lenus);
    private MapGenSatellite juventusGenerator = new MapGenSatellite(MapGenSatellite.satellite.Juventus);
    private MapGenSatellite veGenerator = new MapGenSatellite(MapGenSatellite.satellite.Ve);
    private MapGenSatellite kuGenerator = new MapGenSatellite(MapGenSatellite.satellite.Ku);
    private MapGenSatellite sifGenerator = new MapGenSatellite(MapGenSatellite.satellite.Sif);
	
    private World worldObj;
    private final byte[] field_82700_c = new byte[256];
    private final byte[] field_82698_d = new byte[256];

    public ChunkProviderSpace(World par1World)
    {
        this.worldObj = par1World;
    }

    /**
     * loads or generates the chunk at the chunk location specified
     */
    public Chunk loadChunk(int par1, int par2)
    {
        return this.provideChunk(par1, par2);
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int chunkX, int chunkZ)
    {
    	int x = chunkX * 16;
    	int z = chunkZ * 16;
    	if(solCoords.isEmpty() || distanceToNearest(new ChunkPosition(x, 128, z)) > 128.0D)
    	{
    		solCoords.add(new ChunkPosition(x, 128, z));
    		solGenerator.generate(worldObj, new Random(), x, 128, z);
    		belisamaGenerator.generate(worldObj, new Random(), x-30, 128, z-30);
    		icaunusGenerator.generate(worldObj, new Random(), x+40, 128, z-40);
    		overworldGenerator.generate(worldObj, new Random(), x+50, 128, z+50);
    		lonaGenerator.generate(worldObj, new Random(), x+55, 128, z+55);
    		lenusGenerator.generate(worldObj, new Random(), x-60, 128, z+60);
    		juventusGenerator.generate(worldObj, new Random(), x-70, 128, z-70);
    		veGenerator.generate(worldObj, new Random(), x-77, 128, z-77);
    		kuGenerator.generate(worldObj, new Random(), x-77, 128, z-63);
    		sifGenerator.generate(worldObj, new Random(), x-63, 128, z-77);
    	}
    	
        Chunk chunk = new Chunk(this.worldObj, chunkX, chunkZ);

        for (int k = 0; k < this.field_82700_c.length; ++k)
        {
            int l = k >> 4;
            ExtendedBlockStorage extendedblockstorage = chunk.getBlockStorageArray()[l];

            if (extendedblockstorage == null)
            {
                extendedblockstorage = new ExtendedBlockStorage(k, !this.worldObj.provider.hasNoSky);
                chunk.getBlockStorageArray()[l] = extendedblockstorage;
            }

            for (int i1 = 0; i1 < 16; ++i1)
            {
                for (int j1 = 0; j1 < 16; ++j1)
                {
                    extendedblockstorage.setExtBlockID(i1, k & 15, j1, this.field_82700_c[k] & 255);
                    extendedblockstorage.setExtBlockMetadata(i1, k & 15, j1, this.field_82698_d[k]);
                }
            }
        }

        chunk.generateSkylightMap();
        BiomeGenBase[] abiomegenbase = this.worldObj.getWorldChunkManager().loadBlockGeneratorData((BiomeGenBase[])null, chunkX * 16, chunkZ * 16, 16, 16);
        byte[] abyte = chunk.getBiomeArray();

        for (int k1 = 0; k1 < abyte.length; ++k1)
        {
            abyte[k1] = (byte)abiomegenbase[k1].biomeID;
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    private double distanceToNearest(ChunkPosition chunkPos)
	{
		double nearDistance = Double.MAX_VALUE;
		for(ChunkPosition pos : solCoords)
		{
			double dist = Math.hypot(chunkPos.x-pos.x, chunkPos.z-pos.z);
			if(dist < nearDistance)
				nearDistance = dist;
		}
		return nearDistance;
	}
    
    /**
     * Checks to see if a chunk exists at x, y
     */
    public boolean chunkExists(int par1, int par2)
    {
        return true;
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3){}

    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate)
    {
        return true;
    }

    public void func_104112_b() {}

    /**
     * Unloads chunks that are marked to be unloaded. This is not guaranteed to unload every such chunk.
     */
    public boolean unloadQueuedChunks()
    {
        return false;
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave()
    {
        return true;
    }

    /**
     * Converts the instance data to a readable string.
     */
    public String makeString()
    {
        return "SpaceLevelSource";
    }

    /**
     * Returns a list of creatures of the specified type that can spawn at the given location.
     */
    @SuppressWarnings("rawtypes")
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
    {
        return null;
    }

    /**
     * Returns the location of the closest structure of the specified type. If not found returns null.
     */
    public ChunkPosition findClosestStructure(World par1World, String par2Str, int par3, int par4, int par5)
    {
    	return null;
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }

    public void recreateStructures(int par1, int par2)
    {
    	
    }
}
