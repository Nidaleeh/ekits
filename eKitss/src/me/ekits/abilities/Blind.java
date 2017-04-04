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

public class Blind implements Listener{
	Main plugin;
	public Blind(Main instance){
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Bob's Paintbrush")){
		if(plugin.bobrosscd.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "You have no paint left!");
			return;
		}
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Bob's Paintbrush")){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
		for(Player radiusplayer : Bukkit.getServer().getOnlinePlayers()){
			if(radiusplayer.getLocation().getX() - p.getLocation().getX() < 5 || radiusplayer.getLocation().getY() - p.getLocation().getY() < 5){
				if(!radiusplayer.getName().equals(p.getName())){
					radiusplayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1, true));
					radiusplayer.sendMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "You have been blinded!");
					p.sendMessage("" + ChatColor.YELLOW + ChatColor.BOLD + "Blinded " + radiusplayer.getName());
				}else{
					p.sendMessage("" + ChatColor.AQUA + "Missed!");
									
				}
			}
		}
		plugin.bobrosscd.add(p.getName());
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
                    plugin.bobrosscd.remove(p.getName());
                    p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You regained your paint back to blind enemies!");
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
