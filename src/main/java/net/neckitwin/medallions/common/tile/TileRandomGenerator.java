package net.neckitwin.medallions.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileRandomGenerator extends TileEntity{
    private ItemStack stack;
    private static final String INV_TAG = "Inventory";
    // Записываем данные тайла в чанк
    @Override
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);

        if (stack!=null) {
            NBTTagCompound inventoryTag = new NBTTagCompound();
            stack.writeToNBT(inventoryTag);
            nbt.setTag(INV_TAG, inventoryTag);
        }
    }
    // Считываем данные тайла из чанка
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        if (nbt.hasKey(INV_TAG, Constants.NBT.TAG_COMPOUND)) {
            NBTTagCompound inventoryTag = nbt.getCompoundTag(INV_TAG);
            stack = ItemStack.loadItemStackFromNBT(inventoryTag);
        }
    }
    // Не нужно обновлять тайл, если нет метода {@link TileEntity#updateEntity}
    @Override
    public boolean canUpdate() {
        return false;
    }
    // Проверка на то, что в тайле есть предмет
    public boolean hasStack() {
        return stack != null;
    }
    // Метод, который будет вызываться при активации блока
// В методе блока есть функция нажатия по блоку и в нём вызывается этот метод
    public void handleInputStack(EntityPlayer player, ItemStack heldStack) {
        // Если в тайле нет предмета
        if (stack == null) {
            // Если предмет в руке не пуст и количество в руке есть предмет
            if (heldStack != null && heldStack.stackSize > 0) {
                // Создаем копию предмета и добавляем его в тайл
                stack = heldStack.copy();
                stack.stackSize = 1;

                // Убираем из руки игрока только один предмет
                heldStack.stackSize--;

                // Если стек в руке полностью добавлен, обнуляем его
                if (heldStack.stackSize <= 0) {
                    heldStack = null;
                }
                System.out.println(stack.stackSize);
            }
        } else { // Если в тайле есть предмет
            // Если предмет в руке совпадает с предметом в тайле
            if (heldStack != null && stack.isItemEqual(heldStack) && ItemStack.areItemStackTagsEqual(stack, heldStack)) {
                // Увеличиваем количество предметов в тайле
                stack.stackSize++;
                // Убираем из руки игрока предмет
                heldStack.stackSize--;
                // Вывод в консоль количества предметов в тайле
                System.out.println(stack.stackSize);
            } else {
                // Удаляем предмет из тайла в количестве 1 шт.
                stack.stackSize--;
                // Узнаем, какой предмет был в тайле
                ItemStack copy = stack.copy();
                copy.stackSize = 1;
                // Добавляем предмет в инвентарь игрока
                player.inventory.addItemStackToInventory(copy);
                // Обновление каждого слота в инвенторе игрока
                player.inventoryContainer.detectAndSendChanges();
                // Если в тайле не осталось предметов, обнуляем его
                System.out.println(stack.stackSize);
                if (stack.stackSize <= 0) {
                    stack = null;
                }
            }
        }
        // Помечаем тайл как грязный, чтобы игра сохранила наши данные
        markDirty();
    }
}