package me.ekits.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Sneakattack implements Listener{
	
	Main plugin;
	public Sneakattack(Main instance){
		plugin = instance;
	}
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e){
		Player p = e.getPlayer();
		
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
		if(plugin.chameleon.contains(p.getName())){
		if(!(p.isSneaking())){
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 0));
		    p.getInventory().setHelmet(new ItemStack(Material.AIR));
		    p.getInventory().setChestplate(new ItemStack(Material.AIR));
		    p.getInventory().setLeggings(new ItemStack(Material.AIR));
		    p.getInventory().setBoots(new ItemStack(Material.AIR));
			p.getInventory().remove(Material.STONE_SWORD);
		}else{
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
			p.getInventory().setHelmet(lhelm);
			p.getInventory().setChestplate(lchest);
			p.getInventory().setLeggings(llegs);
			p.getInventory().setBoots(lboots);
			p.getInventory().addItem(Chameleonsword);
			
			
		}
	}
	}
}