package com.gmail.Annarkwin.Platinum.API;

public class Coordinate {
	private int x, y, z;
	
	public Coordinate (int ix, int iy, int iz) {
		x = ix;
		y = iy;
		z = iz;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
}
