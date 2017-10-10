package com.xnuminousx.elementaleffects.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUICommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		String title = ChatColor.DARK_PURPLE + "" + "" + ChatColor.UNDERLINE + "" + ChatColor.BOLD + "ElementalEffects";
		
		if (lable.equalsIgnoreCase("elementaleffects") || lable.equalsIgnoreCase("ee") || lable.equalsIgnoreCase("e")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.DARK_AQUA + "--= " + title + ChatColor.DARK_AQUA + " =--");
				sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "/ee");
				sender.sendMessage(" " + ChatColor.GRAY + "Alias: " + ChatColor.ITALIC + "/elementaleffects");
				sender.sendMessage(" " + ChatColor.YELLOW + "- Shows list of commands");
				
				sender.sendMessage("");
				
				sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "/ee trails");
				sender.sendMessage(" " + ChatColor.GRAY + "Alias: " + ChatColor.ITALIC + "/ee effects");
				sender.sendMessage(" " + ChatColor.YELLOW + "- Opens the trail GUI.");
				return true;
			} else if (args.length == 1) {
				if (sender instanceof Player) {
					Player p = (Player)sender;
					if (args[0].equalsIgnoreCase("trails") || args[0].equalsIgnoreCase("effects")) {
						gui(p);
						return true;
					}
				} else {
					sender.sendMessage("You're not a player!");
					return false;
				}
			}
			return false;
		}
		return false;
	}
	
	public void gui(Player p) {
		Inventory inv = Bukkit.createInventory(p, 45, "ElementalEffects");
		
		ItemStack earthItem = new ItemStack(Material.GRASS);
		ItemStack waterItem = new ItemStack(Material.WATER_BUCKET);
		ItemStack fireItem = new ItemStack(Material.BLAZE_POWDER);
		ItemStack airItem = new ItemStack(Material.STRING);
		ItemStack chiItem = new ItemStack(Material.LEASH);
		ItemStack avatarItem = new ItemStack(Material.NETHER_STAR);
		
		ItemMeta earthMeta = earthItem.getItemMeta();
		ItemMeta waterMeta = waterItem.getItemMeta();
		ItemMeta fireMeta = fireItem.getItemMeta();
		ItemMeta airMeta = airItem.getItemMeta();
		ItemMeta chiMeta = chiItem.getItemMeta();
		ItemMeta avatarMeta = avatarItem.getItemMeta();
		
		earthMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "EarthTrail");
		waterMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "WaterTrail");
		fireMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "FireTrail");
		airMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "AirTrail");
		chiMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "ChiTrail");
		avatarMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "AvatarTrail");
		
		earthItem.setItemMeta(earthMeta);
		waterItem.setItemMeta(waterMeta);
		fireItem.setItemMeta(fireMeta);
		airItem.setItemMeta(airMeta);
		chiItem.setItemMeta(chiMeta);
		avatarItem.setItemMeta(avatarMeta);
		
		inv.setItem(10, earthItem);
		inv.setItem(12, waterItem);
		inv.setItem(14, fireItem);
		inv.setItem(16, airItem);
		inv.setItem(30, chiItem);
		inv.setItem(32, avatarItem);
		
		p.openInventory(inv);
	}

}
