package fr.x9nico.king.fk.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.md_5.bungee.api.ChatColor;

public class PlayerInteractListener implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)return;
		if (event.getItem() == null)return;
		if (!event.getItem().hasItemMeta())return;
		if (event.getItem().getItemMeta().getDisplayName().contains("§6Retourner au Hub"))
		{
			try {
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("lobby");
				player.sendPluginMessage(Bukkit.getPluginManager().getPlugin("FallenKingdom"), "BungeeCord", out.toByteArray());
			} catch (Exception e) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 3, 2));
				player.sendMessage("§cAucun serveur n'est connecté !");
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Erreur...");
			}
		}
	}

}
