package smartLines.items.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import smartLines.SmartLines;
import smartLines.api.Lines;
import smartLines.api.SIDE;
import smartLines.items.blocks.BlockLine;
import smartLines.lib.ModLib;
import smartLines.lib.Names;

public class ItemPipe extends Item{
	
	public ItemPipe() {
		setCreativeTab(SmartLines.lines);
		setUnlocalizedName(ModLib.getUnloc(Names.itemP));
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack items, World w,	EntityPlayer player) {
		MovingObjectPosition pos = getMovingObjectPositionFromPlayer(w, player, true);
		
		if(pos!=null && pos.typeOfHit==MovingObjectType.BLOCK){
			ForgeDirection dir = SIDE.getDirFromSide(pos.sideHit);
			
			w.setBlock(pos.blockX + dir.offsetX, pos.blockY + dir.offsetY, pos.blockZ + dir.offsetZ, Lines.line);
			items.stackSize--;
			if(items.stackSize==0)
				items = null;
		}
		
		
		
		return items;
	}
}
