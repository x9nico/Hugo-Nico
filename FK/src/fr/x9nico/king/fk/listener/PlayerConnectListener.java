package fr.x9nico.king.fk.listener;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.x9nico.king.fk.utils.TitleUtils;

public class PlayerConnectListener implements Listener {
	
	@EventHandler(ignoreCancelled = false)
	public void onPlayerConnect(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage("");
		int online = Bukkit.getOnlinePlayers().size();
		int max = Bukkit.getMaxPlayers();
		TitleUtils.sendActionBar(player, "§e" + player.getName() + " §7a rejoint la partie §a(" + online + "/" + max + ")");
		
		// Item kit
		ItemStack kit = new ItemStack(Material.NAME_TAG);
		ItemMeta kitm = kit.getItemMeta();
		kitm.setDisplayName("§6Choisir un kit §7(Clic-droit)");
		kit.setItemMeta(kitm);
		player.getInventory().setItem(0, kit);
		
		// Item Hub
		ItemStack hub = new ItemStack(Material.BED);
		ItemMeta hubm = hub.getItemMeta();
		hubm.setDisplayName("§6Retourner au Hub");
		hubm.setLore(Arrays.asList("§7Ou faites §e/hub"));
		hub.setItemMeta(hubm);
		player.getInventory().setItem(8, hub);
	}

}
