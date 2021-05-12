package fr.donododo.nspringfieldrp.server.zones;

import java.util.ArrayList;
import java.util.List;

import fr.donododo.nspringfieldrp.utils.Location;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.DEDICATED_SERVER)
public class Zone {

	public int lastId = 0;
	public List<ZonePart> parts = new ArrayList<ZonePart>();
	public List<Location> doors = new ArrayList<Location>();
	public String zoneOwner = "";
	
	public Zone() {
		
	}
	
	private void addPart(ZonePart p) {
		parts.add(p);
	}
	
	public void addPart(Location l1, Location l2) {
		ZonePart part = new ZonePart(l1, l2, lastId);
		lastId = lastId + 1;
		addPart(part);
	}
	
	public void addDoor(Location door) {
		this.doors.add(door);
	}
	
	public List<Location> getDoors() {
		return doors;
	}
	
	public List<ZonePart> getParts() {
		return parts;
	}
	
	public boolean isInZone(Location l) {
		
		for(ZonePart p : parts) {
			if(isInside(l,p.getFirstCorner(),p.getSecondCorner())) {
				return true;
			}else {
				continue;
			}
		}
		
		return false;
	}
	
	public boolean isInside(Location loc, Location l1, Location l2) {
		
		double x1 = Math.min(l1.getX(), l2.getX());
		double z1 = Math.min(l1.getZ(), l2.getZ());
		double y1 = Math.min(l1.getY(), l2.getY());
		double y2 = Math.max(l1.getY(), l2.getY());
		double x2 = Math.max(l1.getX(), l2.getX());
		double z2 = Math.max(l1.getZ(), l2.getZ());
		
		return (loc.getX() >= x1 && loc.getX() <= x2 && loc.getZ() >= z1 && loc.getZ() <= z2 && loc.getY() >= y1 && loc.getY() <= y2);
	}
	
	public String getOwner() {
		return zoneOwner;
	}
	
	public void setOwner(String owner) {
		zoneOwner = owner;
	}
	
}
