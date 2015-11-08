package com.game.network;

import java.util.ArrayList;
import java.util.List;

import com.game.connect4.Grid;

public class Network {
	private Grid grid;
	private List<Node> nodes; //Network objects themselves
	private int indexLevel; //Use this for setting the index for each node so that when they are shifted in the arraylist they don't lost position.

	public Network(Grid grid) {
		indexLevel = 0;
		this.grid = grid;
		nodes = new ArrayList<Node>();

		for (int i = 0; i < grid.getArea(); i++) {
			nodes.add(new Node(i)); //input nodes are always index 0 to index area
		}
		indexLevel = grid.getArea();
	}

	public void updateData() { //This method will first take input from the board, then propagate the signal through the network. This update does signal stuff, not structure stuff
		for (int x = 0; x < grid.getxWidth(); x++) {
			for (int y = 0; y < grid.getyHeight(); y++) {
				nodes.get(x + grid.getxWidth() * y).setState(grid.getState()[x][y]);
			}
		}
	}

	public void updateStructure() {
		for (Node n : nodes) {
			if (n.getNodeIndex() > grid.getArea()) { //As long as the node isn't a network input node:
				if (n.getInputs().size() == 0) { //If there are no inputs, add two inputs

				} else if (n.getInputs().size() == 1) { //If there is one input, add another one

				}
			}
		}
	}

	public void connectNodes() {

	}

	public void addNewNode() {
		nodes.add(new Node(indexLevel));
		indexLevel++; //So increment the index whenever a node is added. Don't reuse indicies of removed nodes
	}

	public void removeNode(int index) {
		if (index > grid.getArea()) { //makes sure that a node isn't removed from the grid board game input nodes.
			nodes.remove(index); //FIXME This is bad because it shifts the indicies of the other nodes. Solve this by just dealing with the fact that the indicies are different.
		}
	}

	public List<Node> getNodes() {
		return nodes;
	}
}
