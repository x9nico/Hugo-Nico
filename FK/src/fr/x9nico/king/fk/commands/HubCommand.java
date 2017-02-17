package fr.x9nico.king.fk.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.x9nico.king.fk.Main;

public class HubCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			Main.log("Commande uniquement utilisable en jeux.");
			return true;
		}
		
		Player player = (Player) sender;
		
		// /hub tout seul on envoie le joueur.
		if (args.length == 0) {
			try {
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("lobby");
				player.sendPluginMessage(Bukkit.getPluginManager().getPlugin("FallenKingdom"), "BungeeCord", out.toByteArray());
			} catch (Exception e) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 3, 10));
				player.sendMessage("§cAucun serveur n'est connecté !");
				
			}
			
		}
		return true;
	}
	
	

}
