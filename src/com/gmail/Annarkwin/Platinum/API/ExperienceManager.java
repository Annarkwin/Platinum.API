package com.gmail.Annarkwin.Platinum.API;

public abstract class ExperienceManager
{

	public static int getTotalExp( int level, float barpercent, int next )
	{

		return getLevelExp(level) + getBarExp(barpercent, next);

	}

	public static int getLevelExp( int level )
	{

		if (level <= 16)
		{

			return (level * level + 6 * level);

		}
		else if (level >= 17 && level <= 31)
		{

			return (int) (2.5 * level * level - 40.5 * level + 360);

		}
		else
			return (int) (4.5 * level * level - 162.5 * level + 2220);

	}

	public static int getBarExp( float barpercent, int next )
	{

		return (int) barpercent * next;

	}

}
