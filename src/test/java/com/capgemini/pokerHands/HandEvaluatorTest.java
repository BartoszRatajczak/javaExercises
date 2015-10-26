package com.capgemini.pokerHands;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class HandEvaluatorTest {
	HandEvaluator evaluator;

	@Before
	public void executeBeforeEachEvaluation() {
		evaluator = new HandEvaluator();
	}
	
	@Test
	public void shouldDetectOnePair() {
		String rawHand = "AC AD 9H QS TC";
		assertThat(evaluator.evaluateHand(rawHand).getHandStrength()).isEqualTo(1);
	}

	@Test
	public void shouldDetectTwoPairs() {
		String rawHand = "AC AD 9H 9S TC";
		assertThat(evaluator.evaluateHand(rawHand).getHandStrength()).isEqualTo(2);
	}

	@Test
	public void shouldDetectThreeOfAKind() {
		String rawHand = "AC AD AH 9S TC";
		assertThat(evaluator.evaluateHand(rawHand).getHandStrength()).isEqualTo(3);
	}

	@Test
	public void shouldDetectFullHouse() {
		String rawHand = "AC AD AH 9S 9C";
		assertThat(evaluator.evaluateHand(rawHand).getHandStrength()).isEqualTo(6);
	}

	@Test
	public void shouldDetectFourOfAKind() {
		String rawHand = "AC AD AH AS 9C";
		assertThat(evaluator.evaluateHand(rawHand).getHandStrength()).isEqualTo(7);
	}
	
	@Test
	public void shouldDetectFlush() {
		String rawHand = "AC KC 4C 6C 9C";
		assertThat(evaluator.evaluateHand(rawHand).getHandStrength()).isEqualTo(5);
	}
	
	@Test
	public void shouldDetectStraight() {
		String rawHand = "2D AC 3C 4S 5C";
		assertThat(evaluator.evaluateHand(rawHand).getHandStrength()).isEqualTo(4);
	}
	
	@Test
	public void shouldDetectHighCard() {
		String rawHand = "6D KC 5C TS 9C";
		assertThat(evaluator.evaluateHand(rawHand).getHandStrength()).isEqualTo(0);
	}

}
