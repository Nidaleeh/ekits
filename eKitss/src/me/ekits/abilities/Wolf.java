package me.ekits.abilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import me.ekits.main.Main;

@SuppressWarnings("deprecation")
public class Wolf implements Listener{
	
	Main plugin;
	public Wolf(Main instance){
		plugin = instance;
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Spawn Wolf")){
		if(plugin.wolf.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "You can't spawn new Wolves yet!");
			return;
		}
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Spawn Wolf")){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
		p.getWorld().spawnEntity(p.getLocation(),EntityType.WOLF);
		p.sendMessage("" + ChatColor.YELLOW + ChatColor.BOLD + "[Wolf] " + ChatColor.RESET + ChatColor.GREEN + "We have come to assist you! Tame us first!");
		plugin.wolf.add(p.getName());
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
                    plugin.wolf.remove(p.getName());
                    p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You can spawn Wolves again!");
            }
    }, 1000);
    return;
}
else {
    return;
}
}

		
		}
		}
	}
}
	}
