package smartLines.items.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smartLines.SmartLines;
import smartLines.items.items.ItemWrench;
import smartLines.lib.ModLib;
import smartLines.lib.Names;
import smartLines.tile.TEPipe;

public class BlockLine extends BlockContainer{

	public BlockLine() {
		super(Material.iron);
		setBlockName(ModLib.getUnloc(Names.blockLine));
		setBlockUnbreakable();
		setBlockBounds(0.2F, 0.2F, 0.2F, 0.8F, 0.8F, 0.8F);
		setCreativeTab(SmartLines.lines);
	}
	
	@Override
	public void onNeighborBlockChange(World w, int x, int y, int z, Block block) {
		((TEPipe)w.getTileEntity(x, y, z)).onNeighbourUpdate();
	}
	
	@Override
	public void onBlockAdded(World w, int x, int y, int z) {
		((TEPipe)w.getTileEntity(x, y, z)).onNeighbourUpdate();
	}
	
	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		TileEntity tile = w.getTileEntity(x, y, z);
		if(tile!=null && tile instanceof TEPipe){
			ItemStack heldItem = player.inventory.mainInventory[player.inventory.currentItem].copy();
			if(heldItem != null && heldItem.getItem() instanceof ItemWrench){
				
			}
		}
		
		
		
		
		return false;
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
	public boolean isNormalCube() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {super.getSubBlocks(item, tab, list);}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TEPipe();
	}

}