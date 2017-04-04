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
		AssassinLore.add("" + ChatColor.GRAY + "Select the Assassin Class!");
		AssassinMeta.setLore(AssassinLore);
		AssassinLeash.setItemMeta(AssassinMeta);

		ItemStack NinjaCoal = new ItemStack(Material.COAL);
		ItemMeta NinjaMeta = NinjaCoal.getItemMeta();
		NinjaMeta.setDisplayName(ChatColor.GREEN + "Ninja");
		List<String> NinjaLore = new ArrayList<String>();
		NinjaLore.add("" + ChatColor.GRAY + "Select the Ninja Class!");
		NinjaMeta.setLore(NinjaLore);
		NinjaCoal.setItemMeta(NinjaMeta);

		ItemStack ViperEye = new ItemStack(Material.SPIDER_EYE);
		ItemMeta ViperMeta = ViperEye.getItemMeta();
		ViperMeta.setDisplayName(ChatColor.GREEN + "Viper");
		List<String> ViperLore = new ArrayList<String>();
		ViperLore.add("" + ChatColor.GRAY + "Select the Viper Class!");
		ViperMeta.setLore(ViperLore);
		ViperEye.setItemMeta(ViperMeta);

		ItemStack GhostPane = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta GhostMeta = GhostPane.getItemMeta();
		GhostMeta.setDisplayName(ChatColor.GREEN + "Ghost");
		List<String> GhostLore = new ArrayList<String>();
		GhostLore.add("" + ChatColor.GRAY + "Select the Ghost Class!");
		GhostMeta.setLore(GhostLore);
		GhostPane.setItemMeta(GhostMeta);

		ItemStack LavaBucket = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta LavaMeta = LavaBucket.getItemMeta();
		LavaMeta.setDisplayName(ChatColor.GREEN + "Lavahound");
		List<String> LavaLore = new ArrayList<String>();
		LavaLore.add("" + ChatColor.GRAY + "Select the Lavahound Class!");
		LavaMeta.setLore(LavaLore);
		LavaBucket.setItemMeta(LavaMeta);

		ItemStack LochnessBucket = new ItemStack(Material.WATER_BUCKET);
		ItemMeta LochnessMeta = LochnessBucket.getItemMeta();
		LochnessMeta.setDisplayName(ChatColor.GREEN + "Lochness");
		List<String> LochnessLore = new ArrayList<String>();
		LochnessLore.add("" + ChatColor.GRAY + "Select the Lochness Class!");
		LochnessMeta.setLore(LochnessLore);
		LochnessBucket.setItemMeta(LochnessMeta);

		ItemStack SpeedySugar = new ItemStack(Material.SUGAR);
		ItemMeta SugarMeta = SpeedySugar.getItemMeta();
		SugarMeta.setDisplayName(ChatColor.GREEN + "Speedy");
		List<String> SpeedyLore = new ArrayList<String>();
		SpeedyLore.add("" + ChatColor.GRAY + "Select the Speedy Class!");
		SugarMeta.setLore(SpeedyLore);
		SpeedySugar.setItemMeta(SugarMeta);
		
		ItemStack FishingRod = new ItemStack(Material.FISHING_ROD);
		ItemMeta FishingMeta = FishingRod.getItemMeta();
		FishingMeta.setDisplayName(ChatColor.GOLD + "Fisherman");
		List<String> FishingLore = new ArrayList<String>();
		FishingLore.add("" + ChatColor.GRAY + "Select the Fishing Class!");
		FishingMeta.setLore(FishingLore);
		FishingRod.setItemMeta(FishingMeta);
		
		ItemStack Chameleon = new ItemStack(Material.GRASS);
		ItemMeta ChameleonMeta = Chameleon.getItemMeta();
		ChameleonMeta.setDisplayName(ChatColor.GOLD + "Chameleon");
		List<String> ChameleonLore = new ArrayList<String>();
		ChameleonLore.add("" + ChatColor.GRAY + "Select the Chameleon Class!");
		ChameleonMeta.setLore(ChameleonLore);
		Chameleon.setItemMeta(ChameleonMeta);
		
		ItemStack Ender = new ItemStack(Material.ENDER_PEARL);
		ItemMeta EnderMeta = Ender.getItemMeta();
		EnderMeta.setDisplayName(ChatColor.GOLD + "Ender");
		List<String> EnderLore = new ArrayList<String>();
		EnderLore.add("" + ChatColor.GRAY + "Select the Ender Class!");
		EnderMeta.setLore(EnderLore);
		Ender.setItemMeta(EnderMeta);
		
		ItemStack Phantom = new ItemStack(Material.FEATHER);
		ItemMeta PhantomMeta = Phantom.getItemMeta();
		PhantomMeta.setDisplayName(ChatColor.GOLD + "Phantom");
		List<String> PhantomLore = new ArrayList<String>();
		PhantomLore.add("" + ChatColor.GRAY + "Select the Phantom Class!");
		PhantomMeta.setLore(PhantomLore);
		Phantom.setItemMeta(PhantomMeta);
		
		ItemStack Switcher = new ItemStack(Material.SNOW_BALL);
		ItemMeta SwitcherMeta = Switcher.getItemMeta();
		SwitcherMeta.setDisplayName(ChatColor.GOLD + "Switcher");
		List<String> SwitcherLore = new ArrayList<String>();
		SwitcherLore.add("" + ChatColor.GRAY + "Select the Switcher Class!");
		SwitcherMeta.setLore(SwitcherLore);
		Switcher.setItemMeta(SwitcherMeta);

		ItemStack FlintPyro = new ItemStack(Material.FLINT_AND_STEEL);
		ItemMeta PyroMeta = FlintPyro.getItemMeta();
		PyroMeta.setDisplayName(ChatColor.GOLD + "Pyro");
		List<String> PyroLore = new ArrayList<String>();
		PyroLore.add("" + ChatColor.GRAY + "Select the Pyro Class!");
		PyroMeta.setLore(PyroLore);
		FlintPyro.setItemMeta(PyroMeta);
		
		ItemStack Psycho = new ItemStack(Material.SHEARS);
		ItemMeta PsychoMeta = Psycho.getItemMeta();
		PsychoMeta.setDisplayName(ChatColor.GOLD + "Psycho");
		List<String> PsychoLore = new ArrayList<String>();
		PsychoLore.add("" + ChatColor.GRAY + "Select the Psycho Class!");
		PsychoLore.add("" + ChatColor.GREEN + "NEW!");
		PsychoMeta.setLore(PsychoLore);
		Psycho.setItemMeta(PsychoMeta);
		
		ItemStack Bob = new ItemStack(Material.IRON_HOE);
		ItemMeta BobMeta = Bob.getItemMeta();
		BobMeta.setDisplayName(ChatColor.GOLD + "Bob Ross");
		List<String> BobLore = new ArrayList<String>();
		BobLore.add("" + ChatColor.GRAY + "Select the Bob Ross Class!");
		BobLore.add("" + ChatColor.GREEN + "NEW!");
		BobMeta.setLore(BobLore);
		Bob.setItemMeta(BobMeta);
		
		

		inv.setItem(1, soldiersword);
		inv.setItem(3, a1);
		inv.setItem(5, TankChest);
		inv.setItem(7, MedicChest);
		inv.setItem(9, AssassinLeash);
		inv.setItem(11, NinjaCoal);
		inv.setItem(13, ViperEye);
		inv.setItem(15, GhostPane);
		inv.setItem(17, LavaBucket);
		inv.setItem(19, LochnessBucket);
		inv.setItem(21, SpeedySugar);
		inv.setItem(23, FishingRod);
		inv.setItem(25, Chameleon);
		inv.setItem(27, Ender);
		inv.setItem(29, Phantom);
		inv.setItem(31, Switcher);
		inv.setItem(33, FlintPyro);
		inv.setItem(34, Psycho);
		inv.setItem(35, Bob);
		
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
			if (e.getCurrentItem().getType().equals(Material.LEASH)) {

				p.chat("/assassin");
				p.closeInventory();

			}

			if (e.getCurrentItem().getType().equals(Material.COAL)) {

				p.chat("/ninja");
				p.closeInventory();

			}
			if (e.getCurrentItem().getType().equals(Material.SPIDER_EYE)) {

				p.chat("/viper");
				p.closeInventory();

			}
			if (e.getCurrentItem().getType()
					.equals(Material.STAINED_GLASS_PANE)) {

				p.chat("/ghost");
				p.closeInventory();

			}
			if (e.getCurrentItem().getType().equals(Material.WATER_BUCKET)) {

				p.chat("/lochness");
				p.closeInventory();

			}
			if (e.getCurrentItem().getType().equals(Material.LAVA_BUCKET)) {

				p.chat("/lavahound");
				p.closeInventory();

			}
			if (e.getCurrentItem().getType().equals(Material.SUGAR)) {

				p.chat("/speedy");
				p.closeInventory();

			}
			if (e.getCurrentItem().getType().equals(Material.FLINT_AND_STEEL)) {

				p.chat("/pyro");
				p.closeInventory();

			}
			if (e.getCurrentItem().getType().equals(Material.SHEARS)) {

				p.chat("/psycho");
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