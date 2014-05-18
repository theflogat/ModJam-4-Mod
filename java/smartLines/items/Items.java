package smartLines.items;

import smartLines.api.Lines;
import smartLines.items.blocks.BlockLine;
import smartLines.items.items.ItemPipe;
import smartLines.items.items.ItemWrench;
import smartLines.lib.ModLib;
import smartLines.lib.Names;
import smartLines.tile.TEPipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Items {
	public static void init() {
		Lines.line = new BlockLine();
		
		Lines.itemPipe = new ItemPipe();
		Lines.itemWrech = new ItemWrench();
		
		
		
		GameRegistry.registerBlock(Lines.line, ModLib.getId(Names.blockLine));
		
		GameRegistry.registerItem(Lines.itemPipe, ModLib.getId(Names.itemP));
		GameRegistry.registerItem(Lines.itemWrech, ModLib.getId(Names.wrench));
		
		GameRegistry.registerTileEntity(TEPipe.class, ModLib.getId(Names.blockLine));
	}
}
