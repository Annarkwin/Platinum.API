package com.gmail.Annarkwin.Platinum.API.Events;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityInteractEvent;

public class EntityTrampleEvent extends Event implements Cancellable
{

	private Block block;
	private Entity entity;
	private boolean cancelled = false;

	public EntityTrampleEvent( EntityInteractEvent event )
	{

		block = event.getBlock();
		entity = event.getEntity();

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

	public Entity getEntity()
	{

		return entity;

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
