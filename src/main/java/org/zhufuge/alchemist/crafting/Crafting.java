package org.zhufuge.alchemist.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.zhufuge.alchemist.Alchemist;
import org.zhufuge.alchemist.Config;

public class Crafting
{
    public static void register()
    {
        GameRegistry.addRecipe(
                new ItemStack(Alchemist.itemLimeTool, 1),
                "#", "X", "X", '#', Alchemist.itemLime, 'X', Items.stick
        );

        GameRegistry.addRecipe(
                new ItemStack(Alchemist.blockLimestone, 1),
                "##", "##", '#', Alchemist.itemLime
        );

        GameRegistry.addSmelting(Alchemist.blockLimestone, new ItemStack(Alchemist.itemLime), 100f);

        GameRegistry.registerFuelHandler(new IFuelHandler() {
            @Override
            public int getBurnTime(ItemStack fuel) {
                return Alchemist.itemLime != fuel.getItem() ? 0 : Config.limeBurnTime;
            }
        });
    }
}
