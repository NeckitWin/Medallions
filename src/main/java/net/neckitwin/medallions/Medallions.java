package net.neckitwin.medallions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.neckitwin.medallions.common.CommonProxy;
import static net.neckitwin.medallions.Medallions.*;

@Mod(modid = MOD_ID, version = VERSION, name = MOD_NAME)
public class Medallions {
    public static final String MOD_ID = "medallions";
    public static final String MOD_NAME = "Medallions";
    public static final String VERSION = "1.0";

    @SidedProxy(
            clientSide = "net.neckitwin.medallions.common.ClientProxy",
            serverSide = "net.neckitwin.medallions.common.CommonProxy"
    )
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
