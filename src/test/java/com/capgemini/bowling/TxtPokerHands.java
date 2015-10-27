package com.capgemini.bowling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.capgemini.pokerHands.HandComparator;
import com.capgemini.pokerHands.HandEvaluator;
import com.capgemini.pythagorean.Pythagorean;

public class TxtPokerHands {

	private static final Logger LOGGER = Logger.getLogger(Pythagorean.class.getName());

	List<String> hands = new ArrayList<String>();
	int firstHandWinsCounter;

	public int checkHandsFromFile(String dir) {
		readFile(dir);
		checkHands();		
		return firstHandWinsCounter;
	}

	private void readFile(String dir) {
		BufferedReader reader = null;
		try {
			File file = new File(dir);
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				hands.add(line);
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
			}
		}
	}

	private void checkHands() {
		HandComparator comparator = new HandComparator();
		HandEvaluator evaluator = new HandEvaluator();
		for (int i = 0; i < hands.size(); i++) {
			if (comparator.compareHands(evaluator.evaluateHand(hands.get(i).substring(0, 14)),
					evaluator.evaluateHand(hands.get(i).substring(15))) == 1) {
				firstHandWinsCounter++;
			}
		}
	}
}
