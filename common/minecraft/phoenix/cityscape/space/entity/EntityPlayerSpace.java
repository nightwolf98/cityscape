package minecraft.phoenix.cityscape.space.entity;

import minecraft.phoenix.cityscape.space.item.SpaceModItem;
import minecraft.phoenix.cityscape.space.world.Space;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.AchievementList;
import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;

/**
 * 21 Century Mod
 * 
 * EntityPlayerSpace
 * 
 * @licence Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * @author nightwolf98
 * @author Martijn
 * @author jack9515
 *
 */

public class EntityPlayerSpace extends ClientPlayerBase {
	
	boolean once = true;
	public int moonAir, maxAir;

	public EntityPlayerSpace(ClientPlayerAPI playerAPI){
		
		super(playerAPI);
		maxAir = moonAir = 100;
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
				if (boots.itemID == SpaceModItem.SpaceBoots.itemID
						&& legs.itemID == SpaceModItem.SpaceLegs.itemID
						&& chest.itemID == SpaceModItem.SpaceChest.itemID
						&& helm.itemID == SpaceModItem.SpaceHelmet.itemID){
					moonAir = maxAir;
				}
			}
			
			moonAir--;
			player.setAir((int) ((300.0 / maxAir) * moonAir));
			
			if (moonAir == -5){
				moonAir = 0;
			}
			
			if (player.sprintingTicksLeft > 0)
	        {
	            --player.sprintingTicksLeft;

	            if (player.sprintingTicksLeft == 0)
	            {
	                player.setSprinting(false);
	            }
	        }

	        if (player.getSprintToggleTimerField() > 0)
	        {
	            player.setSprintToggleTimerField(player.getSprintToggleTimerField()-1);
	        }

	        if (player.mc.playerController.enableEverythingIsScrewedUpMode())
	        {
	            player.posX = player.posZ = 0.5D;
	            player.posX = 0.0D;
	            player.posZ = 0.0D;
	            player.rotationYaw = (float)player.ticksExisted / 12.0F;
	            player.rotationPitch = 10.0F;
	            player.posY = 68.5D;
	        }
	        else
	        {
	            if (!player.mc.statFileWriter.hasAchievementUnlocked(AchievementList.openInventory))
	            {
	                player.mc.guiAchievement.queueAchievementInformation(AchievementList.openInventory);
	            }

	            player.prevTimeInPortal = player.timeInPortal;

	            if (player.getInPortalField())
	            {
	                if (player.mc.currentScreen != null)
	                {
	                    player.mc.displayGuiScreen((GuiScreen)null);
	                }

	                if (player.timeInPortal == 0.0F)
	                {
	                    player.mc.sndManager.playSoundFX("portal.trigger", 1.0F, player.getRandField().nextFloat() * 0.4F + 0.8F);
	                }

	                player.timeInPortal += 0.0125F;

	                if (player.timeInPortal >= 1.0F)
	                {
	                    player.timeInPortal = 1.0F;
	                }

	                player.setInPortalField(false);
	            }
	            else if (player.isPotionActive(Potion.confusion) && player.getActivePotionEffect(Potion.confusion).getDuration() > 60)
	            {
	                player.timeInPortal += 0.006666667F;

	                if (player.timeInPortal > 1.0F)
	                {
	                    player.timeInPortal = 1.0F;
	                }
	            }
	            else
	            {
	                if (player.timeInPortal > 0.0F)
	                {
	                    player.timeInPortal -= 0.05F;
	                }

	                if (player.timeInPortal < 0.0F)
	                {
	                    player.timeInPortal = 0.0F;
	                }
	            }

	            if (player.timeUntilPortal > 0)
	            {
	                --player.timeUntilPortal;
	            }

	            boolean var1 = player.movementInput.jump;
	            float var2 = 0.8F;
	            boolean var3 = player.movementInput.moveForward >= var2;
	            player.movementInput.updatePlayerMoveState();

	            if (player.isUsingItem() && !player.isRiding())
	            {
	                player.movementInput.moveStrafe *= 0.2F;
	                player.movementInput.moveForward *= 0.2F;
	                player.setSprintToggleTimerField(0);
	            }

	            if (player.movementInput.sneak && player.ySize < 0.2F)
	            {
	                player.ySize = 0.2F;
	            }

	            player.pushOutOfBlocks(player.posX - (double)player.width * 0.35D, player.boundingBox.minY + 0.5D, player.posZ + (double)player.width * 0.35D);
	            player.pushOutOfBlocks(player.posX - (double)player.width * 0.35D, player.boundingBox.minY + 0.5D, player.posZ - (double)player.width * 0.35D);
	            player.pushOutOfBlocks(player.posX + (double)player.width * 0.35D, player.boundingBox.minY + 0.5D, player.posZ - (double)player.width * 0.35D);
	            player.pushOutOfBlocks(player.posX + (double)player.width * 0.35D, player.boundingBox.minY + 0.5D, player.posZ + (double)player.width * 0.35D);
	            boolean var4 = (float)player.getFoodStats().getFoodLevel() > 6.0F || player.capabilities.allowFlying;

	            if (player.onGround && !var3 && player.movementInput.moveForward >= var2 && !player.isSprinting() && var4 && !player.isUsingItem() && !player.isPotionActive(Potion.blindness))
	            {
	                if (player.getSprintToggleTimerField() == 0)
	                {
	                    player.setSprintToggleTimerField(7);
	                }
	                else
	                {
	                    player.setSprinting(true);
	                    player.setSprintToggleTimerField(0);
	                }
	            }

	            if (player.isSneaking())
	            {
	                player.setSprintToggleTimerField(0);
	            }

	            if (player.isSprinting() && (player.movementInput.moveForward < var2 || player.isCollidedHorizontally || !var4))
	            {
	                player.setSprinting(false);
	            }

	            if (player.capabilities.allowFlying && !var1 && player.movementInput.jump)
	            {
	                if (player.getFlyToggleTimerField() == 0)
	                {
	                    player.setFlyToggleTimerField(7);
	                }
	                else
	                {
	                    player.capabilities.isFlying = !player.capabilities.isFlying;
	                    player.sendPlayerAbilities();
	                    player.setFlyToggleTimerField(0);
	                }
	            }

	            if (player.capabilities.isFlying)
	            {
	                if (player.movementInput.sneak)
	                {
	                    player.motionY -= 0.15D;
	                }

	                if (player.movementInput.jump)
	                {
	                    player.motionY += 0.15D;
	                }
	            }

	            if (player.func_110317_t())
	            {
	                if (player.field_110320_a < 0)
	                {
	                    ++player.field_110320_a;

	                    if (player.field_110320_a == 0)
	                    {
	                        player.field_110321_bQ = 0.0F;
	                    }
	                }

	                if (var1 && !player.movementInput.jump)
	                {
	                    player.field_110320_a = -10;
	                    player.func_110318_g();
	                }
	                else if (!var1 && player.movementInput.jump)
	                {
	                    player.field_110320_a = 0;
	                    player.field_110321_bQ = 0.0F;
	                }
	                else if (var1)
	                {
	                    ++player.field_110320_a;

	                    if (player.field_110320_a < 10)
	                    {
	                        player.field_110321_bQ = (float)player.field_110320_a * 0.1F;
	                    }
	                    else
	                    {
	                        player.field_110321_bQ = 0.8F + 2.0F / (float)(player.field_110320_a - 9) * 0.1F;
	                    }
	                }
	            }
	            else
	            {
	                player.field_110321_bQ = 0.0F;
	            }

	            super.onLivingUpdate();

	            if (player.onGround && player.capabilities.isFlying)
	            {
	                player.capabilities.isFlying = false;
	                player.sendPlayerAbilities();
	            }
	        }
		}
		else
			super.onLivingUpdate();
			
		
	}
}