package fr.x9nico.king.fk.listener;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.x9nico.king.fk.Main;
import fr.x9nico.king.fk.game.GameState;
import fr.x9nico.king.fk.object.ScoreboardRunnable;
import fr.x9nico.king.fk.utils.TitleUtils;

public class PlayerConnectListener implements Listener {
	
	@EventHandler
	public void onPlayerConnect(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage(null);
		int online = Bukkit.getOnlinePlayers().size();
		int max = Bukkit.getMaxPlayers();
		player.getInventory().clear();
		player.setGameMode(GameMode.SURVIVAL);
		// Message de join
		event.setJoinMessage(null);
		TitleUtils.sendActionBar(player, "§e" + player.getName() + " §7a rejoint la partie §a(" + online + "/" + max + ")");
		player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 1);
		
		if (GameState.isState(GameState.LOBBY)) {
			player.getWorld().setDifficulty(Difficulty.PEACEFUL);
			player.getWorld().setPVP(false);
		}
				
		// Joueur qui n'était pas la au lobby
		if(!GameState.isState(GameState.LOBBY)){
			player.setGameMode(GameMode.SPECTATOR);
			player.sendMessage("§cLa partie a déjà commencée.§eVous êtes en mode spectateur.");
			return;
		}
			
		// PlayerList add
		Main.playerList.add(player);
				
		// Scoreboard set quand un joueur se connecte
		new ScoreboardRunnable().runTaskTimer(Main.instance, 1L, 20L);
		
		player.teleport(new Location(player.getWorld(), 77, 59, 71));
		
		// Item kit
		ItemStack kit = new ItemStack(Material.NAME_TAG);
		ItemMeta kitm = kit.getItemMeta();
		kitm.setDisplayName("§6Choisir un kit §7(Clic-droit)");
		kit.setItemMeta(kitm);
		player.getInventory().setItem(0, kit);
		
		// Item Hub
		ItemStack hub = new ItemStack(Material.BED);
		ItemMeta hubm = hub.getItemMeta();
		hubm.setDisplayName("§6Retourner au Hub");
		hubm.setLore(Arrays.asList("§7Ou faites §e/hub"));
		hub.setItemMeta(hubm);
		player.getInventory().setItem(8, hub);
	
	}

}
