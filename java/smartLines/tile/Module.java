package smartLines.tile;

import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class Module {
	
	public enum ModesReds{
		IGNORE((byte)0),
		SIGNAL((byte)1),
		NOSIGNAL((byte)2);
		
		byte id;
		
		ModesReds(byte id){
			this.id = id;
		}
		
		public static ModesReds[] m = {IGNORE, SIGNAL, NOSIGNAL};
	}
	
	boolean con = false;
	boolean forceDeco = false;
	//Input Output I/O Provide Request Craft
	boolean[] modes = {
		true, false, false, false, false, false	
	};
	ModesReds reds = ModesReds.SIGNAL;
	
	public Module(ModesReds red, boolean[] modes, boolean connect, boolean forceDeco2) {
		reds = red;
		this.modes = modes;
		con = connect;
		forceDeco = forceDeco2;
	}
	
	public Module() {}

	public void writeToNBT(NBTTagCompound comp, String id) {
		comp.setByte("reds" + id, reds.id);
		
		for(int i = 0; i<modes.length; i++){
			comp.setBoolean("modesN" + i + id, modes[i]);
		}
		
		comp.setBoolean("connection" + id, con);
		comp.setBoolean("Fconnection" + id, forceDeco);
	}

	public static Module readFromNBT(NBTTagCompound comp, String id) {
		ModesReds reds = ModesReds.SIGNAL;
		
		for(ModesReds m : ModesReds.m){
			if(comp.getByte("reds" + id)==m.id)
				reds = m;
		}
		
		boolean[] modes = {
				false, false, false, false, false, false	
		};
		
		for(int i = 0; i<modes.length; i++){
			modes[i] = comp.getBoolean("modesN" + i + id);
		}
		
		
		boolean con = comp.getBoolean("connection" + id);
		boolean forceDeco = comp.getBoolean("Fconnection" + id);
		
		return new Module(reds, modes, con, forceDeco);
	}

	public void updateCon(World w, int x, int y, int z, ForgeDirection dir) {
		TileEntity tile = w.getTileEntity(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);
		if(tile !=null && (tile instanceof IInventory || tile instanceof TEPipe)){
			con = true;
			return;
		}
		con = false;
	}
	
	public boolean doCon() {
		return forceDeco ? false : con;
	}
}
