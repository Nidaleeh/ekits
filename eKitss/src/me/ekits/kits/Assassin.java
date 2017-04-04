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

public class Assassin implements CommandExecutor{
	 
	Main plugin;
	public Assassin(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	
	if (cmd.getName().equalsIgnoreCase("assassin") && sender instanceof Player) {  
         Player p = (Player) sender;    
        
         if(!sender.hasPermission("ekits.vip")) {
                 sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
                 return true;
         }
         if(plugin.kitused.contains(p.getName())){
                 p.sendMessage(ChatColor.RED + "You have already used a kit this life!");
                 return true;
         }
         plugin.kitused.add(p.getName());
         p.getInventory().clear();
         // Sword
         ItemStack ninjasword = (new ItemStack(Material.IRON_SWORD));
         ItemMeta m = ninjasword.getItemMeta();
         m.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Assassin's Sword");
         ninjasword.setItemMeta(m);
         ninjasword.addEnchantment(Enchantment.DURABILITY, 3);
         // Buff
         ItemStack redstone = (new ItemStack(Material.LEASH));
         ItemMeta z = redstone.getItemMeta();
         z.setDisplayName("" + ChatColor.DARK_RED + ChatColor.BOLD + "Assassinate" + ChatColor.GRAY +" (Right click)");
		 List<String> lore2 = new ArrayList<String>(); 
	     lore2.add("" + ChatColor.RED + "Right-Click" + ChatColor.GOLD + " to Assassinate!"); 
		 z.setLore(lore2); 
         redstone.setItemMeta(z);
         // Speed buff
         ItemStack sugar = (new ItemStack(Material.SUGAR));
         ItemMeta r = sugar.getItemMeta();
         r.setDisplayName("" + ChatColor.AQUA + ChatColor.BOLD + "Speed boost" + ChatColor.GRAY +" (Right click)");
		 List<String> lore = new ArrayList<String>(); 
	     lore.add("" + ChatColor.RED + "Right-Click" + ChatColor.GOLD + " to use speed!"); 
		 r.setLore(lore); 
         sugar.setItemMeta(r);
         // Armor
         ItemStack asboots = (new ItemStack(Material.GOLD_BOOTS));
         ItemMeta c = asboots.getItemMeta();
     asboots.setItemMeta(c);
         asboots.addEnchantment(Enchantment.DURABILITY, 3);
         asboots.addEnchantment(Enchantment.PROTECTION_FALL, 3);
         // dd
		ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
		hmeta.setColor(Color.RED);	
		hmeta.addEnchant(Enchantment.DURABILITY, 3, true);
		hmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
		lhelm.setItemMeta(hmeta);
		
         p.getInventory().addItem(ninjasword);
         p.getInventory().setHelmet(lhelm);
         p.getInventory().setBoots(new ItemStack(asboots));
         p.getInventory().addItem(new ItemStack(redstone));
         p.getInventory().addItem(new ItemStack(sugar));
			for(int i = 0; i < 34; i++){
		         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
         p.setMaxHealth(20);
         p.setHealth(20);
         p.sendMessage(ChatColor.AQUA + "You were given the " + ChatColor.BOLD + ChatColor.GOLD + "Assassin kit!");
 }
	return false;

}
}
