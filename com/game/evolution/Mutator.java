package com.game.evolution;

import java.util.Random;

import com.game.network.Connection;
import com.game.network.Network;
import com.game.network.Node;

public abstract class Mutator {
	private static final int MUTATION_PROBABILITY_MULTIPLIER = 10;

	public static Network mutate(Network network) {
		Network mutated = new Network(network);
		Random randGen = new Random(System.currentTimeMillis());
		for (Node n : network.getNodes()) {
			for (Connection c : n.getOutputConnections()) {
				if (randGen.nextInt(getActivationProbability(network)) == 0) {
					mutateWeight(c);
				}
			}

		}

		return mutated; // After mutation takes place
	}

	// public static void mutateThreshold(Node n) {
	// }

	public static void mutateWeight(Connection c) {
		Random randGen = new Random(System.currentTimeMillis());
		double weight = randGen.nextDouble() * 3;
		if (randGen.nextBoolean()) {
			weight = -weight;
		}
		c.setUsageWeight(c.getUsageWeight() + weight); //Adds new usage weight to the old one

	}

	public static int getActivationProbability(Network network) {
		int activationProbability = Math.abs((int) Math.round(network.getFitnessLevel() * MUTATION_PROBABILITY_MULTIPLIER)) + 1;
		return activationProbability;
	}
}
