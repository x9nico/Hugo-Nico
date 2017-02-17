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
import org.bukkit.inventory.ItemStack;

import fr.x9nico.king.fk.kits.Kits;

public class KitUtils implements Listener {
	
	private Inventory inv;
	
	public KitUtils() {
		this.inv = Bukkit.createInventory(null, 27, "§7Sélection: §e" + Kits.MINEUR.getKitName());
        this.inv.setItem(Kits.GUERRIER.getSlot(), Kits.GUERRIER.getItem());
        this.inv.setItem(Kits.MINEUR.getSlot(), Kits.MINEUR.getItem());
        this.inv.setItem(Kits.FARMER.getSlot(), Kits.FARMER.getItem());
	}
	
	@EventHandler
    public void interact(PlayerInteractEvent e){
        Player p = e.getPlayer();
        ItemStack i = e.getItem();
       
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)return;
        
        if(i != null && i.getType() != null && i.getType() == Material.NAME_TAG){
            p.openInventory(inv);
        }
       
    }
   
    @EventHandler
    public void clickInventory(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getInventory();
        ItemStack current = e.getCurrentItem();
       
        if(inv.getName().equalsIgnoreCase("§7Sélection: §e" + Kits.MINEUR.getKitName())){
           
            if(current == null) return;
            e.setCancelled(true);
            p.closeInventory();
           
            if(current.getType() == Kits.MINEUR.getIcon().getType()){
                //il a choisit le kit explosion
                Kits.MINEUR.add(p);
            }else if(current.getType() == Kits.GUERRIER.getIcon().getType()){
                //il a choisit le kit guerrier
                Kits.GUERRIER.add(p);
            }else if(current.getType() == Kits.FARMER.getIcon().getType()){
                Kits.FARMER.add(p);
            }
           
        }
       
    }

}
