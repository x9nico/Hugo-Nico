package fr.x9nico.king.fk.utils;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import fr.x9nico.king.fk.Main;

public class Configuration {
	
public static FileConfiguration config = Main.getInstance().getConfig();
	
	/**
 	* Getter and setters
 	* @param path
 	* @return
 	*/
	public static int getInt(String path){
		return config.getInt(path);
	}
	
	public static void setInt(String path) {
		config.set(path, path);
	}
	
	/**
	 * String name, prefix...
	 * @param path
	 * @return
	 */
	public static String getString(String path){
		return config.getString(path).replace("&", "§");
	}
	
	/**
	 * Boolean, condition...
	 * @param path
	 * @return
	 */
	public static boolean getBoolean(String path){
		return config.getBoolean(path);
	}
	
	/**
	 * Double configuration
	 * @param path
	 * @return
	 */
	public static double getDouble(String path) {
		return config.getDouble(path);
	}
	
	/**
	 * List string by KingRider
	 * @param path
	 * @return
	 */
	public static List<String> getList(String path){
		return config.getStringList(path);
	}

}
