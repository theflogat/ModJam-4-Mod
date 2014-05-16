package smartLines.tile;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class Inventory {
	public static int getWhereInsert(TileEntity tile, ItemStack item, int side) {
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
	
	public static ItemStack insert(TileEntity tile, ItemStack item, int slot){
		if(tile instanceof IInventory){
			IInventory inv = (IInventory) tile;
			ItemStack items = inv.getStackInSlot(slot);
			if(items==null){
				inv.setInventorySlotContents(slot, item);
				return null;
			}else{
				int max = Math.min(items.getItem().getItemStackLimit(items), inv.getInventoryStackLimit());
				int incr = Math.min(max - items.stackSize, item.stackSize);
				items.stackSize += incr;
				item.stackSize -= incr;
				return item.stackSize==0 ? null : item;
			}
		}
		return item;
	}
}
