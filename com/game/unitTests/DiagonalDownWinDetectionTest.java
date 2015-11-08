package com.game.unitTests;

import org.junit.Test;

import com.game.connect4.Grid;
import com.game.connect4.State;

public class DiagonalDownWinDetectionTest {

	Grid grid;

	@Test
	public void test() {
		grid = new Grid(6, 7);
		grid.newGame();
		grid.dropGamePiece(2, State.yellow);
		grid.dropGamePiece(2, State.yellow);
		grid.dropGamePiece(2, State.yellow);
		grid.dropGamePiece(2, State.yellow);
		grid.dropGamePiece(2, State.red);
		grid.dropGamePiece(3, State.yellow);
		grid.dropGamePiece(3, State.yellow);
		grid.dropGamePiece(3, State.yellow);
		grid.dropGamePiece(3, State.red);
		grid.dropGamePiece(4, State.yellow);
		grid.dropGamePiece(4, State.yellow);
		grid.dropGamePiece(4, State.red);
		grid.dropGamePiece(5, State.yellow);
		grid.dropGamePiece(5, State.yellow);
	}

}
