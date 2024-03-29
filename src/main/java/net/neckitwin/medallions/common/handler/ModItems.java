package net.neckitwin.medallions.common.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.neckitwin.medallions.common.item.medallions.*;
import net.neckitwin.medallions.common.item.amulets.*;
import net.neckitwin.medallions.common.item.armors.*;
import net.neckitwin.medallions.common.item.tools.*;
import net.neckitwin.medallions.common.item.*;

public class ModItems {
    public static final SpeedOfMedallion SPEED_OF_MEDALLION = new SpeedOfMedallion();
    public static final MedallionOfPower MEDALLION_OF_POWER = new MedallionOfPower();
    public static final DeathMedallion DEATH_MEDALLION = new DeathMedallion();
    public static final HealthMedallion HEALTH_MEDALLION = new HealthMedallion();
    public static final AmuletOfLightning AMULET_OF_LIGHTNING = new AmuletOfLightning();
    public static final InvisibilityCloak INVISIBILITY_CLOAK = new InvisibilityCloak();
    public static final PotionOfSatiety AMULET_OF_SATIETY = new PotionOfSatiety();
    public static final MinersMedallion MINERS_MEDALLION = new MinersMedallion();
    public static final ShadowyMedallion SHADOWY_MEDALLION = new ShadowyMedallion();
    public static final AmuletOfTeleportation AMULET_OF_TELEPORTATION = new AmuletOfTeleportation();
    public static final AmuletOfFlight AMULET_OF_FLIGHT = new AmuletOfFlight();
    public static final WeatherAmulet WEATHER_AMULET = new WeatherAmulet();
    public static final FireMedallion FIRE_MEDALLION = new FireMedallion();
    public static final FireStaff FIRE_STAFF = new FireStaff();
    public static final AngelWings ANGEL_WINGS = new AngelWings();
    public static final ItemEnderBag ENDER_BAG = new ItemEnderBag();
    public static void register() {
        GameRegistry.registerItem(SPEED_OF_MEDALLION, "speedofmedallion");
        GameRegistry.registerItem(MEDALLION_OF_POWER, "medallionofpower");
        GameRegistry.registerItem(DEATH_MEDALLION, "deathmedallion");
        GameRegistry.registerItem(HEALTH_MEDALLION, "healthmedallion");
        GameRegistry.registerItem(AMULET_OF_LIGHTNING, "amuletoflightning");
        GameRegistry.registerItem(INVISIBILITY_CLOAK, "invisibilitycloak");
        GameRegistry.registerItem(AMULET_OF_SATIETY, "amuletofsatiety");
        GameRegistry.registerItem(MINERS_MEDALLION, "minersmedallion");
        GameRegistry.registerItem(SHADOWY_MEDALLION, "shadowymedallion");
        GameRegistry.registerItem(AMULET_OF_TELEPORTATION, "amuletofteleportation");
        GameRegistry.registerItem(AMULET_OF_FLIGHT, "amuletofflight");
        GameRegistry.registerItem(WEATHER_AMULET, "weatheramulet");
        GameRegistry.registerItem(FIRE_MEDALLION, "firemedallion");
        GameRegistry.registerItem(FIRE_STAFF, "firestaff");
        GameRegistry.registerItem(ANGEL_WINGS, "angelwings");
        GameRegistry.registerItem(ENDER_BAG, "enderbag");
    }
}