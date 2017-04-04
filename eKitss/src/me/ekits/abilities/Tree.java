package me.ekits.abilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.ekits.main.Main;

public class Tree implements Listener{
	Main plugin;
	public Tree(Main instance){
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
	    if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Tree Birth Giver")){
		if(plugin.treecd.contains(p.getName())){
			p.sendMessage(ChatColor.RED + "You can't tree-ify yet");
			return;
		}
		if(rightclick instanceof Player){
			if(p != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null){
	    if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Tree Birth Giver")){
	    //
	    	
	    	
	    	rightclick.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 255, true));
	    	Location treeloc = rightclick.getLocation();
	    	Bukkit.getServer()
	    	//
	    	
	    p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You have healed " + ChatColor.UNDERLINE + ChatColor.GOLD + rightclick.getName());
        rightclick.sendMessage("" + ChatColor.GOLD + rightclick.getName() + ChatColor.GREEN + ChatColor.BOLD + ChatColor.UNDERLINE + " You have been tree-ified");
		
		plugin.treecd.add(p.getName());
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
                    plugin.treecd.remove(p.getName());
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

