package com.game.network;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.game.connect4.Grid;
import com.game.exceptions.NetworkStructureException;

public class Network {

	private static final int numLayers = 4; // TODO Play with these values in the evolution stage
	private static final int nodesPerLayer = 4;
	private static final int DEFAULT_USAGE_WEIGHT = 1;

	private Grid grid;
	private int numInputs;
	private int numOutputs;
	private int[] layerCounts;

	private List<Node> nodes;

	public Network(Grid grid) {
		this.grid = grid; // FIXME testing this
		numInputs = grid.getArea() * 2;
		numOutputs = 3;
		layerCounts = new int[numLayers];

		nodes = new ArrayList<Node>();

		// The first area nodes are "input nodes"
		// The next xWidth nodes are "output nodes"
		for (int i = 0; i < numInputs; i++) { // sets up the input nodes
			nodes.add(new Node(0, layerCounts[0]));
			layerCounts[0]++;
		}

		for (int i = 0; i < numOutputs; i++) { // Sets up the output nodes
			nodes.add(new Node(numLayers - 1, layerCounts[numLayers - 1]));
			layerCounts[numLayers - 1]++;
		}

		for (int i = 1; i < numLayers - 1; i++) { //Sets up the hidden layers
			for (int j = 0; j < nodesPerLayer; j++) {
				nodes.add(new Node(i, j));
				layerCounts[i]++;
			}
		}
		connectAllAdjacentNodes();
	}

	public void startTurn() {
		update();
	}

	public void getInputFromGrid() { // FIXME REALLY TEST THIS WELL PLS
		for (int i = 0; i < grid.getxWidth(); i++) {
			for (int j = 0; j < grid.getyHeight(); j++) {
				switch (grid.getState()[i][j]) {
					case empty:
						break;
					case red:
						nodes.get(i + grid.getxWidth() * j).addInputWeight(1);
						break;
					case yellow:
						nodes.get(i + grid.getxWidth() * j + grid.getArea()).addInputWeight(1);
						break;
				}
			}
		}
	}

	public void nodeOutput() {
		for (Node n : nodes) {
			n.outputToConnections();
		}
	}

	public void connectionOutput() {
		for (Node n : nodes) {
			for (Connection c : n.getOutputConnections()) {
				nodes.get(c.getEndIndex()).addInputWeight(c.getOutput());
			}
		}
	}

	public void update() {
		getInputFromGrid();
		for (int i = 0; i < numLayers; i++) {
			nodeOutput();
			connectionOutput();
		}
	}

	// BEGIN UTILS FOR NETWORK SETUP HERE

	public void connectNodes(int startLayerNum, int startLayerPos, int endLayerNum, int endLayerPos) throws NetworkStructureException { // connects two nodes based on
																																		// the coordinats of the nodes
																																		// inputted
		if (startLayerNum < 0 || startLayerNum > numLayers - 1) {
			throw new NetworkStructureException("Invalid network structure");

		} else if (endLayerNum < 0 || endLayerNum > numLayers - 1) {
			throw new NetworkStructureException("Invalid network structure");

		} else if (startLayerPos < 0 || startLayerPos >= layerCounts[startLayerNum]) {
			throw new NetworkStructureException("Invalid network structure");

		} else if (endLayerPos < 0 || endLayerPos >= layerCounts[endLayerNum]) {
			throw new NetworkStructureException("Invalid network structure");

		} else if (startLayerNum > endLayerNum) {
			throw new NetworkStructureException("Invalid network structure");
		} else {
			LinkedList<Node> nodeLinked = new LinkedList<Node>(nodes);
			int startPoint = 0;
			int endPoint = 0;
			boolean success = false, startFound = false, endFound = false;
			int i = 0;
			for (Node n : nodeLinked) {
				if (n.getLayerNum() == startLayerNum && n.getLayerHeight() == startLayerPos) {
					startPoint = i;
					startFound = true;
				} else if (n.getLayerNum() == endLayerNum && n.getLayerHeight() == endLayerPos) {
					endPoint = i;
					endFound = true;
				}
				success = startFound && endFound;
				i++;
			}

			if (!success) {
				throw new NetworkStructureException("Invalid network structure");
			}
			nodes.get(startPoint).addConnection(new Connection(startPoint, endPoint, DEFAULT_USAGE_WEIGHT));
		}
	}

	public void connectAllAdjacentNodes() {
		for (Node n : nodes) {
			int nextConnectionLayer = n.getLayerNum() + 1;
			if (nextConnectionLayer < layerCounts.length) {
				for (int i = 0; i < layerCounts[nextConnectionLayer]; i++) {
					try {
						connectNodes(n.getLayerNum(), n.getLayerHeight(), nextConnectionLayer, i);
					} catch (NetworkStructureException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public int getnumOutputs() {
		return numOutputs;
	}

	public int getnumInputs() {
		// TODO Auto-generated method stub
		return numInputs;
	}
}
