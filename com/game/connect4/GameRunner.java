package com.game.connect4;

import java.util.List;

import com.game.network.Network;
import com.game.network.Node;

public class GameRunner implements Runnable {

	Grid grid;

	public GameRunner(Grid grid) {
		this.grid = grid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	private Player startGame(Network networkA, Network networkB) {
		grid.newGame();
		List<Node> networkANodes;
		List<Node> networkBNodes;
		networkANodes = networkA.extractOutputNodes();
		networkBNodes = networkB.extractOutputNodes();

		boolean isWinner = false;
		while (!isWinner) {
			startTurn(networkA, networkANodes, State.yellow);
			if (grid.winDetector.detectWin(State.yellow)) {
				break;
			}
			startTurn(networkB, networkBNodes, State.red);
			if (grid.winDetector.detectWin(State.red)) {
				isWinner = true;
			}
		}

		return null;
	}

	private void startTurn(Network network, List<Node> nodes, State turn) {
		// TODO Auto-generated method stub
		network.update();
		int placement = 0;
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
