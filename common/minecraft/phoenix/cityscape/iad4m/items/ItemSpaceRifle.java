package iad4m.items;

import iad4m.iAd4m;
import iad4m.entity.EntityBullet;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpaceRifle extends Item{

//These are all of our base variables for our gun
private int damage; //Damage in half-hearts
private int reloadtick; //The current value of our reloading timer
private int reloadmax; //The value that the reloadtick variable needs to be in order for the gun to reload
private int clipid = 204; //The item id of our clip
private int ammo; //The amount of ammo avaliable per clip (used in setting durability)
private int firetick; //The current value of our shooting timer
private int firemax; //The value that the firetick variable needs to be in order for the gun to fire
//Fire delay is completely ignored when firemax is set to 0
private String firesound; //The String that notch uses in his code to figure out what sound to play when we shoot our gun
private String reloadsound; //Firesound but with reloading


//The parameters for our constructor are:
//int i (the id), int damage (damage in half-hearts), int ammo (how much ammo per clip)
//int clipid (the item id of the clip this gun uses), int firedelay (the value of firemax)
//String firesound (the value of firesound), String reloadsound (the value of reloadsound)
public ItemSpaceRifle(int i, int damage, int ammo, int clipid, int firedelay, String firesound, String reloadsound){
 
  super(i); //calls the Item.java constructor and passes in the item id for a parameter
  this.damage = damage; //sets the damage value
  firemax = firedelay; //sets the firemax value
  firetick = firemax; //sets the firetick value equal to firemax (so you don't need to wait for the delay on the first shot)
  reloadmax = 5; //sets the reload max
  reloadtick = 0; //sets the reloadtick to 0
  this.ammo = ammo; //sets the ammo
  this.clipid = clipid; //sets the clipid
  this.firesound = firesound; //sets the firesound
  this.reloadsound = reloadsound; //sets the reloadsound
  setMaxStackSize(1); //sets the max stack size to one
  setMaxDamage(ammo + 1); //sets the durability of our gun to the ammo count + 1
  this.setCreativeTab(CreativeTabs.tabCombat);
}

public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
 
  //Checks if the player has enough ammo
  if(!par2World.isRemote && par1ItemStack.getItemDamage() < ammo){
  
   //if the firemax isn't 0, and the fireing counter is done, then this is true
   if(firetick == firemax && firemax != 0){
   
        //spawns the bullet
        par2World.spawnEntityInWorld(new EntityBullet(par2World, par3EntityPlayer, damage, 1));
        //plays the sound effect
        par2World.playSoundAtEntity(par3EntityPlayer, firesound, 1F, 1F);
        //damages the gun
        par1ItemStack.damageItem(1, par3EntityPlayer);
        //resets the fire delay counter
        firetick = 0;
   
   }else{
   
        //if the fire delay counter isn't done, then this is called, which increases the fire delay counter
        ++firetick;
   }
  
   //if firemax is 0 none of  the above was called, so call this instead
   if(firemax == 0){
   
        par2World.spawnEntityInWorld(new EntityBullet(par2World, par3EntityPlayer, damage, 1));
        par2World.playSoundAtEntity(par3EntityPlayer, firesound, 1F, 1F);
        par1ItemStack.damageItem(1, par3EntityPlayer);
        //already explained...
   }
  
  //If the player is out of ammo in the current clip, and the player has the correct clip, run this code
  }else if(!par2World.isRemote && par3EntityPlayer.inventory.hasItem(clipid) && par1ItemStack.getItemDamage() == ammo){
  
   //checks for the reload timer to complete
   if(reloadtick == reloadmax){
   
        //resets the reload timer
        reloadtick = 0;
        //plays the reload sound
        par2World.playSoundAtEntity(par3EntityPlayer, reloadsound, 1F, 1F);
        //consumes the item of the clipid
        par3EntityPlayer.inventory.consumeInventoryItem(clipid);
        //resets the ammo of the gun
        par1ItemStack.setItemDamage(0);
   
   }else{
   
        //just like with firetick and firemax...
        ++reloadtick;
   }
  }
 
  //just some housekeeping stuff
  return par1ItemStack;
}

public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int i){
 
  //this resets the firetick. I originally planned on using this method for non-automatic weapons
  //but the method didn't seem to end up being called at all... if someone could clarify why this is
  //happening I would appreciate it...
  firetick = firemax;
}
}