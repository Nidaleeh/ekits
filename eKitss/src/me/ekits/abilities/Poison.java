package me.ekits.abilities;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Poison implements Listener{
	
	Main plugin;
	public Poison(Main instance){
		plugin = instance;
	}
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
		if(e.getEntity() instanceof Player){
			
		Player d = (Player) e.getDamager();
		Player p = (Player) e.getEntity();
		if(p != null && d != null){
		if(d.getItemInHand() == null && d.getItemInHand().getItemMeta() == null && p.getItemInHand().getItemMeta().getDisplayName() == null){
			return;
		}
	    if(plugin.viper.contains(d.getName())){
		if(d.getItemInHand().getItemMeta().getDisplayName().contains("Viper Sword")){
		p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 0));
		}
		
	}
}
	}
}
}
}