package me.ekits.abilities;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Water implements Listener{
	
	Main plugin;
	public Water(Main instance){
		plugin = instance;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(p.getLocation().getBlock().getType() == Material.WATER || p.getLocation().getBlock().getType() == Material.STATIONARY_WATER){
		if(plugin.water.contains(p.getName())){
		p.removePotionEffect(PotionEffectType.WATER_BREATHING);
	    p.removePotionEffect(PotionEffectType.SPEED);
	    p.removePotionEffect(PotionEffectType.JUMP);
	    p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 100, 0));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 0));
		}
	}
	}
}
