package com.game.connect4;

public class Grid {

	private int xWidth;
	private int yHeight;
	private int area;

	private State[][] grid;
	public WinDetection winDetector;

	public Grid(int xWidth, int yHeight) {
		this.xWidth = xWidth;
		this.yHeight = yHeight;
		this.area = xWidth * yHeight;
		this.grid = new State[xWidth][yHeight];
		winDetector = new WinDetection(this);
	}

	// Sets full grid to empty
	public void newGame() {
		for (int x = 0; x < xWidth; x++) {
			for (int y = 0; y < yHeight; y++) {
				grid[x][y] = State.empty;
			}
		}
	}

	// Returns state of slot on the coordinate grid
	public State getSlot(int x, int y) {
		return grid[x][y];
	}

	// Decides where to place a game piece based on a slot on the X plane and
	// returns yCoordinate
	public int dropGamePiece(int x, State state) {
		boolean isEmpty = false;
		int yCoordinate = 0;
		for (int i = 0; !isEmpty; i++) {
			if (grid[x][i] == State.empty) {
				grid[x][i] = state;

				yCoordinate = i + 1;
				isEmpty = true;

			}
		}

		return yCoordinate;
	}

	public State[][] getState() {
		return grid;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public void setxWidth(int xWidth) {
		this.xWidth = xWidth;
	}

	public void setyHeight(int yHeight) {
		this.yHeight = yHeight;
	}

	public int getxWidth() {
		return xWidth;
	}

	public int getyHeight() {
		return yHeight;
	}

	public int getArea() {
		return area;
	}

}
