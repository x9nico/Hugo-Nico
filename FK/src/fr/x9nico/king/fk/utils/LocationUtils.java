package fr.x9nico.king.fk.utils;

import java.util.ArrayList;

import org.bukkit.Location;

public class LocationUtils {
	
	public ArrayList<Location> spawns;
	
	public Location loc;
	
	public LocationUtils(Location loc) {
		this.loc = loc;
		spawns = new ArrayList<>();
	}
	
	public Location getSpawnLocation()
	{
		return this.loc;
	}
	
	public void addSpawn(Location loc) {
		spawns.add(loc);
	}
	
	public void removeSpawn(Location loc) {
		spawns.remove(loc);
	}
	

}
