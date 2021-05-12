package fr.donododo.nspringfield.registries;

import java.util.ArrayList;
import java.util.List;

import fr.donododo.nspringfieldrp.server.zones.Zone;
import fr.donododo.nspringfieldrp.utils.Location;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.DEDICATED_SERVER)
public class ZonesRegistry{
	
	private static List<Zone> zonesRegistry;
	
	
	public ZonesRegistry() {
		this.zonesRegistry = new ArrayList<Zone>();
	}
	
	public void load() {
		Zone zone = new Zone();
		zone.addPart(new Location(0.0,0.0,0.0), new Location(10.0,10.0,10.0));
		zonesRegistry.add(zone);
	}

	public static List<Zone> getZonesRegistry() {
		return zonesRegistry;
	}

}
