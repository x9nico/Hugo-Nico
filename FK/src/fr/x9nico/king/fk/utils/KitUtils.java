package fr.x9nico.king.fk.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class KitUtils implements Listener{
	
	@EventHandler
	public void openmenu(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getItem() != null
				&& e.getItem().getType() == Material.NAME_TAG
				&& (e.getAction() == Action.RIGHT_CLICK_AIR))
		kitsGUI(p);
	}
	
	private static String InvName = "§6Kits";
	
	private void kitsGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 27, InvName);
		
		p.openInventory(inv);
	}
	
	@EventHandler
	public void click(InventoryClickEvent e){
		if(e.getInventory().getName().equalsIgnoreCase(InvName)){
			Player p = (Player) e.getWhoClicked();
			if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
			
			switch(e.getCurrentItem().getType()){
			
			default:
				break;
			}
		}
	}

}
