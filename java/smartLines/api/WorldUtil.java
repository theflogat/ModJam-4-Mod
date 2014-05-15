package smartLines.api;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WorldUtil {
	public static void spawnItemStack(World w, int x, int y, int z, ItemStack item){
		EntityItem ent = new EntityItem(w, x+w.rand.nextGaussian(), y+w.rand.nextGaussian(), z+w.rand.nextGaussian(), item);
		w.spawnEntityInWorld(ent);
	}
}
