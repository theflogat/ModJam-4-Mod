package smartLines.proxies;

import smartLines.render.RenderPipe;
import smartLines.tile.TEPipe;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void initRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TEPipe.class, new RenderPipe());
	}
	
	@Override
	public void initSounds() {
		
	}
}
