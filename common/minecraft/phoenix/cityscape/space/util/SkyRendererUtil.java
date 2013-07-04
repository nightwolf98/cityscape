package minecraft.phoenix.cityscape.space.util;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.IRenderHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

/**
 * 21 Century Mod
 * 
 * SkyRendererUtil
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class SkyRendererUtil extends IRenderHandler{
	
	private boolean once = false;
	private int starGLCallList;
	private int glSkyList;
	private int glSkyList2;
	private static int atmosphere;
	
	/**
	 * @param atmosphere Reduces the number of stars in the sky (0 is max number of stars, 200 is no stars)
	 */
	public SkyRendererUtil(int atmosphere)
	{
		SkyRendererUtil.atmosphere = atmosphere;
	}
	
	public static Tessellator renderStars()
	{
		Random var1 = new Random(10842L);
        Tessellator var2 = Tessellator.instance;
        var2.startDrawingQuads();

        for (int var3 = 0; var3 < 20000-atmosphere*100; ++var3)
        {
            double var4 = (double)(var1.nextFloat() * 2.0F - 1.0F);
            double var6 = (double)(var1.nextFloat() * 2.0F - 1.0F);
            double var8 = (double)(var1.nextFloat() * 2.0F - 1.0F);
            double var10 = (double)(0.15F + var1.nextFloat() * 0.1F);
            double var12 = var4 * var4 + var6 * var6 + var8 * var8;

            if (var12 < 1.0D && var12 > 0.01D)
            {
                var12 = 1.0D / Math.sqrt(var12);
                var4 *= var12;
                var6 *= var12;
                var8 *= var12;
                double var14 = var4 * 100.0D;
                double var16 = var6 * 100.0D;
                double var18 = var8 * 100.0D;
                double var20 = Math.atan2(var4, var8);
                double var22 = Math.sin(var20);
                double var24 = Math.cos(var20);
                double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8), var6);
                double var28 = Math.sin(var26);
                double var30 = Math.cos(var26);
                double var32 = var1.nextDouble() * Math.PI * 2.0D;
                double var34 = Math.sin(var32);
                double var36 = Math.cos(var32);

                for (int var38 = 0; var38 < 4; ++var38)
                {
                    double var39 = 0.0D;
                    double var41 = (double)((var38 & 2) - 1) * var10;
                    double var43 = (double)((var38 + 1 & 2) - 1) * var10;
                    double var47 = var41 * var36 - var43 * var34;
                    double var49 = var43 * var36 + var41 * var34;
                    double var53 = var47 * var28 + var39 * var30;
                    double var55 = var39 * var28 - var47 * var30;
                    double var57 = var55 * var22 - var49 * var24;
                    double var61 = var49 * var22 + var55 * var24;
                    var2.addVertex(var14 + var57, var16 + var53, var18 + var61);
                }
            }
        }

        return var2;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void render(float partialTicks, WorldClient world, Minecraft mc)
	{
		if(!once)
		{
	        this.starGLCallList = GLAllocation.generateDisplayLists(3);
	        GL11.glPushMatrix();
	        GL11.glNewList(this.starGLCallList, GL11.GL_COMPILE);
	        SkyRendererUtil.renderStars().draw();
	        GL11.glEndList();
	        GL11.glPopMatrix();
	        Tessellator var5 = Tessellator.instance;
	        this.glSkyList = this.starGLCallList + 1;
	        GL11.glNewList(this.glSkyList, GL11.GL_COMPILE);
	        byte var7 = 64;
	        int var8 = 256 / var7 + 2;
	        float var6 = 16.0F;
	        int var9;
	        int var10;
	        for (var9 = -var7 * var8; var9 <= var7 * var8; var9 += var7)
	        {
	        	for (var10 = -var7 * var8; var10 <= var7 * var8; var10 += var7)
	            {
	                var5.startDrawingQuads();
	                var5.addVertex((double)(var9 + 0), (double)var6, (double)(var10 + 0));
	                var5.addVertex((double)(var9 + var7), (double)var6, (double)(var10 + 0));
	                var5.addVertex((double)(var9 + var7), (double)var6, (double)(var10 + var7));
	                var5.addVertex((double)(var9 + 0), (double)var6, (double)(var10 + var7));
	                var5.draw();
	            }
	        }
	        GL11.glEndList();
	        this.glSkyList2 = this.starGLCallList + 2;
	        GL11.glNewList(this.glSkyList2, GL11.GL_COMPILE);
	        var6 = -16.0F;
	        var5.startDrawingQuads();
		        for (var9 = -var7 * var8; var9 <= var7 * var8; var9 += var7)
	        {
	            for (var10 = -var7 * var8; var10 <= var7 * var8; var10 += var7)
	            {
	                var5.addVertex((double)(var9 + var7), (double)var6, (double)(var10 + 0));
	                var5.addVertex((double)(var9 + 0), (double)var6, (double)(var10 + 0));
	                var5.addVertex((double)(var9 + 0), (double)var6, (double)(var10 + var7));
	                var5.addVertex((double)(var9 + var7), (double)var6, (double)(var10 + var7));
	            }
	        }
	        var5.draw();
	        GL11.glEndList();
		}
		GL11.glDisable(GL11.GL_TEXTURE_2D);
        float var3 = 0.0F;
        float var4 = 0.0F;
        float var5 = 0.0F;
        GL11.glColor3f(var3, var4, var5);
        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_FOG);
        GL11.glColor3f(var3, var4, var5);
        GL11.glCallList(this.glSkyList);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        RenderHelper.disableStandardItemLighting();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GL11.glPushMatrix();
        float var9 = 0.0F;
        float var10 = 0.0F;
        float var11 = 0.0F;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef(var9, var10, var11);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        float var20 = world.getStarBrightness(partialTicks);
        GL11.glColor4f(var20, var20, var20, var20);
        GL11.glCallList(this.starGLCallList);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_FOG);
        GL11.glPopMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(0.0F, 0.0F, 0.0F);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 100.0F, 0.0F);
        GL11.glCallList(this.glSkyList2);
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDepthMask(true);
    }
}
