package net.neckitwin.medallions.common.item.amulets;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class WeatherAmulet extends Item {
    public WeatherAmulet() {
        setUnlocalizedName("weatheramulet");
        setTextureName(Medallions.MOD_ID + ":weatheramulet");
        setMaxStackSize(1);
        setCreativeTab(ModTab.INSTANCE);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        // Проверка, что код выполняется на серверной стороне
        if (!world.isRemote) {
            // Проверяем, что игрок не в креативе
            if (!player.capabilities.isCreativeMode){
            // Добавить проверку, что у игрока более половины хп, от максимального здоровья
            if (player.getHealth() > player.getMaxHealth() * 0.5F) {
                // При нажатии на правую кнопку мыши вызывается рандомное событие погоды
                // (гроза, дождь, солнце, снег)
                int weather = world.rand.nextInt(3);
                switch (weather) {
                    case 0:
                        world.getWorldInfo().setRaining(true);
                        world.getWorldInfo().setThundering(false);
                        break;
                    case 1:
                        world.getWorldInfo().setRaining(true);
                        world.getWorldInfo().setThundering(true);
                        break;
                    case 2:
                        world.getWorldInfo().setRaining(false);
                        world.getWorldInfo().setThundering(false);
                        break;
                }
                // Сооющение в чат о том, что амулет был использован
                player.addChatMessage(new net.minecraft.util.ChatComponentText("You used the Weather Amulet!"));
                // Отнять у игрока 90% от его максимального здоровья
                player.setHealth(player.getMaxHealth() * 0.1F);
                // Эффект головокружения на 10 секунд
                player.addPotionEffect(new net.minecraft.potion.PotionEffect(9, 200, 0));
                // Слепота на 3 секунды
                player.addPotionEffect(new net.minecraft.potion.PotionEffect(15, 60, 0));
            }else{
                // Сообщение в чат о том, что у игрока недостаточно здоровья
                player.addChatMessage(new net.minecraft.util.ChatComponentText("You don't have enough health!"));
            }
            }else{
                int weather = world.rand.nextInt(3);
                switch (weather) {
                    case 0:
                        world.getWorldInfo().setRaining(true);
                        world.getWorldInfo().setThundering(false);
                        break;
                    case 1:
                        world.getWorldInfo().setRaining(true);
                        world.getWorldInfo().setThundering(true);
                        break;
                    case 2:
                        world.getWorldInfo().setRaining(false);
                        world.getWorldInfo().setThundering(false);
                        break;
                }
                // Сооющение в чат о том, что амулет был использован
                player.addChatMessage(new net.minecraft.util.ChatComponentText("You used the Weather Amulet!"));
            }

        }
        return stack;
    }
}
