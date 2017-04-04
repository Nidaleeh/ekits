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

public class Chameleon implements CommandExecutor{
	
	
	Main plugin;
	public Chameleon(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Chameleon Kit
		if(cmd.getName().equalsIgnoreCase("chameleon") && sender instanceof Player){
			
			
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
         plugin.chameleon.add(p.getName());
			//
			ItemStack Chameleonsword = new ItemStack(Material.STONE_SWORD);
			ItemMeta sm = Chameleonsword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Chameleon Sword" + ChatColor.GRAY +" (Shift)");
			Chameleonsword.setItemMeta(sm);
			Chameleonsword.addEnchantment(Enchantment.DURABILITY, 3);
			//Dyed Armor
			ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
			hmeta.setColor(Color.GREEN);	
			hmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			hmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lhelm.setItemMeta(hmeta);
			// Chest
			ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta cmeta = (LeatherArmorMeta) lchest.getItemMeta();
			cmeta.setColor(Color.GREEN);	
			cmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			cmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lchest.setItemMeta(cmeta);
			// Legs
			ItemStack llegs = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta lmeta = (LeatherArmorMeta) llegs.getItemMeta();
			lmeta.setColor(Color.GREEN);	
			lmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			lmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			llegs.setItemMeta(lmeta);
			// Boots
			ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bmeta = (LeatherArmorMeta) lboots.getItemMeta();
			bmeta.setColor(Color.GREEN);	
			bmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			bmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lboots.setItemMeta(lmeta);
			
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().setHelmet(lhelm);
			p.getInventory().setChestplate(lchest);
			p.getInventory().setLeggings(llegs);
			p.getInventory().setBoots(lboots);
			p.getInventory().addItem(Chameleonsword);
			for(int i = 0; i < 34; i++){
		         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Chameleon " + ChatColor.GOLD + "kit!");
		}
		
		
		return false;
}

}

