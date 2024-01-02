package net.neckitwin.medallions.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;
import net.neckitwin.medallions.common.tile.TileMegaChest;

public class BlockMegaChest extends BlockContainer {
    public BlockMegaChest() {
        super(Material.wood);
        setBlockName("megachest");
        setBlockTextureName(Medallions.MOD_ID + ":megachest");
        setCreativeTab(ModTab.INSTANCE);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileMegaChest();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer activator, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(x, y, z);

            if (tile instanceof TileMegaChest) {
                TileMegaChest storage = (TileMegaChest) tile;
                storage.handleInputStack(activator, activator.getHeldItem());
            }
        }
        return true;
    }
}
