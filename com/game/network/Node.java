package com.game.network;

import java.util.List;

import com.game.connect4.State;

public class Node { //Once a node exists. If it doens't have two inputs, find some using randomness.

	private List<Synapse> inputs;

	private State state;
	private int nodeIndex;

	public Node(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public void addInput(Synapse synapse) {
		if (inputs.size() < 2) {
			inputs.add(synapse);
		}
	}

	public void setState(State input) {
		this.state = input;
	}

	public void setInputs(List<Synapse> inputs) {
		this.inputs = inputs;
	}

	public int getNodeIndex() {
		return nodeIndex;
	}

	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public State getState() {
		return state;
	}

	public List<Synapse> getInputs() {
		return inputs;
	}

}
