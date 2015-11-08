package com.game.connect4;

import java.util.List;

import com.game.network.Network;
import com.game.network.Node;

public class GameRunner implements Runnable {

	Grid grid;
	Network parentNetwork;
	Network childANetwork;
	Network childBNetwork;

	public GameRunner(Grid grid) {
		this.grid = grid;
		parentNetwork = new Network(grid);
		childANetwork = new Network(grid);
		childBNetwork = new Network(grid);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Player Winner = startGame(childANetwork, childBNetwork);

	}

	private Player startGame(Network networkA, Network networkB) {
		grid.newGame();
		List<Node> networkANodes;
		List<Node> networkBNodes;
		networkANodes = extractOutputNodes(networkA);
		networkBNodes = extractOutputNodes(networkB);

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

	private List<Node> extractOutputNodes(Network network) {
		List<Node> nodes = network.getNodes();
		List<Node> outputNodes = null;
		for (int i = network.getnumOutputs(); i < network.getnumOutputs() + network.getnumInputs(); i++) {
			outputNodes.add(nodes.get(i));
		}
		return outputNodes;
	}

}
