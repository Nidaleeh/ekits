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

public class Tamer implements CommandExecutor{
	
	Main plugin;
	public Tamer(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Ender Kit
		if(cmd.getName().equalsIgnoreCase("tamer") && sender instanceof Player){
			
			Player p = (Player) sender;
	         if(plugin.kitused.contains(p.getName())){
                 p.sendMessage(ChatColor.RED + "You have already used a kit this life!");
                 return true;
         }
         plugin.kitused.add(p.getName());
         plugin.tamedwolf.add(p.getName());
			// SWORD
			ItemStack soldiersword = new ItemStack(Material.IRON_SWORD);
			ItemMeta sm = soldiersword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Tamer Sword");
			soldiersword.setItemMeta(sm);
			soldiersword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			//Dyed Armor
			ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
			hmeta.setColor(Color.GREEN);	
			hmeta.addEnchant(Enchantment.DURABILITY, 1, true);
			lhelm.setItemMeta(hmeta);
			// Chest
			ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta cmeta = (LeatherArmorMeta) lchest.getItemMeta();
			cmeta.setColor(Color.GREEN);	
			cmeta.addEnchant(Enchantment.DURABILITY, 1, true);
			lchest.setItemMeta(cmeta);
			
			ItemStack llegs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta lmeta = (LeatherArmorMeta) llegs.getItemMeta();
			lmeta.setColor(Color.GREEN);	
			lmeta.addEnchant(Enchantment.DURABILITY, 1, true);
			llegs.setItemMeta(lmeta);
			
			ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bmeta = (LeatherArmorMeta) lboots.getItemMeta();
			bmeta.setColor(Color.GREEN);	
			bmeta.addEnchant(Enchantment.DURABILITY, 1, true);
			lboots.setItemMeta(bmeta);
			
			//TP STICK
			ItemStack blazewand = new ItemStack(Material.STICK);
			ItemMeta bw = blazewand.getItemMeta();
			bw.setDisplayName("" + ChatColor.GOLD + "Spawn Wolf");
			List<String> lore = new ArrayList<String>(); 
			lore.add("" + ChatColor.RED + "Right-Click" + ChatColor.DARK_PURPLE + " to spawn Wolves!"); 
			bw.setLore(lore); 
			blazewand.setItemMeta(bw);
			
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().setHelmet(new ItemStack(lhelm));
			p.getInventory().setChestplate(new ItemStack(lchest));
			p.getInventory().setLeggings(new ItemStack(llegs));
			p.getInventory().setBoots(new ItemStack(lboots));
			p.getInventory().addItem(soldiersword);
			p.getInventory().addItem(blazewand);
			p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
	         p.getInventory().addItem(new ItemStack(Material.BONE, 64));
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
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Tamer " + ChatColor.GOLD + "kit!");
		}
		
		
		return false;
}

}

