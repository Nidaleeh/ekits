package me.ekits.kits;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.ekits.main.Main;

public class Druid implements CommandExecutor {

	Main plugin;

	public Druid(Main instance) {
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		// Soldier Kit
		if (cmd.getName().equalsIgnoreCase("druid")
				&& sender instanceof Player) {

			Player p = (Player) sender;
			if (plugin.kitused.contains(p.getName())) {
				p.sendMessage(ChatColor.RED
						+ "You have already used a kit this life!");
				return true;
			}
			plugin.kitused.add(p.getName());
			plugin.tree.add(p.getName());
			// add to ability
			ItemStack soldiersword = new ItemStack(Material.WOOD_SWORD);
			ItemMeta sm = soldiersword.getItemMeta();
			sm.setDisplayName("" + ChatColor.GOLD + "Druid Sword");
			soldiersword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
			soldiersword.addEnchantment(Enchantment.DURABILITY, 3);
			soldiersword.setItemMeta(sm);
			//wdaw
			ItemStack druids = new ItemStack(Material.STICK);
			ItemMeta dm = soldiersword.getItemMeta();
			dm.setDisplayName("" + ChatColor.GOLD + "Tree Birth Giver");
			druids.setItemMeta(dm);

			// Legs
			ItemStack llegs = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta lmeta = (LeatherArmorMeta) llegs.getItemMeta();
			lmeta.setColor(Color.LIME);
			lmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			llegs.setItemMeta(lmeta);
			// Boots
			ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bmeta = (LeatherArmorMeta) lboots.getItemMeta();
			bmeta.setColor(Color.GREEN);
			bmeta.addEnchant(Enchantment.DURABILITY, 3, true);
			lboots.setItemMeta(lmeta);

			p.getInventory().clear();
			p.setMaxHealth(20);
			p.setHealth(20);
			p.getInventory()
					.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
			p.getInventory().setChestplate(
					new ItemStack(Material.DIAMOND_CHESTPLATE));
			p.getInventory().setLeggings(llegs);
			p.getInventory().setBoots(lboots);
			p.getInventory().addItem(soldiersword);
			p.getInventory().addItem(druids);
			for (int i = 0; i < 35; i++) {
				p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
			p.sendMessage(ChatColor.GOLD + "You have obtained the"
					+ ChatColor.GREEN + " Druid " + ChatColor.GOLD + "kit!");
		}

		return false;
	}
}
