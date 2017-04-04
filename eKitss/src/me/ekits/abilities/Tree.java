package me.ekits.abilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
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
	    	Location treeloc2 = new Location(treeloc.getWorld(), treeloc.getX(), treeloc.getY() + 1, treeloc.getZ());
	    	Location treeloc3 = new Location(treeloc.getWorld(), treeloc.getX(), treeloc.getY() + 2, treeloc.getZ());

	    	Bukkit.getServer().getWorld(rightclick.getWorld().getName()).getBlockAt(treeloc).setType(Material.LOG);
	    	Bukkit.getServer().getWorld(rightclick.getWorld().getName()).getBlockAt(treeloc2).setType(Material.LOG);
	    	Bukkit.getServer().getWorld(rightclick.getWorld().getName()).getBlockAt(treeloc3).setType(Material.LEAVES);
	    	plugin.rooted.add(rightclick.getName());
	    	Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
	            public void run() {
	            	Bukkit.getServer().getWorld(rightclick.getWorld().getName()).getBlockAt(treeloc).setType(Material.AIR);
	    	    	Bukkit.getServer().getWorld(rightclick.getWorld().getName()).getBlockAt(treeloc2).setType(Material.AIR);
	    	    	Bukkit.getServer().getWorld(rightclick.getWorld().getName()).getBlockAt(treeloc3).setType(Material.AIR);
	    	    	plugin.rooted.remove(rightclick.getName());
	            }
	    }, 300);

	    	//
	    	
	    p.sendMessage("" + ChatColor.GREEN + "You have Tree-ified " + ChatColor.GOLD  + ChatColor.BOLD + rightclick.getName());
        rightclick.sendMessage("" + ChatColor.GOLD + rightclick.getName() + ChatColor.GREEN + ChatColor.BOLD + ChatColor.UNDERLINE + " You have been Tree-ified");
		
		plugin.treecd.add(p.getName());
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
            public void run() {
                    plugin.treecd.remove(p.getName());
                    p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "You can Tree-ify again!");
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
	@EventHandler
	public void onMove(PlayerMoveEvent event){
		if(plugin.rooted.contains(event.getPlayer().getName())){
			event.setCancelled(true);
		}else{
			event.setCancelled(false);
		}
	}
	    }

