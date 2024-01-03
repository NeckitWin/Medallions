package net.neckitwin.medallions.common.item.armors;

import net.minecraft.item.ItemArmor;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class BootsAbyss extends ItemArmor {
    public BootsAbyss(){
        super(ArmorMaterial.DIAMOND, 0, 3);
        setUnlocalizedName("bootsAbyss");
        setTextureName(Medallions.MOD_ID+":armor/bootsAbyss");
        setCreativeTab(ModTab.INSTANCE);
        setMaxStackSize(1);
    }

    // Падение с высоты не наносит урона
    @Override
    public void onArmorTick(net.minecraft.world.World world, net.minecraft.entity.player.EntityPlayer player, net.minecraft.item.ItemStack itemStack) {
        player.fallDistance = 0;
    }
}
