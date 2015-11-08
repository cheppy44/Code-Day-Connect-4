package com.game.evolution;

import java.util.Random;

import com.game.network.Connection;
import com.game.network.Network;
import com.game.network.Node;

public abstract class Mutator {

	public static Network mutate(Network network) { //The amount of mutation is based on the fitness level of the network
		Network mutated = network;
		for (Node n : network.getNodes()) {

		}

		return mutated; //After mutation takes place
	}

	//	public static void mutateThreshold(Node n) {
	//	}

	public static void mutateWeights(Connection c) {

	}

	public static int generateRandom(int range) {
		Random randGen = new Random();
		int random = randGen.nextInt(range);
		return random;
	}
}
