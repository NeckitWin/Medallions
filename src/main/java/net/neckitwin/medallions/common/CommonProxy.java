package net.neckitwin.medallions.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.neckitwin.medallions.common.handler.ModBlocks;
import net.neckitwin.medallions.common.handler.ModItems;
import net.neckitwin.medallions.common.handler.ModRecipes;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.register();
        ModRecipes.register();
        ModBlocks.register();
    }

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {}
}