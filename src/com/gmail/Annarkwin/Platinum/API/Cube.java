package com.gmail.Annarkwin.Platinum.API;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

@SerializableAs("Cube")
public class Cube implements ConfigurationSerializable
{

	private Location min;
	private Location max;

	public Cube( Location m, Location n )
	{

		this.min = new Location(m.getWorld(), Math.min(m.getX(), n.getX()), Math.min(m.getY(), n.getY()),
				Math.min(m.getZ(), n.getZ()));
		this.max = new Location(m.getWorld(), Math.max(m.getX(), n.getX()), Math.max(m.getY(), n.getY()),
				Math.max(m.getZ(), n.getZ()));

	}

	public Cube( Map<String, Object> o )
	{

		// Get fields of object and retrieve them from map
		for (Field f : this.getClass().getDeclaredFields())
		{

			try
			{

				f.set(this, o.get(f.getName()));

			}
			catch (Exception e)
			{

				e.printStackTrace();

			}

		}

	}

	@Override
	public Map<String, Object> serialize()
	{

		// Get fields of object and map them with value
		HashMap<String, Object> s = new HashMap<String, Object>();

		for (Field f : this.getClass().getDeclaredFields())
		{

			try
			{

				s.put(f.getName(), f.get(this));

			}
			catch (Exception e)
			{

				e.printStackTrace();

			}

		}

		return s;

	}

	public World getWorld()
	{

		return min.getWorld();

	}

	public Location getMinimumPoint()
	{

		return min;

	}

	public Location getMaximumPoint()
	{

		return max;

	}

	public Cube maximizeHeight()
	{

		min.setY(-2032);
		max.setY(4064);

		return this;

	}

	public boolean containsPoint( Location p )
	{

		if (p.getWorld() == getWorld())
		{

			if (p.getBlockX() >= min.getBlockX() && p.getBlockX() <= max.getBlockX())
			{

				if (p.getBlockY() >= min.getBlockY() && p.getBlockY() <= max.getBlockY())
				{

					if (p.getBlockZ() >= min.getBlockZ() && p.getBlockZ() <= max.getBlockZ())
						return true;

				}

			}

		}

		return false;

	}

	public boolean containsCube( Cube cube )
	{

		return this.containsPoint(cube.min) && this.containsPoint(cube.max);

	}

	public boolean intersectsCube( Cube cube )
	{

		boolean intersect = true;
		if (max.getBlockX() < cube.min.getBlockX())
			intersect = false;
		else if (cube.getMaximumPoint().getBlockX() < min.getBlockX())
			intersect = false;
		if (max.getBlockY() < cube.min.getBlockY())
			intersect = false;
		else if (cube.getMaximumPoint().getBlockY() < min.getBlockY())
			intersect = false;
		if (max.getBlockZ() < cube.min.getBlockZ())
			intersect = false;
		else if (cube.getMaximumPoint().getBlockZ() < min.getBlockZ())
			intersect = false;
		return intersect;

	}

	public HashSet<Block> getBlocks()
	{

		HashSet<Block> blocks = new HashSet<Block>();

		for (int x = min.getBlockX(); x <= max.getBlockX(); x++)
		{

			for (int y = min.getBlockY(); y <= max.getBlockY(); y++)
			{

				for (int z = min.getBlockZ(); z <= max.getBlockZ(); z++)
				{

					blocks.add(getWorld().getBlockAt(x, y, z));

				}

			}

		}

		return blocks;

	}

}
