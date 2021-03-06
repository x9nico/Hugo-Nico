package fr.x9nico.king.fk.listener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
import fr.x9nico.king.fk.manager.GameManager;
import fr.x9nico.king.fk.manager.ScoreboardSign;
import fr.x9nico.king.fk.utils.TitleUtils;

public class PlayerConnectListener implements Listener {
	
	public Map<Player, ScoreboardSign> board = new HashMap<>();
	
	@EventHandler
	public void onPlayerConnect(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		int online = Bukkit.getOnlinePlayers().size();
		int max = Bukkit.getMaxPlayers();
		player.getInventory().clear();
		player.setGameMode(GameMode.SURVIVAL);
		player.setLevel(121);
		// Message de join
		event.setJoinMessage(null);
		TitleUtils.sendActionBar(player, "�e" + player.getName() + " �7a rejoint la partie �a(" + online + "/" + max + ")");
		player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 1);
		
		if (GameState.isState(GameState.LOBBY)) {
			player.getWorld().setDifficulty(Difficulty.PEACEFUL);
			player.getWorld().setPVP(false);
		}
				
		// Joueur qui n'�tait pas la au lobby
		if(!GameState.isState(GameState.LOBBY)){
			player.setGameMode(GameMode.SPECTATOR);
			player.sendMessage("�cLa partie a d�j� commenc�e.�eVous �tes en mode spectateur.");
			return;
		}
			
		// PlayerList add
		Main.playerList.add(player);
		
		// SB Refresh
		for (Entry<Player, ScoreboardSign> boards : board.entrySet()) {
			boards.getValue().setLine(1, "�6Joueurs: �a" + Bukkit.getOnlinePlayers().size()+"");
		}
		
		//SB
		ScoreboardSign sb = new ScoreboardSign(player, "�e�lFallenKingdoms");
		sb.create();
		sb.setLine(0, "�e");
		sb.setLine(1, "�6Joueurs: �a" + Bukkit.getOnlinePlayers().size()+"");
		sb.setLine(3, "�e");
		sb.setLine(4, "�6Temps: �e" + new GameManager().time+"");
		sb.setLine(5, "�e");
		sb.setLine(6, "�eplay.epicube.fr");
		board.put(player, sb);
		
		new GameManager().onStartTimer(player);
		
		player.teleport(new Location(player.getWorld(), 77, 59, 71));
		
		// Item kit
		ItemStack kit = new ItemStack(Material.NAME_TAG);
		ItemMeta kitm = kit.getItemMeta();
		kitm.setDisplayName("�6Choisir un kit �7(Clic-droit)");
		kit.setItemMeta(kitm);
		player.getInventory().setItem(0, kit);
		
		// Item Hub
		ItemStack hub = new ItemStack(Material.BED);
		ItemMeta hubm = hub.getItemMeta();
		hubm.setDisplayName("�6Retourner au Hub");
		hubm.setLore(Arrays.asList("�7Ou faites �e/hub"));
		hub.setItemMeta(hubm);
		player.getInventory().setItem(8, hub);
	
	}

}
