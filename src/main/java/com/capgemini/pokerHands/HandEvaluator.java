package com.capgemini.pokerHands;

public class HandEvaluator {

	public static Hand evaluateHand(String rawHand) {
		Hand hand = new Hand();
		String[] cards = rawHand.split(" ");
		
		// transformCardNames();
		String cardName;
		int[] values = new int[cards.length];
		for (int i = 0; i < cards.length; i++) {
			cardName = cards[i].substring(0, 1);
			values[i] = CardValue.getKeyOf(cardName);
		}
		
		int key;
		for (int i = 0; i < values.length; i++) {
			key = values[i];
			if (hand.getCardDistribution().containsKey(key)) {
				hand.putCard(key, hand.getCardDistribution().get(key) + 1);
			} else {
				hand.putCard(key, 1);
			}
		}
				
		String color1, color2;
		boolean isHandFlush = true;
		for (int i=1; i<cards.length; i++) {
			color1 = cards[i-1].substring(1, 2);
			color2 = cards[i].substring(1, 2);
			if (!color1.equals(color2)) {
				isHandFlush = false;
			}
		}
		
		int value1, value2;
		boolean isHandStraight = true;
		for (int i=1; i<cards.length; i++) {
			value1 = hand.getValues()[i-1];
			value2 = hand.getValues()[i];
			if ((value2 - value1 != 1) && (value2 - value1 != 9)) {
				isHandStraight = false;
			}
		}

		if (hand.getCardDistribution().containsValue(2) && hand.getCardDistribution().size() == 4) {
			hand.setHandStrength(1);
		}

		if (hand.getCardDistribution().containsValue(2) && hand.getCardDistribution().size() == 3) {
			hand.setHandStrength(2);
		}

		if (hand.getCardDistribution().containsValue(3) && hand.getCardDistribution().size() == 3) {
			hand.setHandStrength(3);
		}

		if (hand.getCardDistribution().containsValue(3) && hand.getCardDistribution().containsValue(2)) {
			hand.setHandStrength(6);
		}

		if (hand.getCardDistribution().containsValue(4)) {
			hand.setHandStrength(7);
		}
		
		if (isHandFlush) {
			hand.setHandStrength(hand.getHandStrength()+5);
		}
		
		if (isHandStraight) {
			hand.setHandStrength(hand.getHandStrength()+4);
		}
		
		return hand;
	}
}
