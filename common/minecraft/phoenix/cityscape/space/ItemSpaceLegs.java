package minecraft.phoenix.cityscape.space;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpaceLegs extends ItemArmor
{
	public ItemSpaceLegs(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	@SideOnly(Side.CLIENT)
    public void func_94581_a(IconRegister iconRegister)
    {
		this.itemIcon = iconRegister.registerIcon(CivilizationSpace.modid + ":" + this.getUnlocalizedName());
    }
}
