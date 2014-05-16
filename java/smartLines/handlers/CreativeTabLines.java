package smartLines.handlers;

import smartLines.api.Lines;
import smartLines.items.items.ItemPipe;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabLines extends CreativeTabs{
	
	public CreativeTabLines() {
		super("Lines");
	}

	@Override
	public Item getTabIconItem() {
		return Lines.itemPipe;
	}

}
