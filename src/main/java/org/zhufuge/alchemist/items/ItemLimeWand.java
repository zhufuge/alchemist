package org.zhufuge.alchemist.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.zhufuge.alchemist.Alchemist;
import org.zhufuge.alchemist.creativetab.AlchemistTab;


public class ItemLimeWand extends Item
{
    public static final String NAME = "limeWand";

    public ItemLimeWand()
    {
        super();
        setUnlocalizedName(Alchemist.MODID + "." + NAME);
        setRegistryName(Alchemist.MODID, NAME);
        setCreativeTab(AlchemistTab.alchemistTab);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        if (attacker.worldObj.isRemote) {
            return true;
        }

        double Angle = (attacker.rotationYaw / 180f) * Math.PI;
        double x = 3f * -Math.sin(Angle);
        double y = 1f;
        double z = 3f * Math.cos(Angle);
        target.setVelocity(x, y, z);
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (!worldIn.isRemote) {
            EntityTNTPrimed entity = new EntityTNTPrimed(worldIn, playerIn.posX,
                    playerIn.posY + playerIn.getEyeHeight(), playerIn.posZ, playerIn);

            double angle = (playerIn.rotationYaw / 180F) * Math.PI; // 水平方向的角度
            double angle2 = (-playerIn.rotationPitch / 180F) * Math.PI; // 垂直方向的仰角
            final float speed = 2F; // TNT飞行速度
            entity.motionY = speed * Math.sin(angle2); // 算出三个方向上的速度,为了方便阅读我先计算的Y轴分速度
            entity.motionX = speed * Math.cos(angle2) * -Math.sin(angle); // 根据仰角算出速度在XZ平面上的投影,再正交分解投影
            entity.motionZ = speed * Math.cos(angle2) * Math.cos(angle);
            worldIn.spawnEntityInWorld(entity); // 放置实体
        }
        return itemStackIn;
    }
}
