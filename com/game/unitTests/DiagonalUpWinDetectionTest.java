package com.game.unitTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.game.connect4.Connect4;
import com.game.connect4.Grid;
import com.game.connect4.State;

public class DiagonalUpWinDetectionTest {

	Grid grid;

	@Test
	public void test() {
		Connect4 game = new Connect4();
		grid = game.gameGrid;
		grid.newGame();
		grid.dropGamePiece(2, State.yellow);
		grid.dropGamePiece(2, State.red);
		grid.dropGamePiece(3, State.yellow);
		grid.dropGamePiece(3, State.yellow);
		grid.dropGamePiece(3, State.red);
		grid.dropGamePiece(4, State.yellow);
		grid.dropGamePiece(4, State.yellow);
		grid.dropGamePiece(4, State.yellow);
		grid.dropGamePiece(4, State.red);
		grid.dropGamePiece(5, State.yellow);
		grid.dropGamePiece(5, State.yellow);
		grid.dropGamePiece(5, State.yellow);
		grid.dropGamePiece(5, State.yellow);
		int lastY = grid.dropGamePiece(5, State.red);
		assertTrue(grid.winDetector.detectWin(5, lastY, State.red));
	}

}