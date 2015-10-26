package com.capgemini.coins;

import java.util.List;

public class Coins {
	public static int solution(List<Integer> coins) {
		int[] countersList = new int[coins.size()];
		int[] reversedCoinsList = new int[coins.size()];
		int maxCounter = 0;

		for (int i = 0; i < coins.size(); i++) {
			for (int j = 0; j < coins.size(); j++) {
				if (i == j) {
					reversedCoinsList[j] = (coins.get(j).intValue() == 0) ? 1 : 0;
				} else {
					reversedCoinsList[j] = coins.get(j).intValue();
				}
			}
			for (int j = 1; j < reversedCoinsList.length; j++) {
				if (reversedCoinsList[j - 1] == reversedCoinsList[j]) {
					countersList[i]++;
				}
			}
		}
		maxCounter = countersList[0];
		for (int i = 0; i < countersList.length; i++) {
			if (countersList[i] > maxCounter)
				maxCounter = countersList[i];
		}
		return maxCounter;
	}
}
