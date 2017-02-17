package fr.x9nico.king.fk.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import fr.x9nico.king.fk.api.PlayerKillEvent;

public class PlayerKillListener implements Listener{
	
	@EventHandler
	public void kill(PlayerKillEvent e){
		Player killer = e.getKiller();
		killer.sendMessage("§8[§9FK§8] §rVous avez tué §c"+e.getVictim());
	}

}
