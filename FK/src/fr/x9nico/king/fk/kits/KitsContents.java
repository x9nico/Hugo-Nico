package fr.x9nico.king.fk.kits;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsContents {
	
	public ArrayList<ItemStack> getSnowballKit(){
        ArrayList<ItemStack> i = new ArrayList<>();
        i.add(get(Material.SNOW_BALL, 32, (byte)0, "§aPioche qui vous permettra de miner plus vite", Enchantment.DURABILITY, 1));
        i.add(get(Material.DIAMOND_SWORD, 1, (byte)0, null, Enchantment.DAMAGE_ALL, 2));
        return i;
    }
 
    public ArrayList<ItemStack> getExplosionKit(){
        ArrayList<ItemStack> i = new ArrayList<>();
        i.add(get(Material.TNT, 16, (byte)0, "§aFarmer c'est votre dada...", null, 1));
        i.add(get(Material.FLINT_AND_STEEL, 1, (byte)0, null, null, 2));
        return i;
    }
 
    public ArrayList<ItemStack> getGuerrierKit(){
        ArrayList<ItemStack> i = new ArrayList<>();
        i.add(get(Material.IRON_SWORD, 1, (byte)0, null, Enchantment.DAMAGE_ALL, 1));
        i.add(get(Material.COOKED_BEEF, 11, (byte)0, null, null, 2));
        return i;
    }
   
    private ItemStack get(Material mat, int amount, byte data, String displayName, Enchantment ench, int enchLevel) {
        ItemStack i = new ItemStack(mat,amount,data);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(displayName);
       
        if(ench != null){
            iM.addEnchant(ench, enchLevel, true);
        }
       
        i.setItemMeta(iM);
        return i;
    }
   

}
