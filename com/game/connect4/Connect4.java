package com.game.connect4;

import com.game.network.Network;

public class Connect4 {
	public Grid gameGrid;
	public Network network;

	public Connect4() {
		gameGrid = new Grid(7, 6);
		network = new Network(gameGrid);
	}
}
