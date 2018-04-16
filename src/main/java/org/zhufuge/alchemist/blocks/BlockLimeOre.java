package org.zhufuge.alchemist.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import org.zhufuge.alchemist.Alchemist;
import org.zhufuge.alchemist.creativetab.AlchemistTab;

import java.util.Random;


public class BlockLimeOre extends BlockOre
{
    public static final String NAME = "limeOre";


    public BlockLimeOre()
    {
        super();

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
        setCreativeTab(AlchemistTab.alchemistTab);
        // 本地化名称
        setUnlocalizedName(Alchemist.MODID + "." + NAME);
        // 注册
        setRegistryName(Alchemist.MODID, NAME);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Alchemist.itemLimestone;
    }
}
