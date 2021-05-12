package fr.donododo.nspringfield.registries;

public class NSPRegistries {
	
	public NSPRegistries() {
		
	}
	
	public static void setupClientRegistries() {
		
	}
	
	public static void setupServerRegistries() {
		
		ZonesRegistry zones = new ZonesRegistry();
		zones.load();
		
	}

}
