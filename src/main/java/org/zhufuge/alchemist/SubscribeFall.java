package org.zhufuge.alchemist;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SubscribeFall
{
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void test(LivingFallEvent event)
    {
        if (event.entityLiving instanceof EntityPlayerMP) {
            EntityPlayer entityPlayer = (EntityPlayer) event.entityLiving;
            entityPlayer.addChatMessage(new ChatComponentText("You fell " + event.distance));

            //event.distance = 0.0F;
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW, receiveCanceled = true)
    public void low(LivingFallEvent event)
    {
        if (event.entityLiving instanceof EntityPlayerMP) {
            EntityPlayer entityPlayer = (EntityPlayer) event.entityLiving;
            entityPlayer.addChatMessage(new ChatComponentText("But now fell " + event.distance));
            entityPlayer.setFire(1);
            event.setCanceled(false);
        }
    }
}
