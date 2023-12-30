package net.neckitwin.medallions.common.item.amulets;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.neckitwin.medallions.common.handler.ModTab;

public class AmuletOfLightning extends Item {
    public AmuletOfLightning() {
        setUnlocalizedName("amuletoflightning");
        setTextureName("medallions:amuletoflightning");
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
                // Спавним молнию в позиции блока
                world.addWeatherEffect(new EntityLightningBolt(world, targetBlock.hitVec.xCoord, targetBlock.hitVec.yCoord, targetBlock.hitVec.zCoord));
                // Отнимаем 1 хп у игрока если он не в креативе
                if (!player.capabilities.isCreativeMode) {
                    player.setHealth(player.getHealth() - 4);
                    // Накидываем эффект иссушения на 10 секунд
                    player.addPotionEffect(new net.minecraft.potion.PotionEffect(20, 300, 0));
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
