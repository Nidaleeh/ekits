package me.ekits.abilities;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Lava implements Listener{
	
	Main plugin;
	public Lava(Main instance){
		plugin = instance;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(p.getLocation().getBlock().getType() == Material.LAVA || p.getLocation().getBlock().getType() == Material.STATIONARY_LAVA){
		if(plugin.lava.contains(p.getName())){
		p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
	    p.removePotionEffect(PotionEffectType.SPEED);
	    p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 400, 0));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
		}
	}
	}
}