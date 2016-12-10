package fr.x9nico.king.fk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.x9nico.king.fk.commands.GameCommand;
import fr.x9nico.king.fk.commands.HubCommand;
import fr.x9nico.king.fk.game.GameState;
import fr.x9nico.king.fk.listener.PlayerConnectListener;
import fr.x9nico.king.fk.listener.PlayerDamageListener;
import fr.x9nico.king.fk.listener.PlayerInteractListener;
import fr.x9nico.king.fk.utils.TitleUtils;

/**
 * Copyright (C)
 * @author KingRider
 */
public class Main extends JavaPlugin implements Listener {
	
	// Variables
	public static Main instance;
	public static ArrayList<Player> playerList = new ArrayList<Player>();
	public static HashMap<Player, Integer> kill = new HashMap<Player, Integer>();
	
	@Override
	public void onEnable() {
		instance = this;
		// Vérification de la version
		if (!Bukkit.getVersion().contains("1.8")) {
			getLogger().log(Level.WARNING, "You're not in a 1.8 version !");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		// State in Lobby
		GameState.setState(GameState.LOBBY);
		// Enregistrement des listeners
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new PlayerConnectListener(), this);
		pm.registerEvents(new PlayerDamageListener(), this);
		pm.registerEvents(new PlayerInteractListener(), this);
		// Commands
		this.getCommand("game").setExecutor(new GameCommand());
		this.getCommand("hub").setExecutor(new HubCommand());
	}
	
	/**
	 * Permet d'envoyer un message dans la console.
	 * @author KingRider
	 * @param string
	 */
	public static void log(String string) {
		Bukkit.getConsoleSender().sendMessage(string);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		event.setQuitMessage("");
		Player player = event.getPlayer();
		int online = Bukkit.getOnlinePlayers().size();
		int max = Bukkit.getMaxPlayers();
		TitleUtils.sendActionBar(player, "§e" + player.getName() + " §7a quitté la partie §a(" + online + "/" + max + ")");
	}
	
	/**
	 * Getter instance
	 * @return
	 */
	public static Main getInstance() {
		return instance;
	}
	
	public static String line = "§7------------------------";
	public static String lineMessage = "§6---------------------------";
	
	public static String getMessageActif() {
		return "§av ACTIVE v";
	}
	
	public static String getMessageDes() {
		return "§4x DESACTIVE x";
	}

}
