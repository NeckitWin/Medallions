package net.neckitwin.medallions.common.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.neckitwin.medallions.common.item.SpeedOfMedallion;

public class ModItems {
    public static final SpeedOfMedallion SPEED_OF_MEDALLION = new SpeedOfMedallion();
    public static void register() {
        GameRegistry.registerItem(SPEED_OF_MEDALLION, "speedofmedallion");
    }
}