package com.capgemini.gameOfLife;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class GameOfLifeEngineTest {

	@Test
	public void shouldDieNotEnoughNeighbors() {
		Set<Cell> gameState = new HashSet<Cell>();
		gameState.add(new Cell(0, 0));
		gameState.add(new Cell(1, 0));

		assertThat(GameOfLifeEngine.nextRound(gameState).contains(new Cell(0, 0))).isFalse();
	}

	@Test
	public void shouldDieTooManyNeighbors() {
		Set<Cell> gameState = new HashSet<Cell>();
		gameState.add(new Cell(0, 0));
		gameState.add(new Cell(1, 0));
		gameState.add(new Cell(-1, 0));
		gameState.add(new Cell(1, 1));
		gameState.add(new Cell(-1, -1));

		assertThat(GameOfLifeEngine.nextRound(gameState).contains(new Cell(0, 0))).isFalse();
	}

	@Test
	public void shouldStayAlive() {
		Set<Cell> gameState = new HashSet<Cell>();
		gameState.add(new Cell(0, 0));
		gameState.add(new Cell(1, 0));
		gameState.add(new Cell(-1, 0));
		gameState.add(new Cell(1, 1));

		assertThat(GameOfLifeEngine.nextRound(gameState).contains(new Cell(0, 0))).isTrue();
	}

	@Test
	public void shouldBeBorn() {
		Set<Cell> gameState = new HashSet<Cell>();
		gameState.add(new Cell(0, 0));
		gameState.add(new Cell(1, 0));
		gameState.add(new Cell(-1, 0));
		gameState.add(new Cell(1, 1));

		assertThat(GameOfLifeEngine.nextRound(gameState).contains(new Cell(0, -1))).isTrue();

	}
}
