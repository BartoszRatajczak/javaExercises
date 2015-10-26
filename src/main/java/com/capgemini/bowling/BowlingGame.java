package com.capgemini.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame implements BowlingGameResultCalculator {

	List<OneThrow> game = new ArrayList<OneThrow>();
	int numberOfGainedMultipliers;

	public void roll(int numberOfPins) {
		if (!isFinished()) {
			addBallThrowWithMultiplier(numberOfPins);
			checkSpare(numberOfPins);
			checkStrike(numberOfPins);
			
		} else {
			throw new IllegalStateException("Illegal roll operation.");
		}
	}

	public int score() {
		int sum = 0;
		for (int i = 0; i < game.size(); i++) {
			sum += game.get(i).getBallThrow() * game.get(i).getMultiplier();
		}
		return sum;
	}

	public boolean isFinished() {
		return game.size() >= 20 && numberOfGainedMultipliers == 0;
	}
	
	private void addBallThrowWithMultiplier(int numberOfPins) {
		if (numberOfGainedMultipliers > 0) {
			if (game.size() >= 20) {
				game.add(new OneThrow(numberOfPins, 1));
			} else {
				game.add(new OneThrow(numberOfPins, 2));
			}
			numberOfGainedMultipliers--;
		} else {
			game.add(new OneThrow(numberOfPins, 1));
		}
	}
	
	private void checkSpare(int numberOfPins) {
		if ((game.size() % 2 == 0) && (game.size() > 0)
				&& (game.get(game.size() - 2).getBallThrow() + numberOfPins == 10) && (game.size() <= 20)) {
			numberOfGainedMultipliers = 1;
		}
	}
	
	private void checkStrike(int numberOfPins) {
		if ((game.size() % 2 == 1) && (numberOfPins == 10) && (game.size() <= 20)) {
			game.add(new OneThrow(0, 0));
			numberOfGainedMultipliers = 2;
		}
	}
}
