package smartLines.tile.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import smartLines.tile.TEPipe;

public class ContainerPipe extends Container{
	
	TEPipe tile;
	
	public ContainerPipe(TEPipe te, InventoryPlayer inv) {
		tile = te;
		//int offsetY = te.getActiveTab()==-1 ? 33 : 0;
		int offsetY = 37;
		int size = 18;
		
		for(int x = 0; x < 9; x++) {
			  this.addSlotToContainer(new Slot(inv, x, 4 + x * size, offsetY + 58));
		}
		
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(inv, 9 + x + y * 9, 4 + x * size, offsetY + y * size));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return player.getDistanceSq(tile.xCoord, tile.yCoord, tile.zCoord) <= 64;
	}

}
