package com.game.network;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private static final int DEFAULT_THRESHOLD = 1;
	private int layerNum;
	private int layerHeight;
	private int activationThreshold;

	private List<Connection> outputConnections;
	private List<Double> inputWeights;

	public Node(int layerNum, int layerHeight) {
		inputWeights = new ArrayList<Double>();
		outputConnections = new ArrayList<Connection>();
		this.layerNum = layerNum;
		this.layerHeight = layerHeight;
		activationThreshold = DEFAULT_THRESHOLD;
	}

	public void addInputWeight(double input) {
		inputWeights.add(input);
	}

	public void outputToConnections() {
		boolean output = calcOutput();
		inputWeights.clear();
		for (Connection c : outputConnections) {
			c.setState(output);
		}
	}

	public boolean calcOutput() {
		double weightSum = 0;
		for (double d : inputWeights) {
			weightSum += d;
		}

		return weightSum / inputWeights.size() >= activationThreshold;
	}

	public void setThreshold(int threshold) {
		activationThreshold = threshold;
	}

	public int getLayerNum() {
		return layerNum;
	}

	public int getLayerHeight() {
		return layerHeight;
	}

	public void addConnection(Connection c) {
		outputConnections.add(c);
	}

	public List<Connection> getOutputConnections() {
		return outputConnections;
	}

}
