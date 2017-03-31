package me.ekits.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Ghost implements CommandExecutor {
	
	Main plugin;
	public Ghost(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Soldier Kit
		if(cmd.getName().equalsIgnoreCase("ghost") && sender instanceof Player){
			
			Player p = (Player) sender;
			
	         if(!sender.hasPermission("ekits.vip")) {
                 sender.sendMessage(ChatColor.RED + "You must buy " + ChatColor.GREEN + ChatColor.BOLD + "VIP" + ChatColor.RED + " to gain access to this kit!");
                 return true;
         }
			
			ItemStack soldiersword = new ItemStack(Material.IRON_SWORD);
			ItemMeta sm = soldiersword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Ghost Sword");
			soldiersword.setItemMeta(sm);
			
			ItemStack invis = new ItemStack(Material.AIR);
			
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().addItem(soldiersword);
			for(int i = 0; i < 35; i++){
		         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999999, 0));
			p.getInventory().setItem(1, invis);
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Ghost " + ChatColor.GOLD + "kit!");
		}
		
		
		return false;
}


}
