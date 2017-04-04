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

public class Switcher implements CommandExecutor{
	
	Main plugin;
	public Switcher(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Switcher Kit
		if(cmd.getName().equalsIgnoreCase("Switcher") && sender instanceof Player){
			
			
			Player p = (Player) sender;
			//
			if(!sender.hasPermission("ekits.mvp")) {
                sender.sendMessage(ChatColor.RED + "You are not permitted to do this!");
                return true;
        }
	         if(plugin.kitused.contains(p.getName())){
                 p.sendMessage(ChatColor.RED + "You have already used a kit this life!");
                 return true;
         }
         plugin.kitused.add(p.getName());
         plugin.switcher.add(p.getName());
			//
			ItemStack Switchersword = new ItemStack(Material.IRON_SWORD);
			ItemMeta sm = Switchersword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Switcher Sword");
			Switchersword.setItemMeta(sm);
			Switchersword.addEnchantment(Enchantment.DURABILITY, 3);
			//Dyed Armor
			ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
			hmeta.setColor(Color.YELLOW);	
			hmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			hmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lhelm.setItemMeta(hmeta);
			//
			ItemStack helm = new ItemStack(Material.GOLD_BOOTS);
			ItemMeta meta = helm.getItemMeta();
			meta.addEnchant(Enchantment.DURABILITY, 2, true);
			helm.setItemMeta(meta);
			//
			ItemStack gun = new ItemStack(Material.SNOW_BALL, 8);
			ItemMeta m = gun.getItemMeta();
			m.setDisplayName("" + ChatColor.GOLD + "Switcher's Snowballs");
			gun.setItemMeta(m);
			
			
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().addItem(Switchersword);
			p.getInventory().setHelmet(lhelm);
			p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(helm));
			p.getInventory().addItem(new ItemStack(gun));
			for(int i = 0; i < 34; i++){
		         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Switcher " + ChatColor.GOLD + "kit!");
		}
		return false;
}
}

