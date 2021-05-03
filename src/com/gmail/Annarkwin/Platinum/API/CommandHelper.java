package com.gmail.Annarkwin.Platinum.API;

import java.util.Arrays;

import org.bukkit.command.CommandSender;

public abstract class CommandHelper {
	
	private static final int items_per_page = 9;
	
	public static void sendHelp(CommandSender sender, String[] entries, String helpname, int pagenum) {
				String[] page = CommandHelper.getHelpPage(entries, pagenum);
				sender.sendMessage("§2" + helpname + " Help (page " + pagenum + " of "+ CommandHelper.getPageCount(entries) + ")");
				sender.sendMessage(page);
	}
	
	private static int getPageCount(String[] entries) {
		return (entries.length % items_per_page == 0) ? (entries.length/items_per_page) : (entries.length/items_per_page + 1);
	}
	
	private static String[] getHelpPage(String[] entries, int pageNumber) {
		if (entries.length != 0) {
			if (pageNumber < getPageCount(entries)) {
				String[] page = Arrays.copyOfRange(entries, (pageNumber - 1) * items_per_page, pageNumber * items_per_page);
				return page;
			} else if (pageNumber == getPageCount(entries)) {
				String[] page = Arrays.copyOfRange(entries, (pageNumber - 1) * items_per_page, entries.length);
				return page;
			}
		} 
		return new String[0];
	}

	public static boolean isPositiveInt(String s) {
		try {
			int x = Integer.parseInt(s);
			return (x > 0) ? true:false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isPositiveDouble(String s) {
		try {
			double x = Double.parseDouble(s);
			return (x > 0) ? true:false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static double getDouble(String s) {
		return Double.parseDouble(s);
	}

	public static int getInt(String s) {
		return Integer.parseInt(s);
	}
}
