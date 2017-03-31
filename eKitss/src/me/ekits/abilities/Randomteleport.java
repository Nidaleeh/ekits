package me.ekits.abilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.ekits.main.Main;

public class Randomteleport implements Listener{
	Main plugin;
	public Randomteleport(Main instance){
		plugin = instance;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Random Teleport")){
		if(plugin.rteleport.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "You can't teleport yet!");
			return;
		}
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Random Teleport")){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
		p.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Teleported!");
		plugin.rteleport.add(p.getName());
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
                    plugin.rteleport.remove(p.getName());
                    p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You can randomly teleport again!");
            }
    }, 500);
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
