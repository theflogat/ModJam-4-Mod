package smartLines.items;

import cpw.mods.fml.common.registry.GameRegistry;
import smartLines.api.Lines;
import smartLines.items.blocks.BlockLine;
import smartLines.items.items.ItemPipe;
import smartLines.lib.ModLib;
import smartLines.lib.Names;
import smartLines.tile.TEPipe;

public class Items {
	public static void init() {
		Lines.line = new BlockLine();
		
		Lines.itemPipe = new ItemPipe();
		
		
		
		GameRegistry.registerBlock(Lines.line, ModLib.getId(Names.blockLine));
		
		GameRegistry.registerItem(Lines.itemPipe, ModLib.getId(Names.itemP));
		
		GameRegistry.registerTileEntity(TEPipe.class, ModLib.getId(Names.blockLine));
	}
}
