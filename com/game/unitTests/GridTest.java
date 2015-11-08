package com.game.unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.connect4.Grid;
import com.game.connect4.State;

public class GridTest {

	@Test
	public void test() {
		Grid grid = new Grid(7, 6);
		grid.newGame();
		int yCoordinate1 = grid.dropGamePiece(1, State.red);
		int yCoordinate2 = grid.dropGamePiece(1, State.yellow);

		assertEquals(0, yCoordinate1);
		assertEquals(1, yCoordinate2);

	}

}
