package smartLines.tile.guis;

import smartLines.lib.ModLib;
import smartLines.tile.TEPipe;
import smartLines.tile.containers.ContainerPipe;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiPipe extends GuiContainer{
	
	int sizeX1 = 143;
	int sizeY1 = 33;
	int activeTab = 0;
	
	private ResourceLocation texture = new ResourceLocation(ModLib.modId.toLowerCase(), "textures/guis/pipe.png");

	public GuiPipe(TEPipe te, InventoryPlayer inv) {
		super(new ContainerPipe(te, inv));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int x, int y) {
		mc.renderEngine.bindTexture(texture);
		switch(activeTab){
		case 0:
			xSize = sizeX1;
			ySize = sizeY1;
			drawTexturedModalRect(guiLeft, guiTop, 0, 0, sizeX1, sizeY1);
		}
		
	}

}
