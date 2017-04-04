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

public class Thor implements CommandExecutor{
	
	Main plugin;
	public Thor(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Thor Kit
		if(cmd.getName().equalsIgnoreCase("thor") && sender instanceof Player){
			
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
			// SWORD
			ItemStack soldiersword = new ItemStack(Material.IRON_SWORD);
			ItemMeta sm = soldiersword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Thor Sword");
			soldiersword.setItemMeta(sm);
			soldiersword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			//Dyed Armor
			ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
			hmeta.setColor(Color.WHITE);	
			hmeta.addEnchant(Enchantment.DURABILITY, 2, true);
			lhelm.setItemMeta(hmeta);
			// Chest
			ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta cmeta = (LeatherArmorMeta) lchest.getItemMeta();
			cmeta.setColor(Color.RED);	
			cmeta.addEnchant(Enchantment.DURABILITY, 2, true);
			lchest.setItemMeta(cmeta);
			
			//TP STICK
			ItemStack blazewand = new ItemStack(Material.IRON_AXE);
			ItemMeta bw = blazewand.getItemMeta();
			bw.setDisplayName("" + ChatColor.AQUA + "Lightning Wand" + ChatColor.GRAY +" (Right click)");
			List<String> lore = new ArrayList<String>(); 
			lore.add("" + ChatColor.RED + "Right-Click" + ChatColor.DARK_PURPLE + " to cast lightning!"); 
			bw.setLore(lore); 
			blazewand.setItemMeta(bw);
			
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().setHelmet(new ItemStack(lhelm));
			p.getInventory().setChestplate(new ItemStack(lchest));
			p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			p.getInventory().addItem(soldiersword);
			p.getInventory().addItem(blazewand);
			for(int i = 0; i < 34; i++){
		         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Thor " + ChatColor.GOLD + "kit!");
		}
		
		
		return false;
}

}
