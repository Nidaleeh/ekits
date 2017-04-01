package me.ekits.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitPicker implements Listener {

	Main plugin;

	public KitPicker(Main instance) {
		this.plugin = instance;
	}

	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_AQUA
				+ "Kits!");
		ItemStack soldiersword = new ItemStack(Material.IRON_SWORD);
		ItemMeta soldiermeta = soldiersword.getItemMeta();
		ItemStack off = new ItemStack(Material.REDSTONE_LAMP_OFF);
		ItemMeta offm = off.getItemMeta();

		soldiermeta.setDisplayName(ChatColor.DARK_GRAY + "Soldier");
		List<String> lore = new ArrayList<String>();
		lore.add("" + ChatColor.GRAY + "Select the Soldier Class!");
		soldiermeta.setLore(lore);
		soldiersword.setItemMeta(soldiermeta);

		ItemStack a1 = new ItemStack(Material.BOW);
		ItemMeta am1 = a1.getItemMeta();
		am1.setDisplayName(ChatColor.DARK_GRAY + "Archer");
		List<String> lore1 = new ArrayList<String>();
		lore1.add("" + ChatColor.GRAY + "Select the Arcer Class!");
		am1.setLore(lore1);
		a1.setItemMeta(am1);
		
		

		offm.setDisplayName(ChatColor.RED + "Close");
		off.setItemMeta(offm);
		
		ItemStack TankChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta TankMeta = TankChest.getItemMeta();
		TankMeta.setDisplayName(ChatColor.DARK_GRAY + "Tank");
		List<String> TankLore = new ArrayList<String>();
		TankLore.add("" + ChatColor.GRAY + "Select the Tank Class!");
		TankMeta.setLore(TankLore);
		TankChest.setItemMeta(TankMeta);
		
		ItemStack MedicChest  = new ItemStack(Material.GOLD_CHESTPLATE);
		ItemMeta MedicMeta = MedicChest.getItemMeta();
		MedicMeta.setDisplayName(ChatColor.DARK_GRAY + "Medic");
		List<String> MedicLore = new ArrayList<String>();
		MedicLore.add("" + ChatColor.GRAY + "Select the Medic Class!");
		MedicMeta.setLore(MedicLore);
		MedicChest.setItemMeta(MedicMeta);
		
		

		inv.setItem(0, soldiersword);
		inv.setItem(1, a1);
		inv.setItem(2, TankChest);
		inv.setItem(3, MedicChest);
		inv.setItem(53, off);
		p.openInventory(inv);
	}

	@EventHandler
	public static void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked(); 
		
		if (p.getOpenInventory().equals("Kits!")) {
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getType().equals(Material.IRON_SWORD)) {
					p.chat("/soldier");
					p.closeInventory();
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getType().equals(Material.BOW)) {
					p.chat("/archer");
					p.closeInventory();
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getType()
						.equals(Material.REDSTONE_LAMP_OFF)) {
					p.closeInventory();
					e.setCancelled(true);
				}
				if(e.getCurrentItem().getType().equals(Material.DIAMOND_CHESTPLATE)){
					p.chat("/tank");
					p.closeInventory();
					e.setCancelled(true);
				}
				if(e.getCurrentItem().getType().equals(Material.GOLD_CHESTPLATE)){
					p.chat("/medic");
					p.closeInventory();
					e.setCancelled(true);
				}
			}

		}
	}

	@EventHandler
	public void onUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p != null && p.getItemInHand() != null
				&& p.getItemInHand().getItemMeta() != null
				&& p.getItemInHand().getItemMeta().getDisplayName() != null) {
			if (p.getInventory().getItemInHand().getItemMeta().getDisplayName()
					.contains("Pick a Kit!")) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR
						|| e.getAction() == Action.RIGHT_CLICK_BLOCK) {

					openGUI(p);
				}
			}
		}
	}
}