package com.gmail.Annarkwin.Platinum.API;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;

public abstract class PlatinumCommand
{

	protected PlatinumCommand parent;
	protected ArrayList<PlatinumCommand> children = new ArrayList<PlatinumCommand>();
	protected String name; // Name to match on query for example : home OR 20 in /home 20
	protected String permission; // Exact permission to match for this command
	protected boolean playeronly; // Whether the sender has to be a player
	protected String description; // The line to register for this command in /help
	protected String usage; // If incorrect information is provided for this command, what error message to display

	public PlatinumCommand( String name, String permission, boolean player, String description, String usage )
	{

		this.name = name;
		this.permission = permission;
		this.playeronly = player;
		this.description = description;
		this.usage = usage;

	}

	public boolean nameMatch( String arg )
	{

		return name.equalsIgnoreCase(arg);

	}

	public boolean hasParent()
	{

		return parent != null;

	}

	public PlatinumCommand getParent()
	{

		return parent;

	}

	public void setParent( PlatinumCommand command )
	{

		parent = command;

	}

	public ArrayList<PlatinumCommand> getChildren()
	{

		return children;

	}

	public void addChildCommand( PlatinumCommand command )
	{

		command.setParent(this);
		children.add(command);

	}

	public boolean validSender( CommandSender sender )
	{

		return playeronly == false || (sender instanceof Player);

	}

	public boolean hasPermission( Permissible object )
	{

		return object.hasPermission(permission);

	}

	public String getName()
	{

		return name;

	}

	public String getPermissionHook()
	{

		return permission;

	}

	public boolean isPlayerOnly()
	{

		return playeronly;

	}

	public String getDescription()
	{

		return description;

	}

	public String getUsage()
	{

		return usage;

	}

	public PlatinumCommand getChild( String commandname )
	{

		for (PlatinumCommand subcommand : getChildren())
		{

			if (subcommand.getName().equalsIgnoreCase(commandname))
			{

				return subcommand;

			}

		}

		return null;

	}

	public abstract boolean run( CommandSender sender, String cmdname, String cmdargs[] );

}
