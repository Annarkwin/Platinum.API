package com.gmail.Annarkwin.Platinum.API;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public abstract class PlatinumMainCommand extends PlatinumCommand implements CommandExecutor
{

	public PlatinumMainCommand( String name, String permission, boolean player, String description, String usage )
	{

		super(name, permission, player, description, usage);
		// TODO Auto-generated constructor stub

	}

	@Override
	public boolean onCommand( CommandSender arg0, Command arg1, String arg2, String[] arg3 )
	{

		return run(arg0, this.name, arg3);

	}


}
