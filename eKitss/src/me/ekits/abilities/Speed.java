package me.ekits.abilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Speed implements Listener{
	Main plugin;
	public Speed(Main instance){
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Speed boost")){
		if(plugin.assassin.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "You are still exhausted!");
			return;
		}
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Speed boost")){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 2));
		plugin.assassin.add(p.getName());
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
                    plugin.assassin.remove(p.getName());
                    p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You can sprint again!");
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
