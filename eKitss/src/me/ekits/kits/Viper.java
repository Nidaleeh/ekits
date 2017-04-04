package me.ekits.kits;

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

public class Viper implements CommandExecutor{
	
	Main plugin;
	public Viper(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Viper Kit
		if(cmd.getName().equalsIgnoreCase("viper") && sender instanceof Player){
			
			
			Player p = (Player) sender;
			//
			if(!sender.hasPermission("ekits.vip")) {
                sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
                return true;
        }
	         if(plugin.kitused.contains(p.getName())){
                 p.sendMessage(ChatColor.RED + "You have already used a kit this life!");
                 return true;
         }
         plugin.kitused.add(p.getName());
         plugin.viper.add(p.getName());
			//
			ItemStack Vipersword = new ItemStack(Material.IRON_SWORD);
			ItemMeta sm = Vipersword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Viper Sword");
			Vipersword.setItemMeta(sm);
			Vipersword.addEnchantment(Enchantment.DURABILITY, 3);
			//Dyed Armor
			ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
			hmeta.setColor(Color.GREEN);	
			hmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			hmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lhelm.setItemMeta(hmeta);
			
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().setHelmet(lhelm);
			p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			p.getInventory().addItem(Vipersword);
			for(int i = 0; i < 34; i++){
		         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Viper " + ChatColor.GOLD + "kit!");
		}
		return false;
}
}

