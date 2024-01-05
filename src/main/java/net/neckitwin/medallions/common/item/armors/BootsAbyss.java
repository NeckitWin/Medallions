package net.neckitwin.medallions.common.item.armors;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class BootsAbyss extends ItemArmor {
    public BootsAbyss() {
        super(ArmorMaterial.DIAMOND, 0, 3);
        setUnlocalizedName("bootsAbyss");
        setTextureName(Medallions.MOD_ID + ":armor/bootsAbyss");
        setCreativeTab(ModTab.INSTANCE);
        setMaxStackSize(1);
    }

    // Падение с высоты не наносит урона и применяется функционал столкновения с блоком
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (!player.onGround) {
            return;
        }

        // При приземление отталкиваешься вверх на половину высоты с которой упал
        player.motionY *= -0.5F;
        player.fallDistance = 0;


//        if (player.motionY < 0) {
//            player.motionY *= -1.2F;
//            player.fallDistance = 0;
//        }
    }
}
