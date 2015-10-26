package com.capgemini.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	private BowlingGame game;

	@Before
	public void executedBeforeEachGame() {
		game = new BowlingGame();
	}

	@Test
	public void shouldCountAThrow() {
		game.roll(5);
		game.roll(4);
		game.roll(3);
		assertThat(game.score()).isEqualTo(12);
	}

	@Test
	public void shouldCountASpare() {
		game.roll(6);
		game.roll(4);
		game.roll(3);
		game.roll(2);
		assertThat(game.score()).isEqualTo(18);
	}

	@Test
	public void shouldCountAStrike() {
		game.roll(10);
		game.roll(2);
		game.roll(3);
		assertThat(game.score()).isEqualTo(20);
	}

	@Test
	public void shouldMarkAsFinished() {
		game.roll(10);
		for (int i = 0; i < 18; i++) {
			game.roll(1);
		}
		assertThat(game.isFinished()).isTrue();
	}

	@Test
	public void shouldAddBonusAfterLastSpare() {
		for (int i = 0; i < 19; i++) {
			game.roll(1);
		}
		game.roll(9);
		game.roll(2);
		assertThat(game.score()).isEqualTo(30);
	}

	@Test
	public void shouldAddBonusAfterLastStrike() {
		for (int i = 0; i < 18; i++) {
			game.roll(1);
		}
		game.roll(10);
		game.roll(10);
		game.roll(10);
		assertThat(game.score()).isEqualTo(48);
	}

	@Test(expected = IllegalStateException.class)
	public void shouldCatchIllegalRoll() {
		for (int i = 0; i < 21; i++) {
			game.roll(1);
		}
	}
}
