package com.capgemini.gameOfLife;

import java.util.HashSet;
import java.util.Set;

class GameOfLifeEngine {

	public static Set<Cell> nextRound(Set<Cell> givenGameState) {
		Set<Cell> gameState = new HashSet<Cell>();
		Set<Cell> possibleNewborn = new HashSet<Cell>();
		gameState.addAll(givenGameState);

		countNeighborsAndRemoveExcess(givenGameState, gameState, possibleNewborn);
		addNewCells(givenGameState, gameState, possibleNewborn);
		return gameState;
	}

	private static void countNeighborsAndRemoveExcess(Set<Cell> givenGameState, Set<Cell> gameState,
			Set<Cell> possibleNewborn) {
		Cell comparativeCell = new Cell();
		int aliveNeighbors = -1;
		for (Cell givenCell : givenGameState) {
			for (int x = givenCell.getPosX() - 1; x < givenCell.getPosX() + 2; x++) {
				for (int y = givenCell.getPosY() - 1; y < givenCell.getPosY() + 2; y++) {
					comparativeCell.setPosition(x, y);
					if (givenGameState.contains(comparativeCell)) {
						aliveNeighbors++;
					} else {
						possibleNewborn.add(new Cell(x, y));
					}
				}
			}
			if (aliveNeighbors < 2 || aliveNeighbors > 3) {
				gameState.remove(givenCell);
			}
			aliveNeighbors = -1;
		}
	}

	private static void addNewCells(Set<Cell> givenGameState, Set<Cell> gameState, Set<Cell> possibleNewborn) {
		Cell comparativeCell = new Cell();
		int aliveNeighbors = 0;
		for (Cell cell : possibleNewborn) {
			for (int x = cell.getPosX() - 1; x < cell.getPosX() + 2; x++) {
				for (int y = cell.getPosY() - 1; y < cell.getPosY() + 2; y++) {
					comparativeCell.setPosition(x, y);
					if (givenGameState.contains(comparativeCell)) {
						aliveNeighbors++;
					}
				}
			}
			if (aliveNeighbors == 3) {
				gameState.add(cell);
			}
			aliveNeighbors = 0;
		}
	}
}
