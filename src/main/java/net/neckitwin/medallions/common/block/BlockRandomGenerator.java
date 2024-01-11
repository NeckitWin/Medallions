package net.neckitwin.medallions.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.neckitwin.medallions.Medallions;
import net.neckitwin.medallions.common.handler.ModTab;
import net.neckitwin.medallions.common.tile.TileRandomGenerator;

public class BlockRandomGenerator extends BlockContainer{
    public BlockRandomGenerator() {
        super(Material.wood);
        setBlockName("randomgenerator");
        setBlockTextureName(Medallions.MOD_ID + ":randomgenerator");
        setCreativeTab(ModTab.INSTANCE);
    }
    // Создание TileEntity
    @Override
    public TileEntity createNewTileEntity(World world, int metadata){
        return new TileRandomGenerator();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer activator, int side, float hitX, float hitY, float hitZ ){
        // Выполняется на стороне сервера
        if (!world.isRemote){
            // Получить корды блока
            TileEntity tile = world.getTileEntity(x,y,z);
            // Проверка на то, что это TileEntity, который нам нужен
            if (tile instanceof TileRandomGenerator){
                // Создаём объект нашего TileEntity
                TileRandomGenerator storage = (TileRandomGenerator) tile;
                // Передаём игрока и то, что он держит в руке
                storage.handleInputStack(activator, activator.getHeldItem());
            }
        }
        return true;
    }
}
