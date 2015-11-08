package com.game.network;

public class Connection {
	private boolean state;
	private double usageWeight;
	private int startIndex;
	private int endIndex;

	public Connection(int startIndex, int endIndex, double usageWeight) {
		this.usageWeight = usageWeight;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public double getUsageWeight() {
		return usageWeight;
	}

	public void setUsageWeight(double usageWeight) {
		this.usageWeight = usageWeight;
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

	public void setState(boolean state) {
		this.state = state;
	}

	public double getOutput() {
		if (state) {
			return usageWeight;
		} else {
			return 0;
		}
	}

}
