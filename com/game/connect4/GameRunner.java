package com.game.connect4;

import java.util.List;

import com.game.network.Network;
import com.game.network.Node;

public class GameRunner {

	private Grid grid;
	private int gameLength;

	public GameRunner(Grid grid) {
		this.grid = grid;
		gameLength = 0;
	}

	public GameResult startGame(Network networkA, Network networkB) {

		networkA.setColor(State.red);
		networkB.setColor(State.yellow);

		grid.newGame();

		grid.dropGamePiece(0, State.yellow);
		grid.dropGamePiece(0, State.red);
		grid.dropGamePiece(0, State.red);
		grid.dropGamePiece(0, State.red);
		grid.dropGamePiece(0, State.yellow);
		grid.dropGamePiece(0, State.red);

		List<Node> networkANodes;
		List<Node> networkBNodes;
		networkANodes = networkA.extractOutputNodes();
		networkBNodes = networkB.extractOutputNodes();

		boolean isWinner = false;
		for (int i = 0; i < grid.getArea(); i++) {
			startTurn(networkA, networkANodes, State.yellow);
			if (grid.winDetector.detectWin(State.yellow)) {
				gameLength = i;
				return GameResult.PlayerA;
			}
			startTurn(networkB, networkBNodes, State.red);
			if (grid.winDetector.detectWin(State.red)) {
				gameLength = i;
				return GameResult.PlayerB;
			}
			if (isWinner) {
				break;
			}
		}
		gameLength = grid.getArea();
		return GameResult.tie;
	}

	public void startTurn(Network network, List<Node> nodes, State turn) {
		// TODO Auto-generated method stub
		network.update();
		int placement = 0;
		// Converts from trinary nodes to integer
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).calcOutput()) {
				if (i == 0) {
					placement += 1;
				} else if (i == 1) {
					placement += 2;
				} else if (i == 2) {
					placement += 4;
				}
			}
		}
		if (placement != 0) {
			grid.dropGamePiece(placement - 1, turn);
		}
		// System.out.println("slot " + placement);
	}

	public int getGameLength() {
		return gameLength;
	}
}
