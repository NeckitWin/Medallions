package net.neckitwin.medallions.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

import java.util.List;

public class ItemEnderBag extends Item {
    public ItemEnderBag() {
        setUnlocalizedName("enderbag");
        setTextureName(Medallions.MOD_ID+":enderbag");
        setMaxStackSize(1);
        setCreativeTab(ModTab.INSTANCE);
        setMaxDamage(0);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            InventoryEnderChest invEC = player.getInventoryEnderChest();
            if (invEC != null) {
                player.displayGUIChest(invEC);
            }
        }
        return itemStack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean isAdv) {
        list.add("Right click to open your ender chest");
    }
}
