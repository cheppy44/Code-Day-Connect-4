package com.game.connect4;

public class Grid {

	private int xWidth;
	private int yHeight;
	private int area;

	private State[][] grid;

	public Grid(int xWidth, int yHeight) {
		this.xWidth = xWidth;
		this.yHeight = yHeight;
		this.area = xWidth * yHeight;
		this.grid = new State[xWidth][yHeight];
	}

	//Sets full grid to empty
	public void newGame() {
		for (int x = 1; x <= xWidth; x++) {
			for (int y = 1; y <= yHeight; y++) {
				grid[x - 1][y - 1] = State.empty;
			}
		}
	}

	//Returns state of slot on the coordinate grid
	public State getSlot(int x, int y) {
		return grid[x - 1][y - 1];
	}

	//Decides where to place a game piece based on a slot on the X plane and returns yCoordinate
	public int dropGamePiece(int x, State state) {
		boolean isEmpty = false;
		int yCoordinate = 0;
		for (int i = 0; !isEmpty; i++) {
			if (grid[x - 1][i] == State.empty) {
				grid[x - 1][i] = state;

				yCoordinate = i + 1;
				isEmpty = true;

			}
		}

		return yCoordinate;
	}

	public State[][] getState() {
		return grid;
	}

	public int getxWidth() {
		return xWidth;
	}

	public int getyHeight() {
		return yHeight;
	}

}
