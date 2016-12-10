package fr.x9nico.king.fk.listener;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import fr.x9nico.king.fk.game.GameState;

public class PlayerDamageListener implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Player player = (Player) event.getEntity();
		if (GameState.isState(GameState.LOBBY)) {
			if (event.getCause() == DamageCause.FALL) {
				event.setCancelled(true);
				player.teleport(new Location(player.getWorld(), 77, 59, 71));
				player.sendMessage("Vous ne pouvez pas sortir de la WaitingRoom");
			}
		}
	}

}
