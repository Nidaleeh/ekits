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

public class Fisherman implements CommandExecutor{
	
	Main plugin;
	public Fisherman(Main instance){
		plugin = instance;
	}
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Fisherman Kit
		if(cmd.getName().equalsIgnoreCase("Fisherman") && sender instanceof Player){
			
			
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
         plugin.djump.add(p.getName());
			//
			ItemStack Fishermansword = new ItemStack(Material.IRON_SWORD);
			ItemMeta sm = Fishermansword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Fisherman Sword");
			Fishermansword.setItemMeta(sm);
			Fishermansword.addEnchantment(Enchantment.DURABILITY, 3);
			//
			ItemStack Fisherman = new ItemStack(Material.FISHING_ROD);
			ItemMeta m = Fishermansword.getItemMeta();
			m.setDisplayName("" + ChatColor.GOLD + "Fisherman Rod");
			Fisherman.setItemMeta(m);
			Fisherman.addEnchantment(Enchantment.DURABILITY, 3);
			//Dyed Armor
			ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
			hmeta.setColor(Color.BLUE);	
			hmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			hmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lhelm.setItemMeta(hmeta);
			
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().addItem(Fishermansword);
			p.getInventory().addItem(Fisherman);
			p.getInventory().setHelmet(lhelm);
			p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
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
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Fisherman " + ChatColor.GOLD + "kit!");
		}
		return false;
}
}

