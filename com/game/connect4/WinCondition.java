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
	
	public WinCondition() {
		Coordinates coordinates[grid.area()];
		coordinates[0].getX(1);
		coordinates[0].getY(1);
	}

}
