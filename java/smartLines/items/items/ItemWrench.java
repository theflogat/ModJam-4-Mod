package smartLines.items.items;

import smartLines.SmartLines;
import smartLines.lib.ModLib;
import smartLines.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class ItemWrench extends Item{
	
	public ItemWrench() {
		setCreativeTab(SmartLines.lines);
		setUnlocalizedName(ModLib.getUnloc(Names.wrench));
		setHasSubtypes(true);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack items, World par2World, EntityPlayer par3EntityPlayer) {
		MovingObjectPosition mov = getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);
		if(mov != null && mov.typeOfHit==MovingObjectType.BLOCK)
			return items;
		items = new ItemStack(items.getItem(), items.stackSize, items.getItemDamage()==0 ? 1:0);
		
		return items;
	}
}
