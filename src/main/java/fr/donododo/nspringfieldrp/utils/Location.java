package fr.donododo.nspringfieldrp.utils;

import net.minecraft.world.World;

public class Location {

	double x;
	double y;
	double z;
	
	World w;

	public Location(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Location(double x, double y, double z, World w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public World getWorld() {
		return w;
	}
	
	public String toString() {
		return "Location >> x : " + getX() + " y : " + getY() + " z : " + getZ();
	}
}
