package com.gmail.Annarkwin.Platinum.API;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public abstract class InventoryManager {

	public static boolean isHolding(Player player, ItemStack item) {
		PlayerInventory i = player.getInventory();
		
		return (i.getItemInMainHand().isSimilar(item) || i.getItemInOffHand().isSimilar(item));
	}

	public static boolean isHolding(Player player, Material item) {
		PlayerInventory i = player.getInventory();
		
		return (i.getItemInMainHand().getType() == item || i.getItemInOffHand().getType() == item);
	}
	
	public static ItemStack getHeldItem(Player player, ItemStack item) {
		PlayerInventory i = player.getInventory();
		
		if (!isHolding(player, item)) return null;
		
		else if (i.getItemInMainHand().isSimilar(item))
			return i.getItemInMainHand();
		else 
			return i.getItemInOffHand();
	}
	
	public static boolean takeOne(Player player, Material material) {
		PlayerInventory inv = player.getInventory();
		int index = inv.first(material);
		
		if (index > -1) {
			ItemStack item = inv.getItem(index);
			item.setAmount(item.getAmount() - 1);
		
			inv.setItem(index, item);
			return true;
		}
		else return false;
	}
}
