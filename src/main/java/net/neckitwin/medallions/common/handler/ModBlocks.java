package net.neckitwin.medallions.common.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.block.*;
import net.neckitwin.medallions.common.tile.*;

public class ModBlocks {
    public static final BlockMegaChest MEGA_CHEST = new BlockMegaChest();
    public static void register() {
        GameRegistry.registerBlock(MEGA_CHEST, "megachest");
        GameRegistry.registerTileEntity(TileMegaChest.class, Medallions.MOD_ID + ":tilemegachest");
    }
}
