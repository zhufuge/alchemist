package org.zhufuge.alchemist;


import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid="alchemist", name="alchemist", version="0.1.0")
public class Alchemist
{
    @SidedProxy
    private static ServerProxy proxy;

    public static final String MODID = "alchemist";
    public static BlockLimestone blockLimestone;
    public static ItemLime itemLime;
    public static ItemLimeTool itemLimeTool;
    public static Material materialLime;
    public static ItemLimeWand itemLimeWand;

    // 物品的初始化
    @EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
        materialLime = new MaterialLime();
        blockLimestone = new BlockLimestone();
        GameRegistry.registerBlock(blockLimestone);

        itemLime = new ItemLime();
        GameRegistry.registerItem(itemLime);

        itemLimeTool = new ItemLimeTool();
        GameRegistry.registerItem(itemLimeTool);

        itemLimeWand = new ItemLimeWand();
        GameRegistry.registerItem(itemLimeWand);

        GameRegistry.addSmelting(blockLimestone, new ItemStack(itemLime), 100f);
        GameRegistry.addRecipe(
                new ItemStack(itemLimeTool, 1),
                "###", "#X#", " X ", '#', itemLime, 'X', Items.stick
        );

        proxy.loadModel();
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new SubscribeFall());
        MinecraftForge.EVENT_BUS.register(new SubscribeChat());
        MinecraftForge.EVENT_BUS.register(new SubscribeBoom());
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
    }


    public static class ServerProxy
    {
        public void loadModel() {}
    }

    public static class ClientProxy extends ServerProxy
    {
        @Override
        public void loadModel()
        {
            super.loadModel();

            ModelLoader.setCustomModelResourceLocation(
                    Item.getItemFromBlock(blockLimestone),
                    0,
                    new ModelResourceLocation(MODID + ":" + blockLimestone.NAME, "inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    itemLime,
                    0,
                    new ModelResourceLocation(MODID + ":" + itemLime.NAME, "inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    itemLimeTool,
                    0,
                    new ModelResourceLocation(MODID + ":" + itemLimeTool.NAME, "inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    itemLimeWand,
                    0,
                    new ModelResourceLocation(MODID + ":" + itemLimeWand.NAME, "inventory")
            );
        }
    }
}
