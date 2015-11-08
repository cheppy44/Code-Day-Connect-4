package com.game.connect4;

public class WinDetection {
	private Grid grid;

	public WinDetection(Grid grid) {
		this.grid = grid;
	}

	public boolean detectWin(int lastMoveX, int lastMoveY, State lastPlayer) {

		if (detect4Horizontal(lastMoveX, lastMoveY, lastPlayer) || detect4Vertical(lastMoveX, lastMoveY, lastPlayer)
				|| detect4DiagonalUp(lastMoveX, lastMoveY, lastPlayer)
				|| detect4DiagonalDown(lastMoveX, lastMoveY, lastPlayer)) {
			return true;
		}

		return false;
	}

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

	private boolean detect4DiagonalUp(int x, int y, State state) {
		int filledSlots = 1;
		int dI = 1;
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
			if (dI >= 0 && dI <= grid.getyHeight()) {
				break;
			}
			if (grid.getSlot(i, y - dI) != state) {
				break;
			}
			filledSlots++;
		}
		if (filledSlots == 4) {
			return true;
		}
		return false;
	}

	private boolean detect4DiagonalDown(int x, int y, State state) {
		int filledSlots = 1;
		int dI = 1;
		for (int i = x + 1; i >= 0 && i <= grid.getxWidth(); i++) {
			if (dI >= 0 && dI <= grid.getyHeight()) {
				break;
			}
			if (grid.getSlot(i, y - dI) != state) {
				break;
			}

			filledSlots++;
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