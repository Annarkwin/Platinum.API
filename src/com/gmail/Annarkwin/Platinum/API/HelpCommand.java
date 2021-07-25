package com.gmail.Annarkwin.Platinum.API;

import org.bukkit.command.CommandSender;

public interface HelpCommand
{

	public String[] getHelpEntries( CommandSender sender, PlatinumCommand command );

	public String getHelpString( PlatinumCommand command );

}
