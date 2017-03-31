package me.ekits.abilities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.ekits.main.Main;

public class Swap implements Listener{
	
	Main plugin;
	public Swap(Main instance){
		plugin = instance;
	}
	
	@EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e) {
	    // Check if the Event is NULL
	    if (e == null) return;
	    // Check if the Entities are NULL
	    if (e.getEntity() == null || e.getDamager() == null) return;
	    // Check if the Entites are Players
	    if (!(e.getEntity() instanceof Player && e.getDamager() instanceof Player)) return;
	    // Save it as Players
	    Player p = (Player) e.getEntity();
	    Player d = (Player) e.getDamager();
    		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
        	if (p.getItemInHand().getItemMeta().getDisplayName().contains("Evade")){
            if (p.getItemInHand().getType().equals(Material.WOOD_SWORD) && p.isBlocking()) {
               
                e.setCancelled(true);
               
                final Location loc = p.getLocation().clone();
               
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                   
                    @Override
                    public void run() {
                        p.teleport(d.getLocation());
                       
                        d.teleport(loc);
                    }
                }, 1L);
            }
        }
    }
	}
}
