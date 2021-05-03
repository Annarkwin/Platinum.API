package com.gmail.Annarkwin.Platinum.API.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerLeftClickAirEvent extends Event implements Cancellable {

	private Player player;
	private boolean cancelled = false;
	
	public PlayerLeftClickAirEvent(PlayerInteractEvent event) {
		player = event.getPlayer();
	}
	
	private static final HandlerList handlers = new HandlerList();
		
	public HandlerList getHandlers() {
	    return handlers;
	}

	public static HandlerList getHandlerList() {
	    return handlers;
	}
	
	public Player getPlayer() {
		return player;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		cancelled = cancel;		
	}

}
