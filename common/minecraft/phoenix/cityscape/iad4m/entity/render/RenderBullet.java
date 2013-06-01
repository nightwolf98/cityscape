package iad4m.entity.render;

import iad4m.entity.EntityBullet;
import iad4m.models.ModelBullet;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderBullet extends RenderLiving
{
 protected ModelBullet model;
 
 public RenderBullet (ModelBullet modelBullet, float f)
 {
  super(modelBullet, f);
  model = ((ModelBullet)mainModel);
 }
 
 public void renderBullet(EntityBullet entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderBullet((EntityBullet)par1Entity, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderBullet((EntityBullet)par1Entity, par2, par4, par6, par8, par9);
    }
}
