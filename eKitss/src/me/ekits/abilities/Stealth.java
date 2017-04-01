package me.ekits.abilities;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Stealth implements Listener {
	
	Main plugin;
	public Stealth(Main instance){
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
	    if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Smoke bomb")){
		if(plugin.ninja.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "You can't use that yet!");
			return;
		}
		//Dyed Armor
		ItemStack smokebomb = new ItemStack(Material.COAL);
		ItemMeta bw = smokebomb.getItemMeta();
		bw.setDisplayName("" + ChatColor.GOLD + "Smoke bomb" + ChatColor.GRAY +" (Right click)");
		List<String> lore = new ArrayList<String>(); 
		lore.add("" + ChatColor.RED + "Right-Click" + ChatColor.DARK_PURPLE + " to use Stealth!"); 
		bw.setLore(lore); 
		smokebomb.setItemMeta(bw);
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
		ItemStack llegs = new ItemStack(Material.LEATHER_LEGGINGS);
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
		
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
	    if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Smoke bomb")){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
	    p.sendMessage("" + ChatColor.GRAY + ChatColor.BOLD + "You are now invisible");
	    p.getInventory().removeItem(smokebomb);
	    p.removePotionEffect(PotionEffectType.SPEED);
	    p.getInventory().setHelmet(new ItemStack(Material.AIR));
	    p.getInventory().setChestplate(new ItemStack(Material.AIR));
	    p.getInventory().setLeggings(new ItemStack(Material.AIR));
	    p.getInventory().setBoots(new ItemStack(Material.AIR));
		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 0));
		plugin.ninja.add(p.getName());
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
                plugin.ninja.remove(p.getName());
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0));
                p.getInventory().addItem(smokebomb);
        		p.getInventory().setHelmet(lhelm);
        		p.getInventory().setChestplate(lchest);
        		p.getInventory().setLeggings(llegs);
        		p.getInventory().setBoots(lboots);
                p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You have regained your armor and you can use stealth again!");
            }
    }, 200);
    return;
}
else {
    return;
}
}

		
}
		}
		}
}
	}
