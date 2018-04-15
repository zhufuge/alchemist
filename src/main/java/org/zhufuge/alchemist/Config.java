package org.zhufuge.alchemist;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


public class Config
{
    private static Configuration config;
    private static Logger logger;
    public static int limeBurnTime;

    public Config(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();
        load();
    }

    public static void load()
    {
        logger.info("Started loading config. ");
        String comment;

        comment = "How many seconds can a Lime burn in a furnace. ";
        limeBurnTime = config.get(Configuration.CATEGORY_GENERAL, "burnTime", 200, comment).getInt();

        config.save();
        logger.info("Finished loading config. ");
    }

    public static Logger logger()
    {
        return logger;
    }
}
