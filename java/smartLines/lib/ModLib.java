package smartLines.lib;

public class ModLib {
	public static final String modId = "smartLines";
	public static final String modName = "Smart Lines";
	public static final String version = "0.0.1";
	public static final String author = "theflogat";
	public static final String proxyLocation = "smartLines.proxies";
	
	public String getId(String str) {
		return modId + ":" + author + ":" + str;
	}
	
	public String getAsset(String str) {
		return modId + ":" + str;
	}
}
