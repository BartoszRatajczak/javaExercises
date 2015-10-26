package com.capgemini.gameOfLife;

public class Cell {

	private int posX;
	private int posY;

	public Cell() {

	}

	public Cell(int x, int y) {
		posX = x;
		posY = y;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setPosition(int x, int y) {
		posX = x;
		posY = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + posX;
		result = prime * result + posY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (posX != other.posX)
			return false;
		if (posY != other.posY)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "x: " + posX + ", y:" + posY;
	}
}
