package org.zhufuge.alchemist.items;

import net.minecraft.item.ItemTool;
import org.zhufuge.alchemist.Alchemist;
import org.zhufuge.alchemist.creativetab.AlchemistTab;

import java.util.HashSet;

public class ItemLimeTool extends ItemTool
{
    public static final String NAME = "limeTool";

    public ItemLimeTool()
    {
        super(10.0f, ToolMaterial.EMERALD, new HashSet());
        setHarvestLevel("pickaxe", 3);
        setHarvestLevel("shovel", 3);
        setHarvestLevel("axe", 3);

        //设置最大耐久度,0的话即为永不损坏
        setMaxDamage(0);

        setUnlocalizedName(Alchemist.MODID + "." + NAME);
        setRegistryName(Alchemist.MODID, NAME);
        setCreativeTab(AlchemistTab.alchemistTab);
    }
}
