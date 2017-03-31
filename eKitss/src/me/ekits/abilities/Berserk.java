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

public class Berserk implements Listener{
	
	Main plugin;
	public Berserk(Main instance){
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Assassinate")){
		if(plugin.assassin2.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "You can't Assassinate yet!");
			return;
		}
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
		if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Assassinate")){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
		p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 40));
		p.sendMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "I feel immense power flowing through my body");
		plugin.assassin2.add(p.getName());
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
            		if(plugin.assassin.contains(p.getName())){
                    plugin.assassin2.remove(p.getName());
                    p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You can Assassinate again!");
            }
            }
    }, 600);
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
