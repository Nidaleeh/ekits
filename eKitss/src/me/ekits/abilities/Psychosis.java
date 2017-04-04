package me.ekits.abilities;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Psychosis implements Listener{
	
	HashMap<Player,Integer> kills = new HashMap<Player,Integer>();
	
	Main plugin;
	public Psychosis(Main instance){
		plugin = instance;
	}
	Player p = null;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onKill(PlayerDeathEvent event){
		if(event.getEntityType().equals(EntityType.PLAYER)){
			p = ((Player)event.getEntity().getKiller());
			if(plugin.psycho.contains(p.getName())){
				if(!kills.containsKey(p)){
					kills.put(p, 1);
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 30, 1));
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
			            public void run() {
			              kills.remove(p);     
			            }
			    }, 20);
				}else if(p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)){
					p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.removePotionEffect(PotionEffectType.CONFUSION);
					kills.put(p, kills.get(p).intValue() + 1);
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30, kills.get(p).intValue()));
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 30, kills.get(p).intValue()));
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
			            public void run() {
			              kills.remove(p);     
			            }
			    }, 20);
				}
			}
			
		}
	}
	

}
