package com.game.network;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private int layerNum;
	private int layerHeighht;

	private List<Connection> outputConnections;
	private List<Double> inputWeights;

	public Node(int layerNum, int layerHeighht) {
		inputWeights = new ArrayList<Double>();
		outputConnections = new ArrayList<Connection>();
		this.layerNum = layerNum;
		this.layerHeighht = layerHeighht;
	}

	public void addInputWeight(double input) {
		inputWeights.add(input);
	}

	public void outputToConnections() {
		boolean output = calcOutput();
		inputWeights.clear();
	}

	public boolean calcOutput() {
		double weightSum = 0;
		for (double d : inputWeights) {
			weightSum += d;
		}

		return weightSum / inputWeights.size() >= 1;
	}

	public void addConnection(Connection c) {
		outputConnections.add(c);
	}

	public List<Connection> getOutputConnections() {
		return outputConnections;
	}

}
