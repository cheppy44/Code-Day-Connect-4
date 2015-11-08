package com.game.evolution;

import java.util.Random;

import com.game.network.Connection;
import com.game.network.Network;
import com.game.network.Node;

public abstract class Mutator {
	private static final int MUTATION_PROBABILITY_MULTIPLIER = 10;

	public static Network mutate(Network network) { //The amount of mutation is based on the fitness level of the network
		Network mutated = network;
		Random randGen = new Random(); //TODO Determine if this actually will generate new numbers every time it's called
		for (Node n : network.getNodes()) {
			for (Connection c : n.getOutputConnections()) {
				if (randGen.nextInt(getActivationProbability(network)) == 0) { //Will this derp if the activiation probability is 0?
					mutateWeight(c);
				}
			}

		}

		return mutated; //After mutation takes place
	}

	//	public static void mutateThreshold(Node n) {
	//	}

	public static void mutateWeight(Connection c) {
		Random randGen = new Random();
		double weight = randGen.nextDouble() * 3;
		if (randGen.nextBoolean()) {
			weight = -weight;
		}

		c.setUsageWeight(weight);

	}

	public static int getActivationProbability(Network network) {
		int activationProbability = (int) Math.round(network.getFitnessLevel() * MUTATION_PROBABILITY_MULTIPLIER);
		return activationProbability;
	}

	public static int generateRandom(int range) {
		Random randGen = new Random();
		int random = randGen.nextInt(range);
		return random;
	}
}
