package me.ekits.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.ekits.main.Main;

public class Archer implements CommandExecutor{
	
	Main plugin;
	public Archer(Main instance){
		plugin = instance;
	}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	
	if (cmd.getName().equalsIgnoreCase("Archer") && sender instanceof Player) {  
         Player p = (Player) sender;    
        
         if(plugin.kitused.contains(p.getName())){
                 p.sendMessage(ChatColor.RED + "You have already used a kit this life!");
                 return true;
         }
         plugin.kitused.add(p.getName());
         p.getInventory().clear();
         // Sword
         ItemStack ninjasword = (new ItemStack(Material.STONE_SWORD));
         ItemMeta m = ninjasword.getItemMeta();
         m.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Archer's Sword");
         ninjasword.setItemMeta(m);
         ninjasword.addEnchantment(Enchantment.DURABILITY, 3);
         // Buff
         ItemStack redstone = (new ItemStack(Material.BOW));
         ItemMeta z = redstone.getItemMeta();
         z.setDisplayName("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Archer Bow");
         redstone.setItemMeta(z);
		 redstone.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		 redstone.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
		 redstone.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
         // Armor
		
         p.getInventory().addItem(ninjasword);
         p.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
         p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
         p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
         p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
         p.getInventory().addItem(new ItemStack(redstone));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
         p.getInventory().addItem(new ItemStack(Material.ARROW));
         p.setMaxHealth(20);
         p.setHealth(20);
         p.sendMessage(ChatColor.AQUA + "You were given the " + ChatColor.BOLD + ChatColor.GOLD + "Archer kit!");
 }
	return false;

}
}


