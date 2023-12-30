package net.neckitwin.medallions.common.item.medallions;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class MedallionOfPower extends Item {
    private boolean effectsEnabled = false;
    public MedallionOfPower() {
        setUnlocalizedName("medallionofpower");
        setTextureName("medallionofpower");
        setMaxStackSize(1);
        setCreativeTab(ModTab.INSTANCE);
    }

    // Добавляем визуальное зачарование
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    // Добавляем пассивные бафы
    public void onUpdate(ItemStack stack, net.minecraft.world.World world, net.minecraft.entity.Entity entity, int slot, boolean isHeld) {
        if (entity instanceof net.minecraft.entity.player.EntityPlayer) {
            net.minecraft.entity.player.EntityPlayer player = (net.minecraft.entity.player.EntityPlayer) entity;

            if (effectsEnabled) {
                player.addPotionEffect(new net.minecraft.potion.PotionEffect(1, 1, 2));
                player.addPotionEffect(new net.minecraft.potion.PotionEffect(8, 1, 1));
            }
        }
    }

    // Включить/выключить эффекты при клике правой кнопкой мыши
    @Override
    public ItemStack onItemRightClick(ItemStack stack, net.minecraft.world.World world, net.minecraft.entity.player.EntityPlayer player) {
        if (player.isSneaking()) {
            effectsEnabled = !effectsEnabled; // Переключаем состояние эффектов
            onUpdate(stack, world, player, 0, true);
        } else {
            player.removePotionEffect(1);
            player.removePotionEffect(8);
        }
        return stack;
    }

    // Добавляем редкость предмету (меняет цвет названия предмета)
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
    }
}
