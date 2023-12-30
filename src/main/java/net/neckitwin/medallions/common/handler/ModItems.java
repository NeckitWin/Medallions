package net.neckitwin.medallions.common.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.neckitwin.medallions.common.item.medallions.*;
import net.neckitwin.medallions.common.item.amulets.*;

public class ModItems {
    public static final SpeedOfMedallion SPEED_OF_MEDALLION = new SpeedOfMedallion();
    public static final MedallionOfPower MEDALLION_OF_POWER = new MedallionOfPower();
    public static final DeathMedallion DEATH_MEDALLION = new DeathMedallion();
    public static final HealthMedallion HEALTH_MEDALLION = new HealthMedallion();
    public static final AmuletOfLightning AMULET_OF_LIGHTNING = new AmuletOfLightning();
    public static void register() {
        GameRegistry.registerItem(SPEED_OF_MEDALLION, "speedofmedallion");
        GameRegistry.registerItem(MEDALLION_OF_POWER, "medallionofpower");
        GameRegistry.registerItem(DEATH_MEDALLION, "deathmedallion");
        GameRegistry.registerItem(HEALTH_MEDALLION, "healthmedallion");
        GameRegistry.registerItem(AMULET_OF_LIGHTNING, "amuletoflightning");
    }
}