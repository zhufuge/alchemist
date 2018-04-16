package org.zhufuge.alchemist;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.zhufuge.alchemist.blocks.BlockLimeOre;
import org.zhufuge.alchemist.crafting.Crafting;
import org.zhufuge.alchemist.entity.EntityRegister;
import org.zhufuge.alchemist.handler.EventRegister;
import org.zhufuge.alchemist.items.ItemLime;
import org.zhufuge.alchemist.items.ItemLimestone;
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

    public static BlockLimeOre blockLimeOre;
    public static ItemLimestone itemLimestone;
    public static ItemLime itemLime;

    // 物品的初始化
    @EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
        new Config(event);

        blockLimeOre = new BlockLimeOre();
        itemLimestone = new ItemLimestone();
        itemLime = new ItemLime();

        GameRegistry.registerBlock(blockLimeOre);
        GameRegistry.registerItem(itemLimestone);
        GameRegistry.registerItem(itemLime);

        proxy.loadModel();
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        Crafting.register();
        new EventRegister();
        new EntityRegister();
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
    }
}
