package smartLines.tile;

import smartLines.api.SIDE;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TEPipe extends TileEntity{
	boolean[] id = new boolean[16];

	@Override
	public void updateEntity() {

	}

	private boolean useItemBasic(ForgeDirection dir){
		TileEntity tile = worldObj.getTileEntity(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ);
		if(tile!=null && tile instanceof IInventory){
			getInsertItem(tile, null, SIDE.getSideFromDir(dir));
		}




		return false;
	}

	private int getInsertItem(TileEntity tile, ItemStack item, int side) {
		if(tile instanceof ISidedInventory){
			ISidedInventory inv = (ISidedInventory)tile;
			for(int i = 0; i<inv.getSizeInventory(); i++){
				if(inv.canInsertItem(i, item, side)){
					ItemStack items = inv.getStackInSlot(i);
					if(items == null){
						return i;
					}else{
						if(items.getItem()==item.getItem() && items.stackSize<items.getItem().getItemStackLimit(items) && 
								items.stackTagCompound==item.stackTagCompound && items.stackSize<inv.getInventoryStackLimit()){
							return i;
						}
					}
				}
			}
			return -1;
		}

		IInventory inv = (IInventory)tile;
		for(int i = 0; i<inv.getSizeInventory(); i++){
			if(inv.isItemValidForSlot(i, item)){
				ItemStack items = inv.getStackInSlot(i);
				if(items == null){
					return i;
				}else{
					if(items.getItem()==item.getItem() && items.stackSize<items.getItem().getItemStackLimit(items) && 
							items.stackTagCompound==item.stackTagCompound && items.stackSize<inv.getInventoryStackLimit()){
						return i;
					}
				}
			}
		}
		return -1;
	}
}