package smartLines.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import smartLines.api.SIDE;

public class TEPipe extends TileEntity implements IInventory{
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
					worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				}
			}
		}
		onNeighbourUpdate();
	}

	public void onNeighbourUpdate() {
		for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS){
			int i = SIDE.getSideFromDir(dir);
			itemMod[i].updateCon(worldObj, xCoord, yCoord, zCoord, dir);
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

	public boolean[] getConnections() {
		return new boolean[]{
				itemMod[0].doCon(),itemMod[1].doCon(),itemMod[2].doCon(),itemMod[3].doCon(),itemMod[4].doCon(),itemMod[5].doCon()
		};
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

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return items;
	}

	@Override
	public ItemStack decrStackSize(int slot, int count) {
		ItemStack itemstack = getStackInSlot(slot);

		if(itemstack != null) {
			if(itemstack.stackSize <= count) {
				setInventorySlotContents(slot, null);
			} else {
				itemstack = itemstack.splitStack(count);
			}
		}
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		ItemStack toGive = items.copy();
		items = null;
		return toGive;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack items) {
		this.items = items;
	}

	@Override
	public String getInventoryName() {return "Pipe";}

	@Override
	public boolean hasCustomInventoryName() {return false;}

	@Override
	public int getInventoryStackLimit() {return 64;}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound comp = new NBTTagCompound();
		writeToNBT(comp);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, comp);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
	}
}