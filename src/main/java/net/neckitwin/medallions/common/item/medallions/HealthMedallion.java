package net.neckitwin.medallions.common.item.medallions;

import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class HealthMedallion extends Item {
    private static final String NBT_EFFECTS_ENABLED = "EffectsEnabled";
    private static final String NBT_IS_CHARMED = "IsCharmed";

    public HealthMedallion() {
        setUnlocalizedName("healthmedallion");
        setTextureName(Medallions.MOD_ID + ":healthmedallion");
        setMaxStackSize(1);
        setCreativeTab(ModTab.INSTANCE);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return getNBT(stack).getBoolean(NBT_EFFECTS_ENABLED) && getNBT(stack).getBoolean(NBT_IS_CHARMED);
    }

    public void onUpdate(ItemStack stack, net.minecraft.world.World world, net.minecraft.entity.Entity entity, int slot, boolean isHeld) {
        if (entity instanceof net.minecraft.entity.player.EntityPlayer) {
            net.minecraft.entity.player.EntityPlayer player = (net.minecraft.entity.player.EntityPlayer) entity;

            if (hasEffect(stack)) {
                if (world.getWorldTime() % 100 == 0) {
                    player.addPotionEffect(new net.minecraft.potion.PotionEffect(10, 100, 0));
                }
                player.addPotionEffect(new net.minecraft.potion.PotionEffect(17, 1, 1));
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, net.minecraft.world.World world, net.minecraft.entity.player.EntityPlayer player) {
        if (player.isSneaking()) {
            toggle(NBT_EFFECTS_ENABLED, stack);
            toggle(NBT_IS_CHARMED, stack);
        }
        return stack;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
    }

    private void toggle(String key, ItemStack stack) {
        getNBT(stack).setBoolean(key, !getNBT(stack).getBoolean(key));
    }

    private NBTTagCompound getNBT(ItemStack stack) {
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt == null) {
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }
        return nbt;
    }
}