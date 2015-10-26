package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HandComparator {

	public int compareHands(Hand firstHand, Hand secondHand) {
		int result = 0;

		if (firstHand.getHandStrength() > secondHand.getHandStrength()) {
			return 1;
		} else if (firstHand.getHandStrength() < secondHand.getHandStrength()) {
			return 2;
		} else {
			List<CardOccurence> firstOccuList = new ArrayList<CardOccurence>();
			List<CardOccurence> secondOccuList = new ArrayList<CardOccurence>();

			for (Map.Entry<Integer, Integer> hand : firstHand.getCardDistribution().entrySet()) {
				firstOccuList.add(new CardOccurence(hand.getKey(), hand.getValue()));
			}

			for (Map.Entry<Integer, Integer> hand : secondHand.getCardDistribution().entrySet()) {
				secondOccuList.add(new CardOccurence(hand.getKey(), hand.getValue()));
			}

			CardOccurence singleCard = new CardOccurence();
			for (int i = 1; i < firstOccuList.size(); i++) {
				if (firstOccuList.get(i).getOccurence() > firstOccuList.get(i - 1).getOccurence()) {
					singleCard.setCard(firstOccuList.get(i - 1).getCard());
					singleCard.setOccurence(firstOccuList.get(i - 1).getOccurence());
					firstOccuList.get(i - 1).setCard(firstOccuList.get(i).getCard());
					firstOccuList.get(i - 1).setOccurence(firstOccuList.get(i).getOccurence());
					firstOccuList.get(i).setCard(singleCard.getCard());
					firstOccuList.get(i).setOccurence(singleCard.getOccurence());
				}
				if (secondOccuList.get(i).getOccurence() > secondOccuList.get(i - 1).getOccurence()) {
					singleCard.setCard(secondOccuList.get(i - 1).getCard());
					singleCard.setOccurence(secondOccuList.get(i - 1).getOccurence());
					secondOccuList.get(i - 1).setCard(secondOccuList.get(i).getCard());
					secondOccuList.get(i - 1).setOccurence(secondOccuList.get(i).getOccurence());
					secondOccuList.get(i).setCard(singleCard.getCard());
					secondOccuList.get(i).setOccurence(singleCard.getOccurence());
				}
			}

			for (int i = firstOccuList.size() - 1; i >= 0; i--) {
				if (firstOccuList.get(i).getOccurence() == secondOccuList.get(i).getOccurence()
						&& firstOccuList.get(i).getCard() > secondOccuList.get(i).getCard()) {
					result = 1;
				} else if (firstOccuList.get(i).getOccurence() == secondOccuList.get(i).getOccurence()
						&& firstOccuList.get(i).getCard() < secondOccuList.get(i).getCard()) {
					result = 2;
				}
			}
		}
		return result;
	}
}
