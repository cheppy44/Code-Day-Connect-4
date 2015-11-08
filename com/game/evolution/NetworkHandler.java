package com.game.evolution;

import java.util.Random;

import com.game.connect4.GameResult;
import com.game.connect4.GameRunner;
import com.game.connect4.Grid;
import com.game.connect4.State;
import com.game.graphics.GUI;
import com.game.network.Network;

public class NetworkHandler implements Runnable {

	private Grid grid;
	private GameRunner runner;
	private Network[] population;
	private int generationCount;
	private int generation = 0;

	public NetworkHandler(Grid grid) {
		this.grid = grid;
		runner = new GameRunner(grid);
		population = new Network[4];

		population[0] = new Network(grid); // population 0 is child A
		System.out.println("init network 0");
		population[1] = new Network(grid); // population 1 is child B
		System.out.println("init network 1");
		population[2] = new Network(grid); // population 2 is the "parent"
		System.out.println("init network2");
		// network
		population[3] = new Network(grid); // population 3 is the winner of the
		System.out.println("init network 3");
		// children

		// Initialize some initial mutation here
	}

	@Override
	public void run() { // I need a loop in here
		System.out.println("Generation " + generation);
		testNetworks(population[0], population[1], true);
		testNetworks(population[2], population[3], false);

		population[0] = Mutator.mutate(population[2]); // Need to define mutate
		population[1] = Mutator.mutate(population[2]);
		generation++;

	}

	public void start(GUI gui) {
		boolean running = true;
		while (running) {
			run();
			gui.update();
		}
	}

	private void testNetworks(Network networkA, Network networkB, boolean sneakyBoolean) {
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
				networkA.inputFitnessLevel(1);
				networkB.inputFitnessLevel(1);
				break;
			default:
				break;
			}
		}
		if (networkA.getFitnessLevel() > networkB.getFitnessLevel()) {
			if (sneakyBoolean) {
				population[3] = new Network(population[0]);
			} // Else do nothing, as population[2] will stay the same

		} else if (networkB.getFitnessLevel() > networkB.getFitnessLevel()) {
			if (sneakyBoolean) {
				population[3] = new Network(population[1]);
			} else {
				population[2] = new Network(population[3]);
			}

		} else {
			Random randGen = new Random();
			int rand = randGen.nextInt(2);
			if (rand == 0) {
				if (sneakyBoolean) {
					population[3] = new Network(population[0]);
				} // Else do nothing, as population[2] will stay the same
			} else {
				if (sneakyBoolean) {
					population[3] = new Network(population[1]);
				} else {
					population[2] = new Network(population[3]);
				}
			}
		}
	}

	public void guiTest(GUI gui) {
		// TODO Auto-generated method stub
		grid.dropGamePiece(0, State.red);
		grid.dropGamePiece(2, State.yellow);
		gui.update();
	}
}
