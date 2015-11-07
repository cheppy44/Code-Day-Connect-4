package com.game.connect4;

public class WinCondition {
	
	public class Coordinates {
		int x;
		int y;
		public Coordinates(int x,int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public String toString() {
			return "" + x + y;
		}
		
	}
	
	Grid grid;
	
	public WinCondition(Grid grid) {
		this.grid = grid;
	}

}
