package org.zhufuge.alchemist.entity;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.zhufuge.alchemist.Alchemist;

public class EntityRegister
{
    private static int nextID = 0;

    public EntityRegister()
    {
        registerEntity(EntityGoldenChicken.class, "GoldenChicken", 80, 3, true);
        registerEntityEgg(EntityGoldenChicken.class, 0xffff66, 0x660000);
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String name,
            int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
    {
        EntityRegistry.registerModEntity(entityClass, name, nextID++, Alchemist.instance, trackingRange, updateFrequency,
                sendsVelocityUpdates);
    }

    private static void registerEntityEgg(Class<? extends Entity> entityClass, int eggPrimary, int eggSecondary)
    {
        EntityRegistry.registerEgg(entityClass, eggPrimary, eggSecondary);
    }
}
