package net.neckitwin.medallions.common.item.amulets;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;
import net.minecraft.potion.Potion;

public class AmuletOfFlight extends Item {
    private static final int DIZZINESS_EFFECT_ID = 9;
    private static final int DIZZINESS_EFFECT_DURATION = 20; // Длительность эффекта в тиках
    private boolean isRightClicking = false; // Флаг, указывающий, что ПКМ не зажата
    public AmuletOfFlight() {
        setUnlocalizedName("amuletofflight");
        setTextureName(Medallions.MOD_ID + ":amuletofflight");
        setMaxStackSize(1);
        setCreativeTab(ModTab.INSTANCE);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        // Проверка на выживание
        if (!player.capabilities.isCreativeMode) {
            // Устанавливаем флаг, что ПКМ зажата
            isRightClicking = true;
            // Подлетает
            player.motionY = 0.5;
        }
        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;

            // Проверяем, что ПКМ зажата и игрок находится в выживании
            if (isRightClicking && !player.capabilities.isCreativeMode) {
                // Проверяем, есть ли у игрока уже эффект головокружения
                PotionEffect dizzinessEffect = player.getActivePotionEffect(Potion.confusion);
                if (dizzinessEffect != null && dizzinessEffect.getPotionID() == DIZZINESS_EFFECT_ID) {
                    // Если есть, добавляем к длительности
                    player.addPotionEffect(new PotionEffect(DIZZINESS_EFFECT_ID, dizzinessEffect.getDuration() + DIZZINESS_EFFECT_DURATION, 0));
                } else {
                    // Если нет, устанавливаем новый эффект
                    player.addPotionEffect(new PotionEffect(DIZZINESS_EFFECT_ID, DIZZINESS_EFFECT_DURATION, 0));
                }
            }

            // Снимаем флаг, если ПКМ не зажата
            if (!player.isUsingItem()) {
                isRightClicking = false;
            }
        }
    }
}