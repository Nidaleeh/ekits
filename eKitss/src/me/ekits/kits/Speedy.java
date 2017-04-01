package me.ekits.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Speedy implements CommandExecutor, Listener{

	Main plugin;
	public Speedy(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		//Soldier Kit
		if(cmd.getName().equalsIgnoreCase("speedy") && sender instanceof Player){
			
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
			ItemStack soldiersword = new ItemStack(Material.IRON_SWORD);
			ItemMeta sm = soldiersword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Speedy Sword");
			soldiersword.setItemMeta(sm);
			p.getInventory().clear();
			p.setMaxHealth(20);
	        p.setHealth(20);
			p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
			p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			p.getInventory().addItem(soldiersword);
			for(int i = 0; i < 35; i++){
		         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
			p.sendMessage(ChatColor.GOLD + "You have obtained the" + ChatColor.GREEN + " Speedy " + ChatColor.GOLD + "kit!");
		}
		
		
		return false;
}

}