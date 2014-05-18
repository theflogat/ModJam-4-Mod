package smartLines.tile.guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import smartLines.SmartLines;
import smartLines.lib.GuiIds;
import smartLines.tile.TEPipe;
import smartLines.tile.containers.ContainerPipe;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(SmartLines.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World w,	int x, int y, int z) {
		TileEntity tile = w.getTileEntity(x, y, z);
		switch(ID){
		case GuiIds.Item:
			return new ContainerPipe((TEPipe) tile, player.inventory);
		}


		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World w, int x, int y, int z) {
		TileEntity tile = w.getTileEntity(x, y, z);
		return new GuiPipe((TEPipe) tile, player.inventory, ID);


		//return null;
	}
}
