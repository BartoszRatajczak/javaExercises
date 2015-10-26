package com.capgemini.pokerHands;

import java.util.Map;
import java.util.TreeMap;

public class Hand {

	private Map<Integer, Integer> cardDistribution = new TreeMap<Integer, Integer>();
	private int handStrength;

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

	public void putCard(int key, int value) {
		cardDistribution.put(key, value);
	}
}
