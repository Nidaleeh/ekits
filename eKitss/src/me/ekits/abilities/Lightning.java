package me.ekits.abilities;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import me.ekits.main.Main;

public class Lightning implements Listener{
	
	Main plugin;
	public Lightning(Main instance){
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Lightning Wand")){
		if(plugin.thor.contains(p.getName())){		
		p.sendMessage(ChatColor.RED + "You can't strike down Lightning yet!");
			return;
		}
		Block block = p.getTargetBlock((Set<Material>)null, 20);
		Location bl = block.getLocation();
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Lightning Wand")){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
		p.getWorld().strikeLightning(bl);
		plugin.thor.add(p.getName());
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
                    plugin.thor.remove(p.getName());
                    p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You can use your Lightning Wand again!");
            }
    }, 200);
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

