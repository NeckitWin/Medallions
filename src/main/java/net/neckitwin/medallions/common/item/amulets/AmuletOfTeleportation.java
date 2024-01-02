package net.neckitwin.medallions.common.item.amulets;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class AmuletOfTeleportation extends Item {
    public AmuletOfTeleportation() {
        setUnlocalizedName("amuletofteleportation");
        setTextureName(Medallions.MOD_ID + ":amuletofteleportation");
        setMaxStackSize(1);
        setCreativeTab(ModTab.INSTANCE);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        // Проверка, что код выполняется на серверной стороне
        if (!world.isRemote) {
            // Получаем блок, на который смотрит игрок
            MovingObjectPosition targetBlock = getTargetBlock(player, world);

            // Проверяем, что блок не null и является блоком в мире
            if (targetBlock != null && targetBlock.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                // Телепортируем игрока в позицию блока
                player.setPositionAndUpdate(targetBlock.hitVec.xCoord, targetBlock.hitVec.yCoord, targetBlock.hitVec.zCoord);
                // Отнимаем 1 хп у игрока если он не в креативе
                if (!player.capabilities.isCreativeMode) {
                    player.setHealth(player.getHealth() - 2);
                    // Накидываем эффект голода на 10 секунд
                    player.addPotionEffect(new net.minecraft.potion.PotionEffect(17, 200, 0));
                    // эффект головокружения на 5 секунд
                    player.addPotionEffect(new net.minecraft.potion.PotionEffect(9, 100, 0));
                    // эффект слепоты на секунду
                    player.addPotionEffect(new net.minecraft.potion.PotionEffect(15, 20, 0));
                }
            }
        }

        return stack;
    }

    private static MovingObjectPosition getTargetBlock(EntityPlayer player, World world) {
        Vec3 playerPos = Vec3.createVectorHelper(player.posX, player.posY + player.getEyeHeight(), player.posZ);
        Vec3 lookDir = player.getLookVec();
        double reachDistance = 100.0;

        Vec3 end = playerPos.addVector(lookDir.xCoord * reachDistance, lookDir.yCoord * reachDistance, lookDir.zCoord * reachDistance);

        return world.rayTraceBlocks(playerPos, end);
    }

}
