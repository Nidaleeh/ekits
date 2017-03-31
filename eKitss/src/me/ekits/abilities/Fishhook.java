package me.ekits.abilities;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import me.ekits.main.Main;

public class Fishhook implements Listener{
	
	Main plugin;
	public Fishhook(Main instance){
		plugin = instance;
	}
	@EventHandler
	public void onFish(PlayerFishEvent e){
		Player p = e.getPlayer();
		Player f = (Player) e.getCaught();
		Location loc1 = p.getLocation();
		if(p instanceof Player && f instanceof Player){
		if(p != null && f != null){
		if(p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getItemInHand().getItemMeta().getDisplayName().contains("Fisherman Rod")){
		f.teleport(loc1);
			}
		}
	}
}
}
}
