package com.game.connect4;

import java.util.List;

import com.game.network.Network;
import com.game.network.Node;

public class GameRunner {

	Grid grid;

	public GameRunner(Grid grid) {
		this.grid = grid;
	}

	public Player startGame(Network networkA, Network networkB) {
		grid.newGame();
		List<Node> networkANodes;
		List<Node> networkBNodes;
		networkANodes = networkA.extractOutputNodes();
		networkBNodes = networkB.extractOutputNodes();

		boolean isWinner = false;
		while (!isWinner) {
			startTurn(networkA, networkANodes, State.yellow);
			if (grid.winDetector.detectWin(State.yellow)) {
				return Player.PlayerA;
			}
			startTurn(networkB, networkBNodes, State.red);
			if (grid.winDetector.detectWin(State.red)) {
				return Player.PlayerB;
			}
		}

		return null;
	}

	public void startTurn(Network network, List<Node> nodes, State turn) {
		// TODO Auto-generated method stub
		network.update();
		int placement = 0;
		// Converts from trinary nodes to integer
		for (int i = 0; i <= nodes.size(); i++) {
			if (nodes.get(i).calcOutput()) {
				if (i == 0) {
					placement += 1;
				} else {
					placement += 2 ^ i;
				}

			}
		}
		grid.dropGamePiece(placement, turn);
	}

}
