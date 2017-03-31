package me.ekits.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.ekits.main.Main;

public class Phantom implements CommandExecutor{
	
	Main plugin;
	public Phantom(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	
	if (cmd.getName().equalsIgnoreCase("phantom") && sender instanceof Player) {  
         Player p = (Player) sender;    
        
         if(!sender.hasPermission("ekits.mvp")) {
                 sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
                 return true;
         }
         if(plugin.kitused.contains(p.getName())){
                 p.sendMessage(ChatColor.RED + "You have already used a kit this life!");
                 return true;
         }
         plugin.phantom.add(p.getName());
         plugin.kitused.add(p.getName());
         p.getInventory().clear();
         // Sword
         ItemStack ninjasword = (new ItemStack(Material.IRON_SWORD));
         ItemMeta m = ninjasword.getItemMeta();
         m.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Phantom's Sword");
         ninjasword.setItemMeta(m);
         ninjasword.addEnchantment(Enchantment.DURABILITY, 3);
         // Buff
         ItemStack redstone = (new ItemStack(Material.BOW));
         ItemMeta z = redstone.getItemMeta();
         z.setDisplayName("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Teleport Bow" + ChatColor.GRAY +" (Shoot arrow)");
		 List<String> lore2 = new ArrayList<String>(); 
	     lore2.add("" + ChatColor.RED + "Hit arrow" + ChatColor.GOLD + " to Teleport!"); 
		 z.setLore(lore2); 
         redstone.setItemMeta(z);
         // Armor
         ItemStack asboots = (new ItemStack(Material.IRON_BOOTS));
         ItemMeta c = asboots.getItemMeta();
     asboots.setItemMeta(c);
         asboots.addEnchantment(Enchantment.DURABILITY, 3);
         // dd
		ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
		hmeta.setColor(Color.WHITE);	
		hmeta.addEnchant(Enchantment.DURABILITY, 3, true);
		hmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		lhelm.setItemMeta(hmeta);
		
         p.getInventory().addItem(ninjasword);
         p.getInventory().setHelmet(lhelm);
         p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
         p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
         p.getInventory().setBoots(new ItemStack(asboots));
         p.getInventory().addItem(new ItemStack(redstone));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.ARROW, 10));
         p.setMaxHealth(20);
         p.setHealth(20);
         p.sendMessage(ChatColor.AQUA + "You were given the " + ChatColor.BOLD + ChatColor.GOLD + "Phantom kit!");
 }
	return false;

}
}


