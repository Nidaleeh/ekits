package me.ekits.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.ekits.main.Main;

public class PlayerListeners implements Listener {

	Main plugin;

	public PlayerListeners(Main instance) {
		this.plugin = instance;
	}

	// When player joins the server
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String pname = p.getName();
		p.setHealth(0.0);
		p.getInventory().clear();
		Bukkit.broadcastMessage("" + ChatColor.AQUA + ChatColor.BOLD + pname
				+ ChatColor.RESET + ChatColor.GOLD + " has joined the server!");
		//
		ItemStack Ninjasword = new ItemStack(Material.PAPER);
		ItemMeta sm = Ninjasword.getItemMeta();
		sm.setDisplayName("" + ChatColor.GOLD + "Pick a Kit!");
		Ninjasword.setItemMeta(sm);
		//
		if (!(p.getInventory().contains(Ninjasword))) {
			p.getInventory().clear();
			p.getInventory().setHeldItemSlot(0);
			p.getInventory().setItem(0, Ninjasword);
			//
		}
	}

	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		e.setFoodLevel(20);

	}

	public void removeArrows(Player p) {
		((CraftPlayer) p).getHandle().getDataWatcher().watch(9, (byte) 0);

	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		String pname = p.getName();
		removeArrows(p);
		if (p.getKiller() == null) {
			e.setDeathMessage("" + ChatColor.GREEN + pname + ChatColor.AQUA
					+ " has " + ChatColor.DARK_RED + ChatColor.BOLD + "DIED");
		} else {
			e.setDeathMessage("" + ChatColor.GREEN + pname + ChatColor.AQUA
					+ " was killed by " + ChatColor.RED
					+ p.getKiller().getName());
		}
		e.getDrops().clear();
		plugin.kitused.remove(p.getName());
		plugin.assassin2.remove(p.getName());
		plugin.assassin.remove(p.getName());
		plugin.thor.remove(p.getName());
		plugin.ender.remove(p.getName());
		plugin.ninja.remove(p.getName());
		plugin.ninja2.remove(p.getName());
		plugin.heal.remove(p.getName());
		plugin.wolf.remove(p.getName());
		plugin.chameleon.remove(p.getName());
		plugin.water.remove(p.getName());
		plugin.lava.remove(p.getName());
		plugin.viper.remove(p.getName());
		plugin.rteleport.remove(p.getName());
		plugin.djump.remove(p.getName());
		plugin.switcher.remove(p.getName());
		plugin.regen.remove(p.getName());
		plugin.phantom.remove(p.getName());
		plugin.hit.remove(p.getName());
		plugin.tamedwolf.remove(p.getName());
		plugin.psycho.remove(p.getName());
		plugin.bobross.remove(p.getName());
		plugin.bobrosscd.remove(p.getName());
		plugin.rooted.remove(p.getName());
		plugin.tree.remove(p.getName());
		plugin.treecd.remove(p.getName());
	}

	@EventHandler
	public void onSpawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		p.sendMessage("" + ChatColor.GOLD + "Choose a kit to fight!");
		//
		ItemStack Ninjasword = new ItemStack(Material.PAPER);
		ItemMeta sm = Ninjasword.getItemMeta();
		sm.setDisplayName("" + ChatColor.GOLD + "Pick a Kit!");
		Ninjasword.setItemMeta(sm);
		//
		if (!(p.getInventory().contains(Ninjasword))) {
			p.getInventory().addItem(Ninjasword);
		}
	}

	@EventHandler
	public void onEat(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p != null && p.getItemInHand() != null
				&& p.getItemInHand().getItemMeta() != null
				&& p.getItemInHand().getItemMeta().getDisplayName() != null) {
			if (p.getInventory().getItemInHand().getType()
					.equals(Material.MUSHROOM_SOUP)) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR
						|| e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					p.setHealth(p.getHealth() + 7);
					p.setItemInHand(new ItemStack(Material.BOWL));

				}
			}
		}
	}

	@EventHandler
	public void onBlockIgnite(BlockIgniteEvent event) {
		if (event.getCause() == IgniteCause.LIGHTNING) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		e.getItemDrop().remove();
		if (!(e.getItemDrop().getItemStack().getType() == (Material.BOWL))) {
			e.getPlayer()
					.sendMessage(
							"" + ChatColor.RED + ChatColor.BOLD + "Sorry,"
									+ ChatColor.GOLD + ChatColor.ITALIC
									+ " but you " + ChatColor.YELLOW
									+ ChatColor.UNDERLINE + "can't"
									+ ChatColor.GOLD + ChatColor.ITALIC
									+ " drop this.");
			e.setCancelled(true);
		}
	}
}
