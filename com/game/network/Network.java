package com.game.network;

import java.util.ArrayList;
import java.util.List;

import com.game.connect4.Grid;

public class Network {
	private Grid grid;
	private List<NetworkObject> networkObjects; //Network objects themselves
	private NetworkObject[][] networkInput; //Input from the grid

	public Network(Grid grid) {
		this.grid = grid;
		networkObjects = new ArrayList<NetworkObject>();
		networkInput = new Synapse[grid.getxWidth()][grid.getyHeight()];
	}
}
