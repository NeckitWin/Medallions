package net.neckitwin.medallions.common.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.block.*;
import net.neckitwin.medallions.common.tile.*;

public class ModBlocks {
    public static final BlockInfStorage INFINITE_STORAGE = new BlockInfStorage();
    public static void register() {
        // Блоки
        GameRegistry.registerBlock(INFINITE_STORAGE, "infinitestorage");
        // Тайлы
        GameRegistry.registerTileEntity(TileInfStorage.class, Medallions.MOD_ID + ":tileinfinitestorage");
    }
}
