package com.capgemini.pokerHands;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bowling.TxtPokerHands;

public class HandComparatorTest {
	HandComparator comparator;
	HandEvaluator evaluator;

	@Before
	public void executeBeforeEachComparision() {
		comparator = new HandComparator();
		evaluator = new HandEvaluator();
	}

	@Test
	public void pairAgainstHighCardTest() {
		String rawHand1 = "5C 7H 5D KD 9H";
		String rawHand2 = "4D 3D 2D KS AD";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(1);
	}

	@Test
	public void pairAgainstFullHouseTest() {
		String rawHand1 = "AC AD 9H QS TC";
		String rawHand2 = "9C 9D TH TS TC";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(2);
	}

	@Test
	public void highCardAgainstHighCardTest() {
		String rawHand1 = "8C TS KC 9H 4S";
		String rawHand2 = "7D 2S 5D 3S AC";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(2);
	}

	@Test
	public void flushAgainstFlushTest() {
		String rawHand1 = "3C 2C 9C 8C TC";
		String rawHand2 = "AC 2C 9C 8C TC";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(2);
	}

	@Test
	public void threeOfAKindAgainstThreeOfAKindTest() {
		String rawHand1 = "3D 3C 3H 8C TC";
		String rawHand2 = "2D 2C 2H 8C TC";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(1);
	}
	
	@Test
	public void straightAgainstPairTest() {
		String rawHand1 = "3C 2D 4C 5S 6C";
		String rawHand2 = "4S QS 3S JD 3D";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(1);
	}

	@Test
	public void fullHouseAgainstFullHouseTest() {
		String rawHand1 = "3C 3S 3C 4H 4C";
		String rawHand2 = "3C 3S 3C 2H 2C";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(1);
	}
	
	@Test
	public void pairAgainstPairTest() {
		String rawHand1 = "2D TH 6D QD 6C";
		String rawHand2 = "KC 3H 3S AD 4C";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(1);
	}

	@Test
	public void royalFlushAgainstRoyalFlushTest() {
		String rawHand1 = "AC KC QC JC TC";
		String rawHand2 = "AS KS QS JS TS";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(0);
	}

	@Test
	public void straightAgainstStraightTest() {
		String rawHand1 = "9C 8C QC JC TC";
		String rawHand2 = "9S KS QS JS TS";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(2);
	}
	
	@Test
	public void highCardAgainstThreeOfAKindTest() {
		String rawHand1 = "AS JS 2S QD KH";
		String rawHand2 = "8H 4S AC 8D 8S";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(2);
	}
	
	@Test
	public void pairAgainstTwoPairsTest() {
		String rawHand1 = "QD KH QS 2C 3S";
		String rawHand2 = "8S 8H 9H 9C JC";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(2);
	}

	@Test
	public void twoPairsAgainstTwoPairsTest() {
		String rawHand1 = "2C 2S TC 4H 4C";
		String rawHand2 = "3C 3S 9C 4H 4C";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(2);
	}
	
	@Test
	public void fileExamplesTest() {
		String dir = "src\\main\\resources\\poker.txt";
		TxtPokerHands hands = new TxtPokerHands();
		assertThat(hands.checkHandsFromFile(dir)).isEqualTo(376);
	}
}
