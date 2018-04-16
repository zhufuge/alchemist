package org.zhufuge.alchemist.items;

import net.minecraft.item.Item;
import org.zhufuge.alchemist.Alchemist;
import org.zhufuge.alchemist.creativetab.AlchemistTab;

public class ItemLimestone extends Item
{
    public static final String NAME = "limestone";

    public ItemLimestone()
    {
        super();

        setUnlocalizedName(Alchemist.MODID + "." + NAME);
        setRegistryName(Alchemist.MODID, NAME);
        setCreativeTab(AlchemistTab.alchemistTab);
    }
}
