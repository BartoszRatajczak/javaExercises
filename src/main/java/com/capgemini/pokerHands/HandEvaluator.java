package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.List;

public class HandEvaluator {
	Hand hand;
	String[] cards;
	int[] values;
	boolean isHandFlush;
	boolean isHandStraight;

	public Hand evaluateHand(String rawHand) {
		hand = new Hand();
		cards = rawHand.split(" ");
		values = new int[cards.length];

		obtainCards();
		countCardsOccurence();
		checkCardsColors();
		checkCardsInterval();

		checkPairs(hand);
		checkTwoPairs(hand);
		checkSet(hand);
		checkStraight(hand, isHandStraight);
		checkFlush(hand, isHandFlush);
		checkFullHouse(hand);
		checkFourOfAKind(hand);

		return hand;
	}
	
	private void obtainCards() {
		String cardName;
		for (int i = 0; i < cards.length; i++) {
			cardName = cards[i].substring(0, 1);
			values[i] = CardValue.getKeyOf(cardName);
		}
	}

	private void countCardsOccurence() {
		int key;
		for (int i = 0; i < values.length; i++) {
			key = values[i];
			if (hand.getCardDistribution().containsKey(key)) {
				hand.putCard(key, hand.getCardDistribution().get(key) + 1);
			} else {
				hand.putCard(key, 1);
			}
		}
	}

	private void checkCardsColors() {
		String color1, color2;
		isHandFlush = true;
		for (int i = 1; i < cards.length; i++) {
			color1 = cards[i - 1].substring(1, 2);
			color2 = cards[i].substring(1, 2);
			if (!color1.equals(color2)) {
				isHandFlush = false;
			}
		}
	}

	private void checkCardsInterval() {
		int value1, value2;
		isHandStraight = true;
		List<Integer> valuesList = new ArrayList<Integer>(hand.getCardDistribution().keySet());
		for (int i = 1; i < valuesList.size(); i++) {
			value1 = valuesList.get(i - 1);
			value2 = valuesList.get(i);
			if ((value2 - value1 != 1) && (value2 - value1 != 9)) {
				isHandStraight = false;
			}
		}
	}

	private void checkPairs(Hand hand) {
		if (hand.getCardDistribution().containsValue(2) && hand.getCardDistribution().size() == 4) {
			hand.setHandStrength(1);
		}
	}
	
	private void checkTwoPairs(Hand hand) {
		if (hand.getCardDistribution().containsValue(2) && hand.getCardDistribution().size() == 3) {
			hand.setHandStrength(2);
		}
	}
	
	private void checkSet(Hand hand) {
		if (hand.getCardDistribution().containsValue(3) && hand.getCardDistribution().size() == 3) {
			hand.setHandStrength(3);
		}
	}
	
	private void checkStraight(Hand hand, boolean isHandStraight) {
		if (isHandStraight) {
			hand.setHandStrength(hand.getHandStrength() + 4);
		}
	}
	
	private void checkFlush(Hand hand, boolean isHandFlush) {
		if (isHandFlush) {
			hand.setHandStrength(hand.getHandStrength() + 5);
		}
	}
	
	private void checkFullHouse(Hand hand) {
		if (hand.getCardDistribution().containsValue(3) && hand.getCardDistribution().containsValue(2)) {
			hand.setHandStrength(6);
		}
	}

	private void checkFourOfAKind(Hand hand) {
		if (hand.getCardDistribution().containsValue(4)) {
			hand.setHandStrength(7);
		}
	}
}
