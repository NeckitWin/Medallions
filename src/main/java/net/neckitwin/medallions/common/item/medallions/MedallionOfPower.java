package net.neckitwin.medallions.common.item.medallions;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class MedallionOfPower extends Item {
    private static final String NBT_EFFECTS_ENABLED = "EffectsEnabled";
    private static final String NBT_IS_CHARMED = "IsCharmed";
    public MedallionOfPower() {
        setUnlocalizedName("medallionofpower");
        setTextureName(Medallions.MOD_ID + ":medallionofpower");
        setMaxStackSize(1);
        setCreativeTab(ModTab.INSTANCE);
    }

    // Определяет, должен ли предмет иметь визуальный эффект зачарования
    @Override
    public boolean hasEffect(ItemStack stack) {
        return getEffectsEnabled(stack) && getIsCharmed(stack);
    }

    // Вызывается при обновлении предмета в инвентаре
    public void onUpdate(ItemStack stack, net.minecraft.world.World world, net.minecraft.entity.Entity entity, int slot, boolean isHeld) {
        if (entity instanceof net.minecraft.entity.player.EntityPlayer) {
            net.minecraft.entity.player.EntityPlayer player = (net.minecraft.entity.player.EntityPlayer) entity;

            // Применяет пассивные эффекты, если эффекты включены и амулет зачарован
            if (getEffectsEnabled(stack) && getIsCharmed(stack)) {
                // эффекты силы и скорости
                player.addPotionEffect(new net.minecraft.potion.PotionEffect(5, 1, 2));
                player.addPotionEffect(new net.minecraft.potion.PotionEffect(1, 1, 1));
            }
        }
    }

    // Вызывается при клике правой кнопкой мыши на предмет
    @Override
    public ItemStack onItemRightClick(ItemStack stack, net.minecraft.world.World world, net.minecraft.entity.player.EntityPlayer player) {
        // Переключает состояние эффектов и зачарованности амулета при удерживании кнопки Shift
        if (player.isSneaking()) {
            toggleEffectsEnabled(stack);
            toggleIsCharmed(stack);
        }
        return stack;
    }

    // Определяет редкость предмета, влияющую на цвет его названия
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.rare;
    }

    // Получает значение, указывающее, включены ли эффекты амулета
    private boolean getEffectsEnabled(ItemStack stack) {
        return getNBT(stack).getBoolean(NBT_EFFECTS_ENABLED);
    }

    // Устанавливает значение, указывающее, включены ли эффекты амулета
    private void setEffectsEnabled(ItemStack stack, boolean value) {
        getNBT(stack).setBoolean(NBT_EFFECTS_ENABLED, value);
    }

    // Переключает значение, указывающее, включены ли эффекты амулета
    private void toggleEffectsEnabled(ItemStack stack) {
        setEffectsEnabled(stack, !getEffectsEnabled(stack));
    }

    // Получает значение, указывающее, зачарован ли амулет
    private boolean getIsCharmed(ItemStack stack) {
        return getNBT(stack).getBoolean(NBT_IS_CHARMED);
    }

    // Устанавливает значение, указывающее, зачарован ли амулет
    private void setIsCharmed(ItemStack stack, boolean value) {
        getNBT(stack).setBoolean(NBT_IS_CHARMED, value);
    }

    // Переключает значение, указывающее, зачарован ли амулет
    private void toggleIsCharmed(ItemStack stack) {
        setIsCharmed(stack, !getIsCharmed(stack));
    }

    // Получает объект NBTTagCompound для хранения пользовательских данных
    private NBTTagCompound getNBT(ItemStack stack) {
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt == null) {
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }
        return nbt;
    }
}