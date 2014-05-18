package smartLines.render;

import org.lwjgl.opengl.GL11;

import smartLines.lib.ModLib;
import smartLines.tile.TEPipe;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderPipe extends TileEntitySpecialRenderer{
	
	ModelPipe model = new ModelPipe();
	ResourceLocation texture = new ResourceLocation(ModLib.modId.toLowerCase(), "textures/models/pipe.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTickTime) {
		renderPipe((TEPipe) tile, x, y, z, partialTickTime);
	}
	
	public void renderPipe(TEPipe tile, double x, double y, double z, float partialTickTime) {
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glScalef(-1F,-1F,1F);
		
		bindTexture(texture);
		model.render(0.0625F, tile.getConnections());
		
		GL11.glPopMatrix();
	}

}
