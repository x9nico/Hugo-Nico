package fr.x9nico.king.fk;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.x9nico.king.fk.commands.GameCommand;
import fr.x9nico.king.fk.commands.HubCommand;
import fr.x9nico.king.fk.game.GameState;
import fr.x9nico.king.fk.kits.Kits;
import fr.x9nico.king.fk.kits.KitsContents;
import fr.x9nico.king.fk.listener.PlayerConnectListener;
import fr.x9nico.king.fk.listener.PlayerDamageListener;
import fr.x9nico.king.fk.listener.PlayerInteractListener;
import fr.x9nico.king.fk.utils.KitUtils;
import fr.x9nico.king.fk.utils.TitleUtils;

public class Main extends JavaPlugin implements Listener {
	
	// Variables
	public static Main instance;
	public static ArrayList<Player> playerList = new ArrayList<Player>();
	public KitsContents kitContents = new KitsContents();
	public HashMap<Player, Kits> kits = new HashMap<>();
	public static HashMap<Player, Integer> kill = new HashMap<Player, Integer>();
	
	Player player;
	
	@Override
	public void onEnable() {
		try {
			instance = this;
			// State in Lobby
			GameState.setState(GameState.LOBBY);
			// Enregistrement des listeners
			PluginManager pm = this.getServer().getPluginManager();
			pm.registerEvents(new PlayerConnectListener(), this);
			pm.registerEvents(new PlayerDamageListener(), this);
			pm.registerEvents(new PlayerInteractListener(), this);
			pm.registerEvents(new KitUtils(), this);
			pm.registerEvents(this, this);
			// Commands
			getCommand("game").setExecutor(new GameCommand());
			getCommand("hub").setExecutor(new HubCommand());
			
		} catch(Exception e) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Erreur contactez immédiatement: " + this.getDescription().getAuthors());
		}
		
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
		Player player = event.getPlayer();
		
		player.getInventory().clear();
		
		event.setQuitMessage("");
		
		Main.playerList.remove(player);
		
		int online = Bukkit.getOnlinePlayers().size();
		int max = Bukkit.getMaxPlayers();
		TitleUtils.sendActionBar(player, "§e" + player.getName() + " §7a quitté la partie §a(" + online + "/" + max + ")");
	}
	
	@EventHandler
	public void onWeather(WeatherChangeEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onBreakBlock(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (player.getGameMode() == GameMode.CREATIVE) {
			event.setCancelled(false);
		}
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onPlaceBlock(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (player.getGameMode() == GameMode.CREATIVE) {
			event.setCancelled(false);
		}
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		if (GameState.isState(GameState.LOBBY)) {
			event.setCancelled(true);
		} else {
			event.setCancelled(false);
		}
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
