package com.game.unitTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.game.connect4.Grid;
import com.game.connect4.State;
import com.game.graphics.GUI;

public class ScreenTest {
	Grid grid;
	GUI gui;

	@Test
	public void test() {
		grid = new Grid(7, 6);
		gui = new GUI(grid);
		Thread t = new Thread(gui);
		t.start();
		grid.newGame();
		grid.dropGamePiece(0, State.yellow);
		grid.dropGamePiece(0, State.red);
		grid.dropGamePiece(0, State.red);
		grid.dropGamePiece(1, State.yellow);
		grid.dropGamePiece(2, State.red);
		grid.dropGamePiece(3, State.red);
		gui.run();
		assertTrue(t.isAlive());
	}

}
