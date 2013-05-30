package minecraft.phoenix.cityscape.space.world;

import java.util.List;
import java.util.Random;

import minecraft.phoenix.cityscape.space.world.MapGenSatellite.satellite;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

/**
 * 21 Century Mod
 * 
 * ChunkProviderSpace
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class ChunkProviderSpace implements IChunkProvider
{
    /** Reference to the World object. */
    private World worldObj;

    /** The biomes that are used to generate the chunk */
    private BiomeGenBase[] biomesForGeneration;

    /**
     * Used to store the 5x5 parabolic field that is used during terrain generation.
     */
    float[] parabolicField;
    int[][] field_73219_j = new int[32][32];
    
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

    public ChunkProviderSpace(World par1World)
    {
        this.worldObj = par1World;
    }

    public Chunk loadChunk(int par1, int par2)
    {
        return this.provideChunk(par1, par2);
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int par1, int par2)
    {
        byte[] var3 = new byte[32768];
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
        
        solGenerator.generate(worldObj, new Random(), 0, 128, 0);
        belisamaGenerator.generate(worldObj, new Random(), 0, 128, 0);
        icaunusGenerator.generate(worldObj, new Random(), 0, 128, 0);
        overworldGenerator.generate(worldObj, new Random(), 0, 128, 0);
        lonaGenerator.generate(worldObj, new Random(), 0, 128, 0);
        lenusGenerator.generate(worldObj, new Random(), 0, 128, 0);
        juventusGenerator.generate(worldObj, new Random(), 0, 128, 0);
        veGenerator.generate(worldObj, new Random(), 0, 128, 0);
        kuGenerator.generate(worldObj, new Random(), 0, 128, 0);
        sifGenerator.generate(worldObj, new Random(), 0, 128, 0);

        Chunk var4 = new Chunk(this.worldObj, var3, par1, par2);
        byte[] var5 = var4.getBiomeArray();

        for (int var6 = 0; var6 < var5.length; ++var6)
        {
            var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
        }

        var4.generateSkylightMap();
        return var4;
    }

    /**
     * generates a subset of the level's terrain data. Takes 7 arguments: the [empty] noise array, the position, and the
     * size.
     */
    private double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7)
    {
        return par1ArrayOfDouble;
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

    /**
     * Unloads the 100 oldest chunks from memory, due to a bug with chunkSet.add() never being called it thinks the list
     * is always empty and will not remove any chunks.
     */
    public boolean unload100OldestChunks()
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
    public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
    {
    	return null;
    }

    /**
     * Returns the location of the closest structure of the specified type. If not found returns null.
     */
    public ChunkPosition findClosestStructure(World world, String struct, int x, int y, int z){
    	satellite solarbody = MapGenSatellite.satellite.valueOf(struct);
    	switch(solarbody)
    	{
		case Belisama:
			return this.belisamaGenerator.getCoords();
		case Icaunus:
			return this.icaunusGenerator.getCoords();
		case Juventus:
			return this.juventusGenerator.getCoords();
		case Ku:
			return this.kuGenerator.getCoords();
		case Lenus:
			return this.lenusGenerator.getCoords();
		case Lona:
			return this.lonaGenerator.getCoords();
		case Overworld:
			return this.overworldGenerator.getCoords();
		case Sif:
			return this.sifGenerator.getCoords();
		case Sol:
			return this.solGenerator.getCoords();
		case Ve:
			return this.veGenerator.getCoords();
      	}
        return null;
    }

    public int getLoadedChunkCount(){
        return 0;
    }

    public void recreateStructures(int par1, int par2){}

	@Override
	public boolean unloadQueuedChunks(){
		return false;
	}

	@Override
	public void func_104112_b() {}
}