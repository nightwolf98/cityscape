package minecraft.phoenix.cityscape.space.world;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

public class WorldSaveSolarSpawn extends WorldSavedData{
	 
	 public boolean alreadyGenerated = false;
	 
	 public WorldSaveSolarSpawn(String par1Str){
		 
		 super(par1Str);
	 }

	 @Override
	 public void readFromNBT(NBTTagCompound nbt){
		 
			 alreadyGenerated = nbt.getBoolean("generatedSolarSystem");
	 }

	 @Override
	 public void writeToNBT(NBTTagCompound nbt){
		 
			 nbt.setBoolean("generatedSolarSystem", alreadyGenerated);
	 }
}