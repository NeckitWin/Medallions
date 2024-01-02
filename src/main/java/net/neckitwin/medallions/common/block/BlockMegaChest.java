package net.neckitwin.medallions.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;

public class BlockMegaChest extends Block {
    public BlockMegaChest() {
        super(Material.wood);
        setBlockName("megachest");
        setBlockTextureName(Medallions.MOD_ID + ":megachest");
        setCreativeTab(ModTab.INSTANCE);
    }
}
