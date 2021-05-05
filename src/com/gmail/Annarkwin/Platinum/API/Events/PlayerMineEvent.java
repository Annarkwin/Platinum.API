package com.gmail.Annarkwin.Platinum.API.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerMineEvent extends Event implements Cancellable
{

	// TODO get adjusted drops with enchants - allow to set drops

	private Block block;
	private Material type;
	private Player player;
	private boolean cancelled = false;

	public PlayerMineEvent( BlockBreakEvent event )
	{

		block = event.getBlock();
		type = block.getType();
		player = event.getPlayer();

	}

	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers()
	{

		return handlers;

	}

	public static HandlerList getHandlerList()
	{

		return handlers;

	}

	public Block getBlock()
	{

		return block;

	}

	public Material getBlockType()
	{

		return type;

	}

	public Player getPlayer()
	{

		return player;

	}

	@Override
	public boolean isCancelled()
	{

		return cancelled;

	}

	@Override
	public void setCancelled( boolean cancel )
	{

		cancelled = cancel;

	}

}
