package smartLines.items.blocks;

import java.util.List;

import smartLines.lib.Names;
import smartLines.lib.ModLib;
import smartLines.tile.TEPipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLine extends BlockContainer{

	protected BlockLine() {
		super(Material.iron);
		setBlockName(ModLib.getId(Names.blockLine));
		setBlockUnbreakable();
	}
	
	@Override
	public void breakBlock(World w, int x, int y, int z, Block block, int q) {
		
		super.breakBlock(w, x, y, z, block, q);
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TEPipe();
	}

}
