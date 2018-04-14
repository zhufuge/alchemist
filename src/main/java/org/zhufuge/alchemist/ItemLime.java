package org.zhufuge.alchemist;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemLime extends Item
{
    public static final String NAME = "lime";

    public ItemLime()
    {
        super();

        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName(Alchemist.MODID + "." + NAME);
        setRegistryName(Alchemist.MODID, NAME);
    }


}
