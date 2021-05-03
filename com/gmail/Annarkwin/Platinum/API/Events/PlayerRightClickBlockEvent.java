package com.gmail.Annarkwin.Platinum.API.Events;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerRightClickBlockEvent extends Event implements Cancellable {

	private Block block;
	private BlockFace face;
	private Player player;
	private ItemStack item;
	private boolean cancelled = false;
	
	public PlayerRightClickBlockEvent(PlayerInteractEvent event) {
		block = event.getClickedBlock();
		face = event.getBlockFace();
		player = event.getPlayer();
		item = event.getItem();
	}
	
	private static final HandlerList handlers = new HandlerList();
		
	public HandlerList getHandlers() {
	    return handlers;
	}

	public static HandlerList getHandlerList() {
	    return handlers;
	}
	
	public BlockFace getBlockFace() {
		return face;
	}
	
	public Block getBlock() {
		return block;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean hasItem() {
		return (item != null);
	}
	
	public ItemStack getItem() {
		return item;
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
