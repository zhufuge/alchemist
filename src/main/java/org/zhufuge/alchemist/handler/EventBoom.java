package org.zhufuge.alchemist.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
@Event.HasResult
public class EventBoom extends Event{
    public final EntityPlayer entityPlayer;

    public EventBoom(EntityPlayer entity)
    {
        super();
        entityPlayer = entity;
    }
}
