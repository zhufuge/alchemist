package org.zhufuge.alchemist.items;

import net.minecraft.item.Item;
import org.zhufuge.alchemist.Alchemist;
import org.zhufuge.alchemist.creativetab.AlchemistTab;

public class ItemLime extends Item
{
    public static final String NAME = "lime";

    public ItemLime()
    {
        super();

        setUnlocalizedName(Alchemist.MODID + "." + NAME);
        setRegistryName(Alchemist.MODID, NAME);
        setCreativeTab(AlchemistTab.alchemistTab);
    }
}
