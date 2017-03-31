package me.ekits.abilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import me.ekits.main.Main;

public class Heal implements Listener{
	
	Main plugin;
	public Heal(Main instance){
		plugin = instance;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(PlayerInteractEntityEvent e){
	    if (e == null) return;
	    if(e.getRightClicked() == null && e.getPlayer() == null) return;
	    if(!(e.getRightClicked() instanceof Player && e.getPlayer() instanceof Player)) return;
		Player p = e.getPlayer();
		Player rightclick = (Player) e.getRightClicked();
		if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
	    if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Heal")){
		if(plugin.heal.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "You can't heal yet!");
			return;
		}
		if(rightclick instanceof Player){
			if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
	    if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Heal")){
	    rightclick.setHealth(20.0);
	    p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You have healed " + ChatColor.UNDERLINE + ChatColor.GOLD + rightclick.getName());
        rightclick.sendMessage("" + ChatColor.GOLD + rightclick.getName() + ChatColor.GREEN + ChatColor.BOLD + ChatColor.UNDERLINE + " You have been healed");
		
		plugin.heal.add(p.getName());
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
                    plugin.heal.remove(p.getName());
                    p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You can heal again!");
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

