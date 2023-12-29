package net.neckitwin.medallions.common.handler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.neckitwin.medallions.Medallions;

public class ModTab extends CreativeTabs {
    public static final ModTab INSTANCE = new ModTab();

    private ModTab() {
        super(Medallions.MOD_ID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return ModItems.SPEED_OF_MEDALLION;
    }
}