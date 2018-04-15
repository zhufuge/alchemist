package org.zhufuge.alchemist.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import org.zhufuge.alchemist.Alchemist;


public class BlockLimestone extends Block
{
    public static final String NAME = "limestone";


    public BlockLimestone()
    {
        super(Alchemist.materialLime);

        // 设置硬度
        setHardness(1.5f);
        // 设置对爆炸的抗性
        setResistance(10.0f);
        // 设置发光亮度
        setLightLevel(0.0f);
        // 设置开采所需工具及工具材质
        setHarvestLevel("pickaxe", 0);
        // 设置踩在上面的脚步声
        setStepSound(soundTypeStone);
        // 设置创造模式
        setCreativeTab(CreativeTabs.tabBlock);
        // 本地化名称
        setUnlocalizedName(Alchemist.MODID + "." + NAME);
        // 注册
        setRegistryName(Alchemist.MODID, NAME);
    }
}
