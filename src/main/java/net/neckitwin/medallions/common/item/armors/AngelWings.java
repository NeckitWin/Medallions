package net.neckitwin.medallions.common.item.armors;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class AngelWings extends ItemArmor {
    public AngelWings() {
        super(ArmorMaterial.DIAMOND, 0, 1);
        setUnlocalizedName("angelwings");
        setTextureName(Medallions.MOD_ID + "armor:angelwings");
        setCreativeTab(ModTab.INSTANCE);
        setMaxStackSize(1);
    }

    // Игрока летит туда, куда смотрит, когда нагрудник одет
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(2) != null) {
            if (player.isSneaking()) {
                Vec3 lookVec = player.getLookVec();
                double speedMultiplier = 1.5; // Множитель скорости
                player.motionX = lookVec.xCoord * speedMultiplier;
                player.motionY = lookVec.yCoord * speedMultiplier;
                player.motionZ = lookVec.zCoord * speedMultiplier;
            }// При падении с высоты, игрок не разбивается
            player.fallDistance = 0;
        }
    }
}