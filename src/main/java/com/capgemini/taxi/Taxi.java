package com.capgemini.taxi;

public class Taxi {

	private int distX;
	private int distY;
	private boolean taken;
	
	public int getDistX() {
		return distX;
	}
	public void setDistX(int distX) {
		this.distX = distX;
	}
	public int getDistY() {
		return distY;
	}
	public void setDistY(int distY) {
		this.distY = distY;
	}
	public boolean isTaken() {
		return taken;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
}
