package fr.x9nico.king.fk.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.x9nico.king.fk.Main;
import fr.x9nico.king.fk.utils.TitleUtils;

/**
 * Class for Timer
 * @author KingRider
 */
public class GameManager {
	
	public Map<Player, ScoreboardSign> board = new HashMap<>();
	
	// Variables
	public int time = 121;
	public int start = 11;
	public int task;
	
	public void onStartTimer(Player player) {
		int online = Bukkit.getOnlinePlayers().size();
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				if (online >= 2) {
					time--;
					
					if (time == 121 || time == 120 || time == 60 || time == 40 || time == 30 || time == 20 || time == 10 || time == 5 || time == 4 || time == 3 || time == 2 || time == 1) {
						for (Player pls : Bukkit.getOnlinePlayers()) {
							TitleUtils.sendActionBar(pls, "§6La partie commence dans §e" + time + " §6seconde(s).");
							pls.playSound(pls.getLocation(), Sound.NOTE_PLING, 100, 1);
						}
						
					}
					
					for (Entry<Player, ScoreboardSign> boards : board.entrySet()) {
						boards.getValue().setLine(4, "§6Temps: §e" + time--);
					}
					
					for (Player pls : Bukkit.getOnlinePlayers()) {
						pls.setLevel(time);
					}
					
					if (time == 0) {
						player.getInventory().clear();
						player.closeInventory();
						Bukkit.getScheduler().cancelAllTasks();
					}
				}
			}
		}, 20, 20);
	}
	
	public void onTimerStart(Player player) {
		int online = Bukkit.getOnlinePlayers().size();
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				if (online >= 2) {
					start--;
					
					if (start == 11 || start == 10 || start == 5 || start == 4 || start == 3 || start == 2 || start == 1) {
						for (Player pls : Bukkit.getOnlinePlayers()) {
							TitleUtils.sendActionBar(pls, "§6La partie commence dans §e" + start + " §6seconde(s).");
							pls.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 1);
						}
		
					}
					
					for (Player pls : Bukkit.getOnlinePlayers()) {
						pls.setLevel(start);
					}
					
					if (start == 0) {
						player.getInventory().clear();
						player.closeInventory();
						Bukkit.getScheduler().cancelTask(task);
					}
				}
			}
		}, 20, 20);
	}
	
	public int getSecondRefresh() {
		return time;
	}

}
