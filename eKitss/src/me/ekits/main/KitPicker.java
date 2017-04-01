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
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.DARK_AQUA
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
		lore1.add("" + ChatColor.GRAY + "Select the Archer Class!");
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

		ItemStack MedicChest = new ItemStack(Material.GOLD_CHESTPLATE);
		ItemMeta MedicMeta = MedicChest.getItemMeta();
		MedicMeta.setDisplayName(ChatColor.DARK_GRAY + "Medic");
		List<String> MedicLore = new ArrayList<String>();
		MedicLore.add("" + ChatColor.GRAY + "Select the Medic Class!");
		MedicMeta.setLore(MedicLore);
		MedicChest.setItemMeta(MedicMeta);
		
		ItemStack AssassinLeash = new ItemStack(Material.LEASH);
		ItemMeta AssassinMeta = AssassinLeash.getItemMeta();
		AssassinMeta.setDisplayName(ChatColor.GREEN + "Assassin");
        List<String> AssassinLore = new ArrayList<String>();
        AssassinLore.add("" + ChatColor.GREEN + "Select the Assassin Class!");
        AssassinMeta.setLore(AssassinLore);
        AssassinLeash.setItemMeta(AssassinMeta);
        
        ItemStack NinjaCoal = new ItemStack(Material.COAL);
        ItemMeta NinjaMeta = NinjaCoal.getItemMeta();
        NinjaMeta.setDisplayName(ChatColor.GREEN + "Ninja");
        List<String> NinjaLore = new ArrayList<String>();
        NinjaLore.add("" + ChatColor.GREEN + "Select the Ninja Class!");
        NinjaMeta.setLore(NinjaLore);
        NinjaCoal.setItemMeta(NinjaMeta);
        
        ItemStack ViperEye = new ItemStack(Material.SPIDER_EYE);
        ItemMeta ViperMeta = ViperEye.getItemMeta();
        ViperMeta.setDisplayName(ChatColor.GREEN + "Viper");
        List<String> ViperLore = new ArrayList<String>();
        ViperLore.add("" + ChatColor.GREEN + "Select the Viper Class!");
        ViperMeta.setLore(ViperLore);
        ViperEye.setItemMeta(ViperMeta);
        
        ItemStack GhostPane = new ItemStack(Material.STAINED_GLASS_PANE);
        ItemMeta GhostMeta = GhostPane.getItemMeta();
        GhostMeta.setDisplayName(ChatColor.GREEN + "Ghost");
        List<String> GhostLore = new ArrayList<String>();
        GhostLore.add("" + ChatColor.GREEN + "Select the Ghost Class!");
        GhostMeta.setLore(GhostLore);
        GhostPane.setItemMeta(GhostMeta);
        
        ItemStack LavaBucket = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta LavaMeta = LavaBucket.getItemMeta();
        LavaMeta.setDisplayName(ChatColor.GREEN + "Lavahound");
        List<String> LavaLore = new ArrayList<String>();
        LavaLore.add("" + ChatColor.GREEN + "Select the Lava Class!");
        LavaMeta.setLore(LavaLore);
        LavaBucket.setItemMeta(LavaMeta);
        
        ItemStack LochnessBucket = new ItemStack(Material.WATER_BUCKET);
        ItemMeta LochnessMeta = LochnessBucket.getItemMeta();
        LochnessMeta.setDisplayName(ChatColor.GREEN + "Lochness");
        List<String> LochnessLore = new ArrayList<String>();
        LochnessLore.add("" + ChatColor.GREEN + "Select the Lochness Class!");
        LochnessMeta.setLore(LochnessLore);
        LochnessBucket.setItemMeta(LochnessMeta);
        
        ItemStack SpeedySugar = new ItemStack(Material.SUGAR);
        ItemMeta SugarMeta = SpeedySugar.getItemMeta();
        SugarMeta.setDisplayName(ChatColor.GREEN + "Speedy");
        List<String> SpeedyLore = new ArrayList<String>();
        SpeedyLore.add("" + ChatColor.GREEN + "Select the Speedy Class!");
        SugarMeta.setLore(SpeedyLore);
        SpeedySugar.setItemMeta(SugarMeta);
        
        
        
		inv.setItem(1, soldiersword);
		inv.setItem(3, a1);
		inv.setItem(5, TankChest);
		inv.setItem(7, MedicChest);
		inv.setItem(9 , AssassinLeash);
		inv.setItem(11, NinjaCoal);
		inv.setItem(13, ViperEye);
		inv.setItem(15, GhostPane);
		inv.setItem(17, LavaBucket);
		inv.setItem(19, LochnessBucket);
		inv.setItem(21, SpeedySugar);

		
		
		
		inv.setItem(44, off);
		p.openInventory(inv);
	}

	@EventHandler
	public static void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked(); // The player that clicked the
												// item
		if (p.getOpenInventory().equals("Kits!")) {
			e.setCancelled(true);
		}
		if (e.getCurrentItem() != null) {
			if (e.getCurrentItem().getType().equals(Material.IRON_SWORD)) {
				p.chat("/soldier");
				p.closeInventory();
			}
			if (e.getCurrentItem().getType().equals(Material.BOW)) {
				p.chat("/archer");
				p.closeInventory();
			}
			if (e.getCurrentItem().getType()
					.equals(Material.DIAMOND_CHESTPLATE)) {
				p.chat("/tank");
				p.closeInventory();
			}
			if (e.getCurrentItem().getType().equals(Material.GOLD_CHESTPLATE)) {
				p.chat("/medic");
				p.closeInventory();
			}
			if (e.getCurrentItem().getType().equals(Material.REDSTONE_LAMP_OFF)) {
				p.closeInventory();
			}
			return;
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