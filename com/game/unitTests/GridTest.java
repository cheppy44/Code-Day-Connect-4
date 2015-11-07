package com.game.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.game.connect4.Grid;

public class GridTest {

	@Test
	public void test() {
		Grid grid = new Grid(7,6);
		grid.newGame();
		int yCoordinate1 = grid.dropGamePiece(1, Grid.state.red);
		int yCoordinate2 = grid.dropGamePiece(1, Grid.state.yellow);
		
		assertEquals(1,yCoordinate1);
		assertEquals(2,yCoordinate2);
		
	}

}
