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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Ninja implements CommandExecutor {
	
	Main plugin;
	public Ninja(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Ninja Kit
		if(cmd.getName().equalsIgnoreCase("ninja") && sender instanceof Player){
			
			
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
         plugin.ninja2.add(p.getName());
			//
			ItemStack Ninjasword = new ItemStack(Material.WOOD_SWORD);
			ItemMeta sm = Ninjasword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Evade");
			Ninjasword.setItemMeta(sm);
			Ninjasword.addEnchantment(Enchantment.DAMAGE_ALL, 4);
			Ninjasword.addEnchantment(Enchantment.DURABILITY, 3);
			//Dyed Armor
			ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
			hmeta.setColor(Color.BLACK);	
			hmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lhelm.setItemMeta(hmeta);
			// Chest
			ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta cmeta = (LeatherArmorMeta) lchest.getItemMeta();
			cmeta.setColor(Color.BLACK);	
			cmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lchest.setItemMeta(cmeta);
			// Legs
			ItemStack llegs = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta lmeta = (LeatherArmorMeta) llegs.getItemMeta();
			lmeta.setColor(Color.BLACK);	
			lmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			llegs.setItemMeta(lmeta);
			// Boots
			ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bmeta = (LeatherArmorMeta) lboots.getItemMeta();
			bmeta.setColor(Color.BLACK);	
			bmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lboots.setItemMeta(lmeta);
			//Smoke bomb
			ItemStack smokebomb = new ItemStack(Material.COAL);
			ItemMeta bw = smokebomb.getItemMeta();
			bw.setDisplayName("" + ChatColor.GOLD + "Smoke bomb" + ChatColor.GRAY +" (Right click)");
			List<String> lore = new ArrayList<String>(); 
			lore.add("" + ChatColor.RED + "Right-Click" + ChatColor.DARK_PURPLE + " to use Stealth!"); 
			bw.setLore(lore); 
			smokebomb.setItemMeta(bw);
			
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().setHelmet(lhelm);
			p.getInventory().setChestplate(lchest);
			p.getInventory().setLeggings(llegs);
			p.getInventory().setBoots(lboots);
			p.getInventory().addItem(Ninjasword);
			p.getInventory().addItem(smokebomb);
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
	         p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0));
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Ninja " + ChatColor.GOLD + "kit!");
		}
		
		
		return false;
}

}

