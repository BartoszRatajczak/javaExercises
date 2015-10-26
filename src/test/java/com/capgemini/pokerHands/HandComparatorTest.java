package com.capgemini.pokerHands;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

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
		String rawHand1 = "AC AD 9H QS TC";
		String rawHand2 = "AC 5D 9H QS TC";
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
		String rawHand1 = "3C 2D 9H 8S TC";
		String rawHand2 = "AC 2D 9H 8S TC";
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
	public void fullHouseAgainstFullHouseTest() {
		String rawHand1 = "3C 3S 3C 4H 4C";
		String rawHand2 = "3C 3S 3C 2H 2C";
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
	public void twoPairsAgainstTwoPairsTest() {
		String rawHand1 = "2C 2S TC 4H 4C";
		String rawHand2 = "3C 3S 9C 4H 4C";
		assertThat(comparator.compareHands(evaluator.evaluateHand(rawHand1), evaluator.evaluateHand(rawHand2)))
				.isEqualTo(2);
	}
	
	@Test
	public void thousandTestsFromFile() {
		
	}
}
