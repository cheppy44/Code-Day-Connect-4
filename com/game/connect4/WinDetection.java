package com.game.connect4;

public class WinDetection {
	private Grid grid;
	static int lastMoveX;
	static int lastMoveY;

	public WinDetection(Grid grid) {
		this.grid = grid;
	}

	// Returns true if any win condition returns true
	public boolean detectWin(int lastMoveX, int lastMoveY, State lastPlayer) {

		if (detect4Horizontal(lastMoveX, lastMoveY, lastPlayer) || detect4Vertical(lastMoveX, lastMoveY, lastPlayer)
				|| detect4DiagonalUp(lastMoveX, lastMoveY, lastPlayer)
				|| detect4DiagonalDown(lastMoveX, lastMoveY, lastPlayer)) {
			return true;
		}

		return false;
	}

	public boolean detectWin(State lastPlayer) {

		if (detect4Horizontal(lastMoveX, lastMoveY, lastPlayer) || detect4Vertical(lastMoveX, lastMoveY, lastPlayer)
				|| detect4DiagonalUp(lastMoveX, lastMoveY, lastPlayer)
				|| detect4DiagonalDown(lastMoveX, lastMoveY, lastPlayer)) {
			return true;
		}

		return false;
	}

	// Returns true if last move connected 4 horizontally
	private boolean detect4Horizontal(int x, int y, State state) {
		int filledSlots = 1;
		for (int i = x + 1; i >= 0 && i <= grid.getxWidth(); i++) {
			if (grid.getSlot(i, y) != state) {
				break;
			}
			filledSlots++;
		}
		for (int i = x - 1; i >= 0 && i <= grid.getxWidth(); i--) {
			if (grid.getSlot(i, y) != state) {
				break;
			}
			filledSlots++;
		}
		if (filledSlots == 4) {
			return true;
		}
		return false;
	}

	// Returns true if last move connected 4 vertically
	private boolean detect4Vertical(int x, int y, State state) {
		int filledSlots = 1;
		for (int i = y + 1; i >= 0 && i <= grid.getyHeight(); i++) {
			if (grid.getSlot(x, i) != state) {
				break;
			}
			filledSlots++;
		}
		for (int i = y - 1; i >= 0 && i <= grid.getyHeight(); i--) {
			if (grid.getSlot(x, i) != state) {
				break;
			}
			filledSlots++;
		}
		if (filledSlots == 4) {
			return true;
		}
		return false;
	}

	// Returns true if last move connected 4 diagonally up
	private boolean detect4DiagonalUp(int x, int y, State state) {
		int filledSlots = 1;
		int dI = 0;
		for (int i = x + 1; i >= 0 && i <= grid.getxWidth(); i++) {
			if (dI >= 0 && dI <= grid.getyHeight()) {
				break;
			}
			if (grid.getSlot(i, y + dI) != state) {
				break;
			}

			filledSlots++;
		}
		for (int i = x - 1; i >= 0 && i <= grid.getxWidth(); i--) {
			if (dI <= 0 && dI >= grid.getyHeight()) {
				break;
			}
			if (grid.getSlot(i, y - dI) != state) {
				break;
			}
			filledSlots++;
			dI++;
		}
		if (filledSlots == 4) {
			System.out.println("win condition satisfied");
			return true;
		}
		return false;
	}

	// Returns true if last move connected 4 diagonally down
	private boolean detect4DiagonalDown(int x, int y, State state) {
		int filledSlots = 1;
		int dI = 0;
		for (int i = x + 1; i >= 0 && i <= grid.getxWidth() && y - dI >= 0 && y - dI <= grid.getyHeight(); i++) {
			if (grid.getSlot(i, y - dI) != state) {
				break;
			}

			filledSlots++;
			dI++;
		}
		for (int i = x - 1; i >= 0 && i <= grid.getxWidth(); i--) {
			if (dI >= 0 && dI <= grid.getyHeight()) {
				break;
			}
			if (grid.getSlot(i, y + dI) != state) {
				break;
			}
			filledSlots++;
		}
		if (filledSlots == 4) {
			return true;
		}
		return false;

	}

}