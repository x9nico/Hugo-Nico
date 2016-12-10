package fr.x9nico.king.fk.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class TeamUtils {
	
	public static ArrayList<Player> teamred = new ArrayList<>();
	public static ArrayList<Player> teamblue = new ArrayList<>();
	public static ArrayList<Player> teamgreen = new ArrayList<>();
	public static ArrayList<Player> teamyellow = new ArrayList<>();
	public static ArrayList<Player> teamorange = new ArrayList<>();
	
	public static void addTeamRed(Player p){
		if(!teamred.contains(p)){
			teamred.add(p);
		}
	}
	
	public static void removeTeamRed(Player p){
		if(!teamred.contains(p)){
			teamred.remove(p);
		}
	}
	
	public static ArrayList<Player> getRedPlayer(){
		return teamred;
		
	}
	
	public static ArrayList<Player> getBluePlayer(){
		return teamblue;
		
	}
	
	public static ArrayList<Player> getGreenPlayer(){
		return teamgreen;
	}
	
	public static ArrayList<Player> getYellowPlayer(){
		return teamyellow;
	}
	
}
