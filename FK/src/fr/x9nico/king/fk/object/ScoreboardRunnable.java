package fr.x9nico.king.fk.object;

import java.util.Map.Entry;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/** Scoreboard class.
 * @author KingRider
 */
public class ScoreboardRunnable extends BukkitRunnable{

	@Override
	public void run() {
		for(Entry<Player, ScoreboardManager> scoreboard : ScoreboardManager.sb.entrySet()){
			ScoreboardManager board = scoreboard.getValue();
			board.refresh();
		}
		
	}
	
	/**
	 * Send line in Scoreboard
	 */
	public static void sendLine() {	
		for(Entry<Player, ScoreboardManager> scoreboard : ScoreboardManager.sb.entrySet()){
			ScoreboardManager board = scoreboard.getValue();
			board.getLine();
		}
		
		
	}
}
