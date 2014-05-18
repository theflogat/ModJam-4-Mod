package smartLines.items.items;

import smartLines.SmartLines;
import smartLines.lib.ModLib;
import smartLines.lib.Names;
import net.minecraft.item.Item;

public class ItemWrench extends Item{
	
	public ItemWrench() {
		setCreativeTab(SmartLines.lines);
		setUnlocalizedName(ModLib.getUnloc(Names.wrench));
	}

}
