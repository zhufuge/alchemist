package org.zhufuge.alchemist.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.zhufuge.alchemist.Alchemist;
import org.zhufuge.alchemist.entity.EntityGoldenChicken;

import java.util.Iterator;
import java.util.List;

public class EventRegister
{
    public static final EventBus EVENT_BUS = new EventBus();

    public EventRegister()
    {
        MinecraftForge.EVENT_BUS.register(this);
        EVENT_BUS.register(this);
    }

    // 订阅 Boom 事件，在事件发生时输出 “Booom!!!"
    @SubscribeEvent
    public void sayBoom(EventBoom event)
    {
        event.entityPlayer.addChatMessage(new ChatComponentText("Booom!!!"));
        event.setResult(Event.Result.ALLOW);
    }

    // 订阅 ServerChat 事件，在事件发生时，触发 Boom 事件，并使附近的生物爆炸
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

    // 测试事件优先级别，订阅落地事件，在落地时触发，输出掉落高度，并取消该事件的发生
    // @SubscribeEvent(priority = EventPriority.HIGH)
    public void test(LivingFallEvent event)
    {
        if (event.entityLiving instanceof EntityPlayerMP) {
            EntityPlayer entityPlayer = (EntityPlayer) event.entityLiving;
            entityPlayer.addChatMessage(new ChatComponentText("You fell " + event.distance));

            //event.distance = 0.0F;
            event.setCanceled(true);
        }
    }

    // 测试事件恢复，恢复事件
    // @SubscribeEvent(priority = EventPriority.LOW, receiveCanceled = true)
    public void low(LivingFallEvent event)
    {
        if (event.entityLiving instanceof EntityPlayerMP) {
            EntityPlayer entityPlayer = (EntityPlayer) event.entityLiving;
            entityPlayer.addChatMessage(new ChatComponentText("But now fell " + event.distance));
            // entityPlayer.setFire(1);
            event.setCanceled(false);
        }
    }
}
