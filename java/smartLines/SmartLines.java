package smartLines;

import smartLines.handlers.CreativeTabLines;
import smartLines.items.Items;
import smartLines.lib.ModLib;
import smartLines.proxies.CommonProxy;
import smartLines.tile.guis.GuiHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModLib.modId, name = ModLib.modName, version = ModLib.version)
public class SmartLines {
	
	@SidedProxy(clientSide = ModLib.proxyLocation + ".ClientProxy", serverSide = ModLib.proxyLocation + ".CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabLines lines = new CreativeTabLines();
	
	@Instance(ModLib.modId)
	public static SmartLines instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		proxy.initRenderers();
		proxy.initSounds();
		Items.init();
		new GuiHandler();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
