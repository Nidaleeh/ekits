package me.ekits.abilities;

import java.util.HashMap;

import org.bukkit.Bukkit;
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
		Player p = event.getEntity();
		Player pk = p.getKiller();
			if(plugin.psycho.contains(pk.getName())){
				if(!kills.containsKey(pk)){
					kills.put(pk, 1);
					pk.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30, 1));
					pk.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 30, 1));
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
			            public void run() {
			              kills.remove(pk);     
			            }
			    }, 20);
				}else if(pk.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)){
					pk.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					pk.removePotionEffect(PotionEffectType.CONFUSION);
					kills.put(pk, kills.get(pk).intValue() + 1);
					pk.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30, kills.get(pk).intValue()));
					pk.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 30, kills.get(pk).intValue()));
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
			            public void run() {
			              kills.remove(pk);     
			            }
			    }, 20);
				}
			}
			
	}
	

}
