package com.gmail.Annarkwin.Platinum.API;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

public class TickerEvent extends Event {
	
	TickerEventType t;
	
	public TickerEvent(TickerEventType type){
		t = type;
	}
	
	public static enum TickerEventType{
		SCOREBOARD_UPDATE,
		QUARRY_FILL,
		PORTAL;
	}
	
	private static final HandlerList handlers = new HandlerList();
		
	public HandlerList getHandlers() {
	    return handlers;
	}

	public static HandlerList getHandlerList() {
	    return handlers;
	}
	
	public TickerEventType getType(){
		return t;
	}

	public static int startTicker(Plugin pl, Long period, final TickerEventType type){
        return Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(pl, new Runnable() {
            @Override
            public void run() {
                Bukkit.getServer().getPluginManager().callEvent(new TickerEvent(type));
            }
        }, 0L, period);
	}
}
