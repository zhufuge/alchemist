package org.zhufuge.alchemist.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.zhufuge.alchemist.Alchemist;

public class AlchemistTab
{
    public static CreativeTabs alchemistTab = new CreativeTabs(Alchemist.MODID) {
        @Override
        public Item getTabIconItem() {
            return Alchemist.itemLime;
        }
    };
}
