package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HandComparator {
	int result;
	List<CardOccurence> firstOccuList;
	List<CardOccurence> secondOccuList;

	public int compareHands(Hand firstHand, Hand secondHand) {
		result = 0;

		if (firstHand.getHandStrength() > secondHand.getHandStrength()) {
			result = 1;
		} else if (firstHand.getHandStrength() < secondHand.getHandStrength()) {
			result = 2;
		} else {
			firstOccuList = new ArrayList<CardOccurence>();
			secondOccuList = new ArrayList<CardOccurence>();

			prepareTempOccurenceLists(firstHand, secondHand);
			sortByOccurence();
			checkHigherWildCard();
		}
		return result;
	}

	private void prepareTempOccurenceLists(Hand firstHand, Hand secondHand) {
		for (Map.Entry<Integer, Integer> hand : firstHand.getCardDistribution().entrySet()) {
			firstOccuList.add(new CardOccurence(hand.getKey(), hand.getValue()));
		}
		for (Map.Entry<Integer, Integer> hand : secondHand.getCardDistribution().entrySet()) {
			secondOccuList.add(new CardOccurence(hand.getKey(), hand.getValue()));
		}
	}

	private void sortByOccurence() {
		CardOccurence singleCard = new CardOccurence();
		for (int j=0; j<2; j++) {
			for (int i = 1; i < firstOccuList.size(); i++) {
				if (firstOccuList.get(i).getOccurence() < firstOccuList.get(i - 1).getOccurence()) {
					// exchange cards
					singleCard.setCard(firstOccuList.get(i - 1).getCard());
					singleCard.setOccurence(firstOccuList.get(i - 1).getOccurence());
					firstOccuList.get(i - 1).setCard(firstOccuList.get(i).getCard());
					firstOccuList.get(i - 1).setOccurence(firstOccuList.get(i).getOccurence());
					firstOccuList.get(i).setCard(singleCard.getCard());
					firstOccuList.get(i).setOccurence(singleCard.getOccurence());
				}
				if (secondOccuList.get(i).getOccurence() < secondOccuList.get(i - 1).getOccurence()) {
					// exchange cards
					singleCard.setCard(secondOccuList.get(i - 1).getCard());
					singleCard.setOccurence(secondOccuList.get(i - 1).getOccurence());
					secondOccuList.get(i - 1).setCard(secondOccuList.get(i).getCard());
					secondOccuList.get(i - 1).setOccurence(secondOccuList.get(i).getOccurence());
					secondOccuList.get(i).setCard(singleCard.getCard());
					secondOccuList.get(i).setOccurence(singleCard.getOccurence());
				}
			}
		}
	}

	private void checkHigherWildCard() {
		for (int i = firstOccuList.size() - 1; i >= 0; i--) {
			if (firstOccuList.get(i).getOccurence() == secondOccuList.get(i).getOccurence()
					&& firstOccuList.get(i).getCard() > secondOccuList.get(i).getCard()) {
				result = 1;
				break;
			} else if (firstOccuList.get(i).getOccurence() == secondOccuList.get(i).getOccurence()
					&& firstOccuList.get(i).getCard() < secondOccuList.get(i).getCard()) {
				result = 2;
				break;
			}
		}
	}
}
