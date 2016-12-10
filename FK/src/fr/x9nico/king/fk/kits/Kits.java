package fr.x9nico.king.fk.kits;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.x9nico.king.fk.Main;

public enum Kits {
	   
    GUERRIER(10,"§aKit Guerrier",new ItemStack(Material.STONE_SWORD, 1), Main.getInstance().kitContents.getGuerrierKit()),
    MINEUR(12,"§9Kit Mineur", new ItemStack(Material.STONE_PICKAXE, 1), Main.getInstance().kitContents.getSnowballKit()),
    FARMER(14,"§cKit Farmer", new ItemStack(Material.BONE, 1), Main.getInstance().kitContents.getExplosionKit());
   
    private ArrayList<ItemStack> items;
    private int slot;
    private String kitName;
    private ItemStack icon;
   
    Kits(int slot,String kitName,ItemStack icon, ArrayList<ItemStack> items){
        this.slot = slot;
        this.kitName = kitName;
        this.icon = icon;  
        this.items = items;
    }
   
    public int getSlot(){
        return slot;
    }
   
    public String getKitName(){
        return kitName;
    }
   
    public ItemStack getIcon(){
        return icon;
    }
   
    public ItemStack getItem(){
        ItemStack i = icon;
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(kitName);
        i.setItemMeta(iM);
        return i;
    }
   
    public void add(Player player){
       
        if(Main.getInstance().kits.containsKey(player)){
        	Main.getInstance().kits.remove(player);
        }
       
        Main.getInstance().kits.put(player, this);
        player.sendMessage("§6Votre kit : §e"+kitName);
 
    }
 
    public ArrayList<ItemStack> getItems() {
        return items;
    }
   

}
