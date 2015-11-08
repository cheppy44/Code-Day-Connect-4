package com.game.evolution;

import com.game.connect4.GameResult;
import com.game.connect4.GameRunner;
import com.game.connect4.Grid;
import com.game.graphics.GUI;
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

		System.out.println("Initializing Network 0...");
		population[0] = new Network(grid);
		System.out.println("Initializing Network 1...");
		population[1] = new Network(population[0]);
		System.out.println("Initializing Network 2...");
		population[2] = new Network(population[0]);

		// Initialize some initial mutation here
	}

	@Override
	public void run() {
		testNetworks(population[0], population[1]); // Do something
		System.out.println("Generation " + generationCount);
		generationCount++;
	}

	public void start(GUI gui) {
		boolean running = true;
		while (running) {
			run();
			gui.run();
		}
	}

	private void testNetworks(Network networkA, Network networkB) { // Sets the
																	// fitness
																	// level of
																	// the two
																	// networks
																	// according
																	// to the
																	// result.
		GameResult[] gameWinners = new GameResult[2];
		int[] gameLengths = new int[2];

		gameWinners[0] = runner.startGame(networkA, networkB);
		gameLengths[0] = runner.getGameLength();

		gameWinners[1] = runner.startGame(networkB, networkA);
		gameLengths[1] = runner.getGameLength();

		for (int i = 0; i < 2; i++) {
			switch (gameWinners[i]) {
			case PlayerA:
				networkA.inputFitnessLevel(2 - gameLengths[i] / grid.getArea());
				networkB.inputFitnessLevel(0 + gameLengths[i] / grid.getArea());
				break;
			case PlayerB:
				networkB.inputFitnessLevel(2 - gameLengths[i] / grid.getArea());
				networkA.inputFitnessLevel(0 + gameLengths[i] / grid.getArea());
				break;
			case tie:
				break;
			default:
				break;

			}
		}
	}
}
