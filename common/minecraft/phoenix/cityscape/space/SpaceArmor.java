package minecraft.phoenix.cityscape.space;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class SpaceArmor extends ItemArmor
{
	public SpaceArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(CivilizationSpace.tabSpace);
	}
}
