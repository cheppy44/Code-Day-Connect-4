package com.game.network;

import java.util.List;

import com.game.connect4.State;

public class Node { //Once a node exists. If it doens't have two inputs, find some using randomness.

	private List<Synapse> inputs; //Must not be greater than 2
	private List<Synapse> outputs;

	private State state;

	public Node(int nodeIndex) {

	}

	public void setState(State input) {
		this.state = input;
	}

}
