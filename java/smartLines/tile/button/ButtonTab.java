package smartLines.tile.button;

import java.awt.Color;

import smartLines.tile.guis.GuiPipe;

public class ButtonTab {

	String text;
	public int id;
	int x;
	int y;
	int size = 18;

	public ButtonTab(String text, int id, int x, int y) {
		this.text = text;
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public void draw(GuiPipe gui, int mX, int mY) {
		gui.getFont().drawSplitString(text, gui.getLeft() + x, gui.getTop() + y, size,isPointInRegion(gui, mX, mY) ? Color.GREEN.getRGB() : Color.GRAY.getRGB());
	}

	public boolean isPointInRegion(GuiPipe gui, int mX, int mY) {
		int posX = mX - gui.getLeft();
		int posY = mY - gui.getTop();
		if(x<=posX && posX<=x+size && y<=posY && posY<=y+size)
			return true;

		return false;
	}
}