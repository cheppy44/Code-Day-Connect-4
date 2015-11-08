package com.game.network;

public class Connection {
	private boolean state;
	private double usageWeight;
	private int startIndex;
	private int endIndex;

	public Connection(double usageWeight, int startIndex, int endIndex) {
		this.usageWeight = usageWeight;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public double getOutput() {
		if (state) {
			return usageWeight;
		} else {
			return 0;
		}
	}

}
