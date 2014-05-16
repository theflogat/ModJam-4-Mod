package smartLines.tile;

import net.minecraft.nbt.NBTTagCompound;

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
	
	boolean con = true;
	//Input Output I/O Provide Request Craft
	boolean[] modes = {
		true, false, false, false, false, false	
	};
	ModesReds reds = ModesReds.SIGNAL;
	
	public Module(ModesReds red, boolean[] modes, boolean connect) {
		reds = red;
		this.modes = modes;
		con = connect;
	}
	
	public Module() {}

	public void writeToNBT(NBTTagCompound comp, String id) {
		comp.setByte("reds" + id, reds.id);
		
		for(int i = 0; i<modes.length; i++){
			comp.setBoolean("modesN" + i + id, modes[i]);
		}
		
		comp.setBoolean("connection" + id, con);
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
		
		return new Module(reds, modes, con);
	}
}
