package com.gmail.Annarkwin.Platinum.API;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public abstract class Crops {

	private static Map<Material,Material> seedmap;
	
	static {
		seedmap = new HashMap<Material,Material>();
		seedmap.put(Material.WHEAT,Material.WHEAT_SEEDS);
		seedmap.put(Material.BEETROOTS,Material.BEETROOT_SEEDS);
		seedmap.put(Material.CARROTS, Material.CARROT);
		seedmap.put(Material.POTATOES, Material.POTATO);
		seedmap.put(Material.MELON_STEM, Material.MELON_SEEDS);
		seedmap.put(Material.PUMPKIN_STEM, Material.PUMPKIN_SEEDS);
		seedmap.put(Material.COCOA, Material.COCOA_BEANS);
		seedmap.put(Material.NETHER_WART, Material.NETHER_WART);
	}
	
	public static boolean isCrop(Block b) {
		return (seedmap.containsKey(b.getType()));
	}
	
	public static ItemStack getSeed(Block b) {
		return new ItemStack(seedmap.get(b.getType()));
	}
}
