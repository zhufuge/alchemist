package org.zhufuge.alchemist;


import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.zhufuge.alchemist.blocks.BlockLimestone;
import org.zhufuge.alchemist.blocks.MaterialLime;
import org.zhufuge.alchemist.crafting.Crafting;
import org.zhufuge.alchemist.handler.EventRegister;
import org.zhufuge.alchemist.items.ItemLime;
import org.zhufuge.alchemist.items.ItemLimeTool;
import org.zhufuge.alchemist.items.ItemLimeWand;
import org.zhufuge.alchemist.proxy.ServerProxy;

@Mod(modid="alchemist", name="alchemist", version="0.1.0")
public class Alchemist
{
    @Mod.Instance("alchemist")
    public static Alchemist instance;

    @SidedProxy(
            clientSide = "org.zhufuge.alchemist.proxy.ClientProxy",
            serverSide = "org.zhufuge.alchemist.proxy.ServerProxy"
    )
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
        Config config = new Config(event);

        materialLime = new MaterialLime();
        blockLimestone = new BlockLimestone();
        itemLime = new ItemLime();
        itemLimeTool = new ItemLimeTool();
        itemLimeWand = new ItemLimeWand();

        GameRegistry.registerBlock(blockLimestone);
        GameRegistry.registerItem(itemLime);
        GameRegistry.registerItem(itemLimeTool);
        GameRegistry.registerItem(itemLimeWand);

        proxy.loadModel();
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        Crafting.register();
        new EventRegister();
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
    }
}
