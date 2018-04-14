package org.zhufuge.alchemist;

import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SubscribeBoom
{
    @SubscribeEvent
    public void boom(EventBoom event)
    {
        event.entityPlayer.addChatMessage(new ChatComponentText("Booom!!!"));
        event.setResult(Event.Result.ALLOW);
    }
}
