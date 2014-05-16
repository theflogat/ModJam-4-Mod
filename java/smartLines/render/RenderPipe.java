package smartLines.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderPipe extends TileEntitySpecialRenderer{
	
	ModelPipe model = new ModelPipe();

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTickTime) {
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glScalef(-1F,-1F,1F);
		
		model.render(0.0625F);
		
		GL11.glPopMatrix();
	}

}
