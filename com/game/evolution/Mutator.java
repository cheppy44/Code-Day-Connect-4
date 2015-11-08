package com.game.evolution;

import java.util.Random;

import com.game.network.Connection;
import com.game.network.Network;
import com.game.network.Node;

public abstract class Mutator {
	private static final int MUTATION_PROBABILITY_MULTIPLIER = 10;

	public static Network mutate(Network network) {
		Network mutated = network;
		Random randGen = new Random();
		for (Node n : network.getNodes()) {
			for (Connection c : n.getOutputConnections()) {
				if (randGen.nextInt(getActivationProbability(network)) == 1) {
					mutateWeight(c);
				}
			}

		}

		return mutated; // After mutation takes place
	}

	// public static void mutateThreshold(Node n) {
	// }

	public static void mutateWeight(Connection c) {
		Random randGen = new Random();
		double weight = randGen.nextDouble() * 3;
		if (randGen.nextBoolean()) {
			weight = -weight;
		}
		c.setUsageWeight(weight);

	}

	public static int getActivationProbability(Network network) {
		int activationProbability = Math.abs((int) Math.round(network.getFitnessLevel() * MUTATION_PROBABILITY_MULTIPLIER)) + 1;
		return activationProbability;
	}

	public static int generateRandom(int range) {
		Random randGen = new Random();
		int random = randGen.nextInt(range);
		return random;
	}
}
