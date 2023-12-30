package net.neckitwin.medallions.common.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class ModRecipes {
    public static void register() {
        GameRegistry.addRecipe(new ItemStack(ModItems.SPEED_OF_MEDALLION),
                "EAF", "BGC", "HDI",
                'A', new ItemStack(Items.potionitem,1,8194),        // Стремительность (3 минуты)
                'B', new ItemStack(Items.potionitem, 1, 8226),    // Стремительность II (1.5 минуты)
                'C', new ItemStack(Items.potionitem, 1, 8233),  // Сила II (1.5 минуты)
                'D', new ItemStack(Items.potionitem, 1, 8265),
                'E', Items.bone,
                'F', Blocks.gold_block,
                'G', Items.nether_star,
                'H', Items.shears,
                'I', Items.diamond_boots
        );
        GameRegistry.addRecipe(new ItemStack(ModItems.MEDALLION_OF_POWER),
                "EAF", "BGC", "HDI",
                'A', new ItemStack(Items.potionitem,1,8194),        // Стремительность (3 минуты)
                'B', new ItemStack(Items.potionitem, 1, 8226),    // Стремительность II (1.5 минуты)
                'C', new ItemStack(Items.potionitem, 1, 8233),  // Сила II (1.5 минуты)
                'D', new ItemStack(Items.potionitem, 1, 8265),
                'E', Items.bone,
                'F', Blocks.gold_block,
                'G', Items.nether_star,
                'H', Items.shears,
                'I', Items.diamond_sword
        );
    }
}
