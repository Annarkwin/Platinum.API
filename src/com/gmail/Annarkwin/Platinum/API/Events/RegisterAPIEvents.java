package com.gmail.Annarkwin.Platinum.API.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.Annarkwin.Platinum.API.Crops;

public class RegisterAPIEvents implements Listener
{

	@EventHandler(priority = EventPriority.LOWEST)
	public void newEvent( PlayerInteractEvent e )
	{

		Event event = e;

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
		{

			event = new PlayerRightClickBlockEvent(e);
			Bukkit.getServer().getPluginManager().callEvent(event);

		}

		else if (e.getAction() == Action.RIGHT_CLICK_AIR)
		{

			event = new PlayerRightClickAirEvent(e);
			Bukkit.getServer().getPluginManager().callEvent(event);

		}

		else if (e.getAction() == Action.LEFT_CLICK_BLOCK)
		{

			event = new PlayerLeftClickBlockEvent(e);
			Bukkit.getServer().getPluginManager().callEvent(event);

		}

		else if (e.getAction() == Action.LEFT_CLICK_AIR)
		{

			event = new PlayerLeftClickAirEvent(e);
			Bukkit.getServer().getPluginManager().callEvent(event);

		}

		else if (e.getAction() == Action.PHYSICAL)
		{

			if (e.getClickedBlock().getType() == Material.FARMLAND)
			{

				event = new PlayerTrampleEvent(e);
				Bukkit.getServer().getPluginManager().callEvent(event);

			}
			else
			{

				event = new PlayerBlockStepEvent(e);
				Bukkit.getServer().getPluginManager().callEvent(event);

			}

		}

		if (((Cancellable) event).isCancelled())
			e.setCancelled(true);

	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void newEvent( EntityInteractEvent e )
	{

		Event event = e;

		if (e.getEntityType() != EntityType.PLAYER && e.getEntityType() != EntityType.VILLAGER
				&& e.getBlock().getType() == Material.FARMLAND)
		{

			event = new EntityTrampleEvent(e);
			Bukkit.getServer().getPluginManager().callEvent(event);

		}

		if (((Cancellable) event).isCancelled())
			e.setCancelled(true);

	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void newEvent( BlockBreakEvent e )
	{

		Event event = e;

		if (Crops.isCrop(e.getBlock()))
		{

			event = new PlayerHarvestEvent(e);
			Bukkit.getServer().getPluginManager().callEvent(event);

		}

		else
		{

			event = new PlayerMineEvent(e);
			Bukkit.getServer().getPluginManager().callEvent(event);

		}

		if (((Cancellable) event).isCancelled())
			e.setCancelled(true);

	}

}
