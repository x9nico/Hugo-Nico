package fr.x9nico.king.fk.manager;

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
	
	// Variables
	public int time = 120;
	public int task;
	// Configuration
	/*
	 * Maybe a see ?
	 */
	
	/**
	 * Timer for plugin in GameState lobby
	 * @author KingRider
	 * @param p
	 */
	public void onStartTimer(Player player) {
		int online = Bukkit.getOnlinePlayers().size();
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
			@Override
			public void run() {
				if (online >= 2) {
					time--;
					
					if (time == 120 || time == 60 || time == 40 || time == 30 || time == 20 || time == 10 || time == 5 || time == 4 || time == 2 || time == 1) {
						for (Player pls : Bukkit.getOnlinePlayers()) {
							TitleUtils.sendActionBar(pls, "§6La partie commence dans §e" + time + " §6seconde(s).");
							player.playSound(player.getLocation(), Sound.NOTE_BASS_DRUM, 100, 1);
						}
					}
				}
			}
		}, 20, 20);
	}

}
