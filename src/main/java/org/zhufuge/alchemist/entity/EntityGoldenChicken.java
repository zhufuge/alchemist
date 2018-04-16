package org.zhufuge.alchemist.entity;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.World;
import org.zhufuge.alchemist.Alchemist;

public class EntityGoldenChicken extends EntityChicken
{
    public EntityGoldenChicken(World worldIn)
    {
        super(worldIn);
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    @Override
    protected void dropFewItems(boolean arg1, int arg2)
    {
        this.dropItem(Alchemist.itemLime, 1);
        if (this.rand.nextInt(10) == 0) {

        }
        super.dropFewItems(arg1, arg2);
    }
}
