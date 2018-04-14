package org.zhufuge.alchemist;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Iterator;
import java.util.List;

public class SubscribeChat
{
    @SubscribeEvent
    public void boom(ServerChatEvent event)
    {
        if(event.message.equals("BOOM"))
        {
            event.setCanceled(true);
            EntityPlayer player = event.player;
            EventBoom eventBoom = new EventBoom(player);
            MinecraftForge.EVENT_BUS.post(eventBoom);
            if(eventBoom.getResult() == Event.Result.ALLOW)
            {
                List list = player.worldObj.getEntitiesWithinAABB(
                        EntityLiving.class,
                        new AxisAlignedBB(
                                player.posX-30D,
                                player.posY-20D,
                                player.posZ-30D,
                                player.posX+30D,
                                player.posY+20D,
                                player.posZ+30D
                        )
                );

                for(Iterator iterator = list.iterator(); iterator.hasNext();)
                {
                    EntityLiving entity = (EntityLiving)iterator.next();
                    if(entity.equals(player)) {
                        continue;
                    }
                    player.worldObj.createExplosion(
                            player, entity.posX, entity.posY, entity.posZ, 4f, true
                    );
                }
            }
        }
    }
}
