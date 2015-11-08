package com.game.network;

import java.util.List;

import com.game.connect4.State;

public class Node { //Once a node exists. If it doens't have two inputs, find some using randomness.

	private List<Synapse> inputs; //Must not be greater than 2
	private List<Synapse> outputs;

	private State state;
	private int nodeIndex;

	public Node(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public void setState(State input) {
		this.state = input;
	}

	public List<Synapse> getInputs() {
		return inputs;
	}

	public void setInputs(List<Synapse> inputs) {
		this.inputs = inputs;
	}

	public List<Synapse> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<Synapse> outputs) {
		this.outputs = outputs;
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

}
