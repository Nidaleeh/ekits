package me.ekits.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ekits.main.Main;

public class Medic implements CommandExecutor{
	
	Main plugin;
	public Medic(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Thor Kit
		if(cmd.getName().equalsIgnoreCase("medic") && sender instanceof Player){
			
			Player p = (Player) sender;
	         if(plugin.kitused.contains(p.getName())){
                 p.sendMessage(ChatColor.RED + "You have already used a kit this life!");
                 return true;
         }
         plugin.kitused.add(p.getName());
         plugin.regen.add(p.getName());
			// SWORD
			ItemStack soldiersword = new ItemStack(Material.IRON_SWORD);
			ItemMeta sm = soldiersword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Medic Sword");
			soldiersword.setItemMeta(sm);
			
			//TP STICK
			ItemStack blazewand = new ItemStack(Material.GOLD_AXE);
			ItemMeta bw = blazewand.getItemMeta();
			bw.setDisplayName("" + ChatColor.YELLOW + "Heal");
			List<String> lore = new ArrayList<String>(); 
			lore.add("" + ChatColor.RED + "Right-Click" + ChatColor.DARK_PURPLE + " to heal a player!"); 
			bw.setLore(lore); 
			blazewand.setItemMeta(bw);
			
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
			p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
			p.getInventory().addItem(soldiersword);
			p.getInventory().addItem(blazewand);
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
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Medic " + ChatColor.GOLD + "kit!");
		}
		
		
		return false;
}

}


