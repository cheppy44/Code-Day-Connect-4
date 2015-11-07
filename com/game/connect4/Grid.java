package com.game.connect4;

import java.util.ArrayList;
import java.util.Set;

public class Grid {
	
	int xWidth;
	int yHeight;
	int area;
	
	private enum State{empty,red,yellow}
	
	private State[][] grid;
	
	public Grid(int xWidth, int yHeight) {
		this.xWidth = xWidth;
		this.yHeight = yHeight;
		this.area = xWidth * yHeight;
		this.grid = new State[xWidth][yHeight];
	}
	
	public void newGame() {
		for (int x = 1;x <= xWidth;x++) {
			for (int y = 1;y <= yHeight;y++) {
				grid[x - 1][y - 1] = State.empty;
			}
		}
	}
	
	public State getSlot(int x,int y) {
		return grid[x - 1][y - 1];
	}

}
