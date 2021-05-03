package com.gmail.Annarkwin.Platinum.API;

import org.bukkit.command.CommandSender;

public interface Subcommand {
	
	public void run(CommandSender sender, String[] args);

	public String getName();
	
	public String getPermission();
	
	public String getUsage();
	
	public String getDescription();
	
	public boolean isPlayerOnly();
	
	public MainCommand getMainCommand();
}
