package net.neckitwin.medallions.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileMegaChest extends TileEntity {
    private ItemStack stack;
    private static final String INV_TAG = "inventory";

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        if (stack != null) {
            NBTTagCompound inventoryTag = new NBTTagCompound();
            stack.writeToNBT(inventoryTag);
            nbt.setTag(INV_TAG, inventoryTag);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        if (nbt.hasKey(INV_TAG, Constants.NBT.TAG_COMPOUND)) {
            NBTTagCompound inventoryTag = nbt.getCompoundTag(INV_TAG);
            stack = ItemStack.loadItemStackFromNBT(inventoryTag);
        }
    }

    @Override
    public boolean canUpdate() {
        return false;
    }

    public boolean hasStack() {
        return stack != null;
    }

    public void handleInputStack(EntityPlayer player, ItemStack stack) {
        // Если в StorageTile есть стек, то выполнится действия со взятием предмета из StorageTile
        if (hasStack()) {
            // Если инвентарь заполнен, то предмет будет выброшен, в ином случае будет добавлен игроку в инвентарь.
            if (!player.inventory.addItemStackToInventory(this.stack)) {
                player.dropPlayerItemWithRandomChoice(this.stack, false);
            } else {
                // Иногда бывает, что предмет не отображается в инвентаре после активации блока, данный код исправляет это.
                player.inventoryContainer.detectAndSendChanges();
            }
            // Очищаем стек из StorageTile
            this.stack = null;
        }
        // Если стек в руке не равен null, то он будет положен в кол-ве 1 шт., в StorageTile
        else if (stack != null) {
            // Создаём копию стека и устанавливаем ей размер в 1 шт.
            ItemStack copy = stack.copy();
            copy.stackSize = 1;
            this.stack = copy;
            // Убираем один предмет из инвентаря игрока.
            --stack.stackSize;
        }
        // Не забываем пометить Tile Entity как "грязный", чтобы игра сохранила наши данные.
        markDirty();
    }
}
