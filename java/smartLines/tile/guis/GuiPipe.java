package smartLines.tile.guis;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import smartLines.lib.ModLib;
import smartLines.tile.TEPipe;
import smartLines.tile.button.ButtonTab;
import smartLines.tile.containers.ContainerPipe;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiPipe extends GuiContainer{
	
	int sizeX1 = 143;
	int sizeY1 = 33;
	
	int sizeX2 = 66;
	int sizeY2 = 66;
	
	int v2 = 34;
	
	int sizeXP = 168;
	int sizeYP = 82;
	
	int activeTab = -1;
	static ButtonTab[] tabs = new ButtonTab[6];
	
	private ResourceLocation texture = new ResourceLocation(ModLib.modId.toLowerCase(), "textures/guis/pipe.png");
	TEPipe tile;

	public GuiPipe(TEPipe te, InventoryPlayer inv) {
		super(new ContainerPipe(te, inv));
		xSize = 168;
		ySize = 82;
		tile = te;
	}
	
	static{
		for(int i = 0; i<tabs.length; i++){
			tabs[i] = new ButtonTab(getTextFromId(i), i, 8 + 22*i, 8);
		}
	}
	
	private static String getTextFromId(int i) {
		switch(i){
		case 0: 
			return "In";
		case 1: 
			return "Out";
		case 2: 
			return "I/O";
		case 3: 
			return "Provide";
		case 4: 
			return "Request";
		case 5: 
			return "Craft";
		}
		return "";
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int x, int y) {
		switch(activeTab){
		case -1:
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(guiLeft, guiTop, 0, 0, sizeX1, sizeY1);
			for(ButtonTab tab : tabs){
				tab.draw(this, x, y);
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glColor3f(Color.GRAY.getRed(), Color.GRAY.getBlue(), Color.GRAY.getGreen());
			drawTexturedModalRect(guiLeft, guiTop + sizeY1, 0, 100, sizeXP, sizeYP);
			break;
		case 0:
		case 1:
			mc.renderEngine.bindTexture(texture);
			drawTexturedModalRect(guiLeft, guiTop, 0, v2, sizeX2, sizeY2);
			drawTexturedModalRect(guiLeft, guiTop + sizeY2, 0, 100, sizeXP, sizeYP);
			break;
		case 2:
			mc.renderEngine.bindTexture(texture);
			xSize = sizeX2;
			ySize = sizeY2;
			drawTexturedModalRect(guiLeft, guiTop, 0, v2, sizeX2*2, sizeY2);
			drawTexturedModalRect(guiLeft, guiTop + sizeY2, 0, 100, sizeXP, sizeYP);
			break;
		}
		
	}
	
	@Override
	protected void mouseClicked(int x, int y, int par3) {
		super.mouseClicked(x, y, par3);
		for(ButtonTab tab : tabs){
			activeTab = tab.isPointInRegion(this, x, y) ? tab.id : activeTab;
			tile.setActiveTab(activeTab);
		}
	}

	public FontRenderer getFont() {
		return fontRendererObj;
	}
	
	public int getLeft() {
		return guiLeft;
	}
	
	public int getTop() {
		return guiTop;
	}
}
