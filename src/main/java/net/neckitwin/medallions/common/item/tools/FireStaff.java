package net.neckitwin.medallions.common.item.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class FireStaff extends Item {
    public FireStaff() {
        setUnlocalizedName("firestaff");
        setTextureName(Medallions.MOD_ID+":firestaff");
        setMaxStackSize(1);
        setCreativeTab(ModTab.INSTANCE);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        // Получаем сторону, куда смотрит игрок
        Vec3 lookDir = player.getLookVec();
        // Получаем позицию игрока
        Vec3 playerPos = Vec3.createVectorHelper(player.posX, player.posY + player.getEyeHeight(), player.posZ);
        // Запускаем 5 файрболлов рандомно вокруг игрока подальше друг от друга, чтобы не взорвались и пусть летят в ту сторону, куда смотрит игрок
        if (!world.isRemote) {
            for (int i = 0; i < 5; i++) {
                EntityLargeFireball fireball1 = new EntityLargeFireball(world, player, 1, 1, 1);
                fireball1.setPosition(playerPos.xCoord + Math.random() * 10 - 5, playerPos.yCoord + Math.random() * 10 - 5, playerPos.zCoord + Math.random() * 10 - 5);
                fireball1.accelerationX = lookDir.xCoord * 0.1;
                fireball1.accelerationY = lookDir.yCoord * 0.1;
                fireball1.accelerationZ = lookDir.zCoord * 0.1;
                world.spawnEntityInWorld(fireball1);
                // если файрбол не взорвался и пролетел 100 блоков, то он исчезает
                if (fireball1.isDead || fireball1.getDistance(playerPos.xCoord, playerPos.yCoord, playerPos.zCoord) >= 100) {
                    fireball1.setDead();
                }
            }
        }

        return stack;
    }
}
