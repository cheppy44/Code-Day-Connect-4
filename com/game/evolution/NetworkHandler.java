package com.game.evolution;

import com.game.connect4.GameRunner;
import com.game.connect4.Grid;
import com.game.network.Network;

public class NetworkHandler implements Runnable {

	private Grid grid;
	private GameRunner runner;
	private Network[] population;

	public NetworkHandler(Grid grid) {
		this.grid = grid;
		runner = new GameRunner(grid);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
