package com.capgemini.pokerHands;

import java.util.Map;
import java.util.TreeMap;

public class Hand {

	private int[] values = new int[5];
	private Map<Integer, Integer> cardDistribution = new TreeMap<Integer, Integer>();
	private int handStrength;

	public int[] getValues() {
		return values;
	}

	public void setValues(int[] values) {
		this.values = values;
	}

	public Map<Integer, Integer> getCardDistribution() {
		return cardDistribution;
	}

	public void setCardDistribution(Map<Integer, Integer> cardDistribution) {
		this.cardDistribution = cardDistribution;
	}

	public int getHandStrength() {
		return handStrength;
	}

	public void setHandStrength(int handStrength) {
		this.handStrength = handStrength;
	}

	public void setValue(int value, int pos) {
		values[pos] = value;
	}
	
	public void putCard(int key, int value) {
		cardDistribution.put(key, value);
	}

	@Override
	public String toString() {
		return values[0] + " " + values[1] + " " + values[2] + " " + values[3] + " " + values[4];
	}
}
