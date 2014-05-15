package smartLines;

import smartLines.lib.ModLib;
import smartLines.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModLib.modId, name = ModLib.modName, version = ModLib.version)
public class SmartLines {
	
	@SidedProxy(clientSide = ModLib.proxyLocation + ".ClientProxy", serverSide = ModLib.proxyLocation + ".CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		proxy.initRenderers();
		proxy.initSounds();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void podtInit(FMLPostInitializationEvent event) {
		
	}
}
