package me.ekits.abilities;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.ekits.main.Main;

public class Hitteleport implements Listener{

	Main plugin;
	public Hitteleport(Main instance) {
		this.plugin = instance;
	}
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        Entity damager = e.getDamager();
        if(ent instanceof Player) {
            Player hit = (Player) ent;
            if(damager instanceof Arrow) {
                Arrow Arrow = (Arrow) damager;
                if(Arrow.getShooter() instanceof Player) {
                    Player shooter = (Player) Arrow.getShooter();
                    if(!plugin.phantom.contains(shooter.getName())) return;
                    Location hitloc = hit.getLocation();
                    shooter.teleport(hitloc);
                }
            }
        }
    }
}