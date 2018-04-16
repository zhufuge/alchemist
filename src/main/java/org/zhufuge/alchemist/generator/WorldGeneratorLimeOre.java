package org.zhufuge.alchemist.generator;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGeneratorLimeOre extends WorldGenerator
{

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        return true;
    }
}
