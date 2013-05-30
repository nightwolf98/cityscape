package minecraft.phoenix.cityscape.space.entity;

import java.util.List;

import minecraft.phoenix.cityscape.space.item.ModItem;
import minecraft.phoenix.cityscape.space.world.Space;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

/**
 * 21 Century Mod
 * 
 * EntityPlayerSpace
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 *
 */

public class EntityPlayerSpace extends PlayerBase{
	
	boolean once = true;
	public int moonAir, maxAir;
	private Vec3 portalPos;

	public EntityPlayerSpace(PlayerAPI playerAPI){
		
		super(playerAPI);
		maxAir = moonAir = 100;
	}

	/**
	 * gets Portal Position
	 * @return vector portal position
	 */
	public Vec3 getPortalPos(){
		
		return portalPos;
	}

	/**
	 * sets Portal Position
	 * @param portalPos
	 * 			Portal Position
	 */
	
	public void setPortalPos(Vec3 portalPos){
		
		this.portalPos = portalPos;
	}

	@Override
	public void onLivingUpdate()
	{
		if(player.dimension == Space.space)
		{
			ItemStack boots = player.inventory.armorInventory[0];
			ItemStack legs = player.inventory.armorInventory[1];
			ItemStack chest = player.inventory.armorInventory[2];
			ItemStack helm = player.inventory.armorInventory[3];
			if (!(boots == null || legs == null || chest == null || helm == null)){
				if (boots.itemID == ModItem.SpaceBoots.itemID
						&& legs.itemID == ModItem.SpaceLegs.itemID
						&& chest.itemID == ModItem.SpaceChest.itemID
						&& helm.itemID == ModItem.SpaceHelmet.itemID){
					moonAir = maxAir;
				}
			}
			
			moonAir--;
			int air = (int) ((300.0 / maxAir) * moonAir);
			
			if (moonAir == -5){
				moonAir = 0;
			}
			
			if (player.sprintingTicksLeft > 0){
	            --player.sprintingTicksLeft;

	            if (player.sprintingTicksLeft == 0){
	                player.setSprinting(false);
	            }
	        }

	        if (player.getSprintToggleTimerField() > 0){
	            player.setSprintToggleTimerField(player.getSprintToggleTimerField()-1);
	        }

	        if (player.getMcField().playerController.enableEverythingIsScrewedUpMode()){
	            player.posX = player.posZ = 0.5D;
	            player.posX = 0.0D;
	            player.posZ = 0.0D;
	            player.rotationYaw = (float)player.ticksExisted / 12.0F;
	            player.rotationPitch = 10.0F;
	            player.posY = 68.5D;
	        }
	        else 
	        	if (!player.getMcField().statFileWriter.hasAchievementUnlocked(AchievementList.openInventory)){
	                player.getMcField().guiAchievement.queueAchievementInformation(AchievementList.openInventory);
	            }

	            player.prevTimeInPortal = player.timeInPortal;

	            if (player.getInPortalField()){
	                if (player.getMcField().currentScreen != null){
	                    player.getMcField().displayGuiScreen((GuiScreen)null);
	                }

	                if (player.timeInPortal == 0.0F){
	                    player.getMcField().sndManager.playSoundFX("portal.trigger", 1.0F, player.getRandField().nextFloat() * 0.4F + 0.8F);
	                }

	                player.timeInPortal += 0.0125F;

	                if (player.timeInPortal >= 1.0F){
	                    player.timeInPortal = 1.0F;
	                }

	                player.setInPortalField(false);
	            }
	            else if (player.isPotionActive(Potion.confusion) && player.getActivePotionEffect(Potion.confusion).getDuration() > 60){
	                player.timeInPortal += 0.006666667F;

	                if (player.timeInPortal > 1.0F){
	                    player.timeInPortal = 1.0F;
	                }
	            }
	            else
	                if (player.timeInPortal > 0.0F){
	                    player.timeInPortal -= 0.05F;
	                }

	                if (player.timeInPortal < 0.0F){
	                    player.timeInPortal = 0.0F;
	                }
	            }

	            if (player.timeUntilPortal > 0){
	                --player.timeUntilPortal;
	            }

	            boolean var1 = player.movementInput.jump;
	            float var2 = 0.8F;
	            boolean var3 = player.movementInput.moveForward >= var2;
	            player.movementInput.updatePlayerMoveState();

	            if (player.isUsingItem()){
	                player.movementInput.moveStrafe *= 0.2F;
	                player.movementInput.moveForward *= 0.2F;
	                player.setSprintToggleTimerField(0);
	            }

	            if (player.movementInput.sneak && player.ySize < 0.2F){
	                player.ySize = 0.2F;
	            }

//	            this.pushOutOfBlocks(player.posX - (double)player.width * 0.35D, player.boundingBox.minY + 0.5D, player.posZ + (double)player.width * 0.35D);
//	            this.pushOutOfBlocks(player.posX - (double)player.width * 0.35D, player.boundingBox.minY + 0.5D, player.posZ - (double)player.width * 0.35D);
//	            this.pushOutOfBlocks(player.posX + (double)player.width * 0.35D, player.boundingBox.minY + 0.5D, player.posZ - (double)player.width * 0.35D);
//	            this.pushOutOfBlocks(player.posX + (double)player.width * 0.35D, player.boundingBox.minY + 0.5D, player.posZ + (double)player.width * 0.35D);
	            boolean var4 = (float)player.getFoodStats().getFoodLevel() > 6.0F || player.capabilities.allowFlying;

	            if (player.onGround && !var3 && player.movementInput.moveForward >= var2 && !player.isSprinting() && var4 && !player.isUsingItem() && !player.isPotionActive(Potion.blindness)){
	                if (player.getSprintToggleTimerField() == 0){
	                    player.setSprintToggleTimerField(7);
	                }
	                else{
	                    player.setSprinting(true);
	                    player.setSprintToggleTimerField(0);
	                }
	            }

	            if (player.isSneaking()){
	                player.setSprintToggleTimerField(0);
	            }

	            if (player.isSprinting() && (player.movementInput.moveForward < var2 || player.isCollidedHorizontally || !var4)){
	                player.setSprinting(false);
	            }

	            if (player.capabilities.allowFlying && !var1 && player.movementInput.jump){
	                if (player.getFlyToggleTimerField() == 0){
	                    player.setFlyToggleTimerField(7);
	                }
	                else{
	                    player.capabilities.isFlying = !player.capabilities.isFlying;
	                    player.sendPlayerAbilities();
	                    player.setFlyToggleTimerField(0);
	                }
	            }

	            if (player.capabilities.isFlying){
	                if (player.movementInput.sneak){
	                    player.motionY -= 0.15D;
	                }

	                if (player.movementInput.jump){
	                    player.motionY += 0.15D;
	                }
	            }

	            if (player.getFlyToggleTimerField() > 0){
	                player.setFlyToggleTimerField(player.getFlyToggleTimerField()-1);
	            }

	            if (player.worldObj.difficultySetting == 0 && player.getHealth() < player.getMaxHealth() && player.ticksExisted % 20 * 12 == 0){
	                player.heal(1);
	            }

	            player.inventory.decrementAnimations();
	            player.prevCameraYaw = player.cameraYaw;
	            super.onLivingUpdate();
	            player.landMovementFactor = player.capabilities.getWalkSpeed();
	            player.jumpMovementFactor = player.getSpeedInAirField();

	            if (player.isSprinting()){
	                player.landMovementFactor = (float)((double)player.landMovementFactor + (double)player.capabilities.getWalkSpeed() * 0.3D);
	                player.jumpMovementFactor = (float)((double)player.jumpMovementFactor + (double)player.getSpeedInAirField() * 0.3D);
	            }

	            float f = MathHelper.sqrt_double(player.motionX * player.motionX + player.motionZ * player.motionZ);
	            float f1 = (float)Math.atan(-player.motionY * 0.20000000298023224D) * 15.0F;

	            if (f > 0.1F){
	                f = 0.1F;
	            }

	            if (!player.onGround || player.getHealth() <= 0){
	                f = 0.0F;
	            }

	            if (player.onGround || player.getHealth() <= 0){
	                f1 = 0.0F;
	            }

	            player.cameraYaw += (f - player.cameraYaw) * 0.4F;
	            player.cameraPitch += (f1 - player.cameraPitch) * 0.8F;

	            if (player.getHealth() > 0){
	                List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player, player.boundingBox.expand(1.0D, 0.5D, 1.0D));

	                if (list != null){
	                    for (int i = 0; i < list.size(); ++i){
	                        Entity entity = (Entity)list.get(i);

	                        if (!entity.isDead){
	                        	entity.onCollideWithPlayer(player);;
	                        }
	                    }
	                }
	            }

	            if (player.onGround && player.capabilities.isFlying){
	                player.capabilities.isFlying = false;
	                player.sendPlayerAbilities();
	            }
	        }
		else
			super.onLivingUpdate();
	}//XXX ?????
}