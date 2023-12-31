package net.neckitwin.medallions.common.item.amulets;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class PotionOfSatiety extends ItemFood {
    public PotionOfSatiety() {
        super(1, 1, false);
        setUnlocalizedName("potionofsatiety");
        setTextureName(Medallions.MOD_ID + ":potionofsatiety");
        setMaxStackSize(1);
        setCreativeTab(ModTab.INSTANCE);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        // Пополняем сытость
        player.getFoodStats().addStats(2, 0.5F);
        // анимация поедания
        player.setItemInUse(stack, getMaxItemUseDuration(stack));
        return stack;
    }

    // Не даёт проглатить предмет
    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        return stack;
    }

    // Моментально съедаем предмет
    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }
}