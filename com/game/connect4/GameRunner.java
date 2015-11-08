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

		return null;
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
