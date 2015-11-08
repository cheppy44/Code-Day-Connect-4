package com.game.network;

import java.util.ArrayList;
import java.util.List;

import com.game.connect4.Grid;

public class Network {
	private Grid grid;
	private List<Node> nodes; //Network objects themselves

	public Network(Grid grid) {
		this.grid = grid;
		nodes = new ArrayList<Node>();

		for (int i = 0; i < grid.getArea(); i++) {
			nodes.add(new Node(i)); //input nodes are always index 0 to index area
		}
	}

	public void update() { //This method will first take input from the board, then propagate the signal through the network.

	}

	public void addNewNode() {

	}

	public List<Node> getNodes() {
		return nodes;
	}
}
