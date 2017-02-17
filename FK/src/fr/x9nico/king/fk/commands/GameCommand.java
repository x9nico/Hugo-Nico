package fr.x9nico.king.fk.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.x9nico.king.fk.Main;
import fr.x9nico.king.fk.manager.GameManager;
import fr.x9nico.king.fk.utils.LocationUtils;

public class GameCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			Main.log("Commande uniquement utilisable en jeux.");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (args.length == 0) {
			if (player.isOp() || player.isPermissionSet("fk.admin")) {
				player.sendMessage("/game start | pour lance une partie.");
			}
			
		}
		
		if (args.length > 0) {
			String subCommand = args[0];
			if (subCommand.equalsIgnoreCase("start")) start(player);
			else if (subCommand.equalsIgnoreCase("addspawn")) spawn(player);
			else if (subCommand.equalsIgnoreCase("removeSpawn")) removeSpawn(player);
			else if(subCommand.equalsIgnoreCase("addSpawnSpec")) spawnSpec(player);
		}
		return true;
	}
	
	public void spawnSpec(Player player) {
		new LocationUtils(player.getLocation());
	}

	public void removeSpawn(Player player) {
		new LocationUtils(player.getLocation());
	}

	public void spawn(Player player) {
		new LocationUtils(player.getLocation());
	}

	public void start(Player player) {
		new GameManager().onTimerStart(player);
	}

}
