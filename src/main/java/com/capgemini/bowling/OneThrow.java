package com.capgemini.bowling;

public class OneThrow {

	private int ballThrow;
	private int multiplier;

	public OneThrow(int ballthrow, int multiplier) {
		this.ballThrow = ballthrow;
		this.multiplier = multiplier;
	}

	public int getBallThrow() {
		return ballThrow;
	}

	public void setBallThrow(int ballThrow) {
		this.ballThrow = ballThrow;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
}
