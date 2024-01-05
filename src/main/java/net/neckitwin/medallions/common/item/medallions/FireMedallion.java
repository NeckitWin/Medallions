package net.neckitwin.medallions.common.item.medallions;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class FireMedallion extends Item {
    private static final String NBT_EFFECTS_ENABLED = "EffectsEnabled";
    private static final String NBT_IS_CHARMED = "IsCharmed";

    public FireMedallion() {
        setUnlocalizedName("firemedallion");
        setTextureName(Medallions.MOD_ID + ":firemedallion");
        setCreativeTab(ModTab.INSTANCE);
        setMaxStackSize(1);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        NBTTagCompound nbt = getNBT(stack);
        return nbt.getBoolean(NBT_EFFECTS_ENABLED) && nbt.getBoolean(NBT_IS_CHARMED);
    }

    @Override
    public void onUpdate(ItemStack stack, net.minecraft.world.World world, net.minecraft.entity.Entity entity, int slot, boolean isHeld) {
        if (entity instanceof net.minecraft.entity.player.EntityPlayer && hasEffect(stack)) {
            net.minecraft.entity.player.EntityPlayer player = (net.minecraft.entity.player.EntityPlayer) entity;
            player.addPotionEffect(new net.minecraft.potion.PotionEffect(12, 1, 0));
            spawnFireParticles(world, player);
        }
    }

    private void spawnFireParticles(net.minecraft.world.World world, net.minecraft.entity.player.EntityPlayer player) {
        if (world.getWorldTime() % 2 == 0) {
            for (int i = 0; i < 3; i++) {
                world.spawnParticle("flame", player.posX + (Math.random() - 0.5) * 2, player.posY + (Math.random() - 0.5) * 2, player.posZ + (Math.random() - 0.5) * 2, 0, 0, 0);
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, net.minecraft.world.World world, net.minecraft.entity.player.EntityPlayer player) {
        if (player.isSneaking()) {
            NBTTagCompound nbt = getNBT(stack);
            nbt.setBoolean(NBT_EFFECTS_ENABLED, !nbt.getBoolean(NBT_EFFECTS_ENABLED));
            nbt.setBoolean(NBT_IS_CHARMED, !nbt.getBoolean(NBT_IS_CHARMED));
        }
        return stack;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
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