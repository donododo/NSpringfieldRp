package fr.donododo.nspringfieldrp.server.zones;

import fr.donododo.nspringfieldrp.utils.Location;

public class ZonePart {

	public int id;
	public Location l1;
	public Location l2;
	
	public ZonePart(Location l1, Location l2, int id) {
		this.l1 = l1;
		this.l2 = l2;
		this.id = id;
	}
	
	public Location getFirstCorner() {
		return l1;
	}
	
	public Location getSecondCorner() {
		return l2;
	}
	
	public int getId() {
		return id;
	}
}
