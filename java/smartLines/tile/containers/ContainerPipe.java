package smartLines.tile.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import smartLines.tile.TEPipe;

public class ContainerPipe extends Container{
	
	TEPipe tile;
	
	public ContainerPipe(TEPipe te, InventoryPlayer inv) {
		tile = te;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return player.getDistanceSq(tile.xCoord, tile.yCoord, tile.zCoord) <= 64;
	}

}
