package me.ekits.kits;

import me.ekits.main.Main;

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

public class Psycho implements CommandExecutor {
	Main plugin;
	public Psycho(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Soldier Kit
		if(cmd.getName().equalsIgnoreCase("psycho") && sender instanceof Player){
			
			Player p = (Player) sender;
	         if(plugin.kitused.contains(p.getName())){
                 p.sendMessage(ChatColor.RED + "You have already used a kit this life!");
                 return true;
         }
         plugin.kitused.add(p.getName());
         plugin.psycho.add(p.getName());
			ItemStack soldiersword = new ItemStack(Material.SHEARS);
			ItemMeta sm = soldiersword.getItemMeta();
			sm.setDisplayName("" + ChatColor.YELLOW + "Psycho Scissor");
			sm.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
			soldiersword.setItemMeta(sm);
			
			ItemStack lhelm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta hmeta = (LeatherArmorMeta) lhelm.getItemMeta();
			hmeta.setColor(Color.PURPLE);	
			hmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lhelm.setItemMeta(hmeta);
			
			ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta cmeta = (LeatherArmorMeta) lchest.getItemMeta();
			cmeta.setColor(Color.PURPLE);	
			cmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lchest.setItemMeta(cmeta);
			
			ItemStack llegs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta lmeta = (LeatherArmorMeta) llegs.getItemMeta();
			lmeta.setColor(Color.PURPLE);	
			lmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			llegs.setItemMeta(lmeta);
			
			ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bmeta = (LeatherArmorMeta) lboots.getItemMeta();
			bmeta.setColor(Color.PURPLE);	
			bmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lboots.setItemMeta(lmeta);
			
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().setHelmet(lhelm);
			p.getInventory().setChestplate(lchest);
			p.getInventory().setLeggings(llegs);
			p.getInventory().setBoots(lboots);
			p.getInventory().addItem(soldiersword);
			for(int i = 0; i < 35; i++){
		         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Psycho " + ChatColor.GOLD + "kit!");
		}
		
		
		return false;
}

}
