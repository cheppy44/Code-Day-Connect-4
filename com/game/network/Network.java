package com.game.network;

import java.util.ArrayList;
import java.util.List;

import com.game.connect4.Grid;

public class Network {

	private static final int numLayers = 100; //TODO Play with these values in the evolution stage
	private static final int nodesPerLayer = 100;

	private Grid grid;
	private int numInputs;
	private int numOutputs;

	private List<Node> nodes;

	public Network(Grid grid) {
		this.grid = grid;
		numInputs = grid.getArea() * 2;
		numOutputs = grid.getxWidth();

		nodes = new ArrayList<Node>();

		//The first area nodes are "input nodes"
		//The next xWidth nodes are "output nodes"
		for (int i = 0; i < numInputs; i++) { //
			nodes.add(new Node(0, i));
		}

		for (int i = 0; i < numOutputs; i++) {
			nodes.add(new Node(numLayers, i));
		}

	}
}
