package smartLines.tile;

import smartLines.api.SIDE;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TEPipe extends TileEntity{
	boolean item = false;
	Module[] itemMod = {
			new Module(),new Module(),new Module(),new Module(),new Module(),new Module(),
	};
	
	public ItemStack items;

	@Override
	public void updateEntity() {
		for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS){
			int i = SIDE.getSideFromDir(dir);
			if(item){
				if(itemMod[i].con){
					useItemBasic(dir);
				}
			}
		}

	}

	private boolean useItemBasic(ForgeDirection dir){
		TileEntity tile = worldObj.getTileEntity(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ);
		int i = -1;
		if(tile!=null && tile instanceof IInventory){
			i = Inventory.getWhereInsert(tile, items, SIDE.getSideFromDir(dir));
		}
		if(i>=0 && items !=null){
			items = Inventory.insert(tile, items, i);
			return true;
		}



		return false;
	}

	
	
	@Override
	public void readFromNBT(NBTTagCompound comp) {
		super.readFromNBT(comp);
		for(int i = 0; i<itemMod.length; i++)
			itemMod[i] = Module.readFromNBT(comp, "item" + i);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound comp) {
		super.writeToNBT(comp);
		for(int i = 0; i<itemMod.length; i++)
			itemMod[i].writeToNBT(comp, "item" + i);
	}
}