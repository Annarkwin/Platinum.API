package com.gmail.Annarkwin.Platinum.API;

import org.bukkit.entity.Player;

public abstract class ExperienceManager
{

	// Get total experience player has based on leveling formulas
	public static int getTotalExperience( Player p )
	{

		int level = p.getLevel();
		int exp = (int) (p.getExp() * p.getExpToLevel());
		if (level <= 16)
			return level * level + 6 * level + exp;
		else if (level <= 31)
			return (int) (2.5 * level * level - 40.5 * level + 360) + exp;
		else
			return (int) (4.5 * level * level - 162.5 * level + 2220) + exp;

	}

}
