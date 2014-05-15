package smartLines.api;

import net.minecraftforge.common.util.ForgeDirection;

public class SIDE {
	public static int BOTTOM = 0;
	public static int TOP = 1;
	public static int NORTH = 2;
	public static int SOUTH = 3;
	public static int WEST = 4;
	public static int EAST = 5;
	
	public static int getSideFromDir(ForgeDirection dir) {
		switch(dir){
		case DOWN:
			return BOTTOM;
		case EAST:
			return EAST;
		case NORTH:
			return NORTH;
		case SOUTH:
			return SOUTH;
		case UP:
			return TOP;
		case WEST:
			return WEST;
		default:
			break;
		}
		return -1;
	}
}
