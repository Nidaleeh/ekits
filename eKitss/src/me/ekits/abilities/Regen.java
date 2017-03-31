package me.ekits.abilities;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Regen implements Listener{
	
	Main plugin;
	public Regen(Main instance){
		plugin = instance;
	}
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e){
		Player p = e.getPlayer();
		if(plugin.regen.contains(p.getName())){
		if(!(p.isSneaking())){
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, 0));
		}else{
			p.removePotionEffect(PotionEffectType.REGENERATION);
			
			
		}
	}
}
}