package net.neckitwin.medallions.common.item.armors;

import net.minecraft.item.ItemArmor;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class InvisibilityCloak extends ItemArmor{
    public InvisibilityCloak() {
        super(ArmorMaterial.CLOTH, 0, 1);
        setUnlocalizedName("invisibilitycloak");
        setTextureName(Medallions.MOD_ID +":armor/invisibilitycloak");
        setCreativeTab(ModTab.INSTANCE);
        setMaxStackSize(1);
    }

    // Если нагрудник одет, то игрок становится невидимым
    @Override
    public void onArmorTick(net.minecraft.world.World world, net.minecraft.entity.player.EntityPlayer player, net.minecraft.item.ItemStack itemStack) {
        if (player.getCurrentArmor(2) != null) {
            player.addPotionEffect(new net.minecraft.potion.PotionEffect(14, 20, 0));
        } else {
            player.removePotionEffect(14);
        }
    }

    // Чтобы на игроке не отображался невидимый нагрудник
    @Override
    public String getArmorTexture(net.minecraft.item.ItemStack stack, net.minecraft.entity.Entity entity, int slot, String type) {
        return Medallions.MOD_ID + ":textures/items/armor/none.png";
    }

    // Сделать бесконечную прочность
    @Override
    public boolean isDamaged(net.minecraft.item.ItemStack stack) {
        return false;
    }
}