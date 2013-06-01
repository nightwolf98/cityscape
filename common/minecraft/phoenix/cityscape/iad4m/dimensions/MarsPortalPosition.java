package iad4m.dimensions;
import net.minecraft.util.ChunkCoordinates;
public class MarsPortalPosition extends ChunkCoordinates
{
public long field_85087_d;
final MarsTeleporter field_85088_e;
public MarsPortalPosition(MarsTeleporter marsTeleporter, int par2, int par3, int par4, long par5)
{
super(par2, par3, par4);
this.field_85088_e = marsTeleporter;
this.field_85087_d = par5;
}
}