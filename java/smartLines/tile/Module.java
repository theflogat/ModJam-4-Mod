package smartLines.tile;

import java.awt.Color;

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

	public enum Modes{
		Input(0, Color.black),
		Output(1, Color.red),
		IO(2, Color.blue),
		Provide(3, Color.green),
		Request(4, Color.orange),
		Craft(5, Color.white);

		public int id;
		public Color color;

		Modes(int id, Color col){
			this.id = id;
		}
		
		@Override
		public String toString() {
			switch(id){
			case 0: return "Input";
			case 1: return "Output";
			case 2: return "I/O";
			case 3: return "Provide";
			case 4: return "Request";
			case 5: return "Craft";
			}
			return "";
		}

		public static Modes[] m = {Input, Output, IO, Provide, Request,Craft};

		public Color getColor() {
			switch(id){
			case 0: return Color.black;
			case 1: return Color.red;
			case 2: return Color.blue;
			case 3: return Color.green;
			case 4: return Color.orange;
			case 5: return Color.white;
			}
			return Color.white;
		}
	}

	boolean con = false;
	boolean forceDeco = false;
	//Input Output I/O Provide Request Craft
	public Modes modes = Modes.Input;
	ModesReds reds = ModesReds.SIGNAL;

	public Module(ModesReds red, Modes modes, boolean connect, boolean forceDeco2) {
		reds = red;
		this.modes = modes;
		con = connect;
		forceDeco = forceDeco2;
	}

	public Module() {}

	public void writeToNBT(NBTTagCompound comp, String id) {
		comp.setByte("reds" + id, reds.id);


		comp.setInteger("modesN" + id, modes.id);

		comp.setBoolean("connection" + id, con);
		comp.setBoolean("Fconnection" + id, forceDeco);
	}

	public static Module readFromNBT(NBTTagCompound comp, String id) {
		ModesReds reds = ModesReds.SIGNAL;

		for(ModesReds m : ModesReds.m){
			if(comp.getByte("reds" + id)==m.id)
				reds = m;
		}
		
		Modes modes = Modes.Input;
		for(Modes m : Modes.m){
			if(comp.getInteger("modesN" + id)==m.id)
				modes = m;
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
	
	public boolean canChange(World w, int x, int y, int z, ForgeDirection dir) {
		return con && !(w.getTileEntity(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ) instanceof TEPipe);
	}

	public void nextMode(World w, int x, int y, int z, ForgeDirection dir) {
		if(con && !(w.getTileEntity(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ) instanceof TEPipe))
		modes = Modes.m[modes.id<5?modes.id+1: 0];
	}
}
