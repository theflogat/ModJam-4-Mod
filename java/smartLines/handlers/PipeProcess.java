package smartLines.handlers;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class PipeProcess {
	public abstract boolean process(World w, int x, int y, int z, ForgeDirection dir);
}
