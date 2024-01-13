package net.neckitwin.medallions.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;
import net.neckitwin.medallions.common.tile.TileInfStorage;

public class BlockInfStorage extends BlockContainer{
    public BlockInfStorage() {
        super(Material.wood);
        setBlockName("infinitestorage");
        setBlockTextureName(Medallions.MOD_ID + ":infinitestorage");
        setCreativeTab(ModTab.INSTANCE);
    }
    // Создание TileEntity
    @Override
    public TileEntity createNewTileEntity(World world, int metadata){
        return new TileInfStorage();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer activator, int side, float hitX, float hitY, float hitZ ){
        // Выполняется на стороне сервера
        if (!world.isRemote){
            // Получить корды блока
            TileEntity tile = world.getTileEntity(x,y,z);
            // Проверка на то, что это TileEntity, который нам нужен
            if (tile instanceof TileInfStorage){
                // Создаём объект нашего TileEntity
                TileInfStorage storage = (TileInfStorage) tile;
                // Если игрок зажимает Shift, то будет передаваться весь стек
                    // Передаём игрока и то, что он держит в руке
                    storage.handleInputStack(activator, activator.getHeldItem(), 1);
            }
        }
        return true;
    }
}
