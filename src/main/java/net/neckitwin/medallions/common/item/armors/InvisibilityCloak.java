package net.neckitwin.medallions.common.item.armors;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.EnumHelper;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

import java.util.List;

public class InvisibilityCloak extends ItemArmor {
    public static ArmorMaterial CLOAK_MATERIAL = EnumHelper.addArmorMaterial(
            "CLOAK_MATERIAL", // Название материала
            5, new int[]{0, 0, 0, 0} // Прочность брони
            ,10                     // Энчантабельность
    );

    public InvisibilityCloak() {
        super(CLOAK_MATERIAL, 1,1);
        setUnlocalizedName("invisibilitycloak");
        setTextureName(Medallions.MOD_ID + ":armor/invisibilitycloak");
        setCreativeTab(ModTab.INSTANCE);
        setMaxStackSize(1);
    }
    // Локализация описания предмета
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean isAdv) {
        list.add(StatCollector.translateToLocal("tooltip.invisibilitycloak.name"));
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