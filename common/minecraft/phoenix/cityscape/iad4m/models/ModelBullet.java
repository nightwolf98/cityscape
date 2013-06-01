package iad4m.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBullet extends ModelBase
{
  //fields
    ModelRenderer Bullet;
  
  public ModelBullet()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Bullet = new ModelRenderer(this, 0, 0);
      Bullet.addBox(0F, 0F, 0F, 2, 2, 8);
      Bullet.setRotationPoint(-1F, 22F, -4F);
      Bullet.setTextureSize(64, 32);
      Bullet.mirror = true;
      setRotation(Bullet, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Bullet.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
