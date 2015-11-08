package com.game.evolution;

import java.util.Random;

import com.game.network.Network;

public abstract class Mutator {

	public Network mutate(Network network) {
		Network mutated = network;

		return mutated; //After mutation takes place
	}

	//	public void mutateThreshold(Node n) {
	//		generateRandom(2);
	//	}
	//
	//	public void mutateWeights(Connection c) {
	//
	//	}

	public int generateRandom(int range) {
		Random randGen = new Random();
		int random = randGen.nextInt(range);
		return random;
	}
}
