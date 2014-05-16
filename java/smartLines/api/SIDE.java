package smartLines.api;

import net.minecraftforge.common.util.ForgeDirection;

public class SIDE {
	public static final int BOTTOM = 0;
	public static final int TOP = 1;
	public static final int NORTH = 2;
	public static final int SOUTH = 3;
	public static final int WEST = 4;
	public static final int EAST = 5;
	
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
	
	public static ForgeDirection getDirFromSide(int side) {
		switch(side){
		case BOTTOM:
			return ForgeDirection.DOWN;
		case EAST:
			return ForgeDirection.EAST;
		case NORTH:
			return ForgeDirection.NORTH;
		case SOUTH:
			return ForgeDirection.SOUTH;
		case TOP:
			return ForgeDirection.UP;
		case WEST:
			return ForgeDirection.WEST;
		default:
			break;
		}
		return ForgeDirection.UNKNOWN;
	}
}
