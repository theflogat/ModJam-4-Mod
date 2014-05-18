package smartLines.tile.guis;

import smartLines.tile.TEPipe;
import smartLines.tile.containers.ContainerPipe;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class GuiPipe extends GuiContainer{

	public GuiPipe(TEPipe te, InventoryPlayer inv) {
		super(new ContainerPipe(te, inv));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int x, int y) {
		
	}

}
