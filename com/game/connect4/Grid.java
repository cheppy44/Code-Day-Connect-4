package com.game.connect4;

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
		area = xWidth * yHeight;
		this.grid = new State[xWidth][yHeight];
	}
	
	

}
