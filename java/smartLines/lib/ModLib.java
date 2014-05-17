package smartLines.lib;

public class ModLib {
	public static final String modId = "smartLines";
	public static final String modName = "Smart Lines";
	public static final String version = "0.0.1";
	public static final String author = "theflogat";
	public static final String proxyLocation = "smartLines.proxies";
	
	public static String getUnloc(String str) {
		return modId + ":" + author + ":" + str;
	}
	
	public static String getId(String str) {
		return modId + str;
	}
	
	public static String getAsset(String str) {
		return modId + ":" + str;
	}
}