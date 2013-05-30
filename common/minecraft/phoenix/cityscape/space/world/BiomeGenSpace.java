package minecraft.phoenix.cityscape.space.world;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenSpace extends BiomeGenBase
{
    public BiomeGenSpace(int par1)
    {
        super(par1);
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
    }
}
