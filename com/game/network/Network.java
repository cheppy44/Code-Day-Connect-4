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

	public void update() { //This method will first take input from the board, then propagate the signal through the network. This update does signal stuff, not structure stuff
		for (int x = 0; x < grid.getxWidth(); x++) {
			for (int y = 0; y < grid.getyHeight(); y++) {
				nodes.get(x + grid.getxWidth() * y).setState(grid.getState()[x][y]);
			}
		}
	}

	public void connectNodes() {

	}

	public void addNewNode() {
		int newIndex = nodes.size() + 1;
		nodes.add(new Node(newIndex));
	}

	public void removeNode(int index) {
		if (index > grid.getArea()) { //makes sure that a node isn't removed from the grid board game input nodes.

		}
	}

	public List<Node> getNodes() {
		return nodes;
	}
}
