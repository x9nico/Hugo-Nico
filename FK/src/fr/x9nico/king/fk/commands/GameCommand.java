package fr.x9nico.king.fk.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.x9nico.king.fk.Main;

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
		
		return true;
	}

}
