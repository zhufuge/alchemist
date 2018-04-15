package org.zhufuge.alchemist.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import org.zhufuge.alchemist.Alchemist;

public class ClientProxy extends ServerProxy
{
    @Override
    public void loadModel()
    {
        super.loadModel();

        setCMRLocation(Alchemist.blockLimestone);
        setCMRLocation(Alchemist.itemLime);
        setCMRLocation(Alchemist.itemLimeTool);
        setCMRLocation(Alchemist.itemLimeWand);
    }

    public void setCMRLocation(Block block)
    {
        setCMRLocation(Item.getItemFromBlock(block));
    }

    public void setCMRLocation(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }
}
