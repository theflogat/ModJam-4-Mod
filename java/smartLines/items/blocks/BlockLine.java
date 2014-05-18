package smartLines.items.blocks;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import smartLines.SmartLines;
import smartLines.api.SIDE;
import smartLines.items.items.ItemWrench;
import smartLines.lib.GuiIds;
import smartLines.lib.ModLib;
import smartLines.lib.Names;
import smartLines.tile.Module.Modes;
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
		try{if(!w.isRemote){
			TileEntity tile = w.getTileEntity(x, y, z);
			if(tile!=null && tile instanceof TEPipe){
				ItemStack heldItem = player.inventory.mainInventory[player.inventory.currentItem].copy();
				if(heldItem != null && heldItem.getItem() instanceof ItemWrench){
					if(heldItem.getItemDamage()<1){
						FMLNetworkHandler.openGui(player, SmartLines.instance, GuiIds.Item, w, x, y, z);
					}else{
						((TEPipe)tile).itemMod[side].nextMode(w, x, y, z, SIDE.getDirFromSide(side));
					}
					return true;
				}
			}
		}}catch(Exception e){}
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