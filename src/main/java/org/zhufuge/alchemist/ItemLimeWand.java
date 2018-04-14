package org.zhufuge.alchemist;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLimeWand extends Item {
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
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
}
