package minecraft.phoenix.cityscape.space.mars;

import iad4m.iAd4m;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenMars extends BiomeGenBase
{
	public BiomeGenMars(int par1)
		{
			super(par1);
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.topBlock = ((byte)iAd4m.marsGrass.blockID);
			this.fillerBlock = ((byte)Block.dirt.blockID);
			this.setBiomeName("Mars");
}
}