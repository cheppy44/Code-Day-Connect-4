package com.game.evolution;

import com.game.connect4.GameRunner;
import com.game.connect4.Grid;
import com.game.network.Network;

public class NetworkHandler implements Runnable {

	private Grid grid;
	private GameRunner runner;
	private Network[] population;
	private int generationCount;

	public NetworkHandler(Grid grid) {
		this.grid = grid;
		runner = new GameRunner(grid);
		population = new Network[3];

		population[0] = new Network(grid);
		population[1] = new Network(grid);
		population[2] = new Network(grid);
	}

	@Override
	public void run() {

	}

	private void compareNetworks(Network networkA, Network networkB) {

	}
}
